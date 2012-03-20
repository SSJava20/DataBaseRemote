package org.courses;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Set;

//import org.hibernate.validator.*;
//import org.hibernate.validator.constraints.NotEmpty;

public class Person
{
	protected int Id;

    @NotNull(message="Имя должно быть задано")
	protected String Name;

    @NotNull(message="Фамилия должна быть задана")
    protected String SName;
    //protected int Age;

    @Pattern(regexp = "^(8-\\d{3}-\\d{3}(-\\d{2}){2})$", message = "Invalid phone")
    protected String Phone;

    @Pattern(regexp = "^([a-zA-Z0-9]+[\\w.]*[a-zA-Z0-9]+@[a-zA-Z0-9]+[\\w.]*[a-zA-Z0-9]+.[a-zA-Z0-9]{1,4})$", message = "Invalid mail")
    protected String Mail;

    protected Date birthDay;
    protected String fileName;
    protected String longString;
    protected String imgName;

    public String getImgName()
    {
        return imgName;
    }

    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }
    //protected Image myImg;
//    protected byte[] imgData;

    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

//    public Image getMyImg()
//    {
//        return myImg;
//    }
//
//    public void setMyImg(Image myImg)
//    {
//        this.myImg = myImg;
//    }

    public void setId(int id)
    {
        Id = id;
    }
    public int getId()
    {
        return Id;
    }

    public void setSName(String SName)
    {
        this.SName = SName;
    }

//    public void setAge(int age)
//    {
//        Age = age;
//    }

    public void setName(String name)
    {
        Name = name;
    }

//    public int getAge()
//    {
//        return Age;
//    }

    public String getSName()
    {
        return SName;
    }

    public String getName()
    {
        return Name;
    }

    public String getPhone()
    {
        return Phone;
    }

    public void setPhone(String phone)
    {
        Phone = phone;
    }

    public String getMail()
    {
        return Mail;
    }

    public void setMail(String mail)
    {
        Mail = mail;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(Date birthDay)
    {
        this.birthDay = birthDay;
    }

    public String getLongString()
    {
        return longString;
    }

    public void setLongString(String longString)
    {
        this.longString = longString;
    }

    public Person()
	{
		Id = 0;
		Name = "";
		SName = "";
//		Age = 0;
        fileName = "";
        Phone = "";
        Mail = "";
        birthDay = new Date();
        longString = "";
        imgName = "";
        //myImg = null;
	}



    public Person(int id, String name, String SName, String phone, String mail, Date birthDay, String fileName, String longString, String imgName)
    {
        Id = id;
        Name = name;
        this.SName = SName;
        Phone = phone;
        Mail = mail;
        this.birthDay = birthDay;
        this.fileName = fileName;
        this.longString = longString;
        this.imgName = imgName;
    }

    public static boolean validate(Object object, Validator validator)//, List<String> errors)
	{
		boolean isOk = true;
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object);
		for (ConstraintViolation<Object> cv : constraintViolations)
		{
			isOk = false;
			//errors.add(cv.getMessage());
		}
		return isOk;
	}

}
