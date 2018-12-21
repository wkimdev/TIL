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
		System.out.println("execute this output method");
	}
}
