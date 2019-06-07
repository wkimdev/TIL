## AOP And Error
- 테스트를 돌리는 중 아래의 에러가 났다. 

##### org.springframework.web.client.HttpServerErrorException: 500
- cause by도 없고, 메서드를 호출하는 gateway 클래스 부근의 아래 에러 메세지 빼곤 뚜렷히 어디 에러인지 보기가 어려웠다. 

```
at com.sun.proxy.$Proxy14.getCLSuggestList(Unknown Source)  
at com.uplus.music.adapter.support.imcscj.ImcscjAdapter.getCLSuggestList(ImcscjAdapter.java:59)  
at com.uplus.music.adapter.AdapterImcscjTest.testImcschGetCLSuggestList(AdapterImcscjTest.java:113)  
```

- 그리고 postman에서 post를 날릴시 아래의 에러가 남을 발견... 
  
```
{
    "status": "1002",
    "result": {
        "code": "1002",
        "message": "Session cannot be created"
    }
}
```


#### 이를 해결하기 위해 알아했던 배경지식 들은... 
- <mvc:exclude-mapping />
- 뭔가 세션과 연관...
- 필터와 인터셉터는 적용 시점이 다릅니다. 필터는 스프링 프레임웍과는 무관하게 지정된 자원에 대해 동작합니다. 스프링은 Dispatcher 서블릿으로 부터 시작됨으로 필터는 스프링 컨텍스트의 바깥에 존재 하게 됩니다.
- 인터셉터는 스프링의 Dispatcher 서블릿이 컨트롤러를 호출할 때 전, 후에 끼어듭니다. 그러므로 스프링 컨텍스트 내부에 존재하게 됩니다.
- 인터셉터는 여러개를 사용할 수 있으며, 실행 순서는 <mvc:interceptors> 에 나오는 순서 입니다. 인터셉터를 주로 사용하는 곳은 로그인 체크, 권한 체크, 프로그램 실행시간 계산 작업 로그 처리, 업로드 파일 처리 등에 많이 사용됩니다.
  
## preHandle() 
- 컨트롤러 메소드 실행 직전에 수행됩니다. 
- true 를 반환하면 계속 진행이 되고  false 를 리턴하면 실행 체인(다른 인터셉터, 컨트롤러 실행)이 중지되고 반환 됩니다. 
- 필터의 응답 처리가 있다면 그것은 실행이 됩니다.

출처: https://offbyone.tistory.com/33 [쉬고 싶은 개발자]
  
- 오늘 어제도 삽질했네~~ 이런 삽질 언제쯤 멈추나 ㅠㅠ... 



## Reference
- https://offbyone.tistory.com/33
