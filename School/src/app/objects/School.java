package app.objects;

import app.interfaces.Institution;

import static app.objects.RandomValues.*;

import app.extensions.Building;

/**
 * School class.
 */
public class School extends Building implements Institution {
    private String name;
    private Group groups[];
    private float schoolGPA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public float getSchoolGPA() {
        return schoolGPA;
    }

    public void setSchoolGPA(float schoolGPA) {
        this.schoolGPA = schoolGPA;
    }

    @Override
    public void registerGroup(Group[] newGroups, Group[] originalGroups){

        this.setGroups(newGroups);

        // Iterate over each group.
        for (int i = 0; i < originalGroups.length; i++) {
            // Assign the group to the school.
            this.groups[i] = originalGroups[i];

            // Sum the average GPA of the group to the total GPA of the school.
            this.setSchoolGPA(this.getSchoolGPA() + originalGroups[i].getAverageGPA());
        }

        // Compute the total GPA.
        this.setSchoolGPA(this.getSchoolGPA() / originalGroups.length);

    }

    @Override
    public void enrollStudents(Student[] students, Group group){

        // Create the 9 student array to enroll in this course.
        group.setStudents(new Student[9]);

        // Iterate over each student empty place in the array.
        for (int i = 0; i < group.getStudents().length; i++) {

            // For the current group (we are in position 'n'), enroll a random student.
            group.getStudents()[i] = getRandomStudent(students);

            //For the current group, add to the GPA the enrolled student.
            group.setAverageGPA(group.getAverageGPA() + group.getStudents()[i].getGpa());
        }

        // Compute the average GPA of the group.
        group.setAverageGPA(group.getAverageGPA() / group.getStudents().length);



    }
}