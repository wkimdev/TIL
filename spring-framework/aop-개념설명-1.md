## AOP
- 흩어진 관심사를 모으는 프로그래밍 기법. 
- 횡단 관심사.  
- 캐시, 트랜잭션 구현 가능. .!!.. 항상 캐시가 붙네.. 
- @cacheable를 프로젝트에서 사용하는 거랑, aop랑 연관이 있네~ 
- Aspect-oriendted programming(AOP)는 OOP를 보완하는 수단,흩어진 Aspect를 모듈화 할 수 있는 프로그래밍 기법
- 비즈니스 로직이 아닌, 시스템의 성능을 높일 수 있도록 보안이나 로깅같은 공통 관심사를 표현하는 것. 
  
![image](https://user-images.githubusercontent.com/32521173/62545822-624b7780-b89d-11e9-86c8-1369b96b3028.png)  
    
![image](https://user-images.githubusercontent.com/32521173/62545984-a5a5e600-b89d-11e9-8a21-8a6fcad0fa57.png)
  
  
# AOP 주요개념
- Aspect와 Target
- Advice
- Join point와 Pointcut
  
# AOP 구현체
- 여러 프로그래밍 언어에서의 aop구현.. (https://en.wikipedia.org/wiki/Aspect-oriented_programming)
- 자바
  * AspectJ (심화학습으로서 권장~)  
  * 스프링 AOP (수업) 
 
---
## aspect
- 모듈
#### advice
- 해야할 일들
#### point
- '어디에' 적용되는지
#### join point와 pointcut
- 가장 흔하게 사용하는 애는, **메서드 실행 시점**
- 메서드를 실행할때 끼워들 수 있는 지점. 
- a라는 클래스에 b라는 메서드를 호출할때 지정해라 -> 구체적인 subject -> pointcut
- 어떤 지점. 이라는 키워드로 생각하기. 
  
#### taget
- 적용대상, 클래스 a,b,c
  
  
## aop적용방법(각각의 concern들을 어떻게 모듈화 할 것이냐~)  
- 컴파일 (로드 타임 위버 설정~/성능상 문제 생길 수 있다는 단점... )   
- 로드타임  
- 런타임 (주로 spring aop사용 방법, 별도의 aop공부를 많이 할필요가 없다~ )   *현실적으로 가장 많이 쓰는 방법.  
   
     
--- 
    
# 스프링 AOP: proxy 기반 AOP   
## 스프링 AOP의 특징
  - proxy기반의 aop구현체
  - 스프링 빈에만 aop를 구현할 수 있다. 
  - 모든 aop 기능을 제공하는것이 목적이 아니라, 스프링 IoC와 연동하여 엔터프라이즈 어플리케이션에서 가장 흔한 문제를 해결하는것이 목적. 
  
## proxy패턴   
- a라는 타입의 proxy bean을 만든다.  
- 이 proxy빈이 실제 a가 가지고 있는 foo라는 메서드 호출 직전 hello를 찍고, 그 다음 a를 호출한다.  

#### proxy패턴 문제점
- 매번 프록시 클래스를 작성해야함?
- 여러 클래스 메소드에 적용해야함?
- 객체를 관계도 복잡시러워 지고... 
==> 그래서 등장하게 된게 스프링 AOP!! 
  
- 이어서 계속.. 
  
## error message
- java.lang.IllegalArgumentException: Can not set com.wkimdev.board.member.service.MemberService field com.wkimdev.board.member.controller.MemberController.memberSerive to com.sun.proxy.$Proxy2

#### reference 
- https://loveiskey.tistory.com/116
- 백기선 스프링 강의 
