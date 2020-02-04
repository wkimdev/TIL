## jquery event on off
- jquery 통합 메서드 on() off()

#### jquery 이벤트의 연결 및 처리 .on() .off() .one()
- 이벤트의 연결(eventbinding)
- 특정 요소에서 발생하는 이벤트를 처리하기 위해서는 `이벤트 핸들러(event handler)함수`를 작성해야 한다.  
- 이렇게 작성된 이벤트 핸들러를 **특정 요소에 연결하는 것**을 `이벤트 바인딩(event binding)`이라고 한다.  
- jquery는 이벤트 바인딩을 위해 다양한 방법을 제공한다. 
  
#### event on()예제
   
```
<div>
  <button id="test">click me!</button>
</div>
```
  
- script   
```
$("#test").on('click', function(){
  alert('click!');
}) 
```
- off event()  
  
```
$('#test').off('click')
// 해당 엘리먼트의 클릭 이벤트를 제거한다. 
```  
  
- 이벤트를 바인딩하는 경우 성능 및 메모리에 영향을 미치기 때문에 사용하지 않거나, 제거가 필요한 경우 반드시 off()를 사용하여 제거한다. 
- 작은 어플리케이션의 경우 영향이 크지 않으나, 큰 어플리케이션의 경우 차이가 클 수 있다. 

#### 참고로
- dom에 노드를 추가하거나 삭제하는 작업은 최소화 하는 것이 좋다. 
- dom접근은 (성능면에서) 비용이 많이 드는 작업이다. 
- 브라우저가 할일을 줄여야 한다~!!(퍼포먼스에 좋은 패턴을 사용하지 않고 코딩을 한다면 브라우저가 그 만큼 일을 더 많이 하게 된다) 
- 더 많은 일 = 더 많은 메모리 사용 = 느린 프로그램 
  
  
## reference
- https://webisfree.com/2014-01-03/[jquery]-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%ED%86%B5%ED%95%A9-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%ED%99%9C%EC%9A%A9-on()-off()
- [jquery 성능 향상시키는 방법](http://codefactory.kr/2011/12/07/jquery-performance-tips-and-tricks/) 
- http://www.devkuma.com/books/pages/232   (깔끔하게 정리 잘되어 있음) 
  
