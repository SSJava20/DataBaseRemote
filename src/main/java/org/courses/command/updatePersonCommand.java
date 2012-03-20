package org.courses.command;

import org.courses.db.Person;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 20.03.12
 * Time: 21:31
 * To change this template use File | Settings | File Templates.
 */
public class updatePersonCommand implements ICommand
{
    int index;
    Person toUpdate;

    public updatePersonCommand(int index, Person toUpdate)
    {
        this.index = index;
        this.toUpdate = toUpdate;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public Person getPerson()
    {
        return toUpdate;
    }

    public void setPerson(Person toUpdate)
    {
        this.toUpdate = toUpdate;
    }

    @Override
    public int getType()
    {
        return Command.UPDATE_PERSON;
    }
}
