package com.henry.core_java_20170704;

/**
 * 
 * @description Write a program to read a string and validate whether the given
 *              string is a valid color code based on the following rules: -
 *              Must start with "#" symbol - Must contain six characters after #
 *              - It may contain alphabets from A-F or digits from 0-9
 * @author Henry
 * @version 0.0.1.20170704
 * 
 */
import java.util.Scanner;

public class ColorCode {
	private static final String REGEX = "#[A-F0-9]+";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		boolean isColorCode = validateColorCode(input);
		if (isColorCode) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

	private static boolean validateColorCode(String str) {
		if (str.length() == 7) {
			return str.matches(REGEX);
		} else {
			return false;
		}
	}

}
