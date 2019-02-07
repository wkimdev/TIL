package com.home.test.multithread;

public class JoinExample {
	
	// sum 하는 스레드 코드를 실행한다 
	// 잠시 스레드를 멈춰서 .... 다른 스레드의 작업이 완료되기를 기다린다. 
	// 자바의 비동기 처리인가 ㅎㅎ... 
	
	public static void main(String[] args) {
		SumThread sumthread = new SumThread();
		sumthread.start();
		
		try {
			sumthread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("1~100 합 :"+ sumthread.getSum());
	}
}
