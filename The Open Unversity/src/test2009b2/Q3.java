package test2009b2;

import java.util.Arrays;

public class Q3 {
	
	public static int[] mergesort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		int[] left = new int[arr.length / 2];
		int[] right = new int[arr.length - left.length];
		for (int i = 0; i < arr.length; i++) {
			if(i < left.length) {
				left[i] = arr[i];
			} else {
				right[i - left.length] = arr[i];
			}
		}
		mergesort(left);
		mergesort(right);
		int iL = 0, iR = 0;
		while(iL + iR < arr.length) {
			if(iL >= left.length || (iR < right.length && left[iL] % 4 > right[iR] % 4)) {
				arr[iL + iR] = right[iR];
				iR++;
			} else {
				arr[iL + iR] = left[iL];
				iL++;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,9,3,2,7,2,3,4};
		mergesort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
