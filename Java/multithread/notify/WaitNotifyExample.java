package com.home.test.multithread.notify;

public class WaitNotifyExample {
	
	public static void main(String[] args) {
		
		// 공유객체 생성
		WorkObject sharedObject = new WorkObject();
		
		// thread 생성
		ThreadA threadA = new ThreadA(sharedObject);
		ThreadB threadB = new ThreadB(sharedObject);
		
		// thread 실행 
		threadA.start();
		threadB.start();
		
	}
	
	
	
}

