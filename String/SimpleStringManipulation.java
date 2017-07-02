/**
 * 
 * @description read a string and return a modified string based on the following rules.
 *			Return the String without the first 2 chars except when
 *				1.   keep the first char if it is 'j'
 *				2.   keep the second char if it is 'b'.
 * @author Henry
 * @version 0.0.1.20170702
 * 
 */

package com.henry.core_java_20160702;

import java.util.Scanner;

public class SimpleStringManipulation {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		String strTmp = getString(input);
		System.out.println(strTmp);

	}

	public static String getString(String str) {
		StringBuilder tmpStr = new StringBuilder(str.substring(2, str.length()));
		char first = str.charAt(0);
		char second = str.charAt(1);
		if ('b' == second) {
			tmpStr.insert(0, second);
		}
		if ('j' == first) {
			tmpStr.insert(0, first);
		}
		return tmpStr.toString();
	}

}
