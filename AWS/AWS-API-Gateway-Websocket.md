## TODO
  
![image](https://user-images.githubusercontent.com/32521173/67501311-07b50100-f6bf-11e9-9a50-a9b32f38b9f6.png)
  

   
   
- [aws doc : API Gateway의 WebSocket API 소개](https://docs.aws.amazon.com/ko_kr/apigateway/latest/developerguide/apigateway-websocket-api-overview.html)
- API Gateway에서 AWS 서비스(예: Lambda 또는 DynamoDB) 또는 HTTP 엔드포인트에 대한 상태 저장 프론트엔드로 WebSocket API를 만들 수 있습니다. 
- WebSocket API는 클라이언트 애플리케이션에서 수신한 메시지의 내용을 기반으로 백엔드를 호출합니다.
- 요청을 받고 응답하는 REST API와 달리 WebSocket API는 클라이언트 앱과 백엔드 간의 양방향 통신을 지원합니다. 
- 백엔드는 연결된 클라이언트로 콜백 메시지를 보낼 수 있습니다.
- WebSocket API에서 수신되는 JSON 메시지는 사용자가 구성한 라우팅을 기반으로 백엔드 통합으로 전달됩니다. 
- (비 JSON 메시지는 사용자가 구성한 $default 라우팅으로 전달됩니다.)
- $connect, $disconnect, $default 등 세 가지 사전 정의된 라우팅을 사용할 수 있습니다. 또한 사용자 지정 라우팅을 생성할 수 있습니다. 



## Reference
- [study참고 git](https://github.com/mavi888/websockets-chat)
- [Serverless doc](https://serverless.com/framework/docs/providers/aws/events/websocket/)
- [유튭 : Simple application with API Gateway Websockets | Serverless](https://www.youtube.com/watch?v=Quk_XHMvFJI)
  
  
#### wscat를 사용하여 WebSocket API에 연결하고 메시지 보내기
- [wscat를 사용하여 WebSocket API에 연결하고 메시지 보내기](https://docs.aws.amazon.com/ko_kr/apigateway/latest/developerguide/apigateway-how-to-call-websocket-api-wscat.html)
- wscat 유틸리티로 API Gateway에서 만들고 배포한 websocket API를 테스트할 수 있는 편리한 도구 이다. 
- npm install 이후 아래 처럼 테스트 가능하다 
  
```
>wscat -c wss://8gtimpq2ge.execute-api.ap-northeast-2.amazonaws.com/dev
```
