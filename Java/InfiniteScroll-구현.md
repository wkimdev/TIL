## InfiniteScroll
- event서비스에서 배너 이미지를 호출할시 view단에서 infiniteScroll 함수를 호출하고, 서버에서 응답값을 가져오는 구조이다. 
- 스크롤시 요청한 데이터를 서버에서 처리해줘야 한다. 
- 요청 page별 스크롤 처리를 아래처럼 구현한다. 
- view단에 스크롤을 할때마다 page++를 시키고, 그 page 넘버를 conroller에서 받아서 서비스로 던지게 되어 있다. 

```
int eventPageItemCnt = 0;
int pageCount = 10;
int pageStartCount = (startNum*pageCount) - 9;

 ....

// 해당 구간 아니면 제외시키는 코드 
if( eventPageItemCnt < pageStartCount ){ 
  continue;
} else if( eventPageItemCnt > (startNum*pageCount)	
    && eventPageItemCnt >= pageStartCount ){
  break;
}

``` 

 
