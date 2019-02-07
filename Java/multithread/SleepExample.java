package com.home.test.multithread;

import java.awt.Toolkit;

// 스레드의 상태 제어 
public class SleepExample {
	
	public static void main(String[] args) {
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		for (int i = 0; i < 10; i++) {
//			toolkit.beep();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//			}
//		}
		
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		threadA.work = false;	//tread b 실행 
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		threadA.work = true;	// 모두 실행 
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		threadA.stop = true;
		threadB.stop = true;
		
	}
}
