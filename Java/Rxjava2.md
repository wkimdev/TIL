## RxJava2
- reactive programming을 하기 위한 라이브러리인 Rx(reactive extensions)의 JVM판.
- reactive streams는 java 8+에 친화적
- 이벤트를 정의한 'Observable' 인스턴스에 대해 짧은 함수를 엮은(체인) 스트림같이 이벤트 결과 데이터를 가공하는 처리를 정의, 지연실행, 비동기 콜백을 할수있습니다.


## why??
- 리액프 프로그래밍이 필요해진 배경
- https://blog.redelastic.com/what-is-reactive-programming-bc9fa7f4a7fc
- 하드웨어, 인터넷의 발전때문.
- 1999년 2억 8천만명의 인터넷 사용자, 온라인 뱅킹 초기 단계   
- --> 2005년 10억명의 인터넷 사용자. 550만명 페이스북 사용자, 유투브 신생사(2005년 2월), 트위터 2006년, netflix는 아직 비디오 스트리밍 도입 하지 않을 시기...
- --> 2014년 페이스북 **13억 사용자, 트위터 2억 7천만 사용자 .**
- 많은 양의 트래픽을 처리할 수 있도록 인터넷이 발전할 수 밖에 없었음.
 
## reactive한 프로그래밍의 특징?(의역, 다시 쓰기)
- responsive
- resilient
- scalable
- message-driven (비동기적)
- 리액티브 선언문 : https://www.reactivemanifesto.org/ko
- 리액티브 좋은 슬라이드  :http://mobicon.tistory.com/467
- 옵져버블 좋은 슬라이드 --> 
- https://www.slideshare.net/ssusercaf078?utm_campaign=profiletracking&utm_medium=sssite&utm_source=ssslideview

## web-flux
- spring webflux는 비동기-논블록킹 리액티브 개발을 할 수 있다. 
- spring framework 5의 webflux에 대한 좋은글..
- https://hyungjoon6876.github.io/jlog/2018/07/12/spring5-webflux-start.html


## Observable
- Observable = reactive stream.  
- 비동기 방식으로 전달되는 데이터 추상화.
- 옵저버블, 옵설버블 등으로 읽는다. RxJava뿐만 아니라 리액티브 프로그래밍의 기본적인 모델이다. 
- 일단 여기(Observable)에 넣고 처리한다고 생각 하면 된다. 
- 마치 스프링이 일단은 ApplicationContext에 모든 빈을 넣고 시작하는것과 비슷하다고 보면 된다.
- 데이터 흐름에 맞게 알림을 보내 구독자가 데이터를 처리 할 수 있도록 한다.
- RxJava2.x에서는 Observable, Single, Maybe, Flowable로 클래스를 구분
- Maybe클래스는 reduce()함수나 firstElement()함수와 같이 데이터가 발행 될 수 있거나 혹은 발행되지 않고도 완료되는 경우를 의미
- 교실에서 떠든다. 선생님이 온다. 선생님이 오는걸 말해주는 사람이 필요하다/
- Observable은 주로 푸시(배출)를 기반으로 하는 성격을 지닌다.


- 소켓이랑 뭐가 다른거지??? ..
- https://stackoverflow.com/questions/29390172/whats-difference-between-a-callback-and-observer-pattern-in-java
- https://stackoverflow.com/questions/36213948/what-is-the-difference-between-asynchronous-calls-and-callbacks

## Observer Design pattern   
- ![imagme]
  
## 옵서버 패턴(observer pattern)  
- 한 객체의 상태가 바뀌면, 그 객체를 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식.
- 일대다(one-to-many) 의존성을 정의한다. 
- 객체의 상태 변화를 관찰하는 관찰자들, 즉 옵저버들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드 등을 통해 객체가 직접 목록의 각 옵저버에게 통지하도록 하는 디자인 패턴이다. 주로 분산 이벤트 핸들링 시스템을 구현하는 데 사용된다. 발행/구독 모델로 알려져 있기도 하다.
- 데이터 전달방식은 2가지가 있다.    
  
>  1. 주제객체에서 옵저버로 데이터를 보내는 방식(푸시 방식)  
>  2. 옵저버에서 주제객체의 데이터를 가져가는 방식 (풀 방식)

- http://hyeonstorage.tistory.com/165

