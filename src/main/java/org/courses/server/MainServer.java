package org.courses.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;


public class MainServer
{
    private static int DEFAULT_PORT = 3224;
    private static String DEFAULT_IP = "127.0.0.1";

    protected Vector<ServerThread> serverThreads;
    InetAddress myAddress;

    int Port;

    protected ServerSocket mServerSocket;

    public MainServer(InetAddress address, int port) throws IOException
    {
        try
        {
            myAddress = address;
            serverThreads = new Vector<ServerThread>();
            Port = port;
            mServerSocket = new ServerSocket(port, 0, myAddress);
            while(true)
            {
                Socket nSocket = mServerSocket.accept();
                System.out.println("New client connected");
                serverThreads.add(new ServerThread(this, nSocket));
            }


        } catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally
        {
            mServerSocket.close();
        }
    }

    public ServerThread getServerThreadById(int id)
    {
        return serverThreads.get(id);
    }
    

    public void deleteServerThread(ServerThread toDel)
    {
        serverThreads.remove(toDel);
    }


    public static void main(String[] args)
    {
        int port = DEFAULT_PORT;
        String ip = DEFAULT_IP;
        if (args.length > 1)
        {
            port = Integer.parseInt(args[1]);
            ip = args[0];
        }
        try
        {
            new MainServer(InetAddress.getByName(ip), port);
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}