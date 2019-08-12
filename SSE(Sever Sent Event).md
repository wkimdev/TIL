# SSE(Sever Sent Event)

Created: Aug 05, 2019 10:42 PM

- 단방향으로 웹소켓 서버 구성없이,
(특별한 프로토콜이나 서버 구현이 필요없음 )
클라에서 데이터 전송도 필요 없을 경우
- (ex) 친구의 상태업데이트, 주식 시세 표시기, 뉴스피드, 자동화된 데이터 푸시~
- server to client : 단방향 통신
- 이걸 회사 서비스의 웹소켓 대용으로 사용해 볼 수 있을까?
  - 흠...아니다 양방향 통신 해야 해서 힘들것 같다(구독하고 있다가 에러 발생시 감지 해야 하는 구조라서.. ) 흠냐.. 

[Polling vs SSE vs WebSocket- How to choose the right one](https://codeburst.io/polling-vs-sse-vs-websocket-how-to-choose-the-right-one-1859e4e13bd9)
