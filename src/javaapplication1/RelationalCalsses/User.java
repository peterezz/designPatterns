package javaapplication1.RelationalCalsses;

import javaapplication1.RelationalCalsses.SingltonDesignPattern.FileManger;

/**
 *
 * @author Tamer A.Yassen
 */
public abstract class User {

    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;
    private String status;
    private String fileName;

 

    public FileManger FManger = FileManger.getInstance();

    //static MyException MyEX = new MyException("Tamer Exception");
    public User() {
    }

    public User(String userName, String pass, String fname, String lname, int age, String status) {
        this.userName = userName;
        this.pass = pass;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.status = status;
    }

  

    /*

        if (id < 0) {
            this.id = MyEX.checkPositive("ID");
        } else {
            this.id = id;
        }
        this.fname = fname;
        this.lname = lname;
        
        if (age < 0) {
            this.age = MyEX.checkPositive("Age");
        } else {
            this.age = age;
        }
        
        
        if (!user.contains("@") || !user.contains(".")) {
            this.userName = MyEX.checkEmail("User name");
        } else {
            this.userName = user;
        }

        if (pass.length() < 8) {
            this.pass = MyEX.checkPassLength("Password");
        } else {
            this.pass = pass;
        }*/
    public void setStatus(String status) {
        this.status = status;
        this.fileName = status + ".txt";
    }

    public String getStatus() {
        return status;
    }

    @Override
    public abstract String toString();

    //setter
    public abstract void setid() ;

    public void setId(int id) {
        this.id = id;
    }
  

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }
    public abstract boolean login(int id, String PASS);
  
}

    
