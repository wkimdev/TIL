package com.home.test.thread;

// made run(작업)
public class MyRun implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		show();
	}

	public void show() {
		// TODO Auto-generated method stub
		for(int i=0; i<500; i++) {
			System.out.print("s");
		}
	}
}
