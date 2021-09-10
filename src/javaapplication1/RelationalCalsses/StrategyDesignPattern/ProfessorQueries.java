/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.RelationalCalsses.StrategyDesignPattern;

import java.util.ArrayList;
import javaapplication1.RelationalCalsses.SingltonDesignPattern.FileManger;
import static javaapplication1.RelationalCalsses.StrategyDesignPattern.Professor.Professors;
import static javaapplication1.RelationalCalsses.StrategyDesignPattern.Student.Students;

/**
 *
 * @author Peter
 */
public class ProfessorQueries implements FileQueries {

    private final String ProfFileName = "Professor.txt";
    FileManger FManger = FileManger.getInstance();

//    public static ArrayList<Student> Students = new ArrayList<Student>();
    public ProfessorQueries() {
    }

    @Override
    public boolean addUser(String Data) {
        if (FManger.write(Data, ProfFileName, true)) {
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
//    }
    @Override
    public void loadFromFile() {
        Professors = (ArrayList<Professor>) (Object) FManger.read(ProfFileName);

    }

    @Override
    public boolean deleteUser(int id) {
//        loadFromFile();
        int index = getUserIndex(id);
        if (index != -1) {
            Professors.remove(index);
            return true;
        }
        return false;
//        commitToFile(Data,Data1);
    }

//    @Override
//    public void updateUser(int oldID ,Student ) {
//loadFromFile();
//        int index = getUserIndex(oldID);
//        Students.set(index, this);
//        commitToFile();    }
//    @Override
//    public int getUserIndex(int id) {
//        for (int i = 0; i < Professors.size(); i++) {
//            if (Professors.get(i).getID() == id) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
    @Override
    public boolean updateUser(int oldID, Student x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(int oldID, Professor x) {
//        loadFromFile();

        int index = getUserIndex(oldID);
        if (index != -1) {
            Professors.set(index, x);
            return true;
        }
        return false;
    }

    @Override
    public Student searchUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Professor SearchUser(int id) {
//        loadFromFile();

        Professor temp = null;
        int index = getUserIndex(id);
        if (index != -1) {
            return Professors.get(index);
        } else {
            return temp;
        }
    }

    @Override
    public int getUserIndex(int id) {
        for (int i = 0; i < Professors.size(); i++) {
            if (Professors.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

}
