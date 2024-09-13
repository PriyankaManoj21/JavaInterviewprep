
package com.projectinterview;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Basic {

	public static void main(String[] args) {
		System.out.println("*****REVERSE A STRING******");
		reverseString();
		System.out.println("\n*****SWAP A Number With Temp******");
		swapWithTemp();
		swapWithoutTemp();
		System.out.println("\n*****vowel present in a string******");
		checkVowelPresence();
		System.out.println("\n*****Check Prime Number******");
		checkPrimeNumber();
		System.out.println("\n*****fibonocci series Recursion******");
		printFibnocci(5);
		System.out.println("\n*****fibonocci series******");
		fibonacciSeries(6);
		System.out.println("\n*****odd Number series******");
		printOddNumber();
		System.out.println("\n*****odd Number series Using Parallel Stream******");
		printOddNumberUsingParallelStream();
		System.out.println("\n*****check palindrome******");
		checkPallindrome();
		System.out.println("\n*****remove White Space******");
		removeWhiteSpace();
		System.out.println("\n*****remove Trailing/Leading White Space******");
		removeLeadingAndTrailingSpace();
		System.out.println("\n*****DATE FORMAT******");
		dateTimeFormat();

	}

	public static void reverseString() {

		String str = "Priya";

		// use string builder append function
		StringBuilder s = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			s.append(str.charAt(i));

		}
		System.out.println(s);
	}

	public static void swapWithTemp() {
		int x = 5;
		int y = 10;
		System.out.println("Before Swapping: x = " + x + " y = " + y);
		int z = y;
		y = x;
		x = z;
		System.out.println("After Swapping: x = " + x + " y = " + y);

	}

	public static void swapWithoutTemp() {
		int x = 5;
		int y = 10;
		System.out.println("Before Swapping Without Temp: x = " + x + " y = " + y);
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("Before Swapping Without Temp: x = " + x + " y = " + y);
	}

	public static void checkVowelPresence() {
		String s = "hello";
		System.out.println("vowel is present: " + s.matches(".*[aeiou]*."));

	}

	private static void checkPrimeNumber() {
		// a number that has two factors
		int number = 6;
		int count = 0; // number of factors
		for (int j = 1; j <= number; j++) {
			if (number % j == 0) {
				count++;
			}
		}
		if (count <= 2) {
			System.out.println("number is prime");
		} else {
			System.out.println("number is composite");
		}
	}

	private static void fibonacciSeries(int number) {
		int a = 0;
		int b = 1;
		int c = 1;

		for (int i = 1; i <= number; i++) {
			System.out.print(a + " ");
			a = b;
			b = c;
			c = a + b;

		}

	}

	private static int fibonacciSeriesRecursion(int number) {

		if (number <= 1) {
			return number;
		} else {
			return fibonacciSeriesRecursion(number - 1) + fibonacciSeriesRecursion(number - 2);
		}
	}

	public static void printFibnocci(int number) {
		for (int i = 0; i < number; i++) {
			System.out.print(fibonacciSeriesRecursion(i) + " ");
		}
	}

	public static void printOddNumber() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(6);
		numbers.add(2);
		numbers.add(8);
		numbers.add(9);
		System.out.println("numbers list: " + numbers);
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) % 2 != 0) {

				System.out.println("list has odd numbers: " + numbers.get(i));
				break;

			}

		}

	}

	public static void printOddNumberUsingParallelStream() {
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(6);
		numbers.add(2);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);
		numbers.add(16);
		numbers.add(19);
		numbers.add(20);

		// can use parallel stream for huge list which has no particular order..

		System.out.println(numbers.parallelStream().anyMatch(x -> x % 2 != 0));

	}

	public static void checkPallindrome() {
		String palindromeCheck = "malayalam";
		StringBuilder reverseString = new StringBuilder();

		for (int i = palindromeCheck.length() - 1; i >= 0; i--) {
			reverseString.append(palindromeCheck.charAt(i));
		}

		// can't compare string and string builder since they are different objects.
		// convert string builder to string and check equals
		if (reverseString.toString().equals(palindromeCheck)) {
			System.out.println("String is pallindrome");
		} else {
			System.out.println("String is not a pallindrome");
		}
	}

	public static void removeWhiteSpace() {
		String str = " hello  hi ";
		StringBuilder s = new StringBuilder();
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (!Character.isWhitespace(arr[i])) {
				s.append(arr[i]);
			}

		}

		System.out.println("before removing: " + str);
		System.out.println("After removing: " + s);
	}

	public static void removeLeadingAndTrailingSpace() {
		String s = "   Hi Hel lo";

		s = s.strip();

		System.out.println(s);

	}

	public static void dateTimeFormat() {
		LocalDateTime date = LocalDateTime.now();
		System.out.println("date without formating" + date);
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formattedDate = date.format(formatObj);
		System.out.println("date After formating" + formattedDate);

	}
	
	

}