package org.courses;

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


    public static DAOFactory getInstance()
    {

        if (instance == null)
            instance = new DAOFactory();

        return instance;
    }

    public PersonDAO getPersonDAO()
    {
        if(personDAO == null)
            personDAO = new PersonDAOImpl();

        return personDAO;
    }
}
