package com.home.test.multithread.notify;

// 두 스레드의 작업 내용을 동기화 메소드로 작성한 공유 객체 
public class DataBox {
	private String data;

	//getData, setData
	public synchronized String getData() {
		if ( this.data == null ) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		String returnValue = data;
		System.out.println(" consummerThread가 읽은 데이터 :"+ returnValue);
		data = null;
		notify();	// 생상자 스레드를 실행 대기 상태로 만듬 
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		// data 필드에 값을 저장하고 소비자 스레드를 실행 대기 상태로 만든다. 
		this.data = data;
		System.out.println("producerThread가 생성한 데이터 : "+data);
		notify();
	}
	
	
	
}
