package com.home.test.thread;

// 작업
public class CakePlate {
	
	private int breadCount = 0;
	public CakePlate() {
	}
	
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			try {
				System.out.println("빵이 남는다.");
				wait();
			} catch (InterruptedException e) {
			}
		}
		breadCount++; // 빵이 10개가 안된다면 더 만들자. 
		System.out.println("빵을 1개 더 만든다 총 :"+breadCount+"개");
		this.notifyAll();
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1) {
			try {
				System.out.println("빵이 모자라 기다림");
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		breadCount++;	// 빵이 있으니까 먹자
		System.out.println("빵을 1개 먹음 총 : "+breadCount+" 개");
		this.notifyAll();
	}
}
