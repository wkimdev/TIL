## java exception 강제로 생성하기
- ==> 에러 발생법
- 1. 데이터 정상적 publish but 해당 로직 안타게 됨
- throw new Exception();

```
if(true){
	throw new Exception();
}
```


- 2. 아예 파싱에러가 나도록
ico-server에서 rightPush 에서 아래처럼 던지기
==> listQueueOperations.rightPush("dc:create:address", "dsafdsfafadsf");
 