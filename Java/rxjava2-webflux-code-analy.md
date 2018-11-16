
## issue?
- rxjava2jdbc에서, 객체 자체를 interface로 지정된 VO로 매핑이 안됨...read-only 속성에 대한 개념이 들어간거 같은데,
외부에서 객체단위로 매핑하기 위해서는 DTO개념으로 똑같은걸 만들어줘야 하는건가?

- *DTO : data transfer object, 그냥 담는 역할만 한다.  
- interface로 dto를 처리.
- dto : get,set 값을 가지고 있고, 
- TransferHistory는 interface 

## Setup 
- Java 9
- Spring Boot 2.0.0
- Reactive Web
- domain objects.
- A data repository.
- A handler (read: service).
- A router.

#### 히카리?!
- maxpoolsize는 히카를 쓰고 있고 
- poolsize number는 어떻게 지정하는건지.
- https://github.com/brettwooldridge/HikariCP


#### webflux?
- web-flux는 server, client side 에서 reactive 스타일의 application 개발을 도와주는 모듈

### functional programming model
- functional programming model은 HandlerFunction 과 RouterFunction 나누어 구현합니다.
- 현재 프로젝트는 controller가 아닌, handler 패키지를 두어 transfer action을 수행한다. 
- 그리고 webfluxrouter에서 router를 두어 serverresponse를 수행하고 있다.
- 이게 functional programming?!!!


#### @JsonPropertyOrder
- 오브젝트 프로퍼티를 직렬화 할 경우에 사용하는 순서 부를 정의하기 위해서 사용할 수있는 주석.

#### @JsonTypeInfo
- 

#### @Data
- 

#### @JsonDeserialize(as = ClassName.class)
- 

- (https://blog.lulab.net/java-library-jackson/)

#### DatabaseConfig 
- database = Database.nonBlocking()
- 애초에 비동기설정. 이게 있기 때문에 비동기가 되고 -> 카우치 디비처럼 비동기처럼 처리가 됨.
- 없으면 일반 rdb랑 비슷함.

#### 여기서 block 처리 가능하지만 error 가 난다. 
- Mono<Integer> result = request.bodyToMono(TransferHistory.class).flatMap(mapper -> transferHistoryService.insertTransferHistory(mapper));
- 

#### 아래에서 throw new 하지 않으면 디비정보가 다 리턴되버리기 때문에 에러 처리 해놔야함.
.doOnError(throwable -> {
          throw new RuntimeException("unexcepted");
      });
    
#### Flowable 때문에 
- 비동기, reactive 라고 볼 수 있음.


## 소스구조
src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── doublechain
│   │   │           ├── RxJavaServiceApplication.java
│   │   │           ├── config
│   │   │           │   ├── DatabaseConfig.java (비동기 rxjava-jdbc config)
│   │   │           │   └── WebFluxRouter.java (server response config)
│   │   │           ├── service
│   │   │           │   └── transfer
│   │   │           │       ├── TransferHistoryService.java
│   │   │           │       ├── domain
│   │   │           │       │   ├── BlockHistory.java
│   │   │           │       │   ├── BlockHistoryDTO.java
│   │   │           │       │   ├── TransferHistory.java
│   │   │           │       │   └── TransferHistoryDTO.java
│   │   │           │       └── handler
│   │   │           │           └── TransferHistoryHandler.java
│   │   │           └── util
│   │   │               └── CommonUtil.java
│   │   └── resources
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── doublechain
│                   └── test
│                       └── ServiceTest.java    


## Reference
- https://dzone.com/articles/spring-webflux-a-basic-crud-application-part-1

