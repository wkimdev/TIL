~~~
var a =10;
a
10
window.a
10
> this
Window {parent: Window, opener: null, top: Window, length: 0, frames: Window, …}
~~~
- 최상단에는 윈도우 객체가 있다. 

~~~
## 함수내에서 전역 호출
function sum(a,b){
	console.log(this)
	return a+b;
}

## 생성자 호출 
function Vue(el) { console.log(this); this.el = el; }
new Vue('#app');
Vue {}el: "#app"__proto__: Object
Vue {el: "#app"}

## 비동기처리 this
바인딩을 계속 해줘야 하는 번거로움을 해소하기 위해 화살표 함수를 쓰게 된다. 
var vm = this;
...
화살표 함수를 이용해 컴포넌트의 this를 그대로 가져오기 
~~~
   
  


# 함수 호출 패턴에 따라 결정되는 this.
- 자바스크립트 함수는 호출될 때, 매개변수로 전달되는 인자값 이외에, 'argument' 객체와 'this'를 암묵적으로 전달받는다.
- 자바스크립트의 경우 java와 같이 this에 바인딩되는 객체는 한가지가 아니라 해당 함수 호출 방식에 따라 this에 바인딩 되는 객체가 달라진다.
- this는 함수 내에서 함수 호출 맥락(context)를 의미하고, 맥락/상황에 따라 달라진다.

## 함수 호출 방식과 this 바인딩
- 자바스크립의 경우 함수 호출 방식에 따라, 어떤 객체를 this에 바인딩할 지가 결정된다.(this의 값은, 함수를 호출하는 방법에 의해 결정된다).
- 함수를 어떻게 호출하는지에 따라 this에 할당되는 객체가 달라진다.
- 함수는 호출할 수 있는 방법이 아래와 같다.
>  1. 함수 호출 패턴
   2. 메소드 호출 패턴
   3. 생성자 호출 패턴
   4. apply 호출 패턴
  
```
var foo = function () {
  console.dir(this);
} 

// 1. 함수 호출 패턴
//foo();	//window.
// window.foo();

// 2. 메소드 호출 패턴 ==> 이해 x
/* 
var obj = {	foo : foo};
obj.foo(); //object

 */// 3. 생성자 호출 패턴
//var instance = new foo(); //foo (instance)

// 4. apply 호출 패턴
var bar = { name: 'bar' };
foo.call(bar); 
foo.apply(bar);
foo.bind(bar)();
```

## 함수 호출 패턴
- 전역객체(Global Object)는 모든 객체의 유일한 최상위 객체를 의미.
- browser-side : window
- Server-Side(Node.js) : global   
 
```
//in browser console
this === window //true

//in terminal
node
this === global //true
```

- 전역객체는 전역 스코프를(global scope) 갖는 전역변수(global variable)를 프로퍼티로 소유한다.
- 글로벌 영영에 선언한 함수는 전역객체의 프로퍼티로 접근할 수 있는 전역 변수의 메소드.


# javascript object
- {} === new Object()
- {}는 new Object()에 리터럴.
- 자바스크립트는 상속이라는 개념이 없어서, this라고 하면 자기 자신밖에 찾지 못한다.
- 자바에서 this는 객체 자기 자신이다.
- 그래서 undefined가 뜬다.

```
var s = {
	d: '1',
  a: this.a, //undefined
  s : {
  	q: this.a //undefined
  }
}

console.log("test 1 :"+s.d); //1
console.log("test 1 :"+s.a); //undefined
console.log("test 2 :"+s.s.q); //undefined

```

- vue => new Vue({ }) 라고 인스턴스를 만들시, vue에서 말하는 this는 자기자신의 인스턴스 변수이다.
- 그래서 this.{method}, this.{data}로 접근 가능하다.
- 자바스크립트는 프로토타입형식이고, 프로토타입이 없다.

## 자바스크립트 - Uncaught SyntaxError: Invalid shorthand property initializer
- 구조체형 변수 생성시, 초기값 설정에 ':'를 사용해야하나, '='를 넣어서 오류 발생함.







