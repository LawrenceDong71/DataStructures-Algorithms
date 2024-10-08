import java.util.Arrays;

// MathMatrix.java - CS314 Assignment 2
/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {

    // instance variable
    private int[][] values;

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        // check preconditions
        if (!rectangularMatrix(mat)) {
            throw new IllegalArgumentException("Matrix must be rectangular");
        }
        values = new int[mat.length][mat[0].length];

        // deep copy
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                values[i][j] = mat[i][j];
            }
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns.
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        // check preconditions
        if (numRows <= 0 || numCols <= 0) {
            throw new IllegalArgumentException("numRows and numCols must be " 
                + "greater than or equal to 0");
        }

        values = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // set every element to initialVal
                values[i][j] = initialVal;
            }
        }
    }

    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return values.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns() {
        return values[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        // check preconditions
        if (row < 0 || row >= getNumRows() || col < 0 || col >= getNumColumns()) {
            throw new IllegalArgumentException("Invalid row or col index. Row must be at least 0"
               + "and less than "+ getNumRows() + " and col must be at least 0 and less than"
                   + getNumColumns());
        }

        return values[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns
     * in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
        // check preconditions
        if (rightHandSide == null || rightHandSide.getNumRows() != getNumRows() || 
            rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("Violates Precondition: rightHandside cannot be"
        	    + " and must have same dimensions as values");
        }
        
        int[][] addition = new int[getNumRows()][getNumColumns()];
        
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                addition[i][j] = values[i][j] + rightHandSide.values[i][j];
            }
        }
        
        // create new MathMatrix to avoid altering values and rightHandSide
        return new MathMatrix(addition);
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.getNumColumns() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide
     * from this MathMatrix. The number of rows in the returned MathMatrix is equal to the number
     * of rows in this MathMatrix.The number of columns in the returned MathMatrix is equal to
     * the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
        // check preconditions
        if (rightHandSide == null || rightHandSide.getNumRows() != getNumRows() ||
            rightHandSide.getNumColumns() != getNumColumns()) {
            throw new IllegalArgumentException("Violates Precondition: rightHandside cannot be"
                + " and must have same dimensions as values");
        }
        
        int[][] subtraction = new int[getNumRows()][getNumColumns()];
        
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                subtraction[i][j] = values[i][j] - rightHandSide.values[i][j];
            }
        }

        // create new MathMatrix to avoid altering values and rightHandSide
        return new MathMatrix(subtraction);
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying
     * this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows
     * in this MathMatrix. The number of columns in the returned MathMatrix is equal to the number
     * of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
        // check preconditions
        if (rightHandSide == null || getNumColumns() != rightHandSide.getNumRows() ) {
            throw new IllegalArgumentException("rightHandSide cannot be null, and the number of "
                + "columns in values must be equal to the number of rows in rightHandSide");
        }
        
        // dimensions of resulting array is the rows of values by columns of rightHandSide
        int[][] multiplication = new int[getNumRows()][rightHandSide.getNumColumns()];
        
        for (int i = 0; i < multiplication.length; i++) {
            for (int j = 0; j < multiplication[0].length; j++) {
                // returns dot product
                multiplication[i][j] = dotProduct(values, rightHandSide.values, i, j);
            }
        }
        
        // create new MathMatrix to avoid altering values and rightHandSide
        return new MathMatrix(multiplication);
    }
    
    private int dotProduct(int[][] curr, int[][] rightHand, int currRow, int rightHandCol) {

        int output = 0;
        for (int i = 0; i < getNumColumns(); i++) {
            // dot product formula
            output += values[currRow][i] * rightHand[i][rightHandCol];
        }

        return output;
    }
    	


    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix
     * multiplied by factor.
     * In other words after this method has been called
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
        int[][] scaled = new int[getNumRows()][getNumColumns()];

        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                // multiply by the factor
                scaled[i][j] = values[i][j] * factor;
            }
        }

        return new MathMatrix(scaled);
    }


    /**
     * accessor: get a transpose of this MathMatrix.
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        //rows and columns are swapped
        int[][] transposed = new int[getNumColumns()][getNumRows()];

        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                transposed[j][i] = values[i][j];
            }
        }

        return new MathMatrix(transposed);
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
    	/* CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         *
         * We use getClass instead of instanceof because we only want a MathMatrix to equal
         * another MathMatrix as opposed to any possible sub classes. We would
         * use instance of if we were implementing am interface and wanted to equal
         * other objects that are instances of that interface but not necessarily
         * MathMatrix objects.
         */
        // check preconditions
        if (rightHandSide == null || this.getClass() != rightHandSide.getClass()) {
            return false;
        }
        // We know rightHandSide refers to a non-null MathMatrix object, safe to cast.
        MathMatrix otherMathMatrix = (MathMatrix) rightHandSide;
        // Now we can access the private instance variables of otherMathMatrix
        // and / or call MathMatrix methods on otherMathMatrix.
        
        // different dimensions cannot be the same matrix
        if (getNumRows() != otherMathMatrix.getNumRows() || 
            getNumColumns() != otherMathMatrix.getNumColumns()) {
            return false;
        }
        
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                if (values[i][j] != otherMathMatrix.values[i][j]) {
                    return false;
                }
            }
        }
        // return true if no different values are found
        return true;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix.
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {

        // find longest number in the matrix then plus 1
        int spaceTakenUp = 0;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                int currentCellWidth = ("" + values[i][j]).length() + 1;
                if (currentCellWidth > spaceTakenUp) {
                    spaceTakenUp = currentCellWidth;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < getNumRows(); i++) {
            // indicates the start of the row;
            result.append("|");

            for (int j = 0; j < getNumColumns(); j++) {
                // adds each number in current row
                result.append(String.format("%" + spaceTakenUp + "d", values[i][j]));
            }

            // indicates end of the row
            result.append("|");

            // make a newline for the next row
            result.append("\n");
        }

        return result.toString();

    }



    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise.
     */
    public boolean isUpperTriangular(){
        // check preconditions
    	if (getNumRows() != getNumColumns()) {
    	    throw new IllegalArgumentException("Must be a squaure matrix to "
    	        + "be upper triangular");
    	}
    	
    	// only check numbers below the diagonal
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < i; j++) {
                if (values[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ensure mat is a rectangular matrix. Method is public so
     * client classes can also use it.
     * @param mat mat != null, mat must have at least one row,
     * there must be at least one column in the first row, and
     * all rows in mat must have the same number of columns.
     * @return true if mat is rectangular, false otherwise.
     */
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        } else if (mat[0] == null) {
            throw new IllegalArgumentException("argument may not have null rows. "
                    + "mat = " + Arrays.toString(mat));
        } else if (mat[0].length == 0) {
            throw new IllegalArgumentException("argument mat must have at least "
                    + "one column per row.");
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            // Odd to put this here. Maybe do a two pass approach?
            if (mat[row] == null) {
                throw new IllegalArgumentException("argument may not have null rows. "
                        + "mat = " + Arrays.toString(mat));
            }
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}
