package org.courses.command;

import org.courses.db.Person;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 20.03.12
 * Time: 21:46
 * To change this template use File | Settings | File Templates.
 */
public class AllPersonsCommand implements ICommand
{
    Collection<Person> Persons;

    public AllPersonsCommand(Collection<Person> persons)
    {
        Persons = persons;
    }

    public Collection<Person> getPersons()
    {
        return Persons;
    }

    public void setPersons(Collection<Person> persons)
    {
        Persons = persons;
    }

    @Override
    public int getType()
    {
        return Command.ALL_PERSONS;
    }
}
