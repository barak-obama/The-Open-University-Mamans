package maman14;



public class Ex14 {

	/*
	 * ex1 answers: (a): 3, 5, 6
	 * 
	 * ex2 answers: (a): what method return the length of the longest chain in
	 * the array that it's sum is even.
	 * 
	 * (b): O(n^3) (d): O(n^2)
	 */

	/**
	 * returns true if 'num' is in the array 'm', knowingly that every row and
	 * column is ordered from the small to the large.
	 * 
	 * the running-time complexity of the function is O(n).
	 * 
	 * @param m
	 *            - two dimensional array of integers
	 * @param val
	 *            - a value to look for in the given array
	 * @return - return true if the value exists in 'm', and false otherwise
	 */
	public static boolean findValWhat(int[][] arr, int num) {
		// start to search from the bottom-left corner of the two dimensional
		// array.
		int i = arr.length - 1, j = 0;
		while (i >= 0 && j < arr.length) {
			// since each row and column in the array is sorted from small to
			// large if the current cell is larger than 'num', then 'num' won't
			// be
			// in the current row (the elements to the right are larger) -
			// we need to go 'up' (decrease 'i' in 1).
			// if the current cell is smaller than 'num', then 'num' won't be in
			// the current column (the elements to the top of it are smaller) -
			// we need to go 'right' (increase 'j' in 1)
			if (arr[i][j] > num)
				i--;
			else if (arr[i][j] < num)
				j++;
			else
				return true;
		}
		// i we haven't found 'num' in the array' return false.
		return false;
	}

	/**
	 * returns true if 'num' is in the array 'm', knowingly that every element
	 * in row i-th is smaller (or equal) to every element in the (i+1)-th
	 * (assuming they exist).
	 * 
	 * the running-time complexity of the function is O(n).
	 * 
	 * @param m
	 *            - two dimensional array of integers
	 * @param val
	 *            - a value to look for in the given array
	 * @return - return true if the value exists in 'm', and false otherwise
	 */

