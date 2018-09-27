## ES6란?
- ECMAScript 2015와 동일한 용어
- 2015년은 ES5(2009)이래로 진행한 첫 메이저 업데이트가 승인된 해
- 최신 Front-End FrameworK인 리액트, angular, vue에서 권고하는 언어 형식
- ES5에 비해 문법이 간결해져서 익숙해지면 코딩을 훨씬 편하게 할 수 있음.

# Babel
- 구 버전 브라우저 중에는 es6의 기능을 지원하지 않는 브라우저가 있으므로 transpiling이 필요
- ES6의 문법을 각 브라우저의 호환 가능한 ES5로 변환하는 컴파일러.

# const & let - 새로운 변수 선언 방식
- 블록 단위 {}로 변수의 범위가 제한되었음
- const :한번 선언한 값에 대해서 변경할 수 없음(상수 개념)
- let : 한번 선언한 값에 대해서 다시 선언할 수 없음.

위 특징들에 알아보기 전에 es5 두가지 특징 리뷰

1) 값 재할당 불가능.
const a = 10;
undefined
a = 20;
VM105:1 Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:3
(anonymous) @ VM105:1
var c = 10;
undefined
c = 20;
20

2) 값은 재할당 가능
let x = 10;
undefined
let x = 20;
VM156:1 Uncaught SyntaxError: Identifier 'x' has already been declared
    at <anonymous>:1:1
(anonymous) @ VM156:1
x = 30;
30


# es5특징 - 1) 변수의 scope(= 범위)
- 기존 자바스크립트는 (es5)는 {}와 상관없이 스코프가 설정됨
var sum = 0;
for (var i = 1; i <= 5; i++) {
	sum = sum + i;
}
console.log(sum);
console.log(i); // global scope에 잡힘 - 자바라면 접근 못함.


# 2) Hoisting
- Hoisting이란 선언한 함수와 변수를 해석기가 가장 상단에 있는 것처럼 인식한다.
- js 해석기는 코드의 라인 순서와 관계 없이 '함수선언식'과 '변수'를 위한 메모리 공간을 먼저 확보한다.
- 따라서, function a()와 var는 코드의 최상단으로 끌어 올려진 것(hoisted)으로 보인다.

function a() { return 6 + 10; } //function statement

var sum = function() {
	// function expression
	return 2 + 2;
}


# 아래의 코드 실행할때 자바스크립트 해석기의 코드 순서 재조정은?
~~~
var sum = 5;
sum = sum+i; <-- 일반적으로 애매모호 하다고 생각되는 부분.
function sumAllNumbers() { 
}

var i = 10;
~~~

#1 - 함수 선언식과 변수선언을 hoisting
var sum;
function subAllNumbers() {
	//..
}
var i;

// #2 - 변수 대입 및 할당
sum = 5;
sum = sum + i;
i = 10;


## es5 - let {} 단위로 변수의 범위가 제한됨
let sum = 0;
for (let i = 1; i <= 5; i++) {
	sum = sum + i;
}
15
console.log(sum);
VM67:1 15
undefined
console.log(i); //Uncaught ReferenceError: i is not defined
    at <anonymous>:1:13
	

## es5 - const 로 지정한 값 변경 불가능
const a = 1o;
a = 20; //XX

하지만, 객체나 배열의 내부는 변경시킬 수 있다.
a.num = 10;
10
console.log(a); //10 
 
const b= [];
b.push(200);

- let 선언한 값에 대해서 다시 선언 불가능
let a = 10 ;
let a = 20 ; xx

* const 는 할당이 다시 안되고, let은 선언이 다시 안된다.

-----
function f() {
	{
	let x;
	{
		// 새로운 블록안에 새로운 x의 스코프가 생김
		const x = "sneaky"
		x = "foo"; //위에 이미 const로 x를 선언했으므로 다시 선언하면 에러가 발생한다.
	}
	// 이전 블록 범위로 돌아왔기 때문에 'let x'에 해당하는 메모리에 값을 대입
	x = "bar";
	let x = "inner"; // uncaught syntaxError: Indentifier 'x' has already been declared
	}
}


## Arrow Function - 화살표 함수
- 함수를 정의할 때 function 이라는 키워드를 사용하지 않고 => 로 대체
- 흔히 사용하는 콜백 함수의 문법은 간결화 함.

//ES5 함수 정의 방식
var sum = function(a, b){
	return a + b;
}

//ES6 함수 정의 방식
var sum = (a, b) => {
	return a + b;
}

sum(10, 20);

// ES5
var arr = ["a", "b", "c"];
arr.forEach(function(value){
	console.log(value);
});

// ES6
var arr = [];
arr.forEach(value => console.log(value)); // a,b,c



# 함수 연습
var arr = [1,2,3];

arr.forEach(function(value) { console.log(value); });

arr.forEach((value) => console.log(value); )

# 연습 2
//es5
var sum = function() {
	return 1 + 2;
};

//es6
var multiply = () => {
	return 1 * 2;
};
ES6란?

