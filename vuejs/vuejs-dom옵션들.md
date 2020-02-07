## vuejs DOM 옵션
- Vue컴포넌트는 기본적으로 dom에 연결되어 동작하지만, dom에 연결되어 있지 않아도 동작한다. 
- vuejs는 인스턴스를 생성할때 dom정보를 제공받을 수 있는 관련 옵션 4개를 제공한다. 
- 선택적으로 dom옵션을 전달할 수 있으며, 옵션 사이의 우선순위가 다르다. 
  
#### el옵션
#### template옵션
#### mixims 옵션
- 그동안 vue인스턴스를 생설할땐 vue생성자에 옵션들을 인자로 주어 생성했다. 이런 인스턴스를 여러번 복사해서 생성하는 것을 줄이기 위해 mixims 옵션을 사용한다. 
- Minxins는 컴포넌트에 재사용 가능한 기능을 배포하는 방법
- mixims옵션 값은 객체 리터럴로 설정하며 객체 리터럴은 vue 인스턴스의 옵션뒤에 라이프 사이클 이벤트 훅을 담아둔다. 
- 예
  
```
var mixin = {
  created: function() { console.log(1); }
}

```
 
   
   
- 출처
- https://beomy.tistory.com/61
