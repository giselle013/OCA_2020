package app.objects;

/**
 * Group class.
 */
public class Group {
    private String name;
    private Student students[];
    private float averageGPA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public float getAverageGPA() {
        return averageGPA;
    }

    public void setAverageGPA(float averageGPA) {
        this.averageGPA = averageGPA;
    }
}