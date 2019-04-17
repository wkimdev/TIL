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
- 그렇기 때문에 === 를 쓴다. type corercion을 피해갈 수 있다. 

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

```
const value2 = '';

// 1. 
if(!value2){
  console.log('no~~~');
}

// 2. 
// if(value2 !== undefined){
//   console.log('비어 있음~~~');
// } 
else {
  console.log('값이 있음~~~');
}

// 1과 2의 차이가 무엇인가. 
// ''과 undefined의 차이 
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
    
    
## typeof, instance of 

typeof는 primitive에서 다 작동

typeof 는 버그가 좀 있다. 

typeof null ==> object ( 고치지 않았지만 버그가 있따. )
typeof {}

instance of를 사용한다. (하지만 primitive에서 작동하지 않는다. )



## 아래부분은 이어서 들어야 겠다. 
console.log(he instanceof array);

const he = [];

// "1"
// true
// undefined
 https://www.youtube.com/watch?v=4UZ9yNitwiw&t=34s

## test util  
- https://repl.it/repls/HilariousClosedDictionary  
  
