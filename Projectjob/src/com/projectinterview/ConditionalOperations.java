package com.projectinterview;

public class ConditionalOperations {

	public static void main(String args[]) {

		ifElse(7);
		switchCase(2);
		whileCase(2);
	}

	public static void ifElse(int x) {

		if (x % 2 == 0) {
			System.out.println("X is even");
		} else {
			System.out.println("X is odd");
		}

	}

	public static void switchCase(int age) {
		switch (age) {
		case 1:
			System.out.println("Age is 1");
		case 2:
			System.out.println("Age is 2");
		default:
			System.out.println("THE END");
         break;
		}

	}
	
	public static void whileCase(int age) {
		
		while(age>0) {
			System.out.println("CHECK");
			age--;
		}
	}

}
