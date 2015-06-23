package mmn13;



/**
 * This class represents a two-dimensional image in black and white.
 */
public class Matrix {

	/**
	 * An array of integers between 0-255. Each integer represents a pixel on the gray-scale.
	 */
	int[][] array;

	/**
	 * Constructs a Matrix from a two dimensional array; the dimensions as well
	 * as the values of this Matrix will be the same as the dimensions and
	 * values of the two-dimensional array.
	 */
	public Matrix(int[][] array) {
		this(array.length, array[0].length);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				this.array[i][j] = array[i][j]; 
			}
		}
	}

	/**
	 * Constructs a size1 by size2 Matrix of zeroes.
	 */
	public Matrix(int size1, int size2) {
		array = new int[size1][size2];
	}
	
	/**
	 * Returns a string representation of the Matrix
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				str += array[i][j];
				if(j == array[i].length - 1) {
					str += "\n";
				} else {
					str += "\t";
				}
			}
		}
		return str;
	}
	
	/**
	 * Returns a new Matrix with the negative of the current matrix
	 */
	public Matrix makeNegative() {
		int[][] newArr = new int[array.length][array[0].length];
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr.length; j++) {
				//get the negative value for the cell. 
				newArr[i][j] = 255 - array[i][j];
			}
		}
		return new Matrix(newArr);
	}
	
	/**
	 * Returns a filtered version of this current matrix.
	 * A matrix is filtered by making each cell the average of cells around him.
	 */
	public Matrix imageFilterAverage() {
		int[][] newArr = new int[array.length][array[0].length];
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[i].length; j++) {
				int sum = 0;
				int cellsAdded = 0;
				//a nested for loop to go over the nine cells (or less) and sum them.
				for (int cellMove = -1; cellMove < 2; cellMove++) {
					for (int rowMove = -1; rowMove < 2; rowMove++) {
						//checks if the neighboring cell is in bounds
						if(i + cellMove >= 0 && i + cellMove < newArr.length && j + rowMove >= 0 && j + rowMove < newArr[i + cellMove].length) {
							sum += array[i + cellMove][j + rowMove];
							cellsAdded++;
						}
					}
				}
				newArr[i][j] = sum / cellsAdded;
			}
		}
		return new Matrix(newArr);
	}
	
}
