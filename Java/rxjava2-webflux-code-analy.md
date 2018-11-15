
## issue?
- rxjava2jdbc에서, 객체 자체를 interface로 지정된 VO로 매핑이 안됨...read-only 속성에 대한 개념이 들어간거 같은데,
외부에서 객체단위로 매핑하기 위해서는 DTO개념으로 똑같은걸 만들어줘야 하는건가?

- *DTO : data transfer object, 그냥 담는 역할만 한다.  
- interface로 dto를 처리.
- dto : get,set 값을 가지고 있고, 
- TransferHistory는 interface 

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
- 이런 설정이 있었음.
- database = Database.nonBlocking()
- 이게 있기 때문에 비동기가 되고 -> 카우치 디비처럼 비동기처럼 처리가 됨.
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

    
