package com.home.test.thread;

public class MyRuns implements Runnable {
	
	// 멤버 자원 공유
	private int i = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		show();
	}
	
	
	//public void show() {
	public synchronized void show() {	// synchronized 동기화
		// TODO Auto-generated method stub
		for (; i < 500; i++) { // 이게 뭐지 ????????? 공유 자원을 쓰면 이렇게 쓸 수 있는건가??
			if(((Thread.currentThread()).getName()).equals("a")) {
				System.out.print("A");
			} else if(((Thread.currentThread()).getName()).equals("b")) {
				System.out.print("B");
			} else if(((Thread.currentThread()).getName()).equals("c")){
				System.out.print("C");
			} else {
				System.out.print("["+ Thread.currentThread().getName()+ i +"]");
			}
		}
	}

}
