package com.home.test;

import com.home.test.thread.MyRun;
import com.home.test.thread.MyRuns;
import com.home.test.thread.MyThread;

// 멀티 쓰레드 프로그램
public class MainClass {   
	
	public static void main(String[] args) {
		
		// i guest.. s ==> u ==> ? ==> T ==> R ==> M XXX
		// RESUT ==> 섞여서 동작함. (멀티 스레드??)
//		MyRun myrun1 = new MyRun(); // runable implements // s
//		
//		// 작업만 있고 (RUN)작업장(THREAD)가 없으므로 작업장에 작업을 넣음
//		//  쓰레드에 runnable를 구현한 객체의 레퍼런스를 대입한다. 
//		Thread t1 = new Thread(myrun1);	
//		
//		MyThread t2 = new MyThread(); // thread extends
//		
//		Thread t3 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				for (int i = 0; i < 500 ; i++) {
//					System.out.print("R");
//				}
//			}
//		});
//		
//		// lamdbda
//		new Thread(() -> {
//			for (int i = 0; i < 500; i++) {
//				System.out.print("U");
//			}
//		}
//		).start();
//		t1.start(); // ?
//		t2.start();	// T
//		t3.start(); // R
//		
//		for (int i = 0; i < 500; i++) {
//			System.out.print("M");
//		}
		
		MyRuns mr1 = new MyRuns();
		Thread t1 = new Thread(mr1, "a");
		Thread t2 = new Thread(mr1, "b");
		Thread t3 = new Thread(mr1, "c");
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
