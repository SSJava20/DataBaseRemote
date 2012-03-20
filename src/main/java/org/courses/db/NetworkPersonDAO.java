package org.courses.db;

import com.google.gson.Gson;
import org.courses.command.*;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 20.03.12
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class NetworkPersonDAO implements PersonDAO, Runnable
{
    protected ArrayList<Person> lastGotCollection;
    protected Person latGotPerson;
    boolean complete;
    Socket mySocket;
    Thread listenThread;

    public NetworkPersonDAO(Socket mySocket)
    {
        this.mySocket = mySocket;
    }

    private void sendCommand(String commandString)
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                    mySocket.getOutputStream())), true);
            out.println(commandString);
//            System.out.println("SEND COMMAND: threadID="
//                    + this.server.serverThreads.indexOf(this) + " :  "
//                    + commandString);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void addPerson(Person person) throws SQLException
    {
        Command addCommand = new Command(new addPersonCommand(person));
        sendCommand(addCommand.serialize());
    }

    @Override
    public void updatePerson(int person_id, Person person) throws SQLException
    {
        Command updateCommand = new Command(new updatePersonCommand(person_id, person));
        sendCommand(updateCommand.serialize());
    }

    @Override
    public Person getPersonById(int person_id) throws SQLException
    {
        Command personByIdCommand = new Command(new PersonByIdCommand(person_id, null));
        sendCommand(personByIdCommand.serialize());
        complete = false;
        while (!complete)
        {
        }
        return latGotPerson;
    }

    @Override
    public Collection getAllPersons() throws SQLException
    {
        Command allPersons = new Command(new AllPersonsCommand(null));
        sendCommand(allPersons.serialize());
        complete = false;
        while (!complete)
        {
        }
        return lastGotCollection;
    }

    @Override
    public void deletePerson(Person person) throws SQLException
    {
        Command delCommand = new Command(new deletePersonCommand(person));
        sendCommand(delCommand.serialize());
    }

    private void operateCommand(String getStringCommand)
    {
        Gson gson = new Gson();
        Command command = Command.deserialize(getStringCommand);
        System.out.println("GET COMMAND: threadID="
                + " :COMMAND_TYPE: "
                + command.getType() + " " + command.getStringData());
        switch (command.getType())
        {
            case Command.PERSON_BY_ID:
            {

                PersonByIdCommand personByIdCommand = gson.fromJson(command.getStringData(),
                        PersonByIdCommand.class);
                GetPersonById(personByIdCommand.getPerson());
                break;
            }
            case Command.ALL_PERSONS:
            {

                AllPersonsCommand allPersonsCommand = gson.fromJson(command.getStringData(),
                        AllPersonsCommand.class);
                GetAllPersons(allPersonsCommand.getPersons());
                break;
            }
            default:
        }
    }

    private void GetAllPersons(Collection got)
    {
        lastGotCollection = (ArrayList<Person>) got;
        complete = true;
    }

    private void GetPersonById(Person got)
    {
        latGotPerson = got;
        complete = true;
    }

    @Override
    public void run()
    {
        Scanner in = null;
        try
        {
            in = new Scanner(new InputStreamReader(
                    mySocket.getInputStream()));
        } catch (IOException e1)
        {
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
                    mySocket.close();
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
