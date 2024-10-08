/*  Student information for assignment:
*
*  On my honor, Lawrence Dong, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: lrd2265
*  email address: lawrencerdong@gmail.com
*  Number of slip days I am using: 0
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* A collection of NameRecords.
* Stores NameRecord objects and provides methods to select
* NameRecords based on various criteria.
*/
public class Names {
    // private arraylist to store all the name records
    private ArrayList<NameRecord> listOfRecords;
    /**
     * Construct a new Names object based on the data source the Scanner
     * sc is connected to. Assume the first two lines in the
     * data source are the base year and number of decades to use.
     * Any lines without the correct number of decades are discarded
     * and are not part of the resulting Names object.
     * Any names with ranks of all 0 are discarded and not
     * part of the resulting Names object.
     * @param sc Is connected to a data file with baby names
     * and positioned at the start of the data source.
     */ 
    public Names(Scanner sc) {
        if (sc == null) {
            throw new IllegalArgumentException("Scanner cannot be null");
        }
        
        listOfRecords = new ArrayList<NameRecord>();
        
        // first line of file will be baseDecade
        int baseDecade = Integer.parseInt(sc.nextLine());
        // next line indicates how many decades
        int numOfDecades = Integer.parseInt(sc.nextLine());
        
        while (sc.hasNextLine()) {
            // grabs the current name and its data
            String line = sc.nextLine();
            String[] parsedData = line.split("\\s+");
            // checks to see if all ranks are 0 or not
            boolean allZeroes = true;
            
            // ignore the line if the amount of ranks don't match up with numOfDecades
            if (parsedData.length - 1 == numOfDecades) {
                // name comes first
                String name = parsedData[0];
                int[] ranks = new int[numOfDecades];
                for (int i = 1; i <= numOfDecades; i++) {
                    int currentRank = Integer.parseInt(parsedData[i]);
                    ranks[i - 1] = currentRank;
                    if (currentRank != 0) {
                        // at least 1 non zero element is required
                        allZeroes = false;
                    }
                }
                
                if (!allZeroes) {
                    listOfRecords.add(new NameRecord(name, baseDecade, ranks));
                }
            }
        }  
        
        // sort Name objects based on the name of each of NameRecord object
        Collections.sort(listOfRecords);
    }

   /**
    * Returns an ArrayList of NameRecord objects that contain a
    * given substring, ignoring case.  The names must be in sorted order based
    * on the names of the NameRecords.
    * @param partialName != null, partialName.length() > 0
    * @return an ArrayList of NameRecords whose names contains
    * partialName. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<NameRecord> getMatches(String partialName) {
       if (partialName == null) {
           throw new IllegalArgumentException("Parameter cannot be null");
       }
       
       ArrayList<NameRecord> result = new ArrayList<>();
             
       for (NameRecord current : listOfRecords) {
           // ignore case
           if (current.getName().toLowerCase().contains(partialName.toLowerCase())) {
               result.add(current);
           }
       }
       
       return result;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better for every decade. The Strings  must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been ranked in the top
    * 1000 or better in every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedEveryDecade() {
       ArrayList<String> result = new ArrayList<>();
       
       for (NameRecord current : listOfRecords) {
           if (current.rankedEveryDecade()) {
               result.add(current.getName());
           }
       }
       
       return result;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better in exactly one decade. The Strings must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been ranked in the top
    * 1000 or better in exactly one decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedOnlyOneDecade() {
       ArrayList<String> result = new ArrayList<>();
       
       for (NameRecord current : listOfRecords) {
           if (current.rankedOnlyOneDecade()) {
               result.add(current.getName());
           }
       }
       
       return result;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting more
    * popular every decade. The Strings  must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been getting more popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> alwaysMorePopular() {
       ArrayList<String> result = new ArrayList<>();
       
       for (NameRecord current : listOfRecords) {
           if (current.isMorePopular()) {
               result.add(current.getName());
           }
       }
       
       return result;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting less
    * popular every decade. The Strings  must be in sorted order based
    * on the name of the NameRecords.
    * @return A list of the names that have been getting less popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> alwaysLessPopular() {
       ArrayList<String> result = new ArrayList<>();
       
       for (NameRecord current : listOfRecords) {
           if (current.isLessPopular()) {
               result.add(current.getName());
           }
       }
       
       return result;
   }

   /**
    * Return the NameRecord in this Names object that matches the given String ignoring case.
    * <br>
    * <tt>pre: name != null</tt>
    * @param name The name to search for.
    * @return The name record with the given name or null if no NameRecord in this Names
    * object contains the given name.
    */
   public NameRecord getName(String name) {
       // check preconditions
       if (name == null) {
           throw new IllegalArgumentException("The parameter name cannot be null");
       }
       
       for (NameRecord current : listOfRecords) {
           if (name.equalsIgnoreCase(current.getName())) {
               return current;
           }
       }
       
       return null;
   }
   
   // menu option 1 helper
   // returns a list of names ALONG with its most popular decade
   public ArrayList<String> nameWithMostPopularDecade(String name) {
       // check preconditions
       if (name == null) {
           throw new IllegalArgumentException("Name cannot be null");
       }
       
       ArrayList<String> result = new ArrayList<>();
       
       for (NameRecord current : getMatches(name)) {
           result.add(current.getName() + " " + current.getBestRankedDecade());
       }
       
       return result;
   }
   
   // menu option 7 my own method helper
   // Takes in a parameter rank, and finds all names that have been ranked more than once
   // at that rank.
   // Returns an ArrayList of all these names.
   public ArrayList<String> menu7Option(int rank) {
       // check preconditions
       if (rank > 1000 || rank < 0) {
           throw new IllegalArgumentException("Must be a valid rank.");
       }
       
       ArrayList<String> result = new ArrayList<>();
      
       for (NameRecord current : listOfRecords) {
           if (current.menu7HelperMethod(rank)) {
               result.add(current.getName());
           }
       }
       
       return result;
   }
}