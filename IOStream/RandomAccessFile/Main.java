package com.cognizant.henry.day8_20170629;

public class Main {

	public static void main(String[] args) {

		CopyImage copy = new CopyImage("C:/Henry/1.jpg", "C:/Henry/2.jpg");
		if (copy.copyImage()) {
			System.out.println("successed.");
		} else {
			System.out.println("Failed.");
		}
		System.out.println(copy.toString());
	}

}
