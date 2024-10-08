import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// CodeCamp.java - CS314 Assignment 1 - Tester class

/*
 * Student information for assignment: 
 * Name: Lawrence Dong
 * email address: lawrencerdong@gmail.com
 * UTEID: lrd2265
 * Section 5 digit ID: 50255
 * Grader name: Jyotsna Arunkumar
 * Number of slip days used on this assignment: 0
 */

/*
 * CS314 Students: place results of shared birthdays experiments in this
 * comment.
Based on my experiment, it takes at least 23 people to have a 50% chance of there
being one or more shared birthdays
Num people: 2, number of experiments with one or more shared birthday: 123, percentage: 0.25
Num people: 3, number of experiments with one or more shared birthday: 416, percentage: 0.83
Num people: 4, number of experiments with one or more shared birthday: 711, percentage: 1.42
Num people: 5, number of experiments with one or more shared birthday: 1302, percentage: 2.60
Num people: 6, number of experiments with one or more shared birthday: 2021, percentage: 4.04
Num people: 7, number of experiments with one or more shared birthday: 2659, percentage: 5.32
Num people: 8, number of experiments with one or more shared birthday: 3734, percentage: 7.47
Num people: 9, number of experiments with one or more shared birthday: 4810, percentage: 9.62
Num people: 10, number of experiments with one or more shared birthday: 5924, percentage: 11.85
Num people: 11, number of experiments with one or more shared birthday: 7109, percentage: 14.22
Num people: 12, number of experiments with one or more shared birthday: 8290, percentage: 16.58
Num people: 13, number of experiments with one or more shared birthday: 9744, percentage: 19.49
Num people: 14, number of experiments with one or more shared birthday: 11338, percentage: 22.68
Num people: 15, number of experiments with one or more shared birthday: 12702, percentage: 25.40
Num people: 16, number of experiments with one or more shared birthday: 14317, percentage: 28.63
Num people: 17, number of experiments with one or more shared birthday: 15772, percentage: 31.54
Num people: 18, number of experiments with one or more shared birthday: 17311, percentage: 34.62
Num people: 19, number of experiments with one or more shared birthday: 18946, percentage: 37.89
Num people: 20, number of experiments with one or more shared birthday: 20451, percentage: 40.90
Num people: 21, number of experiments with one or more shared birthday: 22134, percentage: 44.27
Num people: 22, number of experiments with one or more shared birthday: 23669, percentage: 47.34
Num people: 23, number of experiments with one or more shared birthday: 25444, percentage: 50.89
Num people: 24, number of experiments with one or more shared birthday: 26703, percentage: 53.41
Num people: 25, number of experiments with one or more shared birthday: 28454, percentage: 56.91
Num people: 26, number of experiments with one or more shared birthday: 29970, percentage: 59.94
Num people: 27, number of experiments with one or more shared birthday: 31262, percentage: 62.52
Num people: 28, number of experiments with one or more shared birthday: 32757, percentage: 65.51
Num people: 29, number of experiments with one or more shared birthday: 34167, percentage: 68.33
Num people: 30, number of experiments with one or more shared birthday: 35173, percentage: 70.35
Num people: 31, number of experiments with one or more shared birthday: 36506, percentage: 73.01
Num people: 32, number of experiments with one or more shared birthday: 37599, percentage: 75.20
Num people: 33, number of experiments with one or more shared birthday: 38680, percentage: 77.36
Num people: 34, number of experiments with one or more shared birthday: 39771, percentage: 79.54
Num people: 35, number of experiments with one or more shared birthday: 40810, percentage: 81.62
Num people: 36, number of experiments with one or more shared birthday: 41540, percentage: 83.08
Num people: 37, number of experiments with one or more shared birthday: 42349, percentage: 84.70
Num people: 38, number of experiments with one or more shared birthday: 43370, percentage: 86.74
Num people: 39, number of experiments with one or more shared birthday: 43897, percentage: 87.79
Num people: 40, number of experiments with one or more shared birthday: 44622, percentage: 89.24
Num people: 41, number of experiments with one or more shared birthday: 45178, percentage: 90.36
Num people: 42, number of experiments with one or more shared birthday: 45853, percentage: 91.71
Num people: 43, number of experiments with one or more shared birthday: 46149, percentage: 92.30
Num people: 44, number of experiments with one or more shared birthday: 46595, percentage: 93.19
Num people: 45, number of experiments with one or more shared birthday: 47087, percentage: 94.17
Num people: 46, number of experiments with one or more shared birthday: 47380, percentage: 94.76
Num people: 47, number of experiments with one or more shared birthday: 47797, percentage: 95.59
Num people: 48, number of experiments with one or more shared birthday: 48078, percentage: 96.16
Num people: 49, number of experiments with one or more shared birthday: 48324, percentage: 96.65
Num people: 50, number of experiments with one or more shared birthday: 48572, percentage: 97.14
Num people: 51, number of experiments with one or more shared birthday: 48689, percentage: 97.38
Num people: 52, number of experiments with one or more shared birthday: 48944, percentage: 97.89
Num people: 53, number of experiments with one or more shared birthday: 49053, percentage: 98.11
Num people: 54, number of experiments with one or more shared birthday: 49179, percentage: 98.36
Num people: 55, number of experiments with one or more shared birthday: 49340, percentage: 98.68
Num people: 56, number of experiments with one or more shared birthday: 49473, percentage: 98.95
Num people: 57, number of experiments with one or more shared birthday: 49534, percentage: 99.07
Num people: 58, number of experiments with one or more shared birthday: 49591, percentage: 99.18
Num people: 59, number of experiments with one or more shared birthday: 49649, percentage: 99.30
Num people: 60, number of experiments with one or more shared birthday: 49667, percentage: 99.33
Num people: 61, number of experiments with one or more shared birthday: 49746, percentage: 99.49
Num people: 62, number of experiments with one or more shared birthday: 49798, percentage: 99.60
Num people: 63, number of experiments with one or more shared birthday: 49832, percentage: 99.66
Num people: 64, number of experiments with one or more shared birthday: 49864, percentage: 99.73
Num people: 65, number of experiments with one or more shared birthday: 49873, percentage: 99.75
Num people: 66, number of experiments with one or more shared birthday: 49906, percentage: 99.81
Num people: 67, number of experiments with one or more shared birthday: 49926, percentage: 99.85
Num people: 68, number of experiments with one or more shared birthday: 49931, percentage: 99.86
Num people: 69, number of experiments with one or more shared birthday: 49946, percentage: 99.89
Num people: 70, number of experiments with one or more shared birthday: 49956, percentage: 99.91
Num people: 71, number of experiments with one or more shared birthday: 49970, percentage: 99.94
Num people: 72, number of experiments with one or more shared birthday: 49970, percentage: 99.94
Num people: 73, number of experiments with one or more shared birthday: 49980, percentage: 99.96
Num people: 74, number of experiments with one or more shared birthday: 49983, percentage: 99.97
Num people: 75, number of experiments with one or more shared birthday: 49996, percentage: 99.99
Num people: 76, number of experiments with one or more shared birthday: 49993, percentage: 99.99
Num people: 77, number of experiments with one or more shared birthday: 49989, percentage: 99.98
Num people: 78, number of experiments with one or more shared birthday: 49992, percentage: 99.98
Num people: 79, number of experiments with one or more shared birthday: 49998, percentage: 100.00
Num people: 80, number of experiments with one or more shared birthday: 49998, percentage: 100.00
Num people: 81, number of experiments with one or more shared birthday: 49997, percentage: 99.99
Num people: 82, number of experiments with one or more shared birthday: 49997, percentage: 99.99
Num people: 83, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 84, number of experiments with one or more shared birthday: 49997, percentage: 99.99
Num people: 85, number of experiments with one or more shared birthday: 49998, percentage: 100.00
Num people: 86, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 87, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 88, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 89, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 90, number of experiments with one or more shared birthday: 49999, percentage: 100.00
Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 92, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.00
Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.00
 */

