package com.home.test.multithread;

public class ThreadA extends Thread {
	
	// 종료
	// 작업 진행
	public boolean stop = false;
	public boolean work = true;
	
	
	// 작업 실행 코드 
	// 작업이 돌때 안돌때 
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("thread a 작업 내용 ");
			} else {
				Thread.yield(); // 다른 작업에게 양보 
			}
		}
		System.out.println(" thread A 종료 ");
	}
}
