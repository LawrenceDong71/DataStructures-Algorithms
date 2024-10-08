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

public class NameRecord implements Comparable<NameRecord> {
    
    // private instance variables
    private String name;
    private int baseDecade;
    private ArrayList<Integer> ranks;
    
    // sorts the list of NameRecords based on alphabetical name order
    public int compareTo(NameRecord other) {
        return this.name.compareTo(other.name);
    }
    /**
     * Constructs a NameRecord with the given.
     * The name will be ranked starting from the baseDecade
     * A deep copy of the ranks are made in an ArrayList
     * @param name != null
     * @param use baseDecade in file
     * @param array != null && array.length != 0
     */
    public NameRecord(String name, int baseDecade, int[] array) {
        // check preconditions, but baseDecade doesn't have to be checked
        if (name == null || array == null || array.length == 0) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        
        ranks = new ArrayList<>();
        this.name = name;
        this.baseDecade = baseDecade;
        // deep copy
        for (int i = 0; i < array.length; i++) {
            ranks.add(array[i]);
        }
    }
    
    /**
     * Get the name of NameRecord object
     * @return the name of this NameRecord
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the base decade of NameRecord
     * @return the baseDecade at which the ranks for this name start
     */
    public int getBaseDecade() {
        return baseDecade;
    }
    
    /**
     * Get the total decades this name has data for
     * @return the total decades this NameRecord has ranks for
     */
    public int getDecades() {
        return ranks.size();
    }
    
    /**
     * Get the rank of this name in a specific decade
     * @param index > 0 && index < getDecades()
     * @return the rank of this name at a specific decade (0 base indexing)
     */
    public int getRank(int index) {
        // check preconditions
        if (index < 0 || index > ranks.size() - 1) {
            throw new IllegalArgumentException("Must be a valid rank.");
        }
        
        return ranks.get(index);
    }
    
    /**
     * Get the decade this name was best ranked in
     * @return the decade this name had its best rank
     */
    public int getBestRankedDecade() {
        // start from the end of ranks list
        int bestIndex = ranks.size() - 1;
        
        // finds the next best decade that is not 0
        while (ranks.get(bestIndex) == 0 && bestIndex > 0) {
            bestIndex--;
        }
        
        for (int i = bestIndex - 1; i >= 0; i--) {
            // skip ranks that are 0
            if (ranks.get(i) != 0 && ranks.get(i) < ranks.get(bestIndex)) {
                bestIndex = i;
            }
        }
        
        return getBaseDecade() + (bestIndex * 10);
    }
    
    /**
     * Get the number of times this name was ranked in the top 1000
     * @return number of times this name was ranked in the top 1000
     */
    public int topOneThousand() {
        int times = 0;
        
        for (int current : ranks) {
            if (current != 0) {
                times++;
            }
        }
        
        return times;
    }

    /**
     * Return true if name is ranked top 1000 in every decade
     * @return <tt>true</tt> if this is ranked top 1000 in every decade,
     * <tt>false</tt> otherwise.
     */
    public boolean rankedEveryDecade() {
        for (int current : ranks) {
            if (current == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Return true if name was ranked top 1000 in only one decade
     * @return <tt>true</tt> if this name was ranked top 1000 in only one decade,
     * <tt>false</tt> otherwise.
     */
    public boolean rankedOnlyOneDecade() {
        int ranked = 0;
        
        for (int current : ranks) {
            if (current != 0) {
                ranked++;
            }
            // immediately return false if there are more than 1 non zero ranks
            if (ranked > 1) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Return true if the rank is improving in every decade
     * @return <tt>true</tt> if the rank for this name gets smaller every decade
     * <tt>false</tt> otherwise.
     */
    public boolean isMorePopular() {
        for (int i = 1; i < ranks.size(); i++) {
            int currentRank = ranks.get(i);
            int previousRank = ranks.get(i - 1);
            
            // a 0 that is not at index zero automatically means popularity is not increasing
            if (currentRank == 0) {
                return false;
            } else {
                if (previousRank != 0 && currentRank >= previousRank) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return true if the rank is getting worse every decade
     * Consecutive 0s (outside of top 1000) means name is NOT getting less popular
     * @return <tt>true</tt> if the rank for this name gets bigger every decade,
     * <tt>false</tt> otherwise.
     */
    public boolean isLessPopular() {
        for (int i = 1; i < ranks.size(); i++) {
            int currentRank = ranks.get(i);
            int previousRank = ranks.get(i - 1);
            
            if (currentRank == 0) {
                if (previousRank == 0) {
                    // consecutive 0s automatically means the name is NOT getting less popular
                    return false;
                }
            } else {
                // a 0 before any number means rank is NOT decreasing
                if (previousRank == 0 || currentRank <= previousRank) {
                    return false;
                }
            }
        }
        
        return true;
    }

    /**
     * override toString.
     * @return a String of this NameRecord object with the name and the rank at every decade
     * Each rank is on a separate line.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        // name comes first
        result.append(name).append("\n");
        for (int i = 0; i < ranks.size(); i++) {
            int currentDecade = baseDecade + (i * 10);
            // new line after each rank
            result.append(currentDecade).append(": ").append(ranks.get(i)).append("\n");
        }
        
        return result.toString();
    }
    
    // The helper method for option 7
    // Returns true if a rank appears multiple times
    public boolean menu7HelperMethod(int rank) {
        int frequency = 0;
        
        for (int current : ranks) {
            if (current == rank) {
                frequency++;
            }
            
            // immediately return true if the rank appears more than once
            if (frequency > 1) {
                return true;
            }
        }
        
        return false;
    }
}
