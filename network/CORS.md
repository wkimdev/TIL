
### what is cors issue?
- see => https://evan-moon.github.io/2020/05/21/about-cors/
  
### 이슈
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
  

  


