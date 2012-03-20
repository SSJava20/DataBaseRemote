package org.courses.client;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import org.apache.commons.io.FileUtils;
import org.courses.Ui_QtJava;
import org.courses.db.DAOFactory;
import org.courses.db.Person;

import java.io.File;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class QtJava extends QMainWindow 
{

    Ui_QtJava ui = new Ui_QtJava();

    public static void main(String[] args) 
    {
        QApplication.initialize(args);

        QtJava testQtJava = new QtJava();
        testQtJava.show();

        QApplication.exec();
    }

    public QtJava() 
    {
        ui.setupUi(this);
//        generateDBData(30);
        connectButtons();
        //ui.widget.
    }

    public QtJava(QWidget parent) 
    {
        super(parent);
        ui.setupUi(this);   generateDBData(30);

    }

    protected void connectButtons()
    {
        ui.btDoIt.clicked.connect(this, "DoIt()");
        ui.btAdd.clicked.connect(this, "AddPerson()");
        ui.btDel.clicked.connect(this, "DelPerson()");
        ui.tableWidget.cellDoubleClicked.connect(this, "Edit(Integer, Integer)");
    }

    protected void Edit(Integer row, Integer column)
    {
        PersonEditDialog dialog = new PersonEditDialog(this, Integer.parseInt(ui.tableWidget.item(row, 0).text()));
        dialog.show();
        if(dialog.isAccepted())
        {
            ui.tableWidget.removeRow(row);
            AddPersonToTable(dialog.getResult(), row);
        }
    }

    protected void AddPerson()
    {
        PersonEditDialog dialog = new PersonEditDialog(this);
        dialog.show();
        Person toAdd =  dialog.getResult();
        if (dialog.isAccepted())
        {
            AddPersonToTable(toAdd, ui.tableWidget.rowCount());
        }

    }

    protected void DelPerson()
    {
        try
        {
            Person toDel = DAOFactory.getInstance().getPersonDAO('n').getPersonById(Integer.parseInt(ui.tableWidget.item(ui.tableWidget.rowCount(), 0).text()) -1);
            DAOFactory.getInstance().getPersonDAO('n').deletePerson(toDel);
            ui.tableWidget.removeRow(ui.tableWidget.rowCount());
        } catch (SQLException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected void DoIt()
    {
        ui.tableWidget.clear();
        ui.tableWidget.clearContents();
        //ui.tableWidget.remo
        Collection data = null;
        try
        {
            data = DAOFactory.getInstance().getPersonDAO('n').getAllPersons();
            Iterator iterator = data.iterator();
            while (iterator.hasNext())
            {
                Person person = (Person) iterator.next();
		    	AddPersonToTable(person, ui.tableWidget.rowCount());
					//item.
		    }
        } catch (SQLException e)
        {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    protected void AddPersonToTable(Person toAdd, int index)
    {
        ui.tableWidget.insertRow(index);
        QTableWidgetItem idItem = new QTableWidgetItem(Integer.toString(toAdd.getId()));
        ui.tableWidget.setItem(index -1, 0, idItem);

        QTableWidgetItem nameItem = new QTableWidgetItem(toAdd.getName());
        ui.tableWidget.setItem(index -1, 1, nameItem);


        QTableWidgetItem SNameItem = new QTableWidgetItem(toAdd.getSName());
        ui.tableWidget.setItem(index -1, 2, SNameItem);
//        QTableWidgetItem newItem = new QTableWidgetItem();
    }

    protected void generateDBData(int num)
    {
        StringBuilder tFName = new StringBuilder();
        StringBuilder tSName = new StringBuilder();
        StringBuilder tNumber = new StringBuilder();
        Collection<File> files = FileUtils.listFiles(new File("file"), null, false);
        String ext[] =  {"gif"};
        Collection<File> gifs = FileUtils.listFiles(new File("img"), ext, false);
        Date tDate = new Date();
        tDate.setTime((long) ((Math.random())*2147483647) + 1);

        for(int i = 0; i< num; i++)
        {
            for(int j = 0; j< 6; j++)
            {
                tSName.append((char)((int) (Math.random()*26 + 65)));
                tFName.append((char)((int) (Math.random()*26 + 65)));
                //gifs.toArray()[0]
                File tf;


            }

            tNumber.append("8-" + Integer.toString((int) ((Math.random())*899) + 100) + "-"+
                    Integer.toString((int) ((Math.random())*899) + 100) + "-" +Integer.toString((int) ((Math.random())*89) + 10) +
                    "-"+Integer.toString((int) ((Math.random())*89) + 10));

            try
            {
                Person tPerson = new Person(i, tFName.toString(),
                        tSName.toString(), tNumber.toString(), "default@mail.org", tDate,
                        "file/" +((File)files.toArray()[((int)Math.random()*files.size())]).getName(),
                        "some fstring very very long yaaaahh",
                        "img/" +((File)gifs.toArray()[((int)Math.random()*gifs.size())]).getName());
                DAOFactory.getInstance().getPersonDAO('n').addPerson(tPerson);
            } catch (SQLException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (Exception e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            tSName.delete(0, 6);
            tFName.delete(0, 6);
            tNumber.delete(0,tNumber.length());

        }
    }
}
