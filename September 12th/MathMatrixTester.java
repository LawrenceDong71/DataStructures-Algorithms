import java.util.Random;

/* 
 * Experiment 1 Results
 * Initial Dimensions: 550 by 550. Time: ~1.39 seconds
 * Doubled Dimensions: 1100 by 1100. Time: ~ 4.81 seconds
 * Doubled Dimensions: 2200 by 2200. Time: ~ 17.77 seconds
 * 
 * 
 * 
 * Experiment 2 Results
 * Initial Dimensions: 200 by 200. Time: ~1.69 seconds
 * Doubled Dimensions: 400 by 400. Time: ~12.61 seconds
 * Doubled Dimensions: 800 by 800. Time: ~120.54 seconds
 * 
 * QUESTIONS
 * 1. I expect the time to quadruple if I doubled the dimension size of the MathMatrix objects. 
 * So that would be around 64 seconds.
 * 2. The Big O of the add operation is O(N^2). The timing does support this because when the
 * input size (or the N) is doubled, the time quadruples. Increasing the input size by a factor of 2
 * results in a factor of 2^2 = 4.
 * 3. I expect the results to increase by a factor of at least 8. It might be a little more
 * given the results of the first 3 iterations. I'm expecting the time to be around 1200 seconds
 * 4. The Big O of the multiply operation is O(N^3). The timing does support the code. Doubling the
 * dimensions would increase the time by a factor of 2^3 = 8. There are slight deviations in the 
 * timings when the dimensions are doubled, but they are still in range to be considered O(N^3).
 * 5. The largest Matrix I was able to create before I ran out of heap memory was 21000 by 21000.
 * This matrix would take up 1764000000 bytes, which is 1.764 GigaBytes. I have 8 BigaBytes of ram,
 * so 22.05% of my RAM was used before it crashed.
 * 



/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
//      Stopwatch s = new Stopwatch();
//      // Experiment 1 Code
//      // initial dimensions
//      int N = 550;
//      // loop will automatically double the dimensions
//      for (int i = 1; i <= 4; i *= 2) {
//          MathMatrix one = createMat(new Random(), N * i, N * i, 100);
//          MathMatrix two = createMat(new Random(), N * i, N * i, 100);
//          s.start();
//          for (int j = 0; j < 1000; j++) {
//              one.add(two);
//          }
//          s.stop();
//          System.out.println(s.toString());
//      }
//		  
//
//		//Experiment 2 Code
//      //initial dimensions
//      N = 200;
//		for (int i = 1; i <= 4; i *= 2) { 
//          MathMatrix one = createMat(new Random(), N * i, N * i, 100);
//          MathMatrix two = createMat(new Random(), N * i, N * i, 100);
//          s.start();
//          for (int j = 0; j < 100; j++) {
//              one.multiply(two);
//          }
//          s.stop();
//          System.out.println(s.toString());
//      }
//		  
        //Code to determine largest matrix I can create before I run out of heap memory
		//MathMatrix maxSize = new MathMatrix(21000, 21000, 1);
		 
    	
        // tests 1-4, addition
        int[][] data1 = new int[][] { { 5, 5, 5 }, { 5, 5, 5 } };
        int[][] data2 = new int[][] { { 1, 3, 2 }, { 10, 10, 10 } };
        MathMatrix mat1 = new MathMatrix(data1);
        MathMatrix mat2 = new MathMatrix(data2);
        MathMatrix mat3 = mat1.add(mat2);
        int[][] e1 = new int[][] { { 6, 8, 7 }, { 15, 15, 15 } };
        printTestResult(get2DArray(mat3), e1, 1, "add method. Testing mat3 correct result.");

        mat1 = new MathMatrix(2, 3, 0);
        mat3 = mat2.add(mat1);
        e1 = new int[][] { { 1, 3, 2 }, { 10, 10, 10 } };
        printTestResult(get2DArray(mat3), e1, 2, "add method. Testing mat3 correct result.");

        mat1 = new MathMatrix(2, 2, Integer.MIN_VALUE);
        mat2 = new MathMatrix(2, 2, Integer.MAX_VALUE);
        mat3 = mat1.add(mat2);
        e1 = new int[][] { { -1, -1 }, { -1, -1 } };
        printTestResult(get2DArray(mat3), e1, 3, "add method. Testing mat3 correct result.");

        // switching the order of operations shouldn't affect the answer
        mat1 = new MathMatrix(3, 3, -5);
        mat2 = new MathMatrix(3, 3, 15);
        mat3 = mat1.add(mat2);
        printTestResult(get2DArray(mat1.add(mat2)), get2DArray(mat2.add(mat1)), 4,
                "add method. Testing mat3 correct result.");

        // tests 5-8, subtraction
        data1 = new int[][] { { 2, 3, 4 }, { 1, 1, 3 } };
        data2 = new int[][] { { 5, 6, 7 }, { 2, 2, 10 } };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        data1[0][0] = 100;
        e1 = new int[][] { { 2, 3, 4 }, { 1, 1, 3 } };
        // check if deep copy is changed or not
        printTestResult(get2DArray(mat1), e1, 5, "subtract method. Testing mat1 unchanged.");

        e1 = new int[][] { { -3, -3, -3 }, { -1, -1, -7 } };
        printTestResult(get2DArray(mat3), e1, 6, "subtract method. Testing mat3 correct result.");

        mat1 = new MathMatrix(2, 3, 3);
        mat2 = new MathMatrix(2, 3, 3);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { { 0, 0, 0 }, { 0, 0, 0 } };
        printTestResult(get2DArray(mat3), e1, 7, "subtract method. Testing mat3 correct result.");

        mat1 = new MathMatrix(1, 1, 10);
        mat2 = new MathMatrix(1, 1, 2);
        mat3 = mat1.subtract(mat2);
        e1 = new int[][] { { 8 } };
        printTestResult(get2DArray(mat3), e1, 8, "subtract method. Testing mat3 correct result.");

        // tests 9-11, multiplication
        mat3 = mat1.multiply(mat2);
        e1 = new int[][] { { 20 } };
        printTestResult(get2DArray(mat3), e1, 9, "multiply method");

        data1 = new int[][] { { 0, 0, 0 }, { 0, 0, 0 } };
        data2 = new int[][] { { 10 }, { 10 }, { 10 } };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.multiply(mat2);
        e1 = new int[][] { { 0 }, { 0 } };
        printTestResult(get2DArray(mat3), e1, 10, "multiply method");

        data1 = new int[][] { { 3, -1, -9, 2 }, { 1, 19, 2, -2 } };
        data2 = new int[][] { { 2, 2 }, { 9, -4 }, { 1, 1 }, { -2, -7 } };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.multiply(mat2);
        e1 = new int[][] { { -16, -13 }, { 179, -58 } };
        printTestResult(get2DArray(mat3), e1, 11, "multiply method");

        // tests 12-15, getScaledMatrix
        data1 = new int[][] { { 3, 9, 2 }, { 0, 1, 2 } };
        mat1 = new MathMatrix(data1);
        data1[0][0] = 0;
        e1 = new int[][] { { 3, 9, 2 }, { 0, 1, 2 } };
        printTestResult(get2DArray(mat1), e1, 12, "getScaledMatrix method. " + 
                "Testing mat1 unchanged.");
        mat3 = mat1.getScaledMatrix(3);
        e1 = new int[][] { { 9, 27, 6 }, { 0, 3, 6 } };
        printTestResult(get2DArray(mat3), e1, 13, "getScaledMatrix method");

        mat3 = new MathMatrix(2, 2, 2).getScaledMatrix(0);
        e1 = new int[][] { { 0, 0 }, { 0, 0 } };
        printTestResult(get2DArray(mat3), e1, 14, "getScaledMatrix method");

        data1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        mat1 = new MathMatrix(data1);
        mat3 = mat1.getScaledMatrix(1);
        e1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
        printTestResult(get2DArray(mat3), e1, 15, "getScaledMatrix method");

        // tests 16-18, getTranpose
        mat3 = new MathMatrix(new int[][] { { 10 } }).getTranspose();
        e1 = new int[][] { { 10 } };
        printTestResult(get2DArray(mat3), e1, 16, "getTranpose method");

        data1 = new int[][] { { Integer.MAX_VALUE, Integer.MIN_VALUE, -1 },
                { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 } };
        mat3 = new MathMatrix(data1).getTranspose();
        e1 = new int[][] { { Integer.MAX_VALUE, Integer.MIN_VALUE }, 
            { Integer.MIN_VALUE, Integer.MAX_VALUE },
                { -1, 0 } };
        printTestResult(get2DArray(mat3), e1, 17, "getTranpose method");

        mat3 = new MathMatrix(new int[][] { { 1 }, { 2 }, { 3 } }).getTranspose();
        e1 = new int[][] { { 1, 2, 3 } };
        printTestResult(get2DArray(mat3), e1, 18, "getTranpose method");

        // tests 19-22, equals
        mat1 = new MathMatrix(new int[][] { { 1, 2 }, { 1, 2 } });
        mat2 = new MathMatrix(new int[][] { { 2 }, { 3 } });
        boolean answer = false;
        if (mat1.equals(mat2) == answer) {
            System.out.println("Test number 19 tests the equals method. The test passed.");
        } else {
            System.out.println("Test number 19 tests the equals method. The test failed.");
        }

        data1 = new int[][] { { 0, 4, 2 }, { 3, 1, 9 }, { 1, 12, 2 } };
        data2 = new int[][] { { 1, 4, 2 }, { 3, 1, 9 }, { 1, 12, 2 } };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        answer = false;
        if (mat1.equals(mat2) == answer) {
            System.out.println("Test number 20 tests the equals method. The test passed.");
        } else {
            System.out.println("Test number 20 tests the equals method. The test failed.");
        }

        answer = true;
        if (mat1.equals(mat1) == answer) {
            System.out.println("Test number 21 tests the equals method. The test passed.");
        } else {
            System.out.println("Test number 21 tests the equals method. The test failed.");
        }

        answer = false;
        if (mat1.equals(null) == answer) {
            System.out.println("Test number 21 tests the equals method. The test passed.");
        } else {
            System.out.println("Test number 21 tests the equals method. The test failed.");
        }

        // tests a different object (This case would be an int)
        answer = false;
        int test = 1;
        if (mat1.equals(test) == answer) {
            System.out.println("Test number 22 tests the equals method. The test passed.");
        } else {
            System.out.println("Test number 22 tests the equals method. The test failed.");
        }

        // tests 23-26, toString
        mat1 = new MathMatrix(1, 1, 1);
        String expected = "| 1|\n";
        if (mat1.toString().equals(expected)) {
            System.out.println("Passed test 23, toString method.");
        } else {
            System.out.println("Failed test 23, toString method.");
        }

        data1 = new int[][] { { 1, 0 }, { 1000, 10000 }, { 10, 10 } };
        mat1 = new MathMatrix(data1);
        expected = "|     1     0|\n|  1000 10000|\n|    10    10|\n";
        if (mat1.toString().equals(expected)) {
            System.out.println("Passed test 24, toString method.");
        } else {
            System.out.println("Failed test 24, toString method.");
        }

        mat1 = new MathMatrix(new int[][] { { 1, 10, 1, 10, 10 } });
        expected = "|  1 10  1 10 10|\n";
        if (mat1.toString().equals(expected)) {
            System.out.println("Passed test 25, toString method.");
        } else {
            System.out.println("Failed test 25, toString method.");
        }

        data1 = new int[][] { { Integer.MIN_VALUE, Integer.MAX_VALUE, 0 }, 
            { 0, 0, Integer.MAX_VALUE },
                { Integer.MIN_VALUE, 1, 1 } };
        mat1 = new MathMatrix(data1);
        expected = "| -2147483648  2147483647           0|\n" + 
                "|           0           0  2147483647|\n"
                + "| -2147483648           1           1|\n";
        if (mat1.toString().equals(expected)) {
            System.out.println("Passed test 26, toString method.");
        } else {
            System.out.println("Failed test 26, toString method.");
        }

        mat1 = new MathMatrix(new int[][] { { -1 }, { -1 }, { -1 }, { -1 } });
        expected = "| -1|\n| -1|\n| -1|\n| -1|\n";
        if (mat1.toString().equals(expected)) {
            System.out.println("Passed test 26, toString method.");
        } else {
            System.out.println("Failed test 26, toString method.");
        }

        // tests 27-29, upperTriangle
        mat1 = new MathMatrix(1, 1, 100);
        if (mat1.isUpperTriangular()) {
            System.out.println("Passed test 27, upperTriangle method.");
        } else {
            System.out.println("Passed test 27, upperTriangle method.");
        }

        mat1 = new MathMatrix(3, 3, 0);
        if (mat1.isUpperTriangular()) {
            System.out.println("Passed test 28, upperTriangle method.");
        } else {
            System.out.println("Passed test 28, upperTriangle method.");
        }

        data1 = new int[][] { { 4, 4, 4 }, { 0, 4, 4 }, { 1, 0, 10 } };
        mat1 = new MathMatrix(data1);
        answer = false;
        if (mat1.isUpperTriangular() == false) {
            System.out.println("Passed test 29, upperTriangle method.");
        } else {
            System.out.println("Passed test 29, upperTriangle method.");
        }

        // tests 30-31, getNumRows
        mat1 = new MathMatrix(1000, 1000, 1000);
        int rows = 1000;
        if (mat1.getNumRows() == rows) {
            System.out.println("Passed test 30, getNumRows method.");
        } else {
            System.out.println("Failed test 30, getNumRows method.");
        }

        data1 = new int[][] { { 0, 0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0 } };
        mat1 = new MathMatrix(data1);
        rows = 1;
        if (mat1.getNumRows() == rows) {
            System.out.println("Passed test 31, getNumRows method.");
        } else {
            System.out.println("Failed test 31, getNumRows method.");
        }

        // tests 32-33, getNumColumns
        mat1 = new MathMatrix(100, 100, 1);
        int columns = 100;
        if (mat1.getNumColumns() == columns) {
            System.out.println("Passed test 32, getNumColumns method.");
        } else {
            System.out.println("Failed test 32, getNumColumns method.");
        }

        mat1 = new MathMatrix(new int[][] { { 10 }, { 1 }, { 0 }, { 10 }, { 100 }, { 3 } });
        columns = 1;
        if (mat1.getNumColumns() == columns) {
            System.out.println("Passed test 33, getNumColumns method.");
        } else {
            System.out.println("Failed test 33, getNumColumns method.");
        }

        // tests 34-35, getVal
        mat1 = new MathMatrix(2, 2, Integer.MAX_VALUE);
        int value = Integer.MAX_VALUE;
        if (mat1.getVal(1, 1) == value) {
            System.out.println("Passed test 34, getVal method.");
        } else {
            System.out.println("Failed test 34, getVal method.");
        }

        data1 = new int[][] { { 120, 302, 203, 403 }, { 3, 21, 204, 02 }, { 111, 203, 1, 24 }, 
            { 40, 104, 2, 24 } };
        mat1 = new MathMatrix(data1);
        value = 24;
        if (mat1.getVal(mat1.getNumRows() - 1, mat1.getNumColumns() - 1) == value) {
            System.out.println("Passed test 35, getVal method.");
        } else {
            System.out.println("Failed test 35, getVal method.");
        }
            

    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        }
        int result = 0;
        final int ROWS = mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may not be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, 
            String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0) 
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0) 
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: " + 
                    "equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
