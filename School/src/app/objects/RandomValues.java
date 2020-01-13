package app.objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 * This class will contain all the methods that will create the school
 * dynamically, including random name, GPA, groups, etc.
 */
public final class RandomValues {

    // Use this to create random names.
    public static String possibleNames[] = {
        "Ivan",
        "Josci",
        "Robert",
        "Jafet",
        "Bruno",
        "Beto",
        "Giss",
        "Cristian"
    };   

    // Use this to create random last names.
    public static String possibleLastnames[] = {
        "Pedrero",
        "Martinez",
        "Ramirez",
        "Bernal",
        "Muñoz",
        "Garcia",
        "Ortiz",
        "Epimaco"
    }; 

    // Use this to create random careers.
    public static String possibleCareers[] = {
        "ISC",
        "IMT",
        "LAD",
        "IBT",
        "LDI",
        "LIN"
    };
    
    // Use this to create random groups.
    public static String possibleGroups[] = {
        "Math",
        "Programming",
        "Physics",
        "Java",
        "Python"
    };

    public static String possibleCountries[] = {
        "Germany",
        "USA",
        "Italy",
        "Canada",
        "Japan"
    };

    public static String possiblePrograms[] ={
        "StudyAbroad",
        "Traditional Exchange"
    };

    public static String possibleSchools[] = {
        "ITESM",
        "UVM",
        "UNAM",
        "UAEM",
        "IPN",
        "ANÁHUAC",
        "VFS"
    };

    /**
     * This function concatenates random numbers to a string starting 
     * with 'A0' to create a random student number.
     * @return randomly generated student number as a string.
     */
    public static String RandomStudentNumber(){
        // Define counters.
        int i = 0, number = 0;

        // Create the base string.
        String string = "A01";

        // Loop to create the 6 numbers left in the string.
        while(i <= 6){

            // Get a random digit.
            number = randRangeInt(0, 9);
            
            // Concatenate it to the string.
            string += number + "";

            // Add to the counter.
            i++;
        }
        
        // Return the new student number.
        return string;
    }

    /**
     * This function will select a random student from a 
     * students array.
     * @param array Student array from which the random student will be selected.
     * @return The random student from the lsit.
     */
    public static Student getRandomStudent(Student[] array) {
        // Get a random index.
        int rnd = new Random().nextInt(array.length);

        // Return the student at the random position.
        return array[rnd];
    }

    /**
     * This method will return a random integer 
     * from a given range.
     * @param min Minimun range.
     * @param max Maximum range.
     * @return Randomly generated integer.
     */
    public static int randRangeInt(int min, int max) {
        int rand = ThreadLocalRandom.current().nextInt(min, max + 1);
        return rand;
    }

    /**
     * This method will return a random float 
     * from a given range.
     * @param min Minimun range.
     * @param max Maximum range.
     * @return Randomly generated float.
     */
    public static float randRangeFloat(int min, int max) {
        float rand = new Random().nextFloat() * (max - min) + min;
        return rand;
    }
}