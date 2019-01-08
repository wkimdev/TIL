## vue.js feature
- dom에 동적으로 
- 리액트적인
- 컴포넌트 기반
- 데이터 props, 데이터 바인딩.

## vue js 주요 라이프사이클
- Vue에서, 컴포넌트는 본질적으로 미리 정의된 옵션을 가진 Vue 인스턴스
- 모든 vue 앱은 vue함수로 새 vue 인스턴스를 만드는 것부터 시작한다.  

```
var vm = new Vue({
  // 옵션
})
```
  
- vue 생성자는 미리 정의된 옵션으로 재사용 가능한 컴포넌트 생성자를 생성하도록 확장될 수 있다. 

#### 인스턴스 라이프사이클 훅
- 각 vue인스턴스는 '데이터 관찰'을 설정하고, '템플릿을 컴파일'하고, 
인스턴스를 'dom에 마운트'하고, 데이터가 변경 될 때 dom을 업데이트해야 할때 일련의 초기화 단계를 거친다. 
- 그 과정에서 사용자 정의 로직을 실행할 수 있는 **라이프사이클 훅**도 호출된다. 
- 모든 라이프사이클 훅은 this 컨텍스트가 호출하는 Vue 인스턴스를 가리키며 호출됩니다.  
   
   
```

new Vue() --> init Event & lifecycle --> (beforeCreate)
  
init injections & reactivity --> (created) 
  
beforeMount --> mounted --> (when data chengeds) ---> update
  
before destroy --> destroyed  
  
```


## 주요 템플릿 문법
- 렌더링된 dom을 선언적으로 바인딩 할 수 있는 html 기반 템플릿 구문 사용
(Vue.js는 렌더링 된 DOM을 기본 Vue 인스턴스의 데이터에 선언적으로 바인딩 할 수있는 HTML 기반 템플릿 구문)

## v-bind
- v-bind 디렉티브.
- v-bind : 중복되지 않는 선에서 리스트 뿌린다.
- 반응적으로 html 속성을 갱신하는데 사용.  
- 동적으로 값에 따라 class를 추가하거나 뺀다. v-bind 강력함.
- `<i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}" `
- v-bind:"하위로 보낼 이벤트(props)" : "받는 이벤트"

## v-on
- v-on 디렉티브
- DOM '이벤트'를 수신!
- v-on:click (@click 으로도 쓸 수 있다. )
- v-on:"하위 컴포넌트에서 발생시킨 이벤트 이름" : "현재 컴포넌트 메서드명"  

## v-for
- items의 리스트들을 렌더링하는 디렉티브

## v-model
- 하나 이상의 속성 또는 표현식에 대한 구성 요소 소품을 동적으로 바인딩
- `<input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">`  


#### 리팩토링
- 리팩토링 강의의 핵심은, app.vue에서 공통적인 메서드, 데이터 바인딩을 처리해주고, 그걸 컴포넌트에 분배? 하는 흐름..
- 그림 있으면 첨부하기.
- 하위 컴포넌트들은 presentation 역할, app.vue는 공통 데이터 처리 컨테이너 역할을 한다는걸 기억하기.

#### 아침 인강 정리(1/8)
- `this.$emit('이벤트 이름', 인자1, 인자2, ....);` 
- input에서 v-model로 이벤트를 태우고, emit 발생시킨다. 즉, 이벤트를 발생시키는 역할밖에 하지 않는다.
- presentation 역할 (todoInput)
- container 역할 (App.vue)
- app.vue에서 todoItems으로 공통으로 관리가 되기 때문에 list에 잘 추가가 된다. 
- todolist도 표현만 하도록 변경하기.
- todolist에 있는 todoremovev애도,,, 클릭시 이벤트만 발생시키고, 삭제하는건 app.vue에서 하겠지??? -on:click=removeTodo()


## reference
- https://kr.vuejs.org/v2/guide/syntax.html
