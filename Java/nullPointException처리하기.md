   
   
```
// nullpointexception을 예방하기 위한 방법
		// 1) 의미없는 null parameter를 넘기지 않도록 한다. 
		
		// 2) null 여부 처리를 추가한다. 
//		String apple = null;
//		
//		if (apple != null) {
//			System.out.println(apple.indexOf("buy"));
//		}
//		
		// 3) "비교의 주체가 문자열"부터 주어진다면 "null pointException"이 발생하지 않는다.
		//	=> 문자열 비교는 non-null String 기준으로 비교하는게 좋다. 
		// 비교의 주체가 문자열이 오도록 하거나 , constants 등을 활용하도록 한다. 
		String a = null;
		
//		if ("jelly".equals(a)) {
////		if (a.equals("jelly")) { => nullPointException() 발생 
//			System.out.println("equals ==> 참 ");
//		} else {
//			System.out.println("equals ==> 거짓 ");
//		}
		
		// 4) toString() 대신 valueOf()를 사용한다
		Integer integerValue = 1;
		System.out.println(integerValue.toString());
		integerValue = null;
		//System.out.println(integerValue.toString());		// => java.lang.NullPointerException
		System.out.println(String.valueOf(integerValue));	// => nullPointException 발생을 피하게 된다. 


```
