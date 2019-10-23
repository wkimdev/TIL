## 20190610 금일 직면한 이슈
- java로 json을 convert하는 작업을 진행하면서 금일 직면한 이슈를 정리한다. 
  
  
```
1. 뒤로 돌아가서 바람직하지 않은 상황을 분석해보세요.  
2. 무슨 일이 일어난 건지 파악해보세요.  
3. 다음번에는 이 문제를 피할 수 있는 실행 절차를 세워보세요.
```
   
  
## "{"status":"500","message":"java.lang.IllegalStateException: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $"}[\r][\n]"  
- requestChannel로 데이터를 실어서 request param을 외부 서버에 요청하는데 위의 에러가 발생했다.   
- 처음에는 response받을때 나는 에러인 줄 알았다. 하지만 디버깅을 해보니, request할때 에러가 나고 있었다.   
- request에서 원인을 찾기 전까진... (이게 request문제인건 한참 고민하다가, 문득 stackoverflow의 글을 유심히 해석한 뒤 requedst가 잘 못 되었다는것을 깨달았다. )
response받는데에서 왜 object가 아닌 string 로 던지는 걸까, 어디부터 찾아야 될지 당황스러웠다...   
- 원인을 찾아낸 stackoverflow링크 (here)   
- 그리고 설정을 수정했다. 그리고 해결! (하지만 그 다음 다른 에러가 났다. )   
- 그 다음 에러는 기존에 수정했던 환경설정을 back시키지 않아서 났던 에러였다. 이걸 까먹고 또 헤매였다...  
  
  
```
	<!-- Post Gateway -->
	<int:gateway id="PostGateway"
			service-interface="PostGateway"
			default-request-channel="channel">
		<int:default-header name="contentType" value="application/x-www-form-urlencoded"/> <!-- 여기를 json으로 수정해야 합니다.  -->
		<int:default-header name="accept" value="application/json"/>
	</int:gateway>
```

#### next plan
- 요청 방식을 어떻게 처리하는지 분명히 하자. (request param 인지 body(application/json)인지. get/post인지)   
- 인터셉터가 어떻게 연결되어 있는지 파악하자.  
- **지레 겁먹지말고** **에러메세지를 고민해보고**, 어떤 상황에 에러가 나는지 차분히 디버깅 해보자.  (request에서 나는건지, response에서 나는 건지) 
- request에서 난다면, 어떤 방식으로 던지길래 왜 string으로 던진다는 것일까... 한번 찾아보게 된다. 


## Cannot deserialize instance of out of START_OBJECT token
- postman을 뚫어지게 보다보니, 으잉, 원래 문서상 내려주는 타입이 배열이어서 클래스에 배열로 받고 있었는데 object로 내리고 잇었음...
- 그래서 애를 object로 받도록 request, gateway~ 전부 수정하여 다시 테스트를 진행하였다. 
- 그 결과 테스트 무사히 완료 했다!!  

#### next plan
- 한글로 번역하면 저 에러가 하는 말은.. START_OBJECT 토큰 중 인스턴스를 deserialize 할 수 없습니다.
- 뭔가 object쪽 (여기에는 옮겨적진 않았지만, 에러가 발생하던 key값에 저 에러가 나고 있었다.)에서 컨버팅 하는데 deserialize가 안된다는 것이다. 
- serialize가 json을 객체로 읽어드릴 수 있도록 byte로 바꾸는 거니까, deserialize는 객체를 json으로 바꾸는걸 말하는 거겠지??
- stackoverflow의 도움 + response 하는 녀석의 타입이 정확한 건지 **dummy데이터와 postman결과값을 다시 확인해봄으로서, 다음에는 더 빠르게 해결 할 수 있다. **  

  




