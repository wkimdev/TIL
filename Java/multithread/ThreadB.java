package com.home.test.multithread;

public class ThreadB extends Thread {
	
	// 종료, 작업 진행 
	public boolean stop = false;
	public boolean work = true;
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(" thread b 작업 내용 ");
			} else {
				Thread.yield();
			}
		}
		System.out.println(" thread b 작업 종료 ");
	}
}
