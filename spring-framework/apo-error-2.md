## 13:49:32.814 ERROR [GlobalExceptionHandler : handleException] - null...[]  
- 사실 aop에러가 아닐 수도 있지만, causeby없이 proxy에서 새로 만든 list메서드를 호출하는데 에러가 나고 스택트레이스에 aop가 찍히기에 
이게 아닐까? 라고 의심중이지만, 결국 아니라고는 한다. (정말?)
- 문제는 서비스를 잘못 개발했고, 
- 테스트 하는 방식이 이상하다고 하지만, 아직 이해는 못했다... 
- aop설정은 servce-context.xml 외에 나머지는 로깅 aop... 
- 여기 말고는 뚜렷한 이유가 없는데 왜지... 
  
```
13:49:32.814 ERROR [GlobalExceptionHandler : handleException] - null...[]
java.lang.NullPointerException: null
	at com.uplus.music.adapter.aop.GatewayLoggingAdvice.invoke(GatewayLoggingAdvice.java:53)	
	at sun.reflect.GeneratedMethodAccessor82.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:629)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:618)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)
	
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:673)
	
	at com.uplus.music.adapter.support.imcscj.ImcscjAdapter$$EnhancerBySpringCGLIB$$2dd800f8.getCLEpisodeList(<generated>)
	at com.uplus.music.adapter.support.imcscj.service.ImcscjAdapterServiceImpl.getCLEpiosdeList(ImcscjAdapterServiceImpl.java:88)
	at com.uplus.music.adapter.support.imcscj.service.ImcscjFrontServiceImpl.getCLEpisodeList(ImcscjFrontServiceImpl.java:86)		

1. 프락시 메서드로 감싸진 getCLEpisodeList 
2. invoke(ExposeInvocationInterceptor.java:92) 호출 
```  

#### 테스트 방법
- 아래처럼 하는게 틀렸다고???

```
	/*
	 * 4-1. CJ 동일 프로그램 회차 리스트 조회 ( getCLEProgramList )
	 */
	@RequestMapping(value = "/lists/program", method = RequestMethod.POST)
	public ApiResponseModel<List<CJEProgramModel>> getCLEProgramList(CLEpisodeListRequest request) {
		
		String channelId = "EA";  
		String programId = "EA_B120182103"; 
		String pageNo = "1";
		String pageCnt = "10";
		String orderGb = "D";
		
		List<CJEProgramModel> programLists = cJClipService.getCLEProgramList(channelId, programId, pageNo, pageCnt, orderGb);
		
		ApiResponseModel<List<CJEProgramModel>> apiResponse = new ApiResponseModel<List<CJEProgramModel>>()
				.setStatus(ApiResponseType.SUCCESS.code()).setResult(programLists);
		
		return apiResponse;
	}
``` 

  
  