## Flowable
- Flowable은 Observable과 거의 비슷한데 다른 점이 back pressure이 지원된다는 점이다. 
- back pressure이란 데이터의 처리 순서를 보장해주는 로직이다. 
- Observable은 back pressure가 보장되지 않아 아이템이 순서대로 발행된다고 보장되지 않는다. 
- 하지만 Flowable은 보장된다. 따라서 Observable 보단 Flowable을 사용하는 걸 권장한다. 
- Flowable클래스는 Observable에서 데이터가 발행되는 속도가 구독자가 처리하는 속도보다 현저하게 빠른 경우 배압이슈(back pressure)에 대응하는 기능을 추가로 제공한다.
- 간단하게 말해서, 배압(Back pressure)를 해결 하기 위해 flowable(RxJava2부터 도입)을 했다. 
- Reactive-Streams Pattern을 구현하고, 팩토리 메소드, 중개 연산자 및 반응적인 데이터 플로우를 사용할 수있는 기능을 제공하는클래스
- Reactive-Streams는 Flowable이 확장 된 Publishers와 함께 작동합니다. 
- 따라서 많은 운영자가 일반 게시자를 직접 수용하고 다른 Reactive-Streams 구현과 직접 상호 운용 할 수 있습니다.
- Flowable은 시스템 매개 변수 rx2.buffer-size를 통해 전역 적으로 재정의 될 수있는 bufferSize ()를 통해 액세스 할 수있는 연산자에 대한 128 개 요소의 기본 버퍼 크기를 호스팅합니다. 
- 그러나 대부분의 연산자에는 내부 버퍼 크기를 명시 적으로 설정할 수있는 오버로드가 있습니다.

- flowable  --> backpressure --> producer (1초당 1000항목을 생성, 초당 100항목을 처리할 수 있는 )
- Observable produces 1_000_000 items per second how a subscriber which can handle only 100 items per second does process the items? 
- 초당 1000개 항목을 생성(produce), subscribe는 초당 100개 밖에 처리할 수 없음. 이것에 대해?
- 출처[]
- https://proandroiddev.com/rxjava-backpressure-and-why-you-should-care-369c5242c9e6

## backpressure??
- https://proandroiddev.com/rxjava-backpressure-and-why-you-should-care-369c5242c9e6
- http://eyeahs.github.io/rxjava/blog/2016/10/11/rxjava-wiki-backpressure/
- http://javaexpert.tistory.com/811?category=678737


## subscribe()
- .subscribe()에 실행할 메소드를 넣어주면 된다. 
- 엄밀히 말하면 Consumer(컨슈머)라고 파라메터(parameter)가 한개인 void method이다.  
  
```
Observable.just("hello", "rxjava2!!")
.subscribe(System.out::println);

// .from()
Observable<String> source = Observable.just("singleFromObservable");
Single.fromObservable(source).subscribe(System.out::println);

```
  
## Single  
- 데이터를 1개만 발행할 수 있는 클래스가 Single이다.
- Single은 class는 결과가 한개인 것을 엄격하게 통제 해야 할 때 사용한다.
- 아래코드는 이런 에러 발생시킴 ==> `Caused by: java.lang.IllegalArgumentException: Sequence contains more than one element!`
  
```  
Observable<String> source2 = Observable.just("singleFromObservable", "hello");
Single.fromObservable(source2).subscribe(System.out::println);  

```

## .doOnComplete()
- doOnComplete()는 Flowable, Observable등에서 모든 item을 발행 하고 나면 한번만 실행 된다.
- 주로 끝났는지 여부를 로그를 찍기 위해 사용한다. 그래서 .doOnComplete(Action)은 파라메터로 Action을 받는다.
- doOnNext등 다른 메소드 들은 주로 Consumer를 받는 것과는 조금 다르다.
- Action은 () -> {} 이렇게 아무런 파라메터가 들어오지 않는 인터페이스이다.
-  .doOnComplete()로 세가지를 알 수 있다.
- 1. 끝까지 잘 실행이 되었는지 
- 2. 시작을 하지 않았는지 
- 3. 중간에 에러가 났는지

