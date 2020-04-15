## 8-2. 상세

#### 1) (매개변수) => { 본문 }

#### 2) 매개변수가 하나뿐인 경우 괄호 생략 가능

#### 3) 매개변수가 없을 경우엔 괄호 필수

#### 4) 본문이 `return [식 or 값]` 뿐인 경우 `{ }`와 `return` 키워드 생략 가능

#### 5) 위 4) 에서 return할 값이 `객체`인 경우엔 괄호 필수
  
```
const f = () => ({
  a: 1,
  b: 2
})
```


- 변경 전 
  
```
var b = function (a) {
  return a * a
}
var c = function (a, b) {
  return a + b
}
var d = function (a, b) {
  console.log( a * b )
}
```
  
- 변경 후 
```
var b = (a) => a * a;
  
var c = (a, b) => a + b;

var d = (a, b) => console.log( a * b )

```

