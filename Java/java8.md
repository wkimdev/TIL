## java 8

#### ::
- calling a specific method – by name. 


#### stream 문법
- 맨 처음 Stream API에 대해서 읽을 때, 난 JAVA I/O의 InputStream과 OutputStream과 비슷하게 들리는 이름 때문에 헷갈려했다. 
-	하지만 Java 8 스트림은 완전 다른 것이다. 
-	스트림은 Monads, 즉 Java에 함수형 프로그래밍을 가져오는 데 큰 부분을 맡는다.!!!!

```
	//@Test
	public void grammerTest() {
		// 스트림은 원소들의 순열을 나타내고 , 
		// 이런 원소들에 대한 계산을 수행하기 위한 여러 종류의 연산을 지원한다. 
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		
		//test1
//		myList
//		    .stream()
//		    .filter(s -> s.startsWith("c"))
//		    .map(String::toUpperCase)
//		    .sorted()
//		    .forEach(System.out::println);
		
		//test2
		Stream.of("a1", "a2", "a3") //이러한 스트림 연산의 연결을 연산 파이프라인이라고 부른다.
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);
		
	}
	
	@Test
	public void test2() {
		//.map
		//.reduce...
		// 리덕션 연산.
		// Stream.reduce()
		// 스트림의 요소들을 다른 방법으로 결합하고 싶은 경우는 reduce 메서드들 중 하나를 사용하면 된다.
		 int[] array = {23,43,56,97,32};
	   	 //Arrays.stream(array).reduce((x,y) -> x+y).ifPresent(s -> System.out.println(s)); //이 안에 foreach가 있고, 끝날때는 isparallel 
	   	 //Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
	   	 Arrays.stream(array).reduce(StatisticsUtility::addIntData).ifPresent(s -> System.out.println(s));
	}

```


#### reference 
- https://wraithkim.wordpress.com/2017/04/13/java-8-%EC%8A%A4%ED%8A%B8%EB%A6%BC-%ED%8A%9C%ED%86%A0%EB%A6%AC%EC%96%BC/
