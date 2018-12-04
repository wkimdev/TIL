

@see -> http://library1008.tistory.com/47
// 기타 imutable..한 특징이 있었던것 같다... ㅠㅠ 


// code에서는 transaction pool에 올린이후에 utxo의 변경을 막기위해 사용한다.  
	@Test
	public void getDeepCopy() {
		ArrayList<String> source = new ArrayList<String>();
		ArrayList<String> destination = new ArrayList<String>();
		
		source.add("a");
		source.add("b");
		source.add("c");
		
		// init code
//		if( null != source ) {
//			source.clear();
//			source.add("a");
//			source.add("b");
//			source.add("c");
//		}
//		
//		if( null != destination ) {
//			destination.clear();
//		}
		
		// deep copy 
		// 원본과 복사본중 한쪽의 수정의 다른쪽에 영향을 안미친다. 
		destination.addAll(source);
		destination.add("d");
	
		
		/*==== source result ====
		 source size[+0+] :a
		 source size[+1+] :b
		 source size[+2+] :c
		==== destination result ====
		 destination size[+0+] :a
		 destination size[+1+] :b
		 destination size[+2+] :c
		 destination size[+3+] :d
		*/ 
		
		// shallow copy
		// 원본과 복사본중 한쪽의 수정의 다른쪽에 영향을 미친다. 
//		destination = source;
//		destination.add("d");
		
		
		// action code
		System.out.println("==== source result ====");
		for(int i = 0; i < source.size(); i ++) {
			System.out.println(" source size[+"+i+"+] :"+source.get(i));
		}
		
		System.out.println("==== destination result ====");
		for(int i = 0; i < destination.size(); i ++) {
			System.out.println(" destination size[+"+i+"+] :"+destination.get(i));
		}
		
	}