public class CodeCampTester {

    public static void main(String[] args) {
        final String newline = System.getProperty("line.separator");
                
        //hamming distance test 1
         int[] h1 = new int[] { 01, 0, 01, 0, 01, 0};
         int[] h2 = new int[] { 1, 00, 1, 00, 1, 00};
         int expected = 0;
         int actual = CodeCamp.hammingDistance(h1, h2);
         System.out.println(newline + "Test 1 hamming distance: expected value: " + expected
                 + ", actual value: " + actual);
         if (expected == actual) {
             System.out.println(" passed test 1, hamming distance");
         } else {
             System.out.println(" ***** FAILED ***** test 1, hamming distance");
         }
         
         //hamming distance test 2
         h1 = new int[] { 0100, 0010, 0001};
         h2 = new int[] { 100, 10, 1};
         expected = 2;
         actual = CodeCamp.hammingDistance(h1, h2);
         System.out.println(newline + "Test 2 hamming distance: expected value: " + expected
                 + ", actual value: " + actual);
         if (expected == actual) {
             System.out.println(" passed test 2, hamming distance");
         } else {
             System.out.println(" ***** FAILED ***** test 2, hamming distance");
         }
         
         //hamming distance test 3
         h1 = new int[] { 2147483647, 1073741823, Integer.MIN_VALUE };
         h2 = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE/2, Integer.MIN_VALUE };
         expected = 0;
         actual = CodeCamp.hammingDistance(h1, h2);
         System.out.println(newline + "Test 3 hamming distance: expected value: " + expected
                 + ", actual value: " + actual);
         if (expected == actual) {
             System.out.println(" passed test 3, hamming distance");
         } else {
             System.out.println(" ***** FAILED ***** test 3, hamming distance");
         }
         
