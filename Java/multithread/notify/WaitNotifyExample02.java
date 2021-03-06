package com.home.test.multithread.notify;

// 두 스레드를 생성하고 실행하는 메인 스레드 
public class WaitNotifyExample02 {
	public static void main(String[] args) {
		
		DataBox dataBox = new DataBox();
		
		// 스레드 생성
		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);
		
		// 스레드 시작 
		pt.start();
		ct.start();
		
	}
}
