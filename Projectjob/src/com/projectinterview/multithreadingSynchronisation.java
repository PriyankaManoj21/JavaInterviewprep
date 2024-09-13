package com.projectinterview;

/*
 * synchronized is used to lock a method a to a thread. once the usage of method by a thread is completed 
 * the lock is released and method is available for other threads to use.
 * 
 */

class Table extends Thread {
	synchronized void printTable(int n) {
		for (int i = 1; i <= 6; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class multithreadingSynchronisation {

	public static void main(String args[]) {
		Table t = new Table();
		//t.printTable(4);
		
		
		Thread t1 = new Thread() {
			public void run() {
				t.printTable(4);
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				t.printTable(5);
			}
		};
		t1.start();
		t2.start();
	}

}
