public class Java8Test {

	// concat, reduce
	
	/*이 예제-주도 튜토리얼은 Java 8 스트림에 대한 상세한 개요를 제공한다. 
	맨 처음 Stream API에 대해서 읽을 때, 난 JAVA I/O의 InputStream과 OutputStream과 비슷하게 들리는 이름 때문에 헷갈려했다. 
	하지만 Java 8 스트림은 완전 다른 것이다. 
	스트림은 Monads, 즉 Java에 함수형 프로그래밍을 가져오는 데 큰 부분을 맡는다.*/
	
	@Test
	public void grammerTest() {
		// 스트림은 원소들의 순열을 나타내고 , 
		// 이런 원소들에 대한 계산을 수행하기 위한 여러 종류의 연산을 지원한다. 
		List<String> myList = Arrays.asList("a1", "a2", "B1", "c2", "c1","B2","B3");
		
	    List<String> myList2 = Arrays.asList("a1", "a2", "b1");
	    //System.out.println(myList2);
		
	  //test1
	    //myList.stream().filter(s -> s.startsWith("B")).map(String::toLowerCase).sorted().forEach(System.out::println);
	    
	    myList.stream().filter(s -> s.startsWith("B")).map(String::toLowerCase).forEach(System.out::println);
	    
//		myList
//		    .stream()
//		    .filter(s -> s.startsWith("c"))
//		    .map(String::toUpperCase)
//		    .sorted()
//		    .forEach(System.out::println);
		
	  //test2
	    Stream.of("a14", "a2", "a3", "a5", "a11").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
//		Stream.of("a1", "a2", "a3") //이러한 스트림 연산의 연결을 연산 파이프라인이라고 부른다.
//	    .map(s -> s.substring(1))
//	    .mapToInt(Integer::parseInt)
//	    .max()
//	    .ifPresent(System.out::println);
		
	}
	
