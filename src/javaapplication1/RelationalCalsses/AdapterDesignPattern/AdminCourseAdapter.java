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
public class AdminCourseAdapter implements adminSetCourseAvailablity {

    private Course course;

    public AdminCourseAdapter(Course course) {
        this.course = course;
    }

    @Override
    public void addNewCourse(String Avilability, String CName, String CId, int CreditHours) {
        this.course.setCId(CId);
        this.course.setCname(CName);
        this.course.setAvilability(Avilability);
        this.course.setCreditHours(CreditHours);
        this.course.addToCourseAvailablty();
    }

    @Override
    public Course searchForCourse(String id) {

        return this.course.searchCourseAvailablityById(id);
    }

    @Override
    public boolean updateCourse(String oldID) {
        //    public Course(String Avilability, String CName, String CId, int CreditHours) {

        return this.course.updateCourseAvilablty( oldID);
    }

    @Override
    public boolean deleteCourse(String Id) {

        return this.course.deleteCourseAvailable(Id);
    }

}