- ECMAScript 2015와 동일한 용어
- 2015년은 ES5(2009)이래로 진행한 첫 메이저 업데이트가 승인된 해
- 최신 Front-End FrameworK인 리액트, angular, vue에서 권고하는 언어 형식
- ES5에 비해 문법이 간결해져서 익숙해지면 코딩을 훨씬 편하게 할 수 있음.

# Babel
- 구 버전 브라우저 중에는 es6의 기능을 지원하지 않는 브라우저가 있으므로 transpiling이 필요
- ES6의 문법을 각 브라우저의 호환 가능한 ES5로 변환하는 컴파일러.

# const & let - 새로운 변수 선언 방식
- 블록 단위 {}로 변수의 범위가 제한되었음
- const :한번 선언한 값에 대해서 변경할 수 없음(상수 개념)
- let : 한번 선언한 값에 대해서 다시 선언할 수 없음.

위 특징들에 알아보기 전에 es5 두가지 특징 리뷰

1) 값 재할당 불가능.
const a = 10;
undefined
a = 20;
VM105:1 Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:3
(anonymous) @ VM105:1
var c = 10;
undefined
c = 20;
20

2) 값은 재할당 가능
let x = 10;
undefined
let x = 20;
VM156:1 Uncaught SyntaxError: Identifier 'x' has already been declared
    at <anonymous>:1:1
(anonymous) @ VM156:1
x = 30;
30


# es5특징 - 1) 변수의 scope(= 범위)
- 기존 자바스크립트는 (es5)는 {}와 상관없이 스코프가 설정됨
var sum = 0;
for (var i = 1; i <= 5; i++) {
	sum = sum + i;
}
console.log(sum);
console.log(i); // global scope에 잡힘 - 자바라면 접근 못함.


# 2) Hoisting
- Hoisting이란 선언한 함수와 변수를 해석기가 가장 상단에 있는 것처럼 인식한다.
- js 해석기는 코드의 라인 순서와 관계 없이 '함수선언식'과 '변수'를 위한 메모리 공간을 먼저 확보한다.
- 따라서, function a()와 var는 코드의 최상단으로 끌어 올려진 것(hoisted)으로 보인다.

function a() { return 6 + 10; } //function statement

var sum = function() {
	// function expression
	return 2 + 2;
}


# 아래의 코드 실행할때 자바스크립트 해석기의 코드 순서 재조정은?
~~~
var sum = 5;
sum = sum+i; <-- 일반적으로 애매모호 하다고 생각되는 부분.
function sumAllNumbers() { 
}

var i = 10;
~~~

#1 - 함수 선언식과 변수선언을 hoisting
var sum;
function subAllNumbers() {
	//..
}
var i;

// #2 - 변수 대입 및 할당
sum = 5;
sum = sum + i;
i = 10;


## es5 - let {} 단위로 변수의 범위가 제한됨
let sum = 0;
for (let i = 1; i <= 5; i++) {
	sum = sum + i;
}
15
console.log(sum);
VM67:1 15
undefined
console.log(i); //Uncaught ReferenceError: i is not defined
    at <anonymous>:1:13
	

## es5 - const 로 지정한 값 변경 불가능
const a = 1o;
a = 20; //XX

하지만, 객체나 배열의 내부는 변경시킬 수 있다.
a.num = 10;
10
console.log(a); //10 
 
const b= [];
b.push(200);

- let 선언한 값에 대해서 다시 선언 불가능
let a = 10 ;
let a = 20 ; xx

* const 는 할당이 다시 안되고, let은 선언이 다시 안된다.

-----
function f() {
	{
	let x;
	{
		// 새로운 블록안에 새로운 x의 스코프가 생김
		const x = "sneaky"
		x = "foo"; //위에 이미 const로 x를 선언했으므로 다시 선언하면 에러가 발생한다.
	}
	// 이전 블록 범위로 돌아왔기 때문에 'let x'에 해당하는 메모리에 값을 대입
	x = "bar";
	let x = "inner"; // uncaught syntaxError: Indentifier 'x' has already been declared
	}
}


## Arrow Function - 화살표 함수
- 함수를 정의할 때 function 이라는 키워드를 사용하지 않고 => 로 대체
- 흔히 사용하는 콜백 함수의 문법은 간결화 함.

//ES5 함수 정의 방식
var sum = function(a, b){
	return a + b;
}

//ES6 함수 정의 방식
var sum = (a, b) => {
	return a + b;
}

sum(10, 20);

// ES5
var arr = ["a", "b", "c"];
arr.forEach(function(value){
	console.log(value);
});

// ES6
var arr = [];
arr.forEach(value => console.log(value)); // a,b,c



# 함수 연습
var arr = [1,2,3];

arr.forEach(function(value) { console.log(value); });
   
arr.forEach((value) => console.log(value); )

# 연습 2
//es5
var sum = function() {
	return 1 + 2;
};

//es6
var multiply = () => {
	return 1 * 2;
};
