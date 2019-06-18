## junit-logback-설정법
#### task
- junit을 돌릴때 logback에 설정한 경로에 로그 파일을 기록해야 한다. 

#### 상황 
- 현재 logback-dev.xml에 junit관련   
- `<property name="LOG_DIR_JUNIT" value="/logs/uplus/junitlog" />`  설정  
- appender설정 
```  
<!-- junit 로그 -->
	<appender name="JUNIT_PAYLOAD_PRINTER_LOG_FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
		<file>${LOG_DIR_JUNIT}/junit.log</file>
		<rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
			<fileNamePattern>${LOG_DIR}/log_backup/junit.%d{yyyyMMdd}.%i.log</fileNamePattern>
			<maxFileSize>500MB</maxFileSize>
		</rollingPolicy>
		<encoder>
			<pattern>${SERVICE_LOG_PATTERN}</pattern>
		</encoder>
	</appender>
```  
  
- Logger 설정  
<!-- junit appender -->
```
<logger name="com.blah.Test" level="DEBUG" additivity="false">
  <appender-ref ref="JUNIT_PAYLOAD_PRINTER_LOG_FILE"/>
</logger>
``` 
- 을 진행하였으나 run junit을 하여도 아무 로그파일이 남지 않는다.. 

## output file에 로그를 기록하는 방법  
- 1. xml 설정 ? 잘 안되는 중 
- 2. eclipse에서 run configuration -> common --> outputfile 설정 시도 


  
# 용어
#### Appender 
- 로그를 출력 할 위치, 출력 형식 등을 설정.
  
#### FileAppender
– 로그의 내용을 지정된 File에 기록합니다.

#### RollingFileAppender  
– FileAppender로 부터 상속받은 Appender로 날짜, 최대 용량 등을 설정하여 지정한 파일명 패턴에 따라 로그가 다른 파일에 기록.
- 이를 이용하여 대량의 로그를 효과적으로 기록.  
- Appender들의 하위 항목으로 출력 형식(Layout Pattern)을 지정하여 각 Appender마다 원하는 내용을 출력시킬 수 있다.   
      
#### Logger
- 실제 로그 기능을 수행하는 객체로 각 Logger마다 Name을 부여하여 사용
- 각 Logger 마다 원하는 출력 레벨값을 설정할 수 있으며, 0개 이상의 Appender를 지정할 수 있습니다.
- 각 소스로부터 입력받은 로깅 메시지는 로그 레벨에 따라 Appender로 전달 됩니다.   
  

 
#### level
- `error > warn > info > debug > trace`

## 참고
- https://thinkwarelab.wordpress.com/2016/11/18/java%EC%97%90%EC%84%9C-logback%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%A1%9C%EA%B9%85logging-%EC%82%AC%EC%9A%A9%EB%B2%95/
- https://mainia.tistory.com/693 흠...  
- 메뉴얼 : https://logback.qos.ch/manual/index.html  
