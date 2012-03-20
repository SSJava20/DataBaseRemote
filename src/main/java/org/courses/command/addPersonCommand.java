package org.courses.command;

import org.courses.db.Person;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 20.03.12
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class addPersonCommand implements ICommand
{
    private Person toSend;

    public addPersonCommand(Person ts)
    {
        toSend = ts;
    }

    @Override
    public int getType()
    {
        return Command.ADD_PERSON;
    }

    public Person getPerson()
    {
        return toSend;
    }

    public void setPerson(Person toSend)
    {
        this.toSend = toSend;
    }
}
