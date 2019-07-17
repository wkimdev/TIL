## 외부 서버와의 active profile별 설정 
- 자주 실수하는 부분이다. 
- 왜 연결고리를 머리속에 못그리는지 의문... 
- web.xml의 프로젝트 profile 버전을 바꾸게 되면, 연결된 아래의 것들을 고려해야 한다. 
    
```
<context-param>
    	<param-name>contextConfigLocation</param-name>
    	<param-value>
			 classpath:context/spring-context.xml,
			 classpath:context/cache-context.xml,
			 classpath:context/adapter/channel-context.xml,
			 classpath:context/channel/websocket-context.xml
		</param-value>
	</context-param>
```  
   
- 특히 channel-context는 아래의 내용들을 설정하고 있고,  
      
```
<import resource="classpath:context/adapter/apple-context.xml"/>
<import resource="classpath:context/adapter/banana-context.xml"/>
<import resource="classpath:context/adapter/fineapple-context.xml"/>
<import resource="classpath:context/adapter/pitch-context.xml"/>
``` 
      
- 각각 import하고 있는 classpath들의 context.xml들은 아래의 내용을 가지고 있다. 
- 보면, profile별 propts를 properties로 가지고 있다. 
  
```
<!-- IMCS Properties --> 
<util:properties id="appleProps"   location="classpath:properties/adapter/apple/apple-#{profile}.xml"/>
    
``` 
  
- 이렇기 때문에 아래처럼 그림을 그려볼 수 있을것 같다. 
- 앞으로 개발/검수/상용별 테스트를 해야할때, 외부서버와의 연결관계도 고려하여 테스트 상황을 잘 파악하도록 하자. 
    
![image](https://user-images.githubusercontent.com/32521173/61383967-9c52da80-a8ea-11e9-8e07-fcd8b0c083bf.png)
    
  
- 다시 보다 든 의문, 왜 application.xml은 프로파일별 설정을 해놓지 않았을까??

- 요청사항이 들어오는 부분들을 지엽적으로만 보게 되어, 문제의 큰 그림을 못 그리는것 같아 답답하다. 
- 당황하지 말자, 침착하자
- 순차적으로 하나씩.
- 긍정적 자기 대화!!! 
  
