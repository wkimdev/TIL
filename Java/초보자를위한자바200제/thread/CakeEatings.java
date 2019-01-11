package com.home.test.thread;

public class CakeEatings {
	
	public static void main(String[] args) {
		
		// 빵접시를 준비한다. 
		CakePlate cake = new CakePlate();
		// 빵접시를 공유
		CakeEater eater = new CakeEater(cake);
		// 빵접시를 공유
		CakeMaker baker = new CakeMaker(cake);
		
		// 우선순위가 높으면 더 호출할 가능성이 높다?? 
		// baker.setPriority(6);
		baker.start();
		eater.start();
		
	}

}
