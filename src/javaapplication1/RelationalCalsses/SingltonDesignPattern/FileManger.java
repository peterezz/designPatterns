package javaapplication1.RelationalCalsses.SingltonDesignPattern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javaapplication1.RelationalCalsses.ObserverDesignPattern.Course;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Professor;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Student;

/**
 *
 * @author Peter
 */
public class FileManger {
    private static FileManger instance;

    private FileManger() {
    }
     public static FileManger getInstance ()
    {
        if( instance == null)
        {
            instance = new FileManger();
        }
        return instance;
    }

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Object> read(String FilePath) {
       // Scanner input = new Scanner(System.in);
        
        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Students.txt")) {

            ArrayList<Student> Students = new ArrayList<Student>();
            Student x;

            while (Reader.hasNext()) {

                x = new Student();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 20140011@Ahmed@Ali@20@2@3.5@CS@STU_1@12345678@
                x.setId(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setLevel(Integer.parseInt(seprated[4]));
                x.setGPA(Double.parseDouble(seprated[5]));
                x.setUserName(seprated[6]);
                x.setPass(seprated[7]);

                Students.add(x);
            }

            return (ArrayList<Object>) (Object) Students;

        } else if (FilePath.equals("Professor.txt")) {

            ArrayList<Professor> Professors = new ArrayList<Professor>();
            Professor x;

            while (Reader.hasNext()) {

                x = new Professor();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Ayman@Ezzat@30@8000.0@Mon 12pm to 2pm@Prof_1@12345678@
                x.setId(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setOfficeHours(seprated[5]);

                
                x.setUserName(seprated[6]);
                x.setPass(seprated[7]);

                Professors.add(x);
            }

            return (ArrayList<Object>) (Object) Professors;

        } else if (FilePath.equals("Courses.txt")) {

            ArrayList<Course> Courses = new ArrayList<Course>();
            Course x;
            

            while (Reader.hasNext()) {

                x = new Course();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // CTD@CName@StudentName
                x.setCId(seprated[0]);
                
                x.setStudentID(Integer.parseInt( seprated[1]));
               
                Courses.add(x);
            }

            return (ArrayList<Object>) (Object) Courses;

        } else if (FilePath.equals("CoursesAvailabity.txt")) {

            ArrayList<Course> CoursesAvailabity = new ArrayList<Course>();
            Course x;

            while (Reader.hasNext()) {

                x = new Course();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                //     public Course( String CName, String CId, int CreditHours,String Avilability) {

                x.setCId(seprated[0]);
                x.setCname(seprated[1]);
                x.setCreditHours(Integer.parseInt(seprated[2]));
                x.setAvilability(seprated[3]);
                

                CoursesAvailabity.add(x);
            }

            return (ArrayList<Object>) (Object) CoursesAvailabity;

//        } else if (FilePath.equals("Courses.txt")) {
//
//            ArrayList<Course> Courses = new ArrayList<Course>();
//            Course x;
//
//            while (Reader.hasNext()) {
//
//                x = new Course();
//                String Line = Reader.nextLine();
//                String[] seprated = Line.split("@");
//
//                // PL2@CS213@100@
//                x.setCname(seprated[0]);
//                x.setCId(seprated[1]);
//                x.setCreditHours(Integer.parseInt(seprated[2]));
//
//                Courses.add(x);
//            }
//
//            return (ArrayList<Object>) (Object) Courses;

        } else {
            return null;
        }

    }

}
