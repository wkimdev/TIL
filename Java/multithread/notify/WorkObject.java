package com.home.test.multithread.notify;

// 두 스레드의 작업 내용을 동기화 메소드로 작성한 공유 객체
// 공유 객체~~
public class WorkObject {
	
	public synchronized void methodA() {
		System.out.println("ThreadA 의 methodA() 작업 실행 ");
		notify();	// 일시 정지 상태에 있는 thread b를 실행 대기 상태로 만듬 
		try {
			wait(); // thread a를 일시 정지 
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB() {
		System.out.println(" ThreadB의 methodb() 작업 실행 ");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
