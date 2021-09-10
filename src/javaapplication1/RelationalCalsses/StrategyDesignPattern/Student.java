package javaapplication1.RelationalCalsses.StrategyDesignPattern;

import java.util.ArrayList;
import javaapplication1.RelationalCalsses.ObserverDesignPattern.Course;
import javaapplication1.RelationalCalsses.ObserverDesignPattern.observer;
import javaapplication1.RelationalCalsses.User;

/**
 *
 * @author Peter
 */
public class Student extends User implements observer {

    private int level;
    private double GPA;
    private FileQueries fileQueries;
    private final String studentFileName = "Students.txt";
    private String notification;

    public static ArrayList<Student> Students = new ArrayList<Student>();

    public Student(String name) {
        this.fname=name;

    }

    public Student() {
    }

    public Student(FileQueries fileQueries) {
        this.fileQueries = fileQueries;
    }

   
    public Student(int level, double GPA, String userName, String pass, String fname, String lname, int age, String status, FileQueries fileQueries) {
        super(userName, pass, fname, lname, age, status);
        this.level = level;
        this.GPA = GPA;
        this.fileQueries = fileQueries;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getLevel() {
        return this.level;
    }

    public double getGPA() {
        return this.GPA;
    }

    public boolean addStudentInfo() {
        return fileQueries.addUser(getStudentData());
//        if (FManger.write(getStudentData(), studentFileName, true)) {
//            return true;
//        } else {
//            return false;
//        }
    }

    private String getStudentData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.level + "@" + this.GPA + "@" + this.userName + "@" + this.pass + "@";
    }

    private void commitToFile() {
//        fileQueries.commitToFile(Students.get(0).getStudentData(),getStudentData());
        FManger.write(Students.get(0).getStudentData(), studentFileName, false);
        for (int i = 1; i < Students.size(); i++) {
            FManger.write(Students.get(i).getStudentData(), studentFileName, true);
        }

    }

    private int getStudentIndex(int id) {
        return fileQueries.getUserIndex(id);
//
    }

//        for (int i = 0; i < Students.size(); i++)
//            if(Students.get(i).getID() == id)
//                return i;
//        
//        return -1;
    //}
        
    private void loadFromFile() {
//       fileQueries.loadFromFile();
        Students = (ArrayList<Student>) (Object) FManger.read(studentFileName);

    }

    public String displayAllStudents() {
        loadFromFile();
        String S = "\nAll Student Data:\n";
        for (Student x : Students) {
            S = S + x.toString();
        }
        return S;
    }

    public Student searchStudent(int id) {
//        int index=getStudentIndex(id);
        loadFromFile();
        return fileQueries.searchUser(id);
//       Student temp = new Student();
//        loadFromFile();
//        int index = getStudentIndex(id);
//        if (index != -1) {
//            return Students.get(index);
//        } else {
//            return temp;
//        }
    }

    public boolean updateStudent(int oldID, Student x) {

        loadFromFile();

        if (fileQueries.updateUser(oldID, x)) {
            commitToFile();
            return true;
        }
        return false;

    }

    public boolean deleteStudent(int id) {
        loadFromFile();

        if (fileQueries.deleteUser(id)) {
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + GPA + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void study() {
        System.out.println("I'm Studying Undergraduate Courses @ FCIH :) ");
    }

    @Override
    public boolean login(int id, String PASS) {
        loadFromFile();

        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id && Students.get(i).getPass().equals(PASS)) {

                return true;
            }
        }

        return false;
    }

    public void StudentRegisterCourse(String cID, String cName) {
        Course x = new Course();
        x.setCId(cID);
        x.setCname(cName);
        x.setStudentID(this.getID());
        x.addToCourseStudent();
    }
//     public void checkCourse()

    @Override
    public void setid() {
        loadFromFile();
        this.id = Students.get(Students.size() - 1).getID();
        this.id++;

    }

    public String getNotification() {
        return notification;
    }

    @Override
    public void getNotification(String massage) {
        this.notification = massage;
    }

}
