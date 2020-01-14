# what is vuejs LifeCycle??
- vue인스턴스나 컴포넌트가 생성될때, 미리 사전에 정의된 몇 단계의 과정을 거치게 되는데 이를 라이프사이클이라 한다. 
- Vue 인스턴스가 생성 된 후 우리 눈에 보여지게 되고 사라지는 단계를 일컫는 말. 

## mounted
- `vm.$el 생성과 대체` 단계가 끝나고 '마운트' 단계로 들어가기 직전에 호출된다.  
- `el` 옵션은 Vue 인스턴스만 사용할 수 있다. 
- 렌더링시, 컴포넌트를 가상 dom으로 미리 변환하는 과정에서, 컴포넌트가 사용할 템플릿이 지정된 `el, template, render` 옵션 중 하나를 찾는다. 

## created
- created훅에서는 `data`를 반응형으로 추적할 수 있게 되며 `computed, methods, watch`등이 활성화 되어 접근 가능하게 된다. 
- 하지만 아직까지 `DOM`에는 추가 되지 않은 상태. 
- data에 직접 접근이 가능하기 때문에, 컴포넌트 초기에 외부에서 받아온 값들로 data를 셋팅해야 하거나 `이벤트 리스너를 선언` 해야 한다면
이 단계에서 하는 것이 가장 적절합니다.  
  * 앞으로 네이티브 이벤트를 리스너 하고 있는 부분은 무조건(native interface를 선언한 부분) created를 보고 먼저 판단해볼 수 있겠다.    

---
  
## computed
- 고급 템플릿 기법으로서, computed 속성의 첫번째 장점은 data 속성 값의 변화에 따라 자동으로 다시 연산
- 두 번째 장점은 캐싱

## watch 속성
- watch 속성은 데이터 변화를 감지해 자동으로 특정 로직을 수행
- computed와 유사하지만, computed 속성은 내장 api를 활용한 간단한 연산 정도에 적합, watch 속성은 데이터 호출과 같이 시간이 상대적으로 
더 많이 소모되는 비동기 처리에 적합... 
 
  
---

# 컴포넌트 가드
## beforeRouter
- beforeRouter는 컴포넌트 가드이다. (옹 앞에 라우터가 붙었네~) 
- 라우터 가드와 컴포넌트 가드도 같은 원리로 동작한다. 다만 url 이동을 막기 위해 사용하는 API가 조금 다르다. 

```
onst Login = {
  template: '<p>Login Component</p>',
  beforeRouteEnter (to, from, next) {
    // Login 컴포넌트가 화면에 표시되기 전에 수행될 로직
    // Login 컴포넌트는 아직 생성되지 않은 시점
  },
  beforeRouteUpdate (to, from, next) {
    // 화면에 표시된 컴포넌트가 변경될 때 수행될 로직
    // `this`로 Login 컴포넌트를 접근할 수 있음
  },
  beforeRouteLeave (to, from, next) {
    // Login 컴포넌트를 화면에 표시한 url 값이 변경되기 직전의 로직
    // `this`로 Login 컴포넌트를 접근할 수 있음
  }
}
  
```
  

## 출처
- https://wormwlrm.github.io/2018/12/29/Understanding-Vue-Lifecycle-hooks.html 
- computed 동작에 대한 좋은글~ https://mygumi.tistory.com/311
- vuejs 입문 책 캡틴판교~
  
