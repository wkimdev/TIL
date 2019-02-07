package com.home.test.multithread.notify;

public class ThreadB extends Thread {
	
	private WorkObject workObject;
	
	// 공유 객체를 매개값으로 받아 필드에 저장 
	public ThreadB(WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
	
}
