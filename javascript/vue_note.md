- vue는 너무 고민하지 말기.
y축 확인하기!

>>
labels에 data 뿌리기,
count date 로딩 시키기.

# 라우터는 기본적으로 rootUrl/#/{router name}의 구조로 되어 있다.
- history 기능을 추가하면 hasing(#)을 제외시킬 수 있다.


#
- 미들웨어단에서 처리하고, 
- 루프 돌려서 데이터 가져오도록 함.
- 서버에서 계속 가져오기

#
var vm = new Vue({
    
})

vue 생성자는 미리 정의된 옵션으로 재사용 가능한 컴포넌트 생성자를 생성하도록
확장될 수 있습니다.

vue앱은 new Vue를 통해 만들어진 root vue instance로 구성되며, 선택적으로 중첩이 가능하고
재사용 가능한 컴포넌트 트리로 구성된다.

- 모든 vue 컴포넌트가 본질적으로 확장된 vue instance.

* 속성과 메소드
- 각 vue 인스턴스는 data 객체에 있는 모든 속성을 프록시 처리 한다.


<div class="app2">

</div>

//vue instance 추가
new Vue({
    el: '#app2',
    components: {
        'my-local-component' = '';
    }
})

부모와 자식 컴포넌트 관계
- 구조상 상-하 관계에 있는 데이터 통신
 - 부모 -> 자식 : props down
 - 자식 -> 부모 : events-up

# props
- 모든 컴포넌트는 각 컴포넌트 자체의 스코프를 갖는다.
    - ex) 하위 컴포넌트가 상위 컴포넌트의 값을 바로 참조할 수 없는 형식.
- 상위에서 하위로 값을 전달하려면 props 속성을 사용한다.


# non paren 
- 컴포넌트간의 직접적인 통신을 불가능하도록 되어 있다. --> vue의 기본 구조.
- emit event를 통해서 컴포넌트간 데이터 통신?을 가능하게 해준다.

# parent - child
- 같은 레벨에서 다른 컴포넌트로 데이터를 전달할때 불편하다.

# event bus
- 컴포넌트간의 이벤트를 쉽게 하기 위한 것.

# ***this(중요함).
- Java : 클래스 인스턴스의 래퍼런스 변수.
- javascript : 현재 실행 문맥.(호출자가 누구인가에 따라)
- 


# 
컴포넌트는 자체 스콥을 가지고 있기 때문에 
컴포넌트간의 직접적인 통신은 불가능하도록 되어 있다.

parent --> child : props
child --> parent : emit event

## event bus - 컴포넌트간 통신
- non parent - child 컴포넌트간의 통신을 위해 event bus를 활용할 수 있다.
(vuex는 컴포넌트간 데이터를 던지는데 유용하게 한다.)
- 싱글 컴포넌트 이런식으로 new vue~ 하는건, es6 이게 적용되야 하는 것.



- 왜 잘 안되고
- 왜 애는 잘되는지
- 어떻게 동작하는지


구글 map static api 키
AIzaSyC6IvhsLvfPaoyg573DeL8jEh-VyBFRzNY

- index.html


# 스크립트 동작구조!!!
--> 
## 나
이벤트가 발생 --> 데이터를 맵핑시킨다 (mounted, method) --> 돔 렌더링 (created) --> 사용자가 화면에서 확인한다.

수정전==> div --> created --> method --> 
수정후==> div --> mounted --> method(initmap) --> '렌더링이 된 이후에, 접근이 가능하니까!!!!'

대충..
created --> data영역
mounted --> rendering 영역, map, chart같은 것..

## 보충
- Vue.js의 라이프 사이클은 크게 Creation, Mounting, Updating, Destruction 으로 나눌 수 있다

1. creation 단계
- 컴포넌트가 돔에 추가되기 전.
beforeCreate
모든 훅 중에 가장 먼저 실행되는 훅이다. 아직 data와 events(vm.$on, vm.$once, vm.$off, vm.$emit)가 세팅되지 않은 시점이므로 접근하려고 하면 에러를 뿜어낼 것이다.
created
created 훅에서는 이제 data와 events가 활성화되어 접근할 수 있다. 여전히 템플릿과 가상돔은 마운트 및 렌더링되지 않은 상태이다.

2. Mounting : 돔(DOM) 삽입 단계

3. Updating : Diff 및 재 렌더링 단계



##
# vue routers
- vue를 이용한 SPA를 제작할 때 유용한 라우팅 라이브러리
- 페이지요청을 서버에 하는게 아니라, 
처음 화면 호출할때 모든 페이지의 정보를 가지고 있다가 호출함.

- vue 코어 라이브러리 외에 router 라이브러리를 공식적으로 지원하고 있다.

- vue 라우터는 기본적으로 {rootrul}/#/{router name}의 구조로 되어 있음

- route-link는 뷰의 route를 이용하기 위한 태그
- <router-view>에 결국 해당 컴포넌트가 띄워지게 된다.

# Nested routers
- 라우터로 화면 이동시 nexted router를 이용해 여러개의 컴포넌트를 동시에 렌더링 가능하다.
- 렌더링 되는 컴포넌트의 구조는 가장 큰 상위 컴포넌트가 하위의 컴포넌트를 포함하는 
parent - child 형태와 같다.


# vue의 template 에는 최상위 태그가 1개만 있어야 헨더가 가능하다. 
-  Error compiling template:
<div>foo</div> <router-view></router-view>
- Component template should contain exactly one root element. If you are using v-if on multiple elements, use v-else-if to chain them instead.


# Nested Routes vs Named Views?
- 특정 url 에서 1 개의 컴포넌트에 여러 개의 하위 컴포넌트를 갖는 것을 nested routers
- 특정 url에서 여러개의 컴포넌트를 쪼개진 뷰 단위로 렌더링 하는 것을 named view라고 한다. 
- 그림을 보고 이해하기!

# Vue를 이용한 http 통신
- npm install vue-resource --save (현재 지원 중단 2016년)