         //isPermutation test 1
         int[] a = new int[] {};
         int[] b = new int[] {};
         boolean expectedBool = true;
         boolean actualBool = CodeCamp.isPermutation(a, b);
         System.out.println(newline + "Test 4 isPermutation: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 4, isPermutation");
         } else {
             System.out.println(" ***** FAILED ***** test 4, isPermutation");
         }
         
         //permutation test 2
         a = new int[] { 0, 0, 0, 1 };
         b = new int[] { 1, 1, 0, 0};
         expectedBool = false;
         actualBool = CodeCamp.isPermutation(a, b);
         System.out.println(newline + "Test 5 isPermutation: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 5, isPermutation");
         } else {
             System.out.println(" ***** FAILED ***** test 5, isPermutation");
         }
         
         //mostVowels test 1
         String[] arrayOfStrings = new String[] { "", "", "", "", "", "", "", "", "", "" };
         int expectedResult = 0;
         int actualResult = CodeCamp.mostVowels(arrayOfStrings);
         System.out.println(newline + "Test 6 mostVowels: expected result: " + expectedResult
                 + ", actual result: " + actualResult);
         if (actualResult == expectedResult) {
             System.out.println("passed test 6, mostVowels");
         } else {
             System.out.println("***** FAILED ***** test 6, mostVowels");
         }
         
         //mostVowels test 2
         arrayOfStrings = new String[] { "null", "1E", "2A", "3I", "4O", "5U", "6", "E", null};
         expectedResult = 0;
         actualResult = CodeCamp.mostVowels(arrayOfStrings);
         System.out.println(newline + "Test 7 mostVowels: expected result: " + expectedResult
                 + ", actual result: " + actualResult);
         if (actualResult == expectedResult) {
             System.out.println("passed test 7, mostVowels");
         } else {
             System.out.println("***** FAILED ***** test 7, mostVowels");
         }
         
         //mostVowels test 3
         arrayOfStrings = new String[] { "null", null, null, null, "nulll", "nuulll", null };
         expectedResult = 5;
         actualResult = CodeCamp.mostVowels(arrayOfStrings);
         System.out.println(newline + "Test 8 mostVowels: expected result: " + expectedResult
                 + ", actual result: " + actualResult);
         if (actualResult == expectedResult) {
             System.out.println("passed test 8, mostVowels");
         } else {
             System.out.println("***** FAILED ***** test 8, mostVowels");
         }
         
         //sharedBirthdays test 1
         //the result for this test varies (could be 0 or 1 pairs)
         int pairs = CodeCamp.sharedBirthdays(2, 2);
         System.out.println(
                 newline + "Test 9 shared birthdays: expected: varies, actual: " + pairs);
          System.out.println("passed test 9, shared birthdays");
         
         //sharedBirthdays test 2
         pairs = CodeCamp.sharedBirthdays(500, 365);
         System.out.println(
                 newline + "Test 10 shared birthdays - stress test. (Is solution slow?) : expected: > 300"
                         + ", actual: " + pairs);
         if (pairs > 300) {
             System.out.println("passed test 10, shared birthdays");
         } else {
             System.out.println("***** FAILED ***** test 10, shared birthdays. "
                     + "Expected at least 300 pairs. Value returned: " + pairs);
         }
         
         //sharedBirthdays test 3
         pairs = CodeCamp.sharedBirthdays(1000, 1);
         System.out
                 .println(newline + "Test 11 shared birthdays: expected: 499500" + ", actual: " + pairs);
         if (pairs == 499500) {
             System.out.println("passed test 11, shared birthdays");
         } else {
             System.out.println("***** FAILED ***** test 11, shared birthdays. "
                     + "Expected pairs to be 499500. Value returned: " + pairs);
         }
         
         //queensAreSafe test 1
         char[][] board = new char[][] { { '.', '.', '.', '.' }, 
                                		 { '.', '.', '.', '.' },
                                		 { '.', '.', '.', '.' }, 
                                		 { '.', '.', '.', '.' } };
         expectedBool = true;
         actualBool = CodeCamp.queensAreSafe(board);
         System.out.println(newline + "Test 12 queensAreSafe: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 12, queensAreSafe");
         } else {
             System.out.println(" ***** FAILED ***** test 12, queensAreSafe");
         }


         //queensAreSafe test 2
         board = new char[][] { { 'q', 'q', 'q', 'q' }, 
                                { 'q', 'q', 'q', 'q' },
                                { 'q', 'q', 'q', 'q' }, 
                                { 'q', 'q', 'q', 'q' } };
         expectedBool = false;
         actualBool = CodeCamp.queensAreSafe(board);
         System.out.println(newline + "Test 13 queensAreSafe: expected value: " + expectedBool
                 + ", actual value: " + actualBool);
         if (expectedBool == actualBool) {
             System.out.println(" passed test 13, queensAreSafe");
         } else {
             System.out.println(" ***** FAILED ***** test 13, queensAreSafe");
         }
         
         //queensAreSafe test 3
         board = new char[][] { { 'q', '.', '.', '.', '.' },
        	 					{ '.', '.', 'q', '.', '.' },
        	 					{ '.', '.', '.', '.', 'q' },
        	 					{ '.', 'q', '.', '.', '.' },
        	 					{ '.', '.', '.', 'q', '.' } };
         expectedBool = true;
		 actualBool = CodeCamp.queensAreSafe(board);
		 System.out.println(newline + "Test 14 queensAreSafe: expected value: " + expectedBool
				 + ", actual value: " + actualBool);
		 if (expectedBool == actualBool) {
			 System.out.println(" passed test 14, queensAreSafe");
	 	 } else {
	 		 System.out.println(" ***** FAILED ***** test 14, queensAreSafe");
		 }
		 
		//getValueOfMostValuablePlot test 1
	    int[][] city = new int[][] { { 11, 29, 2, 3 }, 
	                         		 { 15, 15, 10, 34 }, 
	                         		 { 12, 7, 20, 5 },
	                         		 { 5, 5, 8, 20 } };

	    expected = 201;
	    actual = CodeCamp.getValueOfMostValuablePlot(city);
	    System.out.println("\nTest 15 getValueOfMostValuablePlot: expected value: " + expected
	            + ", actual value: " + actual);
	    if (expected == actual) {
	        System.out.println(" passed test 15, getValueOfMostValuablePlot");
	    } else {
	        System.out.println(" ***** FAILED ***** test 15, getValueOfMostValuablePlot");
	    }
	     
	    //getValueOfMostValuablePlot test 2
	    city = new int[][] { { 0, 0, 0, 0, 0 }, 
	    	 				 { 0, 0, 0, 0, 0 }, 
	                         { 0, 0, 0, 0, 0 },
	                         { 0, 0, 0, 0, 0 }, 
	                         { 0, 0, 0, 0, 0 }, 
	                         { 0, 0, 0, 0, 0 } };

	    expected = 0;
	    actual = CodeCamp.getValueOfMostValuablePlot(city);
	    System.out.println(newline + "Test 16 getValueOfMostValuablePlot: expected value: "
	            + expected + ", actual value: " + actual);
	    if (expected == actual) {
	        System.out.println(" passed test 16, getValueOfMostValuablePlot");
	    } else {
	        System.out.println(" ***** FAILED ***** test 16, getValueOfMostValuablePlot");
	    }	    
	     
	    //getValueOfMostValuablePlot test 3
	    city = new int[][] { { 1, -1, 1, -1 },
	    	 				  { -1, 1, -1, 1 },
	    	 				  { 1, -1, 1, -1 },
	    	 				  { -1, 1, -1, 1 } };
	    expected = 1;
	    actual = CodeCamp.getValueOfMostValuablePlot(city);
	    System.out.println(newline + "Test 17 getValueOfMostValuablePlot: expected value: "
	    	 			           + expected + ", actual value: " + actual);
	    if (expected == actual) {
	        System.out.println(" passed test 17, getValueOfMostValuablePlot");
	    } else {
	        System.out.println(" ***** FAILED ***** test 17, getValueOfMostValuablePlot");
	    }	
	    
	    //getValueOfMostValuablePlot test 4
	    city = new int[][] { { 1, -1, 1, -1 },
			  				 { 1, -1, 1, -1 },
			  			     { 1, -1, 1, -1 },
			  				 { 1, -1, 1, -1 } };
		expected = 4;
		actual = CodeCamp.getValueOfMostValuablePlot(city);
		System.out.println(newline + "Test 18 getValueOfMostValuablePlot: expected value: "
			  		                + expected + ", actual value: " + actual);
		if (expected == actual) {
			 System.out.println(" passed test 18, getValueOfMostValuablePlot");
		} else {
			 System.out.println(" ***** FAILED ***** test 18, getValueOfMostValuablePlot");
		}
         
    } // end of main method

    // pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list parameter may not be null.");
        }
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for (int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}