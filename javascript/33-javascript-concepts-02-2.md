## javascript scope
- variable이 존재하는가 아닌가 ==> 심플 스코프
- 접근할 수 있냐, 없냐 ==> 스코프
- 1. 모두가 가지고 있는 scope ==> global scope
    
```
if(true){
   const hello = "hi";
   console.log(hello);
}  

console.log(hello);
```
    

## best 예시, 
- variable은 큰 곳에서 작은 곳으로 접근 가능하다. 
- 함수는 버블 같다. 이 버블은 부모 버블에 접근 가능하다. (작은 곳에서 큰 곳)
- 하지만 부모 버블은 자식 버블에 접근 못함. (큰 곳 -> 작은 곳)  
  
```
const h = "hello";

function a(){
  console.log(h)
  const b = "b"
}

// a();
console.log(b);
```
  
  
## var 을 사용하지 말아야 하는 이유중 하나
#### 3. 예전에 var 썻을때, var 을 사용하지 말아야 하는 이유중 하나  
   
```
if(true){
  var hell =  "h";
}

console.log(hell);
```  
  
## let, const 둘다 block scope 
    
```
if(true){
  //const hell =  "h";
  let hell =  "h";
}

console.log(hell);
```

    
## example 1
  
```
try{
  
} catch(e){

}
console.log(e); // not work
```

## example 2
  
```
function a(){
  const b ="b";
  function c(){
     const d ="d"; 
     function e(){
       const nn = "nn";
     }
  }
}
```

## scope 공유
#### api에게 hello를 전달해야 할 경우.... 
   
```
let apple;
if(true){
  apple = "hello";
}
console.log(apple);
```
  
  
## reference
- 노마드코더 
