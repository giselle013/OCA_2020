package app.objects;
/**
 * Student class.
 */
public class Student{
    private String name;
    private String studentNumber;
    private String career;
    private float gpa;
    private int coursingYear;

    public Student(String name, String studentNumber, String career, float gpa, int coursingYear){
        this.name = name;
        this.studentNumber = studentNumber;
        this.career = career;
        this.gpa = gpa;
        this.coursingYear = coursingYear;

    }

    public Student(String name){
        this(name, null, null, 0.0F, 0);
    }

    public Student(){

    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getCoursingYear() {
        return coursingYear;
    }

    public void setCoursingYear(int coursingYear) {
        this.coursingYear = coursingYear;
    }
}