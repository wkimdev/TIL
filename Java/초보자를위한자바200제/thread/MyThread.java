package com.home.test.thread;

// made thread(작업장)
public class MyThread extends Thread {
	
	public void run() {
		for(int i=0; i<500; i++) {
			System.out.print("T");
		}
	}

}
