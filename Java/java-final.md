## fianl?
- final 키워드는 엔티티를 한 번만 할당할 때 사용. 두번이상 할당할땐 컴파일 오류가 발생하여 확인 가능. 
- the final keyword is used in several contexts to define an entity that can only be assigned once.

#### 현재 코드에서 사용하는 부분은... 
- 이런식으로... 
```
public MenuResult getMenuList(final MenuRequest request, final boolean fromCache) {
		return mimsAdapterService.getMenuList(request);
}
```
     
## 그래서, 언제 사용하냐??  
- 개발 의도(변수, 함수, 클래스의 명시적 제한)
- 개발 의도는 반드시 본 변수, 함수, 클래스는 final로 제한되어야 함을 보여줍니다. 클래스와 메소드를 제한함으로써 Override로 인한 실수를 최소화 하고 버그를 줄이기 위해 선언합니다.
 
 
## final은 왜 쓸까?
- 결국 Java에서의 final은 Immutable/Read-only 속성을 선언하는 지시어입니다.
- 클래스, 함수, 변수가 변하지 못하도록 의도하고 싶다면 final로 선언하자.

## 출처
- https://blog.lulab.net/programming-java/java-final-when-should-i-use-it/#fn:3
