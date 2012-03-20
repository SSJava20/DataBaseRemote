package org.courses.client;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.*;
import org.courses.Ui_PersonEditDialog;
import org.courses.db.DAOFactory;
import org.courses.db.Person;

import javax.validation.Validation;
import javax.validation.Validator;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: stvad
 * Date: 25.02.12
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */

public class PersonEditDialog extends QDialog
{
    protected Person editablePerson;
    protected boolean newPerson;
    protected boolean accepted;
    protected Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    protected Person toValid;

    Ui_PersonEditDialog ui = new Ui_PersonEditDialog();

//    public static void main(String[] args)
//    {
//        QApplication.initialize(args);
//
//        PersonEditDialog testPersonEditDialog = new PersonEditDialog();
//        testPersonEditDialog.show();
//
//        QApplication.exec();
//    }

    public PersonEditDialog()
    {
        ui.setupUi(this);
        init(-1);
    }

    public PersonEditDialog(QWidget parent)
    {
        super(parent);
        init(-1);
    }

    public PersonEditDialog(QWidget parent, int id)
    {
        super(parent);
        init(id);
    }

    
    protected void init(int id)
    {
        ui.setupUi(this);
        accepted = false;
        toValid = new Person(0, "Vasya", "Pupkin", "8-093-223-33-44", "default@mail.org", null, "olo", "lo", "whee");
        if(id == -1)
        {
            editablePerson = new Person();
            newPerson = true;
        }
        else try
        {
            editablePerson = DAOFactory.getInstance().getPersonDAO('n').getPersonById(id);
            newPerson = false;
        } catch (SQLException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        updateData();
        connectButtons();
    }
    
    protected void updateData()
    {
        ui.leName.setText(editablePerson.getName());
        ui.leSName.setText(editablePerson.getSName());
        ui.leMail.setText(editablePerson.getMail());
        ui.lePhone.setText(editablePerson.getPhone());
        //ui.leBirthday.setText(editablePerson.getBirthDay().toString());
        ui.dateEdit.setDate(new QDate(editablePerson.getBirthDay().getYear(), editablePerson.getBirthDay().getMonth(), editablePerson.getBirthDay().getDay()));
        ui.tePetsonInfo.setText(editablePerson.getLongString());
        ui.lblImage.setSizePolicy(QSizePolicy.Policy.Expanding, QSizePolicy.Policy.Expanding);
        ui.lblImage.setPixmap(new QPixmap(editablePerson.getImgName()));
    }

    protected void connectButtons()
    {
        ui.pbSetImage.clicked.connect(this, "getImgName()");
        ui.btSetFile.clicked.connect(this, "getFileName()");
        ui.buttonBox.accepted.connect(this, "Accept()");
        ui.leMail.editingFinished.connect(this, "validateMail()");
        ui.lePhone.editingFinished.connect(this, "validatePhone()");
    }

    protected void getImgName()
    {
        editablePerson.setImgName(QFileDialog.getOpenFileName(this,
                tr("Open Image"), "", new QFileDialog.Filter(tr("Image Files (*.png *.gif *.bmp *.ico *.tif *.tiff)"))));
        ui.lblImage.setPixmap(new QPixmap(editablePerson.getImgName()));

    }
    
    protected void validateMail()
    {
        String valid = toValid.getMail();
        toValid.setMail(ui.leMail.text());

        if(!Person.validate(toValid, validator))
        {
            toValid.setMail(valid);
            ui.leMail.setStyleSheet("background-color: red;");
            ui.buttonBox.setEnabled(false);
        }
        else
        {
            ui.leMail.setStyleSheet("background-color: white;");
            ui.buttonBox.setEnabled(true);
        }
        //validator.validateValue()
    }

    protected void validatePhone()
    {
        String valid = toValid.getPhone();
        toValid.setPhone(ui.lePhone.text());

        if(!Person.validate(toValid, validator))
        {
            toValid.setPhone(valid);
            ui.lePhone.setStyleSheet("background-color: red;");
            ui.buttonBox.setEnabled(false);
        }
        else
        {
            ui.lePhone.setStyleSheet("background-color: white;");
            ui.buttonBox.setEnabled(true);
        }
    }

    protected void getFileName()
    {
        editablePerson.setFileName(QFileDialog.getOpenFileName(this,
                tr("Open File"), "", new QFileDialog.Filter(tr("All Files (*.*)"))));
    }

    protected void Accept()
    {
        try
        {
            editablePerson.setName(ui.leName.text());
            editablePerson.setSName(ui.leSName.text());
            //editablePerson.setBirthDay();
            editablePerson.setMail(ui.leMail.text());
            editablePerson.setPhone(ui.lePhone.text());
            editablePerson.setLongString(ui.tePetsonInfo.toPlainText());
            if(newPerson)
                DAOFactory.getInstance().getPersonDAO('n').addPerson(editablePerson);
            else
                DAOFactory.getInstance().getPersonDAO('n').updatePerson(editablePerson.getId(), editablePerson);

            accepted = true;
        } catch (SQLException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    public boolean isAccepted()
    {
        return accepted;
    }

//    public boolean isNewPerson()
//    {
//        return newPerson;
//    }

    public Person getResult()
    {
        return editablePerson;
    }
}
