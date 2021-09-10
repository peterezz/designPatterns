package javaapplication1.RelationalCalsses;

import javaapplication1.RelationalCalsses.StrategyDesignPattern.Professor;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Student;
import javaapplication1.RelationalCalsses.AdapterDesignPattern.adminSetCourseAvailablity;
import javaapplication1.RelationalCalsses.ObserverDesignPattern.Course;

/**
 *
 * @author Tamer A.Yassen
 */
public class Admin extends User implements adminSetCourseAvailablity{

    public Admin() {

    }

    public void displayStudents() {
        Student x = new Student();
        System.out.println(x.displayAllStudents());
    }

    public void searchForStudent(int id) {
        Student x = new Student();
        System.out.println(x.searchStudent(id));
    }

    public void updateStudent(int oldID, Student newStudentValues) {
        Student x = new Student();
        x.updateStudent(oldID, newStudentValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteStudent(int Id) {
        Student x = new Student();
        x.deleteStudent(Id);
        System.out.println("deleted Successfully ... !");
    }

  
    

    public void searchForProf(int id) {
        Professor x = new Professor();
        System.out.println(x.searchProf(id));
    }

    public void updateProf(int oldID, Professor newProfValues) {
        Professor x = new Professor();
        x.updateProf(oldID, newProfValues);
        System.out.println("Updated Successfully ... !");
    }

    public void deleteProf(int Id) {
        Professor x = new Professor();
        x.deleteProf(Id);
        System.out.println("deleted Successfully ... !");
    }
//    public Course(String Avilability, String CName, String CId, int CreditHours, int id) {

    @Override
    public void addNewCourse(String Avilability, String CName,String CId ,int CreditHours) {
        
       
    }

//    public void displayCourses() {
//        Course x = new Course();
//        System.out.println(x.displayAllCourses());
//    }

    @Override
    public Course searchForCourse(String id) {
        System.out.println("Searching ... !");
        return null;
       
    }

    @Override
    public boolean updateCourse(String oldID) {
       System.out.println("Updating ... !");
        return true;
        
    }

    @Override
    public boolean deleteCourse(String Id) {
       return true;
    }

    @Override
    public String toString() {
        return "I'm Manager : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    @Override
    public boolean login(int id, String PASS) {
        if (id == 0 && PASS.equals("admin")) {
            return true;
        }
        return false;
    }

    @Override
    public void setid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
