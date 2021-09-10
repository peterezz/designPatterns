/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.AdapterDesignPattern;

import javaapplication1.RelationalCalsses.ObserverDesignPattern.Course;

/**
 *
 * @author Peter
 */
public interface adminSetCourseAvailablity {
    public void addNewCourse(String Avilability, String CName,String CId ,int CreditHours);
   
    
    public Course searchForCourse(String id);
    
     public boolean updateCourse(String oldID );
     public boolean deleteCourse(String Id);
}
