package com.home.test.multithread.notify;

// 데이터를 소비하는 (읽는) 스레드
public class ConsumerThread extends Thread {
	private DataBox dataBox;
	
	public ConsumerThread(DataBox dataBox) {
		this.dataBox = dataBox; // 공유 객체를 필드에 저장 
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 3; i++) {
			String data = dataBox.getData();
		}
	}
		
	
}
