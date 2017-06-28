package com.henry.core_java;

import java.util.Scanner;

/**
 * 
 * @description read an integer array and remove all 10s from the array, shift
 *              the other elements towards left and fill the trailing empty
 *              positions by 0 so that the modified array is of the same length
 *              of the given array.
 * 
 * @author Henry
 * 
 */

public class RemoveTens {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		int retArr[] = removeTens(n, arr);
		for (int tmp : retArr) {
			System.out.println(tmp);
		}
	}

	/**
	 * @description remove 10's in the integer array.
	 * 
	 */
	public static int[] removeTens(int n, int[] arr) {

		int tmpArr[] = new int[n];
		int j = 0;
		for (int i = 0; i < n; i++) {
			// if not ten, get the value into new array.
			if (arr[i] != 10) {
				tmpArr[j] = arr[i];
				j++;
			}
		}

		return tmpArr;
	}
}
