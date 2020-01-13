package app.interfaces;

import app.objects.Group;
import app.objects.Student;

/**
 * Institution
 */
public interface Institution {

    public void registerGroup(Group[] newGroups, Group[] originalGroups);
    public void enrollStudents(Student[] students, Group groups);

    
}