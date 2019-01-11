package com.home.test.thread;

public class CakeEater extends Thread {
	
	private CakePlate cake;
	public CakeEater(CakePlate cake) {
		setCakePlate(cake);
	}
	
	public void setCakePlate(CakePlate cake) {
		// TODO Auto-generated method stub
		this.cake = cake;
	}
	
	public CakePlate getCakePlate() {
		// TODO Auto-generated method stub
		return cake;
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			cake.eatBread();
		}
	}
}
