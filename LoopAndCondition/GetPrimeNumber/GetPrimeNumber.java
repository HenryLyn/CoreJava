package com.henry.core_java_20160629;

/**
 * 
 * @description get the prime number form 0 to 100;
 * 
 * @author Henry
 * 
 */

public class GetPrimeNumber {
	private static final int END = 100;

	public static void main(String[] args) {

		for (int i = 2; i < END; i++) {
			if (i == 2) {
				System.out.print(i + " ");
				continue;
			}
			int end = (int) Math.sqrt(i);
			for (int j = 2; j <= end; j++) {
				if (i % j == 0) {
					break;
				}
				if (j == end) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
