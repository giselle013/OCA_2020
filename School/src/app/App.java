package app;

import app.exceptions.SchoolExceptions;
import app.objects.Foreign;
import app.objects.School;
import app.objects.Group;
import app.objects.Student;

import static app.objects.RandomValues.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main driver class. It will create arrays from Student, Group and School 
 * classes and link them together using their attributes. Each time the 
 * program runs, it will generate a new school using random values.
 */
public class App {

    // Array of students.
    private static Student[] students;

    // Array of groups.
    private static Group[] groups;

    // Only one school.
    private static ArrayList<School> schools;

    /**
     * This class will create an array of 20 students and assign 
     * random properties using the random generator class.
     * @see java
     */
    private static void createStudents() {
        // Create the 20 students array.
        students = new Student[20];


        // Loop through each student from the array and create the random properties.
        for (int i = 0; i < students.length; i++) {

            if(i> students.length/2){
                students[i] = new Foreign(possibleNames[randRangeInt(0,
                possibleNames.length - 1)] + " "
                + possibleLastnames[randRangeInt(0,
                        possibleLastnames.length - 1)],
                    possibleCountries[randRangeInt(0,possibleCountries.length - 1)],
                    possiblePrograms[randRangeInt(0,possiblePrograms.length - 1)]

                );
            }else{
            // Create the object in the heap memory.
                students[i] = new Student();

             // Assign a random name and last name.
             students[i].setName(possibleNames[randRangeInt(0,
             possibleNames.length - 1)] + " "
             + possibleLastnames[randRangeInt(0,
                     possibleLastnames.length - 1)]);
            }

           
                
            // Assign a random student number.
            students[i].setStudentNumber(RandomStudentNumber()); 

            // Assign a random career.
            students[i].setCareer(possibleCareers[randRangeInt(0,
            possibleCareers.length - 1)]); 
            
            // Assign a random GPA.
            students[i].setGpa(randRangeFloat(80, 100));

            // Assign a random coursing year.
            students[i].setCoursingYear(randRangeInt(1, 9));
        }
    }

    /**
     * This method will create 5 groups randomly and assign random properties,
     * a random student list and will compute the average GPA using each student GPA.
     */
    private static void createGroups() {
        // Create the array of groups int thhe heap memory.
        groups = new Group[5];

        // Iterate over each group.
        for (int n = 0; n < groups.length; n++) {

            // Create the group.
            groups[n] = new Group();

            // Assign a random name.
            groups[n].setName(possibleGroups[randRangeInt(0,
            possibleGroups.length - 1)]);

            for (int j = 0; j < groups.length; j++) {

                if(groups[j] != null && j != n){

                    while(groups[j].getName() == groups[n].getName()) {

                        // Assign a random name.
                        groups[n].setName(possibleGroups[randRangeInt(0,
                        possibleGroups.length - 1)]);
                    } 
                                               
                }
                
            }
        }
    }

    /**
     * This method will create a single school and assign all the groups 
     * previously created, as well as compute the GPA for the entire school.
     */
    private static void createSchool(School school) {

        // Give it a name.
        school.setName(possibleSchools[randRangeInt(0, possibleSchools.length -1)]);

        school.registerGroup(new Group[groups.length], groups);

        for (Group group : groups) {
            school.enrollStudents(students, group);
        }

        //Calculate GPA.

        for (Group group : school.getGroups()) {
            school.setSchoolGPA(school.getSchoolGPA() + group.getAverageGPA());
        }

        school.setSchoolGPA(school.getSchoolGPA() / school.getGroups().length);
       
    }

    private static void createSchools(){
        schools = new ArrayList<School>();

        for(int i=0; i<5; i++){

            // Create the students.
            createStudents();

            // Create the groups.
            createGroups();

            // Create the object.
            School school = new School();
            createSchool(school);
            schools.add(school);
        }
    }

    /**
     * This method will display a simple console menu to check the results 
     * of the dynamically generated school.
     */
    private static void menu() {

        // Use this op variable to ask for input from the user.
        int op = 0;

        // Use the scanner object to read the input.
        Scanner scanner = new Scanner(System.in);

        // Display the options.
        System.out.println();
        System.out.println("VERY BASIC management tool for ");
        System.out.println("1) List schools");
        System.out.println("2) List groups from school");
        System.out.println("3) List students from school");
        System.out.println("4) Exit");
        System.out.println();

        // Ask for the input from the user.
        try {
            System.out.println("Select the option : ");
            op = scanner.nextInt();
            
        } catch (SchoolExceptions e) {
            System.out.println(e);
            scanner.close();
        }

        // Switch through the options variable.
        switch (op) {
        case 1:
            listSchools();
            break;
        case 2:
            selectSchoolForGroup();
            break;
        case 3:
            selectSchoolForStudent();
            break;
        case 4:
            System.exit(0);
            break;
        default:
            System.out.println("[ERROR] Invalid option.");
            menu();
            break;
        }

        // Close the scanner.
        scanner.close();
    }

