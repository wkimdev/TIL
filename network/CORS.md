
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
  

### 시도해본 방법
- eventpublish 사용 해봄?!
- 기타... 집중이 어렵당 이걸 하고 있어도 되나... 
  
  
### 낼 시도해볼 방법 
- 샘플 코드 처럼 emitter를 ConcurrentHashMap에 넣어두고 값이 변경 되었을 경우 `send()`를 다시 시켜보자. 그럼 메세지가 갈까????  제발.. 🙏 제발 🙏 🥺 
  
