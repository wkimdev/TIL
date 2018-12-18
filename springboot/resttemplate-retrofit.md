## spring resttemplate
- rest client
- RestTemplate을 사용하여 Spring 안에서 GET, POST, PUT, PATCH, DELETE REST 요청을 처리
- retrofit 보다 좀더 복잡하고 (불안정한 측면?이 있다??--> 이건 잘 모르겠다. )
- http://blog.saltfactory.net/using-resttemplate-in-spring/

  
## Retrofit
- rest client
- 구조화된 인터페이스
- 많이 쓰는 방식 rest template보다 더 정리/간결되어 있음
- http://jsonobject.tistory.com/413



config --> client 기능
기존 방식이면 api 가 바뀌면 리턴타입이 다 바뀌어야 하는데, 지금 방식은 @api("") 이것만 바꾸면 된다
기존 dexko 에서 처리하던 resttemplate 보다 --> 복잡하던 sprign rest template 방식을 rest retro로 바꿀 수 있다. 
etherscan api 여기서도 확인 가능
고민점 : msa 처럼, 서버간 통신을 할때 어떻게 할 것인가??

