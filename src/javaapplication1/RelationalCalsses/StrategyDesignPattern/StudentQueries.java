/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.StrategyDesignPattern;

import java.util.ArrayList;
import javaapplication1.RelationalCalsses.FactoryDesigPattern.UserFactory;
import javaapplication1.RelationalCalsses.SingltonDesignPattern.FileManger;
import static javaapplication1.RelationalCalsses.StrategyDesignPattern.Student.Students;

/**
 *
 * @author Peter
 */
public class StudentQueries implements FileQueries {

    private final String studentFileName = UserFactory.getInstance().student + ".txt";
    FileManger FManger = FileManger.getInstance();

//    public static ArrayList<Student> Students = new ArrayList<Student>();
    public StudentQueries() {
    }

    @Override
    public boolean addUser(String Data) {
        if (FManger.write(Data, studentFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

//    @Override
//    public void commitToFile(String Data,String Data1) {
//        FManger.write(Data, studentFileName, false);
//        for (int i = 1; i < Students.size(); i++) {
//            FManger.write(Data1, studentFileName, true);
//        }
//
////    }
    @Override
    public void loadFromFile() {
        Students = (ArrayList<Student>) (Object) FManger.read(studentFileName);
    }

    @Override
    public boolean deleteUser(int id) {
//        loadFromFile();
        int index = getUserIndex(id);
        if (index != -1) {
            Students.remove(index);
            return true;
        }
        return false;
    }

//    @Override
//    public void updateUser(int oldID ,Student ) {
//loadFromFile();
//        int index = getUserIndex(oldID);
//        Students.set(index, this);
//        commitToFile();    }
//    @Override
//    public int getUserIndex(int id) {
//        for (int i = 0; i < Students.size(); i++) {
//            if (Students.get(i).getID() == id) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
    @Override
    public boolean updateUser(int oldID, Student x) {
//        loadFromFile();
        int index = getUserIndex(oldID);
        if (index != -1) {
            Students.set(index, x);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(int oldID, Professor x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student searchUser(int id) {
//        loadFromFile();
        int index = getUserIndex(id);
        Student temp = null;
        if (index != -1) {
            return Students.get(index);
        } else {
            return temp;
        }
    }

    @Override
    public Professor SearchUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUserIndex(int id) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }
}
