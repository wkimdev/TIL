- batch소스코드의 아래 키워드들에 대해 고민을 해보자. 왜 사용하는 것인지.. 
  
## volatile  
  
```
volatile 키워드를 사용하면 다음의 의미를 갖는다.
1. 인스턴스의 변수의 값은 로컬 쓰레드 내에 캐쉬 되지 않아야 한다.
2. 항상 메인 메모리에서 값을 읽거나 써야 한다.
3. 인스턴스 변수가 여러 쓰레드에 의해서 변경될 수 있음을 컴파일러에게 알려준다.
4. 암시적으로 인스턴스 변수가 synchronized 블럭에 감싸진 것 처럼 동작한다. 
``` 
  
  
## ReentrantLock 
- 동기화의 시작점 끝점을 수동으로 설정가능하게 해줌?
- 명시적 동기화 
- https://eskeptor.tistory.com/83
