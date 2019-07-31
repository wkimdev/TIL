## AOP
- 횡단 관심사. 
- 비즈니스 로직이 아닌, 시스템의 성능을 높일 수 있도록 보안이나 로깅같은 공통 관심사를 표현하는 것. 
  
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

  
## error message
- java.lang.IllegalArgumentException: Can not set com.wkimdev.board.member.service.MemberService field com.wkimdev.board.member.controller.MemberController.memberSerive to com.sun.proxy.$Proxy2

#### reference 
- https://loveiskey.tistory.com/116