	public static boolean findValTest(int[][] arr, int num) {
		int i;
		// iterate over all the first elements in every row
		for (i = 0; i < arr.length; i++) {
			// if 'arr[i][0]' is bigger then 'num' num can't be in any row after
			// the 'i'-th row or before the 'i-1'-th row (if i=0 so it can b
			// only in the first row)
			if (arr[i][0] > num) {
				if (i > 0)
					for (int j = 0; j < arr[i].length; j++) {
						if (arr[i][j] == num || arr[i - 1][j] == num)
							return true;
					}

				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] == num)
						return true;
				}
			}
		}
		// if 'num' is bigger than 'arr[arr.length-1][0]' so it can be only in he last row
		for (int j = 0; j < arr[i-1].length; j++) {
			if (arr[i-1][j] == num)
				return true;
		}
		// if num is not found in any row, return false.
		return false;
	}

	/**
	 * what method return the length of the longest chain in the array that it's
	 * sum is even
	 * 
	 * The running-time complexity of the function is O(n^2).
	 * 
	 * @param a
	 *            - array of integers
	 * @return - largest number of elements you can sum 'in a row', so that the
	 *         sum is divisible by two
	 */
	public static int what(int[] a) {
		int temp = 0;
		int sum = 0;
		// iterates over all the possible sums.
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				// sum the array from 'i' to 'j' by
				// adding to 'sum' the value of 'a[j]' instead of using
				// "int c = f(a, i, j)".
				sum += a[j];
				// check if the sum is even and is the number of elements is the
				// largest.
				if (sum % 2 == 0 && j - i + 1 > temp)
					temp = j - i + 1;
			}
			// initialization the sum
			sum = 0;
		}
		return temp;
	}

	/**
	 * return the weight of the first instance of 'digit' in the number 'num'
	 * 
	 * 
	 * @param num
	 *            - a given number
	 * @param digit
	 *            - the digit to look for in the given number 'num'
	 * @return - weight of the first instance of 'digit' in the number 'num'
	 */
	public static int weight(int num, int digit) {
		int w = 1;
		while (num > 0) {
			// checking if the digit with weight "w" is "digit"
			if (num % 10 == digit)
				return w;
			// if not, remove that digit and multiply the weight by 10.
			w *= 10;
			num /= 10;
		}
		// if "digit" is not in "num"' return 0.
		return 0;
	}

	/**
	 * recursively returns the weight of the first instance of 'digit' in the
	 * number 'num'
	 * 
	 * @param num
	 *            - a given number
	 * @param digit
	 *            - the digit to look for in the given number 'num'
	 * @return - weight of the first instance of 'digit' in the number 'num'
	 */
	public static int weightRec(int num, int digit) {
		// if digit isn't found in num
		if (num == 0)
			return 0;
		// base case
		if (num % 10 == digit)
			return 1;
		// multiplies by ten for each digit it passes to reach the weight of the
		// digit
		return 10 * weightRec(num / 10, digit);
	}

	/**
	 * returns the number 'num' in reversed order.
	 * 
	 * @param num
	 *            - the number to reverse
	 * @return - the reversed number
	 */
	public static int reverse(int num) {
		int newNum = 0;
		// takes each digit in turn from the rightmost side of 'num', then add
		// it to digit and shifts it left
		while (num > 0) {
			newNum *= 10;
			newNum += num % 10;
			num /= 10;

		}
		return newNum;
	}

	/**
	 * recursively returns the number 'num' in reversed order.
	 * 
	 * @param num
	 *            - the number to reverse
	 * @param digit
	 *            - a helping number used to save the current digits
	 * @return - the reversed number
	 */
	public static int reverseRec(int num, int digit) {
		// takes each digit in turn from the rightmost side of 'num', then add
		// it to digit and shifts it left.
		// after this its' gets rid of the rightmost digit of num, we don't need
		// it anymore
		return num == 0 ? digit : reverseRec(num / 10, digit * 10 + num % 10);
	}

	/**
	 * recursively returns the number 'num' in reversed order.
	 * 
	 * @param num
	 *            - the number to reverse
	 * @return - the reversed number
	 */
	public static int reverseRec(int num) {
		return reverseRec(num, 0);
	}

	/**
	 * returns the number of 'legal paths', in a two-dimensional array of
	 * non-negative integers that are smaller than 100
	 * 
	 * @param mat
	 *            - two dimensional array of non-negative integers that are
	 *            smaller than 100
	 * @param i
	 *            - starting row
	 * @param j
	 *            - starting column
	 * @return - number of 'legal paths' in mat
	 */
	public static int countPaths(int[][] map, int i, int j) {
		if (map[i][j] == 0) {
			// if the current element's value is 0 this element is the end of
			// path.
			// if the end is the end o a legal path' return 1' else return 2.
			return i == map.length && j == map[i].length ? 1 : 0;
		}

		// checks how many legal paths there is.
		int a1 = map[i][j] % 10, a2 = map[i][j] / 10;
		// way 1
		int x1 = i + a1, y1 = j + a2;
		// way two
		int x2 = i + a2, y2 = j + a1;
		int c = 0;

		// if going this way doesn't get us out of the array so it 'give' us
		// 'countPaths(map, x1, y1)' legal paths
		if (x1 < map.length && y1 < map[x1].length)
			c += countPaths(map, x1, y1);
		// if going this way doesn't get us out of the array (and is this way is
		// not the same like to latter) so it 'give' us 'countPaths(map, x1,
		// y1)' legal paths
		if (x2 != x1 && y2 != y1 && x2 < map.length && y2 < map[x2].length)
			c += countPaths(map, x2, y2);

		// if there is no ways to go (a.k.a c = 0) do the current element is an
		// end of a path. if its an end of a legal path is 'gives' one 1 legal
		// paths
		if (c == 0 && i == map.length - 1 && j == map[i].length - 1)
			c = 1;
		return c;
	}

	/**
	 * returns the number of 'legal paths', in a two-dimensional array of
	 * non-negative integers that are smaller than 100
	 * 
	 * @param mat
	 *            - two dimensional array of non-negative integers that are
	 *            smaller than 100
	 * @return - number of 'legal paths' in mat
	 */
	public static int countPaths(int[][] map) {
		return countPaths(map, 0, 0);
	}
}
