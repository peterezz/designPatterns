/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.FactoryDesigPattern;

import javaapplication1.RelationalCalsses.Admin;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Professor;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Student;
import javaapplication1.RelationalCalsses.User;

/**
 *
 * @author Peter
 */
public class UserFactory {
    
    private static UserFactory instance; 
    
    private UserFactory()
    {
        
    }
      public static UserFactory getInstance ()
    {
        if( instance == null)
        {
            instance = new UserFactory();
        }
        return instance;
    }

    public  String student = "Students";
    public  String teacher = "Professor";
    public  String admin = "admin";

    public  User usercreation(String Usertybe) {
        switch (Usertybe) {
            case "Students":
                return new Student();
            case "Professor":
                return new Professor();
            case "admin":
                return new Admin();
            default:
                return null;

        }
    }

}
