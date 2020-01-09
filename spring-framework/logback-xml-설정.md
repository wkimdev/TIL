## slf4j
- slf4j-log4j 모듈은 slf4j에 전달된 로그를 Log4j를 이용해서 남길때 사용하는 모듈.  
- 위의 의존설정을 사용하면 스프링이 발생하는 로그는 slf4j를 거쳐 log4j를 통해 기록하게 된다.  
- 예전에는 스프링에서 로그를 남길 때 Log4J를 사용했었는데, 성능 및 기능상의 이유로 대체 logger들이 많아졌고, 현재 대부분은 SLF4J 인터페이스를 구현한 Logback을 사용
- Spring이 기존에 사용하던 로그 라이브러리 JCL 대신, 새로운 라이브러리 Logback을 사용하도록 하기 위해서는 SLF4J가 필요
- SLF4J는 JCL과 Log4J의 징검다리 역할
  
## logback.xml
- 로그파일이 쌓이는 path 지정 
```
<property name="LOG_DIR" value="/logs/wkimdev/was/tomcat" />
<property name="LOG_DIR_TLO" value="/logs/wkimdev/was/tomcat/tlolog" />
```
  
-  어느 패키지 또는 클래스에 대해서 로그를 남길 것인지, 어느 정도 수준에 대해서 로그를 남글 것인지도 설정  
   
```
	<!-- com.wkimdev.music 아래 패키지 로그들만 consoleAppender, fileAppender 방법으로 로그를 
		남긴다. -->
	<logger name="com.wkimdev.music" level="info" additivity="false">
		<appender-ref ref="fileAppender" />
	</logger>

	<!-- root는 글로벌 로거를 의미하며, 위의 logger에 해당하지 않으면 root 로거가 실행된다. -->
	<root level="warn">
		<appender-ref ref="consoleAppender" />
	</root>
  
```

## 시간별로 로그 파일 쌓기
- 시간별로 로그를 쌓을시 설정 

  
- 남에게 알려줄 수 있을정도까지 졸꾸!!

## reference
- 최범균 스프링 4.0
- https://victorydntmd.tistory.com/173 
  
