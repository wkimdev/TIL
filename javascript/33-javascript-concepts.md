# javascript type
- javascript은 primitive type, obejct type으로 나뉜다. 

## primitive values
- 오브젝트를 제외한 모든 값은 **변경 불가능한 값(immutable value)이다.**  
- 특히 c언어와는 다르게도, **문자열은 불변값(immutable)이다.**  

## 1. 상수
- 아래 세가지 타입은 상수이므로, 이것들로 다른 오브젝트를 표현할 수 없다. 
  
#### boolean  
- true, false   
  
#### Null 
- null type은 딱 한가지 값인 null을 가질 수 있다.   
  
#### Undefined
- 값을 할당하지 않는 변수는 `undefined`값을 가진다.  

## 2. Number
## 3. String
- C 같은 언어와는 다르게, 자바스크립트의 문자열은 변경 불가능 (immutable) 하다. 
- 이것은 한 번 문자열이 생성되면, 그 문자열을 수정할 수 없다는걸 의미한다. 
- 그러나 원래 문자열에서 일부가 수정된 다른 문자열을 만드는건 가능  

## 4. symbol
- es6에서 추가됨. 
- 유일하고 변경 불가능한 (immutable) 기본값(primitive value) 이다. 

  
## object type
- 객체는 식별자(identifier)로 참조할 수 있는, 메모리에 있는 값이다. 
- javascript에서 객체는, 속성(properties)를 담고있는 가방(collection)으로 볼 수 있다. 
- 속성값은 객체를 포함해 어떠한 자료형도 될 수 있고, 그 덕분에 복잡한 데이터 구조를 형성하는게 가능해 진다. 
- 속성은 key 값으로 식별된다. 
- **키값은 string 이거나 symbol값이다.**  


#### Dates
#### Arrays
#### WeekMaps, Maps, Sets
#### TypedArrays
  


## Value Types and reference  

```
let a = 50;
let b = a; // <-- whats on a? b는 a값을 카피해서 넣는다. (NOT reference)
a = 10;  
``` 
  
```  
const apple = ["nan", "bada"]; // 메모리에 있는 배열을 참고하고 있다. 
const banana = apple; // 배열을 참조하는 애를 바라보고, 동일한 배열을 참조하게 된다. 

apple.push("hello"); // this is reference , 해당 배열을 참조하게 된다. 
banana.push("buy");
```  
  

## 그렇기 때문에 아래의 경우!!!

  
```
console.log([10] === [10]) // 이 둘은 각각 메모리에 위치한 각기 다른 오브젝트. // false

const x = {
  a: 'hhello'
}
const b = x;

b.a = 'gigigi';
```  


- // array, object, function ==> reference

---
# 4. Type Coercion --> conversion (javascript가 강제로 값을 변경시킨다.)
- 아래 결과값들을 추측해보자. 
  
```
console.log(4+"hello");
console.log(4+4+"hello");
console.log("" == true); // 이건 null도 아니고 값도 없는거 아닌가 
console.log(1 == true); // true?
console.log(66 + true); // true를 1로 변경시킴
console.log(66 + false); // false 0 
```

- '+' 가 덩어리로 만든다 (loaded operator?)
- 왼쪽에서 오른쪽으로 읽는다. `console.log(10+66+"false") // "76false"  ` 
- console.log(25 - "1") // 이게 된다닝!
- 텅빈 STRING은 거짓이다... 텅빈 string은 0바이트. 그걸 0으로 변환시킨다.  

```
console.log(0 == true); // javascript에서 0은 false... 
```  
  
```  
console.log("1" == 1);  // true
console.log("1" === 1); // false : ===를 사용하면 type conversion이 일어나지 않는다. 
```  

```
console.log("true" == true); // false
```  

- `==`이 boolean을 만나게 되면 숫자로 변환된다. 즉, true가 1이 되고, 또한 앞의 string을 숫자로 변환하려 한다. 
- 하지만 아래처럼 string true는 숫자로 변경되지 않는다. 
   
```
console.log(parseInt("true")) // NaN
```  
  
- 그래서 NaN ==1 을 하려고 해서 이상한 것이다. 
- 그렇기 때문에 === 를 쓴다. type corercion을 피해갈 수 있다.  **생각해볼 점

## double equal은 몇 가지 복잡한 문제를 해결할 수 있는 사례. 
- 무조건 트리플 equal가 능사는 아닐 수 도 있다. 상황에 따라 전략적으로 사용해야 함... 
http://adripofjavascript.com/blog/drips/equals-equals-null-in-javascript.html
  
```
var ethos = {
    achilles: "glory",
    aeneas: "duty",
    hades: null // Beyond human understanding
};

function printEthos (name) {
    if (ethos[name] != null) {
        console.log(ethos[name]);
    } else {
        console.log(name + " has no recorded ethos.");
    }
}

ethos.pythagoras = 0;

printEthos("pythagoras"); // 0 
```
  



#### 내가 자주 헤깔리는 부분  
```
const hello = "";

// 1. 
if(hello){
  console.log('test'); 
}
// 결과 undefined

// 2. 
// if(typeof hello !== undefined){
//   console.log('apple');
// }
// 결과 apple
```
## undefined 
- undefined는 값이 할당되지 않은 javascript primitive type이다.
  
## ''의 type
- 텅빈 STRING은 false이다... 텅빈 string은 0바이트. 그걸 0으로 변환시키게 되고 false를 리턴하게 된다. 

- 두 타입을 잘 비교하라.  
  
---
    
```
// const x;
const y = '';

//console.log(typeof y);
// if (typeof x === 'undefined') {
//    // 이 문이 실행됨
//    console.log('test~');
// }
if(typeof y === string){
  console.log('test2~'); // ReferenceError: string is not defined./.. 이런 에러가 왜 나지..... 
}

```

#### 그래서 빈값 체크는 어떻게 하지?
- 자바스크립트에서 false로 반환되는 값은
- `"", null, undefined, 0, NaN`, 나머지는 모두 true이다. 
  
```
if('' || null || undefined || 0 || NaN){
  // ...
}else{
  console.log("여기가 실행");
}

```

- 위의 경우 이외에도, 빈 배열 ([]), 빈 객체({})가 있을 수도 있다. 그럴 경우 아래처럼 처리한다. 
  
```
//[], {}도 빈값으로 처리한다. 

function isEmpty(value){
  if( value == "" || value == null || value == undefined || (value != null && typeof value == "object" && !Object.keys(value).length )){
    return true, 
  } else {
    return false;
  }
}
```
    
    
## typeof, instance of 
- typeof와 거의 동일하지만 primitive에서 작동하지 않는다.(string, boolean, number)
- console.log(typeof(undefined)); // works

#### typeof 는 버그가 좀 있다!
- `typeof null ==> object ( 고치지 않았지만 버그가 있따. )`
- typeof {}  
    
```
console.log(typeof []); // object
console.log(typeof {}); // object
console.log(typeof null); // object
  
```
  

#### instance of 
```
console.log([] instanceof Array); // true
console.log({} instanceof Object); // true

// primitive type.. 
// "1"
// true
// undefined
console.log("" instanceof String) // false
console.log(true instanceof Boolean) // false

```
 



## test util  
- https://repl.it/repls/HilariousClosedDictionary  
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Data_structures    
- 출처: https://sanghaklee.tistory.com/3 [이상학의 개발블로그]
