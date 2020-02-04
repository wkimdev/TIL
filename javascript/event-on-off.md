## jquery event on off
- jquery 통합 메서드 on() off()

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
 

## reference
- https://webisfree.com/2014-01-03/[jquery]-%EC%9D%B4%EB%B2%A4%ED%8A%B8-%ED%86%B5%ED%95%A9-%EB%A9%94%EC%84%9C%EB%93%9C%EC%9D%98-%ED%99%9C%EC%9A%A9-on()-off()

