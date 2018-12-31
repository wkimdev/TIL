package com.home.wkimdev;

public class ExceptionTest {
	
	public static void main(String[] args) {
		
		// 다중 catch 
		// 주의점은 상위 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다. exception을 상속한 녀석들 이기 때문.. 
		// 멀티 catch ==> | 로 연결하기  
		
//		try {
//			String data1 = args[0];
//			String data2 = args[1];
//			int value1 = Integer.parseInt(data1);
//			int value2 = Integer.parseInt(data2);
//			int result = value1 + value2;
//			System.out.println(value1 + " + " + value2 + " = "+result);
//			
//		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
//			System.out.println("실행 매개값의 수가 부족하거나 혹은 숫자로 변환할 수 없습니다.");
//			System.out.println("[ 실행 방법 ] ==>num1 num2  지정 ");
//		} catch (Exception e) {
//			System.out.println("알 수 없는 예외 발생");
//		} finally {
//			System.out.println("다시 실행하세요. ");
//		}
		try {
			method1();
		} catch (ClassNotFoundException e) {
			System.out.println("class가 존재하지 않습니다. ");
		}
		
	}
	
	// 왜 main class 밖의 녀석들이 static이 되지???
	// 예외 떠넘기기 
	// 경우에 따라서는 메소드를 호출한 곳에서 예외를 떠넘길 수 있다. 이때 사용하는 키워드가 throws이다.
	public static void method1() throws ClassNotFoundException {
//		try {
			method2();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("클래스가 존재하지 않습니다. ");
//		}
		
	}
	
	public static void method2() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
