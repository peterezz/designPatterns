package javaapplication1.RelationalCalsses.StrategyDesignPattern;

import java.util.ArrayList;
import javaapplication1.RelationalCalsses.User;

/**
 *
 * @author Tamer A.Yassen
 */
public class Professor extends User {

    private String officeHours;
    private FileQueries fileQueries;

    private final String ProfFileName = "Professor.txt";

    public static ArrayList<Professor> Professors = new ArrayList<Professor>();
    private double salary;

    public Professor() {
    }

    public Professor(FileQueries fileQueries) {
        this.fileQueries = fileQueries;
    }

    public Professor(String officeHours, double salary, String userName, String pass, String fname, String lname, int age, String status) {
        super(userName, pass, fname, lname, age, status);
        this.officeHours = officeHours;
        this.salary = salary;
    }

    public Professor(String officeHours, double salary, String userName, String pass, String fname, String lname, int age, String status, FileQueries fileQueries) {
        super(userName, pass, fname, lname, age, status);
        this.officeHours = officeHours;
        this.salary = salary;
         this.fileQueries=fileQueries;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setOfficeHours(String h) {
        this.officeHours = h;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public boolean addProf() {
        return fileQueries.addUser(getProfData());
    }

    private String getProfData() {
        return this.id + "@" + this.fname + "@" + this.lname + "@" + this.age + "@" + this.salary + "@" + this.officeHours + "@" + this.userName + "@" + this.pass + "@";
    }

    private void commitToFile() {
        FManger.write(Professors.get(0).getProfData(), ProfFileName, false);
        for (int i = 1; i < Professors.size(); i++) {
            FManger.write(Professors.get(i).getProfData(), ProfFileName, true);
        }

    }

    private int getProfIndex(int id) {
        return fileQueries.getUserIndex(id);
//for (int i = 0; i < Professors.size(); i++) {
//            if (Professors.get(i).getID() == id) {
//                return i;
//            }
//        }
//
//        return -1;
    }

    private void loadFromFile() {
        Professors = (ArrayList<Professor>) (Object) FManger.read(ProfFileName);
//fileQueries.loadFromFile();
    }

    public String displayAllProfs() {
        loadFromFile();
        String S = "\nAll Professors Data:\n";
        for (Professor x : Professors) {
            S = S + x.toString();
        }
        return S;
    }

    public Professor searchProf(int id) {
        loadFromFile();
        return fileQueries.SearchUser(id);
//        loadFromFile();
//        int index = getProfIndex(id);
//        if (index != -1) {
//            return "\nFound ...!" + Professors.get(index).toString();
//        } else {
//            return "\nNot Found ...!";
//        }
    }

    public boolean updateProf(int oldID, Professor x) {
//        
        loadFromFile();

        if (fileQueries.updateUser(oldID, x)) {
            commitToFile();
            return true;
        }
        return false;

    }

    public boolean deleteProf(int id) {
        loadFromFile();

        int index = getProfIndex(id);
        if (fileQueries.deleteUser(index)) {
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Prof : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + officeHours + "\n" + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Lectures !");
    }

    @Override
    public boolean login(int id, String PASS) {
        loadFromFile();

        for (int i = 0; i < Professors.size(); i++) {
            if (Professors.get(i).getID() == id && Professors.get(i).getPass().equals(PASS)) {

                return true;
            }
        }

        return false;
    }

    @Override
    public void setid() {
        loadFromFile();
        this.id = Professors.get(Professors.size() - 1).getID();
        this.id++;
    }
}
