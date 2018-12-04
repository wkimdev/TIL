## Producing a Stream of Data
- 응용 프로그램을 반응 적으로 처리하려면 먼저 데이터 스트림을 생성해야합니다. 
- In order for an application to be reactive, the first thing it must be able to do is to produce a stream of data. 
- 이것은 우리가 이전에 준 재고 업데이트 예제와 같을 수 있습니다. 
- Without this data, we wouldn’t have anything to react to, which is why this is a logical first step. 
- Reactive Core는이 작업을 수행 할 수있는 두 가지 데이터 유형을 제공합니다.


#### 1. Flux

#### 2. Mono
- mono는 한건의 데이터를 처리하는데 사용됨. cf) flux --> 여러 element를 처리한다. 
- flux는 iterable한 데이터들을 mono로 바꿔서 나누고 합침으로 해서 subscriber에게 전달합니다. 즉 mono가 뭉치면 flux 라고 생각....일단은.
- 현재 프로젝트에서 아래와 같이 실행 중
- `Mono<String> just = Mono.just("foo");`
- just() 메서드는 이미 존재하는 값을 사용해서 Flux/Mono를 생성할 때 사용된다. (just의 리턴타입이 mono이다)
- Create a new Mono that emits the specified item, which is captured at instantiation time.



## reference
- https://www.baeldung.com/reactor-core
- (설명좋다!!) https://ahea.wordpress.com/2017/02/15/spring-reactive/
- 