	//@Test
	public void test2() {
		//.map
		//.reduce...
		// 리덕션 연산.
		// Stream.reduce()
		// 스트림의 요소들을 다른 방법으로 결합하고 싶은 경우는 reduce 메서드들 중 하나를 사용하면 된다.
		 int[] array = {23,43,56,97,32};
	   	 Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s)); //이 안에 foreach가 있고, 끝날때는 isparallel 
	   	 Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
	   	 //Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));
	}
	
	
	//@Test
	public void testConcat() {
		// 두 스트림을 연결하여 새로운 스트림을 반환(Merging Two Streams)
		//Stream<String> concatStream = Stream.concat(stream1, stream2);
//		Stream<Integer> stream1 = Stream.of(1,3,5);
//		Stream<Integer> stream2 = Stream.of(2,4,6);
//		
//		Stream<Integer> resultStream = Stream.concat(stream1, stream2);
//		
//		//System.out.println(resultStream); //java.util.stream.ReferencePipeline$Head@545b5ed0
//		System.out.println(resultStream.collect(Collectors.toList())); //[1, 3, 5, 2, 4, 6]
		
//		assertEquals(
//				Arrays.asList(1,3,5,2,4,6),
//				resultStream.collect(Collectors.toList()));
		
		Stream<String> stream3 = Stream.of("test1", "test2", "test3");
		Stream<String> stream4 = Stream.of("test5", "test6");
		
		Stream<String> resultSteram = Stream.concat(stream3, stream4);
		System.out.println(resultSteram.collect(Collectors.toList()));
		
	}
	
	//@Test
	public void testStringJoin() {
		List<String> strings = new LinkedList<>();
		strings.add("Java");
		strings.add("is");
		strings.add("Cool");

		String message = String.join(" " , strings);
		System.out.println(message); // Java is Cool
	}
	
	//@Test
	public void test () {
	
	// transaction in
		
	// 스트링을 조회해서 같은 값이 있다면 값은 키값으로 배열로 반환한다.
    // eg. [test0=[test0], test1=[test1], test2=[test2, test2] ........
//    Map<String, List<String>> convertMap  = txIns.stream()
//                                                 .map(mapper -> mapper.getTxOutHash() + mapper.getTxOutIndex())
//                                                 .collect(Collectors.groupingBy(string -> string));
//    // 위의 convertMap에서 items.getValue가 1보다 큰 경우 예를 들면 test2=[test2, test2]같은 녀석이 있다면 true로 반환할 것이고 없다면 false
//    return convertMap.entrySet().stream()
//                                .filter(items -> items.getValue().size() > 1 )
//                                .findAny()
//                                .map(item ->  true)
//                                .orElse(false);
		
		// 스트링을 조회해서 같은 값이 있다면 값은 키값 배열로 반환한다. 
//		List<String> a = Stream.of("test1", "test3", "test4", "test5", "test6", "test9").collect(Collectors.toList());
//        Map<String, List<String>> r  = a.stream().collect(Collectors.groupingBy(str -> str));
//        System.out.println(r);
		
		// 위의 a에서 items.getValue()가 1보다 큰 경우가 있다면 true반환, 없다면 false
        // 중복되는게 있을 경우 true를 반환, 
        // 없으면 false
//        boolean ab = r.entrySet().stream().filter(items -> items.getValue().size() > 1 )
//                                            .findAny()
//                                            .map(item ->  true)
//                                            .orElse(false);
//        System.out.println(ab);
		
		// collect는 Collectors를 매개변수로 하는 스트림 최종 연산.
		List<String> a = Stream.of("star1", "star2", "star3", "star2", "star4", "star3").collect(Collectors.toList());
		Map<String, List<String>> r = a.stream().collect(Collectors.groupingBy(str -> str));
		System.out.println(r);
		
		// 중복체크 
		// items.getValue() 가 아마... ===> {star1=[star1], star4=[star4], star2=[star2, star2], star3=[star3, star3]}
		boolean ab = r.entrySet().stream().filter(items -> items.getValue().size() > 1).findAny().map(item -> true).orElse(false);
		System.out.println(ab);
        
	}
	
	//@Test
	public void testBox() {
		
		/*
		 .boxed()와 
		 IntStream
		 기본 스트림을 변환하려면 먼저 래퍼 클래스의 요소를 상자에 넣은 다음 수집해야합니다.
		 이 유형의 스트림을 박스형 스트림이라고합니다.
		*/
		
		// transaction pool store에 존재한다. 
		// TRANSACTIONPOOL_STORE.clear();
//		Map<Integer, Transaction> changedMap = IntStream.range(0, transactionList.size())
//														.boxed()
//														.collect(Collectors.toMap(index -> index, index -> transactionList.get(index)));
//		
		// TRANSACTIONPOOL_STORE.putAll(changedMap);
		
		
		List<Integer> inits = IntStream.of(0,5,6,7,8,9,1).boxed().collect(Collectors.toList());
		//System.out.println(inits);
		
		// object type
		Map<Integer, Object> map = IntStream.range(0, inits.size()).boxed()
										  .collect(Collectors.toMap(index -> index, index -> inits.get(index)));
		
		System.out.println(map);
	}
	
	//@Test
	public void testConcurrentHashMap() {
		
		Map<Integer, Object> map = new ConcurrentHashMap<>();
		map.put(1, "name");
		map.put(2, "gender");
		map.put(3, "companyName");
		
		List<Integer> inits = IntStream.of(0,5,6,7,8,9,1).boxed().collect(Collectors.toList());
		
		//System.out.println(map.values()); //[name, gender, companyName] 
		map.clear();
		System.out.println("after clear map >>>> "+map.values()); //[]
		
		// 기존 map의 stream 형을 바꾸는 작업.
		Map<Integer, Object> changedMap = IntStream.range(0, inits.size()).boxed()
								.collect(Collectors.toMap(index -> index, index -> inits.get(index)));
		
		map.putAll(changedMap);
		System.out.println("after chaned map >>>> "+map);
	}
	
	
}
