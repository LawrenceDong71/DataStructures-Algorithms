/*  Student information for assignment:
 *
 *  On my honor, Lawrence Dong, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Lawrence Dong
 *  email address: lawrencerdong@gmail.com
 *  UTEID: lrd2265
 *  Section 5 digit ID: 50255
 *  Grader name: Jyotsna Arunkumar
 *  Number of slip days used on this assignment: 0
 */

// add imports as necessary
import java.util.Map;
import java.util.Set;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Manages the details of EvilHangman. This class keeps
 * tracks of the possible words from a dictionary during
 * rounds of hangman, based on guesses so far.
 *
 */
public class HangmanManager {

    // instance variables / fields
    // set used for dictionary just to ensure that no duplicate words are allowed.
    private Set<String> dict;
    private Set<Character> guessesSoFar;
    private ArrayList<String> activeList;
    private String activePattern;
    private int guessesLeft;
    private HangmanDifficulty difficulty;
    private boolean debug;
    // picking second hardest pattern means this variable will be set to false
    private boolean hardest;
    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     * @param debugOn true if we should print out debugging to System.out.
     */
    public HangmanManager(Set<String> words, boolean debugOn) {
        if (words == null || words.size() == 0) {
            throw new IllegalArgumentException("Parameters cannot be null.");
        }
        // not every instance variables needs to be instantiated
        dict = new TreeSet<>(words);
        guessesSoFar = new TreeSet<>();
        activeList = new ArrayList<>();
        debug = debugOn;
        hardest = true;
    }

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * Debugging is off.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     */
    public HangmanManager(Set<String> words) {
        if (words == null || words.size() == 0) {
            throw new IllegalArgumentException("Parameters cannot be null.");
        }
        // not every instance variables needs to be instantiated
        dict = new TreeSet<>(words);
        activeList = new ArrayList<>();
        guessesSoFar = new TreeSet<>();
        debug = false;
        hardest = true;
    }


    /**
     * Get the number of words in this HangmanManager of the given length.
     * pre: none
     * @param length The given length to check.
     * @return the number of words in the original Dictionary
     * with the given length
     */
    public int numWords(int length) {
        int count = 0;
        for (String element : dict) {
            if (element.length() == length) {
                count++;
            }
        }
        return count;
    }


    /**
     * Get for a new round of Hangman. Think of a round as a
     * complete game of Hangman.
     * @param wordLen the length of the word to pick this time.
     * numWords(wordLen) > 0
     * @param numGuesses the number of wrong guesses before the
     * player loses the round. numGuesses >= 1
     * @param diff The difficulty for this round.
     */
    public void prepForRound(int wordLen, int numGuesses, HangmanDifficulty diff) {
        if (wordLen <= 0 || numGuesses < 1) {
            throw new IllegalArgumentException("Word length and number of guesses "
                + "must be valid.");
        }
        guessesSoFar.clear();
        activeList.clear();
        for (String element : dict) {
            if (element.length() == wordLen) {
                activeList.add(element);
            }
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < wordLen; i++) {
            temp.append('-');
        }
        activePattern = temp.toString();
        guessesLeft = numGuesses;
        difficulty = diff;
        // the constructor will specify whether debug is on or not
        hardest = true;
    }


    /**
     * The number of words still possible (live) based on the guesses so far.
     *  Guesses will eliminate possible words.
     * @return the number of words that are still possibilities based on the
     * original dictionary and the guesses so far.
     */
    public int numWordsCurrent() {
        return activeList.size();
    }


    /**
     * Get the number of wrong guesses the user has left in
     * this round (game) of Hangman.
     * @return the number of wrong guesses the user has left
     * in this round (game) of Hangman.
     */
    public int getGuessesLeft() {
        return guessesLeft;
    }


    /**
     * Return a String that contains the letters the user has guessed
     * so far during this round.
     * The characters in the String are in alphabetical order.
     * The String is in the form [let1, let2, let3, ... letN].
     * For example [a, c, e, s, t, z]
     * @return a String that contains the letters the user
     * has guessed so far during this round.
     */
    public String getGuessesMade() {
        StringBuilder result = new StringBuilder("[");
        
        // set doesn't have indexes, so use count to print commas and spaces if needed
        int size = guessesSoFar.size();
        int count = 0;
        for (Character element : guessesSoFar) {
            result.append(element);
            count++;
            if (count < size) {
                result.append(", ");
            }
        }
       
        return result.append("]").toString();
    }


    /**
     * Check the status of a character.
     * @param guess The characater to check.
     * @return true if guess has been used or guessed this round of Hangman,
     * false otherwise.
     */
    public boolean alreadyGuessed(char guess) {
        return guessesSoFar.contains(guess);
    } 


    /**
     * Get the current pattern. The pattern contains '-''s for
     * unrevealed (or guessed) characters and the actual character 
     * for "correctly guessed" characters.
     * @return the current pattern.
     */
    public String getPattern() {
        return activePattern;
    }


