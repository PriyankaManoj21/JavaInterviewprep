package com.projectinterview;

public class Recursion {

	public static void main(String[] args) {
		// calculateTotal(6);
		long s = factorial(5);
		System.out.println(s);

	}

	public static int calculateTotal(int num) {
		int total = 0;
		if (num == 0) {
			total = num;
			System.out.println(num);

		} else {
			total = num + calculateTotal(num - 1);
			System.out.println(total);
		}
		return total;

	}

	public static void fibonocci(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println(fibonocciSeris(i));
		}

	}

	public static int fibonocciSeris(int num) {
		int series = 0;
		if (num <= 1) {
			series = num;
		} else {
			series = fibonocciSeris(num - 1) + fibonocciSeris(num - 2);
		}
		return series;
	}

	public static long factorial(int num) {

		if (num == 1) {
			return 1 ;
			

		} else {
			
			return (num * factorial(num - 1));
		}

	}
}
