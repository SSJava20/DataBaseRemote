package org.courses.server;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;
import org.courses.command.*;
import org.courses.db.DAOFactory;
import org.courses.db.Person;

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
//        Command command = new Command(new ResendRequestGame(id));
//        String commandString = command.serialize();
//        sendCommand(commandString);
    }

    private void AddPerson(Person toAdd) throws SQLException
    {
        DAOFactory.getInstance().getPersonDAO().addPerson(toAdd);
    }

    private void UpdatePerson(int id, Person toUpd) throws SQLException
    {
        DAOFactory.getInstance().getPersonDAO().updatePerson(id, toUpd);
    }

    private void DeletePerson(Person toDel) throws SQLException
    {
        DAOFactory.getInstance().getPersonDAO().deletePerson(toDel);
    }

    private void SendPersonById(int id) throws SQLException
    {
        Command command = new Command(new PersonByIdCommand(id, DAOFactory.getInstance().getPersonDAO().getPersonById(id)));
        String commandString = command.serialize();
        sendCommand(commandString);
    }

    private void SendAllPersons() throws SQLException
    {
        Command command = new Command(new AllPersonsCommand(DAOFactory.getInstance().getPersonDAO().getAllPersons()));
        String commandString = command.serialize();
        sendCommand(commandString);
    }

    private void operateCommand(String getcommand) throws SQLException
    {
        Gson gson = new Gson();
        Command command = Command.deserialize(getcommand);
        System.out.println("GET COMMAND: threadID="
                + this.server.serverThreads.indexOf(this) + " :COMMAND_TYPE: "
                + command.getType() + " " + command.getStringData());
        switch (command.getType())
        {
            case Command.ADD_PERSON:
            {

                addPersonCommand apComm = gson.fromJson(command.getStringData(),
                        addPersonCommand.class);
                AddPerson(apComm.getPerson());
                break;
            }
            case Command.UPDATE_PERSON:
            {

                updatePersonCommand upComm = gson.fromJson(command.getStringData(),
                        updatePersonCommand.class);
                UpdatePerson(upComm.getIndex(), upComm.getPerson());
                break;
            }
            case Command.DELETE_PERSON:
            {

                deletePersonCommand delComm = gson.fromJson(command.getStringData(),
                        deletePersonCommand.class);
                DeletePerson(delComm.getPerson());
                break;
            }
            case Command.PERSON_BY_ID:
            {

                PersonByIdCommand personByIdCommand = gson.fromJson(command.getStringData(),
                        PersonByIdCommand.class);
                SendPersonById(personByIdCommand.getIndex());
                break;
            }
            case Command.ALL_PERSONS:
            {

                AllPersonsCommand allPersonsCommand = gson.fromJson(command.getStringData(),
                        AllPersonsCommand.class);
                SendAllPersons();
                break;
            }
            default:
        }
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
