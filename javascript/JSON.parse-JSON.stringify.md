## JSON.parse()
- **JSON 표기법이 포함 된 문자열** 을 "Javascript 객체로 변환하는 데 사용"
- "[object Object]"값은 유효한 JSON이 아닙니다. 
-  **JSON 문자열의 구문을 분석** 하고, 그 결과에서 JavaScript 값이나 객체를 생성.    
  
```  
 
var json = '{"result":true, "count":42}';
obj = JSON.parse(json);

console.log(obj.count);
// expected output: 42

console.log(obj.result);
// expected output: true

```  

  
  


## JSON.stringify()
- **JavaScript 값이나 객체를** "JSON 문자열"로 변환.  
  
```  
console.log(JSON.stringify({ x: 5, y: 6 }));
// expected output: "{"x":5,"y":6}"

console.log(JSON.stringify([new Number(3), new String('false'), new Boolean(false)]));
// expected output: "[3,"false",false]"

console.log(JSON.stringify({ x: [10, undefined, function(){}, Symbol('')] }));
// expected output: "{"x":[10,null,null,null]}"

console.log(JSON.stringify(new Date(2006, 0, 2, 15, 4, 5)));
// expected output: ""2006-01-02T15:04:05.000Z""
```   

  
  
## 헤깔리지 말자!
- 배열은 객체 [] --> Object 
- JS, Javascript Object ==> ?

## javascript
#### javascript 자료형
- 1) 동적 타이핑 : 타입은 프로그램의 처리 과정에서 자동으로 파악됨  
  
```
var foo = 42;    // foo 는 이제 Number 임
var foo = "bar"; // foo 는 이제 String 임
var foo = true;  // foo 는 이제 Boolean 임

```
  
- 2) 데이터 타입
  * 기본 자료형 : Primitive type (boolean, Null, Undefined, Number, String, Symbol(ecmaScript6)  
  * Object   

- 2-1) 기본 타입 (Primitive values)  
  * 오브젝트를 제외한 모든 값은 변경 불가능한 값 (immutable value)   
  * boolean : true/false
  * Null : null 타입은 딱 한가지 값, null을 가질 수 있다. 
  * Undefined 타입 : 값을 할당하지 않는 변수는 undefined값을 가진다. 
  * ==> 이 세 가지 타입은 상수이므로, 이것들로 다른 오브젝트를 표현할 수 없다.  
  * Number : 정수만을 표현하기 위한 특별한 자료형은 없다. ( Number 타입은 세 가지 의미있는 몇가지 상징적인 값들도 표현할 수 있다. 이 값에는 +무한대, -무한대, and NaN (숫자가 아님)이 있다.)  
  * String : 자바스크립트의 String 타입은 텍스트 데이터를 나타내는데 사용한다. C 같은 언어와는 다르게, 자바스크립트의 문자열은 변경 불가능 (immutable) 하다. 그러나 원래 문자열에서 일부가 수정된 다른 문자열을 만드는건 가능하다. 예를 들자면 이렇다.(아래 예시)  
  * Symbol 은 ECMAScript 6 에서 추가되었다. Symbol은 유일하고 변경 불가능한 (immutable) 기본값 (primitive value) 이다. 또한, 객체 속성의 key 값으로도 사용될 수 있다 (아래를 볼 것). 몇몇 프로그래밍 언어에서는 Symbol을 atom 이라고 부른다.   
  
```
  
- 원래 문자열에서 각각의 글자를 추출하거나 String.substr()을 사용해서 만든 부분 문자열
- 접합 연산자 (+) 나 String.concat() 으로 두 문자열을 합친 문자열  

```
  
  
- 2-2) 객체 (Objects)
- 컴퓨터 과학에서, 객체는 식별자 (Identifier) 로 참조할 수 있는, 메모리에 있는 값이다.
  * properties 속성 => 데이터 속성, 접근자 속성 
  * "Normal" objects, and functions 
  * Dates : 시간을 나타낼때 data utility를 사용한다. 
  * Arrays : 배열(arrays)은 정수키를 가지는 일련의 값들을 표현하기 위한 오브젝트. 배열 오브젝트에는 길이를 나타내는 'length'란 속성도 있다. 배열은 Array.prototype을 상속받으므로 배열을 다룰 때 편한 indexOf (배열에서 값 검색)와 push (새로운 값 추가) 같은 함수를 사용할 수 있다. 배열은 리스트나 집합을 표현하는데 적합하다!!!! 
  * WeakMaps, Maps, Sets : 표준이 아니지만 ECMAScript 6에서 표준이 될 것 같다. 이 자료형들에서는 키가 문자열 뿐만 아니라 오브젝트도 될 수 있다. 
  * TypedArrays  

  
- 
- JavaScript는 세 가지 다른 값 비교 연산을 제공합니다: ===를 사용한 엄격한(strict) 같음, ==를 사용한 느슨한(loose) 같음 및 Object.is() 메서드.


## javascript, 그리고 prototype?


## 참고
- https://stackoverflow.com/questions/14432165/uncaught-syntaxerror-unexpected-token-with-json-parse
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Data_structures


