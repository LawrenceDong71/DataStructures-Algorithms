//  CodeCamp.java - CS314 Assignment 1
public class CodeCamp {

    /**
     * Determine the Hamming distance between two arrays of ints.
     * Neither the parameter <tt>aData</tt> or
     * <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null, aData.length == aData.length
     * @param bData != null
     * @return the Hamming Distance between the two arrays of ints.
     */
    public static int hammingDistance(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null || aData.length != bData.length) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "hammingDistance. neither parameter may equal null, arrays" +
                    " must be equal length.");
        }
        int distance = 0;
        for (int i = 0; i < aData.length; i++) {
        	if (aData[i] != bData[i]) {
        		//if the two numbers at the same index are different, hammingdistance increases by 1
        		distance++;
        	}
        }
        return distance;
    }


    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>aData</tt> or
     * the parameter <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null
     * @param bData != null
     * @return <tt>true</tt> if aData is a permutation of bData,
     * <tt>false</tt> otherwise
     *
     */
    public static boolean isPermutation(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isPermutation. neither parameter may equal null.");
        }
        
        //the arrays can't be permutations if they are different length
        if (aData.length != bData.length) return false;
        
        //Create a 2D array to store the frequencies of each element in aData
        int[][] freqA = new int[aData.length][2];
        
        //Keep tracks of the of the index for new unique elements
        int newElementIndex = 0;
        
        //Populate 2D array with frequencies of the elements in aData
        for (int i = 0; i < aData.length; i++) {
        	int j = 0;
        	
        	//Check if the current element already exists in freqA
        	while (j < newElementIndex && freqA[j][0] != aData[i]) j++;
        	if (j < newElementIndex) {
        		//Element is found, so increase the frequency
        		freqA[j][1]++;
        	} else {
        		////Element is not found, so the element is populated with a default frequency of 1
        		freqA[newElementIndex][0] = aData[i];
        		freqA[newElementIndex++][1] = 1;
        	}
        }
        
        //Compare with frequencies with elements in bData
        for (int i = 0; i < bData.length; i++) {
        	int j = 0;
        	//find the index at which the current element is at in freqA
        	while (j < newElementIndex && freqA[j][0] != bData[i]) j++;
        	if (j < newElementIndex) {
        		//Element is found, so decrement the frequency from freqA
        		freqA[j][1]--;
        		//If frequency goes below 0, then the element has more occurrences
        		//in bData than aData
        		if (freqA[j][1] < 0) return false;
        		
        	// the element is not found
        	} else return false;
        }
        
        //If any frequency is still not 0, then the two arrays are not permutations
        for (int i = 0; i < newElementIndex; i++) {
        	if (freqA[i][1] != 0) return false;
        }
        return true;
    }


    /**
     * Determine the index of the String that
     * has the largest number of vowels.
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o',
     * 'U', and 'u'</tt>.
     * The parameter <tt>arrayOfStrings</tt> is not altered as a result of this method.
     * <p>pre: <tt>arrayOfStrings != null</tt>, <tt>arrayOfStrings.length > 0</tt>,
     * there is an least 1 non null element in arrayOfStrings.
     * <p>post: return the index of the non-null element in arrayOfStrings that has the
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero.
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param arrayOfStrings the array to check
     * @return the index of the non-null element in arrayOfStrings that has
     * the largest number of vowels.
     */
    public static int mostVowels(String[] arrayOfStrings) {
        // check preconditions
        if (arrayOfStrings == null || arrayOfStrings.length == 0
        		|| !atLeastOneNonNull(arrayOfStrings)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "mostVowels. parameter may not equal null and must contain " +
                    "at least one none null value.");
        }

        int indexWithMostVowels = -1;
        int maxVowelCount = -1;
        for (int i = 0; i < arrayOfStrings.length; i++) {
        	//if the string at i is null, then skip over it
        	if (arrayOfStrings[i] != null) {
        		//Convert the string to all lowercase to handle case sensitivity
            	String current = arrayOfStrings[i].toLowerCase();
            	//Counter for vowels in current string
            	int count = 0;
            	for (char c : current.toCharArray()) {
            		//increment count if the character is a vowel
            		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c== 'u') {
            			count++;
            		}
            	}
            	
            	//update index and max vowel count if current string has more vowels
            	if (count > maxVowelCount) {
            		maxVowelCount = count;
            		indexWithMostVowels = i;
            	}
        	}
        }
        return indexWithMostVowels;
    }



    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people.
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiment.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople +
                    ", numDaysInYear: " + numDaysInYear);
        }
        //stores frequency of the birthdays encountered
        int[] freqBday = new int[numDaysInYear];
        
        for (int i = 0; i < numPeople; i++) {
        	int currentBday = (int) (Math.random() * numDaysInYear);
        	freqBday[currentBday]++;
        }
        
        int pairCount = 0;
        for (int i = 0; i < freqBday.length; i++) {
        	//only calculate pairs if there are 2 or more, or else a pair can't be formed
        	if (freqBday[i] >= 2) {
        		pairCount += (freqBday[i] * (freqBday[i] - 1) ) / 2;
        	}
        }
        return pairCount;
    }
    
    //1 million experiments code
    public static double runExperiment(double numOfExperiments, int numPeople, int numDaysInYear) {
    	double totalPairs = 0;
    	//run the experiment num times, this case, 1 million times
    	for (double i = 0; i < numOfExperiments; i++) {
    		totalPairs += sharedBirthdays(numPeople, numDaysInYear);
    	}
    	//return the average
    	return totalPairs / numOfExperiments;
    }
    
    //2-100 people 50000 experiments code
    public static void percentSucess(int lower, int upper, int numDaysInYear) {
    	//run experiment from 2 to 100 people
    	for (int i = lower; lower <= upper; lower++) {
    		int experimentsOverOne = 0;
    		//run the experiment 50000 times for each numPeople
    		for (int j = 0; j < 50000; j++) {
    			//increment expOverOne if there are more than 1 pair
    			if (sharedBirthdays(lower, 365) >= 1) {
    				experimentsOverOne++;
    			}
    		}
    		System.out.printf("Num people: %d, number of experiments with one or more shared "
    				+ "birthday: %d, percentage: %.2f\n", lower, experimentsOverOne, 
    				(experimentsOverOne / 50000.0) * 100);
    	}
    }
    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board)
                || !onlyContains(board, validChars)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "queensAreSafe. The board may not be null, must be square, " +
                    "and may only contain 'q's and '.'s");
        }

        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == 'q') {
        			//check if queen is safe
        			if (!directionCheck(board, i, j)) {
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
    
    //helper method to check if there are queens on diagonals, row, and column
    private static boolean directionCheck(char[][] board, int i, int j) {
    	int length = board[0].length;
    	int height = board.length;
    	
    	//check left to right if there is a queen
    	for (int k = 0; k < length; k++) {
    		if (k != j && board[i][k] == 'q') {
    			return false;
    		}
    	}
    	
    	//check up to down if there is a queen
    	for (int k = 0; k < height; k++) {
    		if (k != i && board[k][j] == 'q') {
    			return false;
    		}
    	}
    	
    	int indexBound = (length == height) ? length : Math.max(length, height);
    	
    	//Check diagonally in all 4 four directions
    	//start at k = 1 to avoid checking own square
    	for (int k = 1; k < indexBound; k++) {
    		if (i - k >= 0 && j - k >= 0 && board[i-k][j-k] == 'q') {
    			return false;
    		}
    		if (i - k >= 0 && j + k < length && board[i-k][j+k] == 'q') {
    			return false;
    		}
    		if (i + k < height && j - k >= 0 && board[i+k][j-k] == 'q') {
    			return false;
    		}
    		if (i + k < height && j + k < length && board[i+k][j+k] == 'q') {
    			return false;
    		}
    	}
    	return true;
    }
    


    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1.
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0
                || !isRectangular(city) ) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getValueOfMostValuablePlot. The parameter may not be null," +
                    " must value at least one row and at least" +
                    " one column, and must be rectangular.");
        }

        int max = -10000;
        
        //iterate through all possible top left corners
        for (int rows = 0; rows < city.length; rows++) {
        	for (int cols = 0; cols < city[0].length; cols++) {
        		
        		//find all possible bottom right corners
        		for (int bottomRow = rows; bottomRow < city.length; bottomRow++) {
        			for (int bottomCol = cols; bottomCol < city[0].length; bottomCol++) {
        				
        				int current = subRectangleSum(city, rows, cols, bottomRow, bottomCol);
        				
        				//max is updated if current is greater
        				if (current > max) {
        					max = current;
        				}
        			}
        		}
        	}
        }
        return max;
    }
    
    //calculates the sum of sub rectangle
    private static int subRectangleSum(int[][] city, int row, int col, int botRow, int botCol ) {
    	int sum = 0;
    	for (int i = row; i <= botRow; i++) {
    		for (int j = col; j <= botCol; j++) {
    			sum += city[i][j];
    		}
    	}
    	return sum;

    }


    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiment code here:


    /*
     * pre: arrayOfStrings != null
     * post: return true if at least one element in arrayOfStrings is
     * not null, otherwise return false.
     */
    private static boolean atLeastOneNonNull(String[] arrayOfStrings) {
        // check precondition
        if (arrayOfStrings == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "atLeastOneNonNull. parameter may not equal null.");
        }
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < arrayOfStrings.length ) {
            foundNonNull = arrayOfStrings[i] != null;
            i++;
        }
        return foundNonNull;
    }


    /*
     * pre: mat != null
     * post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isSquare. Parameter may not be null.");
        }
        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while (isSquare && row < numRows) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }


    /*
     * pre: mat != null, valid != null
     * post: return true if all elements in mat are one of the
     * characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if (mat == null || valid == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "onlyContains. Parameters may not be null.");
        }
        String validChars = new String(valid);
        int row = 0;
        boolean onlyContainsValidChars = true;
        while (onlyContainsValidChars && row < mat.length) {
            int col = 0;
            while(onlyContainsValidChars && col < mat[row].length) {
                int indexOfChar = validChars.indexOf(mat[row][col]);
                onlyContainsValidChars = indexOfChar != -1;
                col++;
            }
            row++;
        }
        return onlyContainsValidChars;
    }


    /*
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isRectangular. Parameter may not be null and must contain" +
                    " at least one row.");
        }
        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null)
                    && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }

    // make constructor private so no instances of CodeCamp can not be created
    private CodeCamp() {

    }
}
