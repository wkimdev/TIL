## 자바의 마커 인터페이스
- 소스코드에 interface만 뚱 하니 있는 녀석들이 있다.. 
- 무슨 기능을 하길래 이러고 있지?..
- 알고보니 마커 인터페이스 같음. 뭔지 알아보쟈. 


#### 의미
- 자바의 마커 인터페이스란 일반적인 인터페이스와 동일하지만 사실상 아무 메서드도 선언하지 않은 그런 인터페이스를 말한다. 예를들어 다음과 같다.
```
public interface SomeObject {
}
```
- 자바의 대표적인 마커 인터페이스로는 우리가 흔히 아는 `Serializable, Cloneable` 와 흔히 알지는 못하지만 Spring에서 event리스너를 사용한다면 종종 보이는  `EventListener` 라는 인터페이스도 있다.  

#### 왜 존재하는가?
- 대부분의 경우에는 단순한 타입체크 (모든 경우 x)
- 자바의 대표적인 마커 인터페이스인 Serializable  
-. Serializable 인터페이스 같은 경우에는 직렬화를 할 수 있다는 뜻이다. 만약 이 인터페이스를 구현(?) 하지 않은 클래스 경우에는 직렬화를 하지 못한다.
  
```
public interface Serializable {
}
```
  

  

  


## reference
- http://wonwoo.ml/index.php/post/1389

