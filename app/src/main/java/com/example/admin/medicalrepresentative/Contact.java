package com.example.admin.medicalrepresentative;

/**
 * Created by Admin on 3/1/2016.
 */
public class Contact
{
    String fn,mn,ln,email,city,address,un,passwd,confirmPassword,contactNo,pin;

    //Initialize and get the values of the fields requred.

    public void setFn(String fn)
    {
        this.fn = fn;
    }

    public String getfn()
    {
        return this.fn;
    }

    public void setLn(String ln)
    {
        this.ln = ln;
    }

    public String getLn()
    {
        return this.ln;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setUn(String un)
    {
        this.un = un;
    }

    public String getUn()
    {
        return this.un;
    }

    public void setPasswd(String passwd)
    {
        this.passwd = passwd;
    }

    public String getPasswd()
    {
        return this.passwd;
    }

    public void setConfirmPassword(String confirmPassword)
    {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword()
    {
        return this.confirmPassword;
    }


}
