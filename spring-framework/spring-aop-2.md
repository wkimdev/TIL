# 스프링 AOP
- 스프링 IoC 컨테이너가 제공하는 기반 시설과 Dynamic 프록시를 사용하여 여러 복잡한 문제 해결. 
## 동적 프록시
- 동적으로 프록시 객체 생성하는 방법  
  
## 스프링 IoC 
- 기존 빈을 대체하는 동적 프록시 빈을 만들어 등록 시켜준다.  
  


## 동적 프록시
- 동적으로 프록시를 생성하는 방법.
  - 자바가 제공하는 방법은 인터페이스기반 프록시 생성.
  - CGIB는 클래스기반 프록시도 지원. 

#### 현재설정 정보
- 패키지 각각
- aop
  - loggingAdvice
- intercepter 적용 
  - mapparam
  - payloadPrint
  - palytype


# 스프링 AOP : @aop
- 애노테이션 기반의 스프링 aop
  
- 의존성 추가 
  
```
spring-boot-starter-aop 
```
    
#### 애스팩트 정의
- @Aspect 
- 빈으로 등록해야 하기 때문에 (컴포넌트 스캔을 사용한다면) @Component도 추가. 
    
#### 포인트컷 정의
- @PointCut(표현식)
- 주요 표현식
  * execution
  * @annotation
  * bean
- 포인트컷 조합
  * &&, ||, !  

#### 어드바이스 정의
- @before
- @AfterReturning
- @AfterThrowing
- @Around  


### AOP 설정
- 표현식 예제
```java
<aop:config>
    <aop:pointcut id="allPointcut" expression="execution(* io.icednut.spring.exercise..*Impl.*(..))"/>
    <aop:aspect ref="log">
        <aop:before pointcut-ref="allPointcut" method="printLog"/>
    </aop:aspect>
</aop:config>
```
- allPointcut이라는 포인트컷은 io.icednut.spring.exercise 란는 패키지로 시작하는 클래스 중 Impl로 끝나는 클래스의 모든 메소드를 포인트컷으로 설정, 애스펙트 설정에서 app:before 엘리먼트의 **pointcut-ref** 속성으로 포인트컷을 참조.
- http://closer27.github.io/backend/2017/08/03/spring-aop/


  
# Reference
- 백기선의 스프링 강의 참고!! 
  
