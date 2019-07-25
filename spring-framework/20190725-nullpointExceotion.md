## 미해결이슈. 
- local profile 버전에서 gateway를 호출시, 서비스에서 로컬 더미데이터를 가지고 와야 하는데 아래 에러가 난다. 
- 내일 시도해봐야 하는건, `cache에서만 해보기 - service에서 호출 말고 ` 
  
  
```
java.lang.NullPointerException: null
	at com.uplus.music.adapter.aop.GatewayLoggingAdvice.invoke(GatewayLoggingAdvice.java:53)	
	at sun.reflect.GeneratedMethodAccessor82.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
  ...
  	at com.sun.proxy.$Proxy54.getCLEpisodeList(Unknown Source)
	at com.uplus.music.concert.service.CJClipService.getCLEProgramList(CJClipService.java:132)
	at com.uplus.music.dummy.controller.ImcscjDummyApiController.getCLEProgramList(ImcscjDummyApiController.java:149)
```  
  
  