    private static void listSchools(){
        System.out.println("Schools");
        for (School school : schools) {
            System.out.println("Name : " + school.getName());
            System.out.println("GPA : " + school.getSchoolGPA());
            
        }

        returnToMenuOnEnter();

    }

    /**
     * This method will display the menu again when the user press enter.
     */
    public static void returnToMenuOnEnter(){
        // Create the scanner object.
        Scanner scanner = new Scanner(System.in);

        // Ask for the input.
        System.out.println("\nType ENTER to continue...\n");

        // If the input is enter (the user didn't pressed anything)...
        if (scanner.nextLine().equals("")){
            // Display the menu.
            menu();

            // Close the scanner.
            scanner.close();
        }    
    }

    private static void selectSchoolForGroup(){

        Scanner scanner = new Scanner(System.in);

        // Print the options dynamically. (We prompt i to start at 1).
        int i = 1;
        for (School school : schools) {
            System.out.println(i + ") " + school.getName());
            i++;
            
        }

        // Ask for user input.
        System.out.println();
        System.out.println("Select the School : ");
        int schoolSelected = scanner.nextInt();

        // Validate if the group selected is valid.
        if(schoolSelected < 0 || schoolSelected > schools.size()){

            System.out.println("[ERROR]: Invalid group.");

            selectSchoolForGroup();

        }else {
            // Display the group (sending the index minus one due arrays startign at index 0).
            listGroups(schoolSelected-1);
        }

        // Close the scanner.
        scanner.close();
    }

    private static void selectSchoolForStudent(){

        Scanner scanner = new Scanner(System.in);

        // Print the options dynamically. (We prompt i to start at 1).
        int i = 1;
        for (School school : schools) {
            System.out.println(i + ") " + school.getName());
            i++;
            
        }

        // Ask for user input.
        System.out.println();
        System.out.println("Select the School : ");
        int schoolSelected = scanner.nextInt();

        // Validate if the group selected is valid.
        if(schoolSelected < 0 || schoolSelected > schools.size()){

            System.out.println("[ERROR]: Invalid group.");

            selectSchoolForGroup();

        }else {
            // Display the group (sending the index minus one due arrays startign at index 0).
            listStudents(schoolSelected-1);
        }

        // Close the scanner.
        scanner.close();
    }

    /**
     * This method will list the dynamically created groups linked to a school.
     */
    private static void listGroups(int schoolIndex) {
        // Print the school.
        System.out.println("School : " + schools.get(schoolIndex).getName());
        System.out.println();

        // For each group assigned to the school...
        for (Group group : schools.get(schoolIndex).getGroups()) {
            // Print its attributes.
            System.out.println("Group       : " + group.getName());
            System.out.println("Average GPA : " + group.getAverageGPA());
            System.out.println();
        }

        // Return to menu when enter key is pressed.
        returnToMenuOnEnter();
    }

    /**
     * This method will list the dynamically created students linked to a school.
     */
    private static void listStudents(int schoolIndex) {
        // Print the school.
       System.out.println("School : " + schools.get(schoolIndex).getName());
        System.out.println();
        
        for (Group group : schools.get(schoolIndex).getGroups()) {
            // For each student...
            for (Student student : group.getStudents()) {
                
                // Print its attributes.
                System.out.println("Name:   " + student.getName());
                System.out.println("Number: " + student.getStudentNumber());
                System.out.println("Career: " + student.getCareer());
                System.out.println("GPA:    " + student.getGpa());
                System.out.println("Year:   " + student.getCoursingYear());
                
                //Check type of student
                if(student instanceof Foreign){
                    System.out.println("Type:   Foreign");
                    System.out.println("Country:  " + ((Foreign) student).getCountry());
                    System.out.println("Program:  "+ ((Foreign) student).getProgram());
                    
                }else if(student instanceof Student){

                    System.out.println("Type:  Local");
                }

                System.out.println();
            }

        }

        // Return to menu when enter key is pressed.
        returnToMenuOnEnter();
    }

    /**
     * Program driver function. It will create the students, groups 
     * and school dynamically, as well as displaying the menu.
     * @param args
     */
    public static void main(String ...args) {

        // Create the school.
        createSchools();

        // Display the menu.
        menu();
    }
}