    /**
     * Update the game status (pattern, wrong guesses, word list),
     * based on the give guess.
     * @param guess pre: !alreadyGuessed(ch), the current guessed character
     * @return return a tree map with the resulting patterns and the number of
     * words in each of the new patterns.
     * The return value is for testing and debugging purposes.
     */
    public TreeMap<String, Integer> makeGuess(char guess) {
        if (alreadyGuessed(guess)) {
            throw new IllegalArgumentException("Guess must be valid.");
        }
        
        guessesSoFar.add(guess);
        Map<String, ArrayList<String>> wordFamilies = new TreeMap<>();
        
        for (String curr : activeList) {
            String currPatt = buildCurrentPattern(curr, guess);
            
            // add the current word to family of words in the map
            wordFamilies.putIfAbsent(currPatt, new ArrayList<String>());
            wordFamilies.get(currPatt).add(curr);
        }
        
        String hardestPattern = choosePattern(wordFamilies);
        if (hardestPattern.equals(activePattern)) {
            // increase incorrect guesses if old activePattern does not match newest pattern
            guessesLeft--;
        } 
        
        activePattern = hardestPattern;
        activeList = wordFamilies.get(activePattern);
        TreeMap<String, Integer> result = new TreeMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : wordFamilies.entrySet()) {
            // copy the entries from the wordFamily map into TreeMap for return purposes
            result.put(entry.getKey(), entry.getValue().size());
        }
        // print debug statements
        if (debug) {
            printDebugCode(wordFamilies.size());
        }
        return result;   
    }
   
    // uses StringBuilder to build pattern for current word
    private String buildCurrentPattern(String word, char guess) {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                pattern.append(guess);
            } else {
                // the activePattern can only become more revealed
                pattern.append(activePattern.charAt(i));
            }
        }
        return pattern.toString();
    }
    // depending on difficulty, chooses the next pattern to use as activePattern
    private String choosePattern(Map<String, ArrayList<String>> map) {
        // extract keys into an ArrayList
        // uses map to sort this ArrayList based on criteria
        ArrayList<String> sortedPatterns = new ArrayList<>(map.keySet());
        Collections.sort(sortedPatterns, new sizeComparator(map));
        String[] patterns = new String[2];
        // index 0 is the hardest, index 1 is the secondHardest
        for (int i = 0; i < 2 && i < sortedPatterns.size(); i++) {
            patterns[i] = sortedPatterns.get(i);
            
        }
        // secondHardest is same as hardest if there is only one available pattern
        if (patterns[1] == null) {
            patterns[1] = patterns[0];
        }
        int guessesMade = guessesSoFar.size();
        if (difficulty == HangmanDifficulty.HARD) {
            return patterns[0];
        } else if (difficulty == HangmanDifficulty.MEDIUM) {
            // pick second hardest pattern every 4th guess
            if (guessesMade % 4 == 0) {
                hardest = false;
                return patterns[1];
            } else {
                hardest = true;
                return patterns[0];
            }
        } else {
            // pick second hardest pattern every other guess
            if (guessesMade % 2 == 0) {
                hardest = false;
                return patterns[1];
            } else {
                hardest = true;
                return patterns[0];
            }
        }
    }
    
    /**
     * Custom comparator for ArrayList<String>
     * Takes in a map to find the size of each wordFamiliy
     * Sorts an ArrayList<String> whose elements are the keys in the map
     */
    private static class sizeComparator implements Comparator<String> {
        // instance variable
        private final Map<String, ArrayList<String>> temp;
        
        // take a map for the constructor, so we can access the size of the families
        public sizeComparator(Map<String, ArrayList<String>> wordFamilies) {
            temp = wordFamilies;
        }
        
        public int compare(String key1, String key2) {
            int difference = temp.get(key2).size() - temp.get(key1).size();
            // the bigger sized family comes first
            if (difference != 0) {
                return difference;
            } 
            // tiebreak: look at the amount of characters revealed
            difference = countRevealed(key1) - countRevealed(key2);
            // the pattern that reveals less characters comes first
            if (difference != 0) {
                return difference;
            }
            
            // lastly, compare lexicographically if everything else before is a tie
            return key1.compareTo(key2); 
        }
        
        private int countRevealed(String pattern) {
            int result = 0;
            for (char c : pattern.toCharArray()) {
                if (c != '-') {
                    result++;
                }
            }
            return result;
        }
    }
    
    private void printDebugCode(int wordFamilySize) {
        System.out.println();
        // print debug statements based on whether the hardest or 
        // secondHardest pattern was chosen
        if (hardest) {
            printDefaultHardestCode();
        } else {
            // if difficulty wasn't hard, and second hardest was picked, 
            //then this debug statement is printed
            if (wordFamilySize == 1) {
                System.out.println("DEBUGGING: Should pick second hardest pattern this turn, "
                    + "but only one pattern available.");
                printDefaultHardestCode();
            } else {
                System.out.println("DEBUGGING: Difficulty second hardest pattern and list.");
                System.out.println("DEBUGGING: New pattern is: " + getPattern() + ". New family"
                    + " has " + activeList.size() + " words.");
            }
        }
    }
    
    // the default debug code if hardest list was picked
    public void printDefaultHardestCode() {
        System.out.println("DEBUGGING: Picking hardest list.");
        System.out.println("DEBUGGING: New pattern is: " + getPattern() + ". New family"
            + " has " + activeList.size() + " words.");
    }

    /**
     * Return the secret word this HangmanManager finally ended up
     * picking for this round.
     * If there are multiple possible words left one is selected at random.
     * <br> pre: numWordsCurrent() > 0
     * @return return the secret word the manager picked.
     */
    public String getSecretWord() {
        if (numWordsCurrent() <= 0) {
            throw new IllegalArgumentException("Current number of words must "
                + "be greater than 0.");
        }
        // generate a random index bounded by the activeList's size
        return activeList.get(new Random().nextInt(activeList.size()));  
    }
}