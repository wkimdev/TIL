## slf4j
- slf4j-log4j 모듈은 slf4j에 전달된 로그를 Log4j를 이용해서 남길때 사용하는 모듈.  
- 위의 의존설정을 사용하면 스프링이 발생하는 로그는 slf4j를 거쳐 log4j를 통해 기록하게 된다.  
  
## logback.xml
- 로그파일이 쌓이는 path 지정 
```
<property name="LOG_DIR" value="/logs/wkimdev/was/tomcat" />
<property name="LOG_DIR_TLO" value="/logs/wkimdev/was/tomcat/tlolog" />
```
  
  
- 아래 설정은 차차 알아보자..
  
- 남에게 알려줄 수 있을정도까지 졸꾸!!

## reference
- 최범균 스프링 4.0

  
