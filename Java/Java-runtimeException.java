package com.home.wkimdev;

import java.io.Serializable;

public class BoardMain {
	
	public static void main(String[] args) throws Exception {
		
		// runtime exception 
		
		// 배열 arrayindexoutofboundsException 
//		if(args.length == 2) {
//			String data1 = args[0];
//			String data2 = args[1];
//			System.out.println("args[0] : "+data1);
//			System.out.println("args[1] : "+data2);
//		} else {
//			System.out.println("실행 방법 ");
//			System.out.println("java arrayindexoutofboundsException example ");
//			System.out.println(" test ");
//		}
		
		
		// numberformat exception!!
		//  NumberFormatException extends IllegalArgumentException
		// 		class IllegalArgumentException extends RuntimeException {
		// 			public class RuntimeException extends Exception {
		//				public class Exception extends Throwable {
		//					public class Throwable implements Serializable {
		//							public interface Serializable {
//		String data1 = "100";
//		String data2 = "a100";
//		
//		int value1 = Integer.parseInt(data1);
//		int value2 = Integer.parseInt(data2);
//		
//		int result = value1 + value2;
		
		// 에러 강제로 발생시키기
//		if(true) {
//			throw new Exception();
//		}
		//System.out.println("execute this output method");
		
				// classcastException
		// case 1
		Animal animal = new Dog();
		// instanceof로 타입 변환이 가능한지 확인하기
		Cat cat = (Cat) animal;
//		if(animal instanceof Dog) {
//			Dog dog = (Dog) animal;
//			System.out.println("1111111");
//		} else if(animal instanceof Cat) {
//			Cat cat = (Cat) animal;
//			System.out.println("222222");
//		}
			
		// 참조변수(연산자) instanceof 타입(클래스명-피연산자)
		// return type은 boolean
		
		// case 2
		Remocon rc = new Audio();
		if(rc instanceof Television) {
			Television tv = (Television) rc ;
			System.out.println("Television");
		} else if (rc instanceof Audio) {
			Audio audio = (Audio) rc;
			System.out.println("Audio");
		}

		
		
	}
}
