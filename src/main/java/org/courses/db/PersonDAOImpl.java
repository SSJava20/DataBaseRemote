package org.courses.db;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 19.02.12
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class PersonDAOImpl implements PersonDAO
{
    public void addPerson(Person person) throws SQLException
    {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при вставке», JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {

                session.close();
            }
        }
    }

    public void updatePerson(int person_id, Person person) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при вставке», JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }

    public Person getPersonById(int person_id) throws SQLException
    {
        Session session = null;
        Person person = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            person = (Person) session.load(Person.class, person_id);
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка 'findById'», JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        return person;
    }

    public Collection getAllPersons() throws SQLException
    {
        Session session = null;
        List persons = new ArrayList<Person>();
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            persons = session.createCriteria(Person.class).list();
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка 'getAll'», JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        return persons;
    }

    public void deletePerson(Person person) throws SQLException
    {
        Session session = null;
        try
        {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage(), «Ошибка при удалении», JOptionPane.OK_OPTION);
        } finally
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
    }
}
