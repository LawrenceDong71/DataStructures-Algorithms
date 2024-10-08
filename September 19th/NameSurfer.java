import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameSurfer {

    // My menu 7 option asks the user for a rank. Then it will show a list of names that have been 
    // ranked more than once at that rank.
    
    // Some names start with 'ch', but there are variations that use 'k' instead. The trend I
    // found was that the 'ch' are, most of the time, more popular than their 'k' starting 
    // counterpart. 
    // Christopher: from 1970 to 2000, this name has been ranked 2, 2, 2, 5 respectively
    // Kristopher: This name, on the other hand, has never made it to top 150
    // Christina: This name peaked at ranked 16 and remained in the top 100 from 1960 to 2000
    // Kristina: This name has only been in the top 100 twice
    // Christian: This name, from 1900 to 2000, has never been outside the top 700.
    // Kristian: This name has never been in the top 400.
    // Cameron: This isn't exactly 'ch' name, but this name as been ranked 53rd and 33rd
    // Kameron: On the other hand, this names peak was at rank 267.
    // Carol: This is another one, but this name peaked at 5, and has been ranked every year from
    // 1900 to 2000
    // Karol: This name peaked at 573 in 1940, and has only been ranked for 3 years.
    
    // NameRecord class test cases
    public static void simpleNameRecordTest() {
        NameRecord jakeRecord = new NameRecord("Jake", 1900, 
            new int[] {262, 312, 323, 479, 484, 630, 751, 453, 225, 117, 97});
        String name = "Jake";
        if (jakeRecord.getName().equals(name)) {
            System.out.println("Passed getName method");
        } else {
            System.out.println("Failed getName Method");
        }
        if (jakeRecord.getBaseDecade() == 1900) {
            System.out.println("Passed getBaseDecade method");
        } else {
            System.out.println("Failed getBaseDecade method");
        }
        if (jakeRecord.getDecades() == 11) {
            System.out.println("Passed getDecades method");
        } else {
            System.out.println("Failed getDecades method");
        }
        if (jakeRecord.getRank(0) == 262) {
            System.out.println("Passed getRank method");
        } else {
            System.out.println("Failed getRank method");
        }
        if (jakeRecord.getBestRankedDecade() == 2000) {
            System.out.println("Passed getBestRankedDecade method");
        } else {
            System.out.println("Failed getBestRankedDecade method");
        }
        if (jakeRecord.topOneThousand() == 11) {
            System.out.println("Passed topOneThousand method");
        } else {
            System.out.println("Failed topOneThousand method");
        }
        if (jakeRecord.rankedEveryDecade() == true) {
            System.out.println("Passed rankedEveryDecade method");
        } else {
            System.out.println("Failed rankedEveryDecade method");
        }
        if (jakeRecord.rankedOnlyOneDecade() == false) {
            System.out.println("Passed rankedOnlyOneDecade method");
        } else {
            System.out.println("Failed rankedOnlyOneDecade method");
        }
        if (jakeRecord.isMorePopular() == false) {
            System.out.println("Passed isMorePopular method");
        } else {
            System.out.println("Failed isMorePopular method");
        }
        if (jakeRecord.isLessPopular() == false) {
            System.out.println("Passed isMorePopular method");
        } else {
            System.out.println("Failed isMorePopular method");
        }
        String expected = "Jake\n"
            + "1900: 262\n"
            + "1910: 312\n"
            + "1920: 323\n"
            + "1930: 479\n"
            + "1940: 484\n"
            + "1950: 630\n"
            + "1960: 751\n"
            + "1970: 453\n"
            + "1980: 225\n"
            + "1990: 117\n"
            + "2000: 97\n";
        if (jakeRecord.toString().equals(expected)) {
            System.out.println("Passed toString method");
        } else {
            System.out.println("Failed toString method");
        }
        System.out.println();
        
        // second test
        NameRecord jasonRecord = new NameRecord("Jason", 1900, 
            new int[] {717, 707, 667, 679, 563, 420, 87, 3, 11, 45, 39});
        name = "Jason";
        if (jasonRecord.getName().equals(name)) {
            System.out.println("Passed getName method");
        } else {
            System.out.println("Failed getName Method");
        }
        if (jasonRecord.getBaseDecade() == 1900) {
            System.out.println("Passed getBaseDecade method");
        } else {
            System.out.println("Failed getBaseDecade method");
        }
        if (jasonRecord.getDecades() == 11) {
            System.out.println("Passed getDecades method");
        } else {
            System.out.println("Failed getDecades method");
        }
        if (jasonRecord.getRank(6) == 87) {
            System.out.println("Passed getRank method");
        } else {
            System.out.println("Failed getRank method");
        }
        if (jasonRecord.getBestRankedDecade() == 1970) {
            System.out.println("Passed getBestRankedDecade method");
        } else {
            System.out.println("Failed getBestRankedDecade method");
        }
        if (jasonRecord.topOneThousand() == 11) {
            System.out.println("Passed topOneThousand method");
        } else {
            System.out.println("Failed topOneThousand method");
        }
        if (jasonRecord.rankedEveryDecade() == true) {
            System.out.println("Passed rankedEveryDecade method");
        } else {
            System.out.println("Failed rankedEveryDecade method");
        }
        if (jasonRecord.rankedOnlyOneDecade() == false) {
            System.out.println("Passed rankedOnlyOneDecade method");
        } else {
            System.out.println("Failed rankedOnlyOneDecade method");
        }
        if (jasonRecord.isMorePopular() == false) {
            System.out.println("Passed isMorePopular method");
        } else {
            System.out.println("Failed isMorePopular method");
        }
        if (jasonRecord.isLessPopular() == false) {
            System.out.println("Passed isMorePopular method");
        } else {
            System.out.println("Failed isMorePopular method");
        }
        expected = "Jason\n"
            + "1900: 717\n"
            + "1910: 707\n"
            + "1920: 667\n"
            + "1930: 679\n"
            + "1940: 563\n"
            + "1950: 420\n"
            + "1960: 87\n"
            + "1970: 3\n"
            + "1980: 11\n"
            + "1990: 45\n"
            + "2000: 39\n";
        if (jasonRecord.toString().equals(expected)) {
            System.out.println("Passed toString method");
        } else {
            System.out.println("Failed toString method");
        }
        
    }

    private static final String NAME_FILE = "names.txt";

    public static void main(String[] args) {
        //simpleNameRecordTest();
        Scanner fileScanner = getFileScannerForNames(NAME_FILE);
        Names namesDatabase = new Names(fileScanner);
        fileScanner.close();
        runOptions(namesDatabase);
    }

    /* pre: namesDatabase != null
     * Ask user for options to perform on the given Names object.
     * Creates a Scanner connected to System.in.
     */
    private static void runOptions(Names namesDatabase) {
        Scanner keyboard = new Scanner(System.in);
        MenuChoices[] menuChoices = MenuChoices.values();
        MenuChoices menuChoice;
        do {
            showMenu();
            int userChoice = getChoice(keyboard) - 1;
            menuChoice = menuChoices[userChoice];
            if(menuChoice == MenuChoices.SEARCH) {
                search(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.ONE_NAME) {
                oneName(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.APPEAR_ONCE) {
                appearOnce(namesDatabase);
            } else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
                appearAlways(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_MORE) {
                alwaysMore(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_LESS) {
                alwaysLess(namesDatabase);
            } else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
                ownDesignMethod(namesDatabase, keyboard);
            }
        } while(menuChoice != MenuChoices.QUIT);
        keyboard.close();
    }
    
    /* Create a Scanner and return connected to a File with the given name.
     * pre: fileName != null
     * post: Return a Scanner connected to the file or null
     * if the File does not exist in the current directory.
     */
    private static Scanner getFileScannerForNames(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("\n***** ERROR IN READING FILE ***** ");
            System.out.println("Can't find this file "
                    + fileName + " in the current directory.");
            System.out.println("Error: " + e);
            String currentDir = System.getProperty("user.dir");
            System.out.println("Be sure " + fileName + " is in this directory: ");
            System.out.println(currentDir);
            System.out.println("\nReturning null from method.");
            sc = null;
        }
        return sc;
    }
    
    // this search returns  a list of names that have been ranked more than once at the 
    // specified rank given by the client
    private static void ownDesignMethod(Names namesDatabase, Scanner keyboard) {
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        
        System.out.print("Enter a rank: ");
        int input = keyboard.nextInt();
        System.out.println();
        if (input == 0) {
            System.out.println("There are " + namesDatabase.menu7Option(input).size() + 
                " names that have been ranked outside of the top one thousand multiple times");
        } else {
            System.out.println("There are " + namesDatabase.menu7Option(input).size() + 
                " names that have been ranked at " + input + " multiple times.");
        }
        System.out.println(namesDatabase.menu7Option(input));
        
    }

    /* Display the names that have appeared in every decade.
     * pre: n != null
     * post: print out names that have appeared in ever decade
     */
    private static void appearAlways(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        System.out.println(namesDatabase.rankedEveryDecade().size() + 
            " names appear in every decade. The names are: ");
        System.out.println(namesDatabase.rankedEveryDecade());
    }

    /* Display the names that have appeared in only one decade.
     * pre: n != null
     * post: print out names that have appeared in only one decade
     */
    private static void appearOnce(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        System.out.println(namesDatabase.rankedOnlyOneDecade().size() + 
            " names appear in exactly one decade. \nThe names are: ");
        
        System.out.println(namesDatabase.rankedOnlyOneDecade());
    }

    /* Display the names that have gotten more popular
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten more popular in each decade
     */
    private static void alwaysMore(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        System.out.println(namesDatabase.alwaysMorePopular().size() + 
            " names are more popular in every decade.");
        System.out.println(namesDatabase.alwaysMorePopular());

    }

    /* Display the names that have gotten less popular
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten less popular in each decade
     */
    private static void alwaysLess(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        System.out.println(namesDatabase.alwaysLessPopular().size() + 
            " names are less popular in every decade");
        System.out.println(namesDatabase.alwaysLessPopular());

    }

    /* Display the data for one name or state that name has never been ranked.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: print out the data for n or a message that n has never been in the
     * top 1000 for any decade
     */
    private static void oneName(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        
        System.out.print("Eneter a name: ");
        String input = keyboard.nextLine();
        if (namesDatabase.getName(input) == null) {
            System.out.println(input + " does not appear in any decade");
        } else {
            System.out.println(namesDatabase.getName(input).toString());
        }

    }

    /* Display all names that contain a substring from the user
     * and the decade they were most popular.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: display the data for each name.
     */
    private static void search(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        
        System.out.print("Enter a partial name: ");
        String input = keyboard.nextLine();
        System.out.println();
        System.out.println("There are " + namesDatabase.nameWithMostPopularDecade(input).size() + 
            " matches for " + input);
        System.out.println("The matches with their highest ranking decade are:");
        System.out.println(namesDatabase.nameWithMostPopularDecade(input));

    }

    /* Get choice from the user keyboard != null and is connected to System.in
     * return an int that is >= MenuChoices.SEARCH.ordinal()
     *  and <= MenuChoices.QUIT.ordinal().
     */
    private static int getChoice(Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (keyboard == null) {
            throw new IllegalArgumentException("The parameter keyboard cannot be null");
        }
        int choice = getInt(keyboard, "Enter choice: ");
        keyboard.nextLine();
        // Add one due to zero based indexing of enums, but 1 based indexing of menu.
        final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
        while (choice < 1  || choice > MAX_CHOICE) {
            System.out.println();
            System.out.println(choice + " is not a valid choice");
            choice = getInt(keyboard, "Enter choice: ");
            keyboard.nextLine();
        }
        return choice;
    }

    /* Ensure an int is entered from the keyboard.
     * pre: s != null and is connected to System.in
     * post: return the int typed in by the user.
     */
    private static int getInt(Scanner s, String prompt) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (s == null) {
            throw new IllegalArgumentException("The parameter s cannot be null");
        }
        System.out.print(prompt);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // Show the user the menu.
    private static void showMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("Enter 1 to search for names.");
        System.out.println("Enter 2 to display data for one name.");
        System.out.println("Enter 3 to display all names that appear in only "
                + "one decade.");
        System.out.println("Enter 4 to display all names that appear in all "
                + "decades.");
        System.out.println("Enter 5 to display all names that are more popular "
                + "in every decade.");
        System.out.println("Enter 6 to display all names that are less popular "
                + "in every decade.");
        System.out.println("Enter 7 to display all names that have been ranked more "
            + "than once at a certain rank");
        System.out.println("Enter 8 to quit.");
        System.out.println();
    }

    /**
     * An enumerated type to hold the menu choices
     * for the NameSurfer program.
     */
    private static enum MenuChoices {
        SEARCH, ONE_NAME, APPEAR_ONCE, APPEAR_ALWAYS, ALWAYS_MORE,
        ALWAYS_LESS, STUDENT_SEARCH, QUIT;
    }
}
