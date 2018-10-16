## enhanced Object Literals - 향상된 객체 리터럴
- 객체의 속성을 메서드로 사용할때 function 예약어를 생략하고 생성 가능
```
var dictionary = {
	words: 100,
	// es5
	lookup: function(){
		console.log('this is es5~');
	},
	// es6
	lookup() {
		console.log('this is es6~');
	}
};

```

## 객체의 속성명과 값 명이 동일할 때 아래와 같이 축약 가능
```
var figures = 10;
var dictionary = {
	// figures: figures,
	figures
}

```


## Modules - 자바스크립트 모듈화 방법(이걸 왜 쓰는지 고민)
- 자바스크립트 모듈 로더 라이브러리(AMd, Common Js)기능을 js 언어 자체에서 지원
- 재사용 기능이 뛰어난 기능을 묶어서 필요할때만 가져다 쓰는 기능
- 호출되기 전까지는 코드 실행과 동작을 하지 않는 특징이 있음

```
// libs/math.js
export function sum(x, y) {
	return x + y;
}

export var pi = 3.1415;

// main.js
import {sum} from '';
sum(1,2);

```

- vue.js 에서 마주칠 default export
- default : 한개의 파일에서 하나만 export 된다.


```
// util.js
export default function (x) {
	return console.log(x);
}

// main.js
import util from 'util.js';
console.log(util); //function (x) {}
util("hi");


// app.js
import log from 'util.js';
console.log(log);
log("hi");

```


