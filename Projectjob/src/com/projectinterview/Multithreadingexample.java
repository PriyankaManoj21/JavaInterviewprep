package com.projectinterview;

/*
 * class contains example of using thread class and runnable interface
 *      run method is invoked when start() is called on any thread.
 *      runnable interface is prefered over thread class --> a class can only extend one class
 *      so when thread class is extended no more class can be extended. where a class can implement 
 *      multiple interface.
 *  
 */
class ThreadOne extends Thread {
	public void run() {
		for (int i = 0; i <= 4; i++) {
			System.out.println("ThreadOne " + i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Multithreadingexample {
	public static void main(String args[]) throws InterruptedException {
		// using thread class
		ThreadOne one = new ThreadOne();

		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i <= 4; i++) {
					System.out.println("t1 " + i);
				}
			}
		};

		// using runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("inisde runnable");

			}
		};
		// using runnable with lambda
		Runnable r2 = () -> {
			System.out.println("inisde runnable2");
			System.out.println("CURRENT THREAD " + Thread.currentThread());
		};

		Thread runnableThread = new Thread(r1);
		Thread runnableThread2 = new Thread(r2);
		runnableThread2.setPriority(Thread.MAX_PRIORITY);

		one.start();
		runnableThread.start();
		runnableThread2.start();
		t1.start();

		/*
		 * thread.join() is used to tell when only these threads are completed move to
		 * the main thread. "end of code" will print only after all 2 threads are
		 * completed
		 * 
		 */

		runnableThread2.join();
		t1.join();

		System.out.println("****end of code****");

	}

}