## autoMap
- ResultSet 열을 할당 할 수있는 생성자 매개 변수로 자동 매핑하여 ResultSet의 각 행을 T의 인스턴스로 변환합니다. 
- 일반적인 할당 가능한 기준 (예 : Integer 123이 Double에 할당 가능) 이외에도 다른 변환이 존재하여 자동 매핑을 용이하게합니다.

```
Flowable<TransferHistory> flowable = database.select("SELECT * FROM TABLES WHERE ~ ")
                  .parameter(params)
                  .autoMap(TransferHistory.class);
```

## Webflux(Spring WebFlux)
- 큰 도움 받은 블로그  ==> https://hyungjoon6876.github.io/jlog/2018/07/12/spring5-webflux-start.html
- spring webflux는 비동기-논블록킹 리엑티브 개발을 할 수 있다. 
- **효율적으로 동작하는 고성능 웹 어플리케이션을 개발할 수 있는 서비스간 호출이 많은 마이크로서비스 아키텍처에 적합한 프레임워크**
- Undertow
- serverResponse, serverReqeuest에 대한 키워드도 webflux와 연관...
- spring webflux 예제 ==> 아래 글 필히 읽어볼 것!!
- http://hojak99.tistory.com/463  
- 아래는 reactive system에 대한 글.(정리하는데 목차 도움받기!)
- http://hojak99.tistory.com/453 

## mock test란 무엇인가? 왜 이렇게 부르지??
- https://medium.com/@SlackBeck/mock-object%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80-85159754b2ac
- http://hyper-cube.io/2017/08/06/spring-boot-test-1/
- http://egloos.zum.com/kingori/v/4169398


## 히카리디비 커넥션풀 ??
- 도큐먼트 서칭해봄 : 
- (스프링 HikariCP (커넥션풀) 적용 ) https://gs.saro.me/dev?page=10&tn=450
- http://jeong-pro.tistory.com/162
- 고민해본 문제.. ==> [Thinking behind decision of database connection pool size](https://stackoverflow.com/questions/8753442/thinking-behind-decision-of-database-connection-pool-size)


- fka

## spring webflu toy proejct 기반!!!
- [Spring Webflux: A Basic CRUD Application (Part 1)](https://dzone.com/articles/spring-webflux-a-basic-crud-application-part-1)



#### 출처
- http://reactivex.io/
- http://krksap.tistory.com/1189
- [[RxJava2] 배압(Backpressure) 이란 무엇인가.](http://javaexpert.tistory.com/809)
- 영문글(webflux와 rxjava2-jdbc 설명) https://medium.com/netifi/spring-webflux-and-rxjava2-jdbc-83a94e71ba04
- [Java 9의 새로운 기능 : 리 액티브 스트림](https://aboullaite.me/java-9-new-features-reactive-streams/)
- https://dzone.com/articles/5-things-to-know-about-reactive-programming
- https://medium.com/@ggikko/rxjava-2-x-%EC%97%90-%EB%8C%80%ED%95%9C-%EC%83%9D%EA%B0%81-e11c7ca008d1
- flowable과 observable의 차이https://01010011.blog/2017/03/29/rxjava-flowable-%EA%B3%BC-observable-%EC%9D%98-%EC%B0%A8%EC%9D%B4/

## notice
- 멈추지 않고 기다리기(Non-blocking)와 비동기(Asynchronous) 그리고 동시성(Concurrency)(https://tech.peoplefund.co.kr/2017/08/02/non-blocking-asynchronous-concurrency.html)
- observable 알고가기 (http://jepark-diary.tistory.com/49)
- [네트워크] 블로킹과 논블로킹 메커니즘(https://12bme.tistory.com/231)
- [스레드풀!! 왜 쓰냐] (http://limkydev.tistory.com/55)
- 프로듀서-컨슈머 패턴 (http://byplacebo.tistory.com/18)
- 핫 , 콜드.. http://javaexpert.tistory.com/794?category=678737
- (Java-NIO는-생각만큼-non-blocking-하지-않다/)https://homoefficio.github.io/2016/08/06/Java-NIO%EB%8A%94-%EC%83%9D%EA%B0%81%EB%A7%8C%ED%81%BC-non-blocking-%ED%95%98%EC%A7%80-%EC%95%8A%EB%8B%A4/
- 스레드때문에 찾아봤던 --> http://mygumi.tistory.com/154 (노드.js와 자바의 차이)

