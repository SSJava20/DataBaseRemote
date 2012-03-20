package org.courses.db;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 19.02.12
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
public class DAOFactory
{
    private static DAOFactory instance = null;

    private static PersonDAO personDAO = null;
    private static PersonDAO personDAONW = null;


    public static DAOFactory getInstance()
    {

        if (instance == null)
            instance = new DAOFactory();

        return instance;
    }

    public PersonDAO getPersonDAO(char type) throws Exception
    {
        switch (type)
        {
            case 'l':
            {
                if (personDAO == null)
                    personDAO = new PersonDAOImpl();
                return personDAO;
            }
            case 'n':
            {
                if (personDAONW == null)
                    personDAONW = new NetworkPersonDAO(new Socket(InetAddress.getByName("127.0.0.1"), 3224));
                return personDAONW;
            }
            default:
                return personDAO;

        }

    }
}
