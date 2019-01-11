package com.home.test.thread;

// 작업장
public class CakeMaker extends Thread{
	private CakePlate cake;
	public CakeMaker(CakePlate cake) {
		setCakePlate(cake);
	}
	
	public void setCakePlate(CakePlate cake) {
		// TODO Auto-generated method stub
		this.cake=cake;
	}
	
	public CakePlate getCakePlate() {
		// TODO Auto-generated method stub
		return cake;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			cake.makeBread();
		}
	}
	
}
