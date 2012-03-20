package org.courses.server;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;
import org.courses.command.Command;
import command.ClientCommand.Accept;
import command.ClientCommand.Move;
import command.ClientCommand.PlayerData;
import command.ClientCommand.RequestGame;
import command.ServerCommand.ResendRequestGame;
import command.ServerCommand.SendGameState;
import command.ServerCommand.SendPlayerList;
import command.ServerCommand.SendPlayerMark;

/**
 * @author Roman Kostyrko 02.03.2012 class provides communication with
 *         ClientThread
 */
public class ServerThread implements Runnable
{
    private String name;
    private Socket clientSocket;
    private MainServer server;
    private Thread clientThread;
    int id;

    public ServerThread(MainServer server, Socket clientSocket)
    {
        int iid = server.serverThreads.size();
        name = "Player" + iid; // Default
        this.server = server;
        this.clientSocket = clientSocket;
        clientThread = new Thread(this);
        clientThread.start();
    }

    private void sendCommand(String commandString)
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    clientSocket.getOutputStream())), true);
            out.println(commandString);
            System.out.println("SEND COMMAND: threadID="
                    + this.server.serverThreads.indexOf(this) + " :  "
                    + commandString);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * void
     */
    private void requestNewGame(int id)
    {
        Command command = new Command(new ResendRequestGame(id));
        String commandString = command.serialize();
        sendCommand(commandString);
    }

    /**
     * @param opponentServerThread void accepting new game request from opponent, creating game,
     *                             and sending new game state to client
     */
    private void acceptGame(ServerThread opponentServerThread)
    {
        Game newgame = server.addNewGame(opponentServerThread, this);
        this.setMyGame(newgame);
        opponentServerThread.setMyGame(newgame);
        this.sendPlayerMark();
        opponentServerThread.sendPlayerMark();
    }

    private void sendPlayerList()
    {
        FreePlayer[] a = new FreePlayer[server.getFreeList(this).size()];
        server.getFreeList(this).toArray(a);
        Command command = new Command(new SendPlayerList(a));
        sendCommand(command.serialize());
    }

    /**
     * @param currentgamestate void sending state of game to player client of this game
     */
    public void sendGameState(GameState state)
    {
        Command command = new Command(new SendGameState(state));
        sendCommand(command.serialize());
    }

    /**
     * @param getcommand void Define type of received command from client and call
     *                   processing methods
     */
    private void operateCommand(String getcommand)
    {
        Gson gson = new Gson();
        Command command = Command.deserialize(getcommand);
        System.out.println("GET COMMAND: threadID="
                + this.server.serverThreads.indexOf(this) + " :COMMAND_TYPE: "
                + command.getType() + " " + command.getStringData());
        switch (command.getType())
        {
            case Command.REQUEST_GAME:
            {

                RequestGame requestgame = gson.fromJson(command.getStringData(),
                        RequestGame.class);
                requestNewGametoThread(requestgame.getCurId());
                break;
            }
            case Command.ACCEPT:
            {
                Accept accept = gson
                        .fromJson(command.getStringData(), Accept.class);
                acceptGame(server.getServerThreadById(accept.getAcceptedplayerid()));
                break;
            }
            case Command.MOVE:
            {
                Move move = gson.fromJson(command.getStringData(), Move.class);
                if (myGame != null)
                {
                    myGame.Move(this, new Point(move.getRow(), move.getCol()));
                }
                break;
            }
            case Command.GET_PLAYER_LIST:
            {
                sendPlayerList();
                break;
            }
            case Command.PLAYER_DATA:
            {
                PlayerData pdata = gson.fromJson(command.getStringData(),
                        PlayerData.class);
                this.setName(pdata.getName());
                break;
            }
            case Command.CLOSE_GAME:
            {
                closeGame();
                break;
            }
            case Command.SEND_PLAYER_MARK:
            {
                sendPlayerMark();
                break;
            }
            default:
        }
    }

    private void closeGame()
    {
        myGame.Surrender(this);
    }

    private void sendPlayerMark()
    {
        Command command = new Command(new SendPlayerMark(this.getMark()));
        sendCommand(command.serialize());
    }

    @Override
    public void run()
    {
        Scanner in = null;
        try
        {
            in = new Scanner(new InputStreamReader(
                    clientSocket.getInputStream()));
        } catch (IOException e1)
        {
            server.serverThreads.remove(this);
            e1.printStackTrace();
        }
        while (true)
        {
            String getStringCommand = "";
            try
            {
                getStringCommand = in.nextLine();
                System.out.println(getStringCommand);
                operateCommand(getStringCommand);
            } catch (Exception e)
            {
                try
                {
                    clientSocket.close();
                    server.serverThreads.remove(this);
                } catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                break;
            }
            System.out.println(getStringCommand);
        }
        Thread.currentThread().interrupt();
    }

}
