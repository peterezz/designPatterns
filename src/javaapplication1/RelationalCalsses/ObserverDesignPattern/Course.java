package javaapplication1.RelationalCalsses.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;
import javaapplication1.RelationalCalsses.SingltonDesignPattern.FileManger;
import javaapplication1.RelationalCalsses.StrategyDesignPattern.Student;
import static javaapplication1.RelationalCalsses.StrategyDesignPattern.Student.Students;

/**
 *
 * @author Tamer A.Yassen
 */
public class Course implements Subject {

    private String Avilability;
    private List<observer> observerList;
    private String courseAvailablity;
    private String CName, CId;
    private int CreditHours;
    private int Studentid;
    FileManger FManger = FileManger.getInstance();
    private final String CourseFileName = "Courses.txt";
    private final String CourseAvailability = "CoursesAvailabity.txt";
    public static ArrayList<Course> Courses = new ArrayList<Course>();
    public static ArrayList<Course> CoursesAvilable = new ArrayList<Course>();

    public Course() {
    }

    public Course(String Avilability, String CName, String CId, int CreditHours, int id) {
        this.Avilability = Avilability;
        this.CName = CName;
        this.CId = CId;
        this.CreditHours = CreditHours;
        this.Studentid = id;

    }

    public Course(String Avilability, String CName, String CId, int CreditHours) {
        this.Avilability = Avilability;
        this.CName = CName;
        this.CId = CId;
        this.CreditHours = CreditHours;
    }

    public Course(String cID, String cName) {
        this.CId = cID;
        this.CName = cName;
        observerList = new ArrayList<>();

    }

    public int getStudentID() {
        return this.Studentid;
    }

    public void setStudentID(int studentID) {
        this.Studentid = studentID;
    }

    public void setCId(String Id) {
        this.CId = Id;
    }

    public void setCname(String name) {
        this.CName = name;
    }

    public void setCreditHours(int CreditHours) {
        this.CreditHours = CreditHours;
    }

    public String getCId() {
        return this.CId;
    }

    public String getCname() {
        return this.CName;
    }

    public int getCreditHours() {
        return this.CreditHours;
    }

    public void setAvilability(String Avilability) {
        this.Avilability = Avilability;
    }

    public String getCourseAvailability() {
        return Avilability;
    }

    public void addToCourseStudent() {
        loadFromCourseName();
        Courses.add(this);
        commitToCourseName();
    }

    public void addToCourseAvailablty() {
        loadFromCourseAvailable();
        CoursesAvilable.add(this);
        commitToCourseAvailable();
    }

    public void checkcourseAvailability(String cID) {

        for (int i = 0; i < CoursesAvilable.size(); i++) {
            if (CoursesAvilable.get(i).getCId().equals(CName)) {
                Avilability = CoursesAvilable.get(i).getCourseAvailability();
            }
        }

    }

    private void commitToCourseName() {
        FManger.write(Courses.get(0).getCourseData(), CourseFileName, false);
        for (int i = 1; i < Courses.size(); i++) {
            FManger.write(Courses.get(i).getCourseData(), CourseFileName, true);
        }
    }

    private void commitToCourseAvailable() {
        FManger.write(CoursesAvilable.get(0).getCourseavailableData(), CourseAvailability, false);
        for (int i = 1; i < CoursesAvilable.size(); i++) {
            FManger.write(CoursesAvilable.get(i).getCourseavailableData(), CourseAvailability, true);
        }
    }

    private void loadFromCourseName() {
        Courses = (ArrayList<Course>) (Object) FManger.read(CourseFileName);
    }

    private void loadFromCourseAvailable() {
        CoursesAvilable = (ArrayList<Course>) (Object) FManger.read(CourseAvailability);
    }

    private int getCourseIndex(String id) {
        for (int i = 0; i < Courses.size(); i++) {
            if (Courses.get(i).getCId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    private int getCourseAvailableIndex(String id) {
        for (int i = 0; i < CoursesAvilable.size(); i++) {
            if (CoursesAvilable.get(i).getCId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public Course searchCourseById(String id) {
        Course temp = null;
        loadFromCourseName();
        int index = getCourseIndex(id);
        if (index != -1) {
            return Courses.get(index);
        } else {
            return temp;
        }
    }

    public String getAvilability() {
        return Avilability;
    }

    public Course searchCourseAvailablityById(String id) {
        Course temp = null;
        loadFromCourseAvailable();
        int index = getCourseAvailableIndex(id);
        if (index != -1) {
            return CoursesAvilable.get(index);
        } else {
            return temp;
        }
    }

    public ArrayList<Course> listCourses() {
        loadFromCourseName();
        return Courses;
    }

    public ArrayList<Course> listCoursesAvailable() {
        loadFromCourseAvailable();
        return CoursesAvilable;
    }

    public boolean updateCourse() {
        loadFromCourseName();
        int index = getCourseIndex(this.CId);

        if (index != -1) {
            Courses.set(index, this);

            commitToCourseName();
            return true;
        }

        return false;
    }

    public boolean updateCourseAvilablty(String oldID) {
        loadFromCourseAvailable();
        int index = getCourseAvailableIndex(oldID);

        if (index != -1) {
            CoursesAvilable.set(index, this);

            commitToCourseAvailable();
            return true;

        }

        return false;
    }

    public boolean deleteCourse(String id) {
        loadFromCourseName();
        int index = getCourseIndex(id);

        if (index != -1) {
            Courses.remove(index);

            commitToCourseName();
            return true;
        }

        return false;
    }

    public boolean deleteCourseAvailable(String id) {
        loadFromCourseAvailable();
        int index = getCourseAvailableIndex(id);

        if (index != -1) {
            CoursesAvilable.remove(index);

            commitToCourseAvailable();
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nCourse Name : " + CName + "\t" + "Course ID : " + CId + "\n" + "Course Credit Hours : " + CreditHours + "\n";
    }

    @Override
    public void subscribe(observer Observer) {
        observerList.add(Observer);
    }

    @Override
    public void unsubscribe(observer Observer) {
        observerList.remove(Observer);
    }

    @Override
    public void notifyAllSubscribers() {
        for (observer Observer : observerList) {
            Observer.getNotification(courseAvailablity);
        }
    }

    public void setAvailability() {
        if (getAvilability().equals("Available")) {
            courseAvailablity = this.CName + " is Available";
        } else if (getAvilability().equals("NotAvailable")) {
            courseAvailablity = this.CName + " is NOT Available";

        }

        notifyAllSubscribers();
    }

    private String getCourseData() {

        return this.CId + "@" + this.Studentid;

    }

    /*
     x.setCId(seprated[0]);
                x.setCname(seprated[1]);
                x.setCreditHours(Integer.parseInt(seprated[2]));
                x.setAvilability(seprated[3]);
    
     */
    private String getCourseavailableData() {

        return this.CId + "@" + this.CName + "@" + this.CreditHours + "@" + this.Avilability;

    }

    public boolean setCoursID(String ID) {
        loadFromCourseAvailable();
        for (int i = 0; i < CoursesAvilable.size(); i++) {
            if (CoursesAvilable.get(i).getCId().equals(ID)) {
                return false;
            }
        }
        return true;

    }
}
