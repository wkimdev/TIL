
### what is cors issue?
- see => https://evan-moon.github.io/2020/05/21/about-cors/
  
### 이슈1
- server-sent event를 프론트단에 적용하기 위해 아래처럼 eventSource() 인스턴스를 생성하고 url를 지정하는데 cors이슈가 발생했다. 
- 타겟 url은 로컬 api 였다. 
  
```
const evtSource = new EventSource("blah-my-url"); 
```
  
```

Access to resource at 'http://localhost:8080/my/events' from origin 
'http://localhost:8002' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.

```

### 시도해본 방법
- javascript에서 강제로 `Access-Control-Allow-Origin: *`를 설정해보기.. 
- backend에서 헤더에 Access-Control-Allow-Origin 세팅

### 해결
- frontend 에 webpack에 이미 타겟 url에 대한 리버스 프록시가 설정 되어 있다. 앞의 localhost:8080만 빼면 됬었답... 😭 엄청 졸았낭
    
### 이슈2
- sse 를 프론트와 서버 연결 시도는 성공했다!!
- 하지만 login 값이 변경 되었을 경우 (즉, 데이터가 변경되는 시점에) 변경된 데이터가 프론트로 전달되지 않았다.. 디버깅을 해봐도 코드는 잘타는데 데이터가 전달이 되지 않았다. 
  
### 시도해본 방법 & 해결
- eventpublish 사용 해봄?! => 해당 사항 없음 
- 샘플 코드 처럼 emitter를 ConcurrentHashMap에 넣어두고 값이 변경 되었을 경우 `send()`를 다시 시켜보니 메세지가 전달된다. 
- https://wedul.site/157 
   
   
### 이슈3
- 서버에서 로그인 시점에 send()를 시킬때 메세지가 전달이 될때가 있고 안될 때가 있다. 
- 또한 처음 연결하는 시점에 응답 속도가 3초 이상이 걸리는 것 같다... 그리고 한번에 되지 않는다. 
- 정확히 확인해보지 않았지만 뭔가 메로리릭.. 경고가 떴었고, 메세지가 간헐적?으로 전달이 되더니 어느순간부터 아예 전달이 되지 않았다. 
- 클라이언트단에서 확인해보니 event를 수신하고 있는데 waiting...이런게 떴었다. 
- 비동기로 메세지를 전달하면서... 뭔가 병목현상?이 발생한 것 같은데 정확한 원인을 못 찾겠다. 
- 비동기... 

### 이슈4
- timeout 설정 후 어제보단 send가 잘되는 것 같다. 
- 빌드 후에 앱에서 테스트 해 본 결과...  쀼에서 만든 이벤트버스가 들어가지 않는다. 
- 타겟 url을 수정해서 다시 시도해봐야겠다. 잠시 전에는 그 생각이 안들었다. 
    
### 시도해보기
- sseemitter에 타임아웃을 설정해놓기 
  - https://stackoverflow.com/questions/29880336/spring-sseemitter-causes-cannot-forward-after-response-has-been-committed-except
  
### 잡담 
- 처음엔 cors 이슈 정리를 하려고 시작했는데 어느순간 sse 처리하면서 발생한 이슈를 낙서하게 되는 노트...   
- 로그인을 이런식으로 처리해도 될까... 
  
  
