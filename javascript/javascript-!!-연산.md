## !! 연산
- 0, null, undefined 등과 같이 정의되지 않는 변수들을 강제 변환하여 정확한 논리 결과인 ture/false를 만들어 return해준다. 
- 애매한 변수들을 정확한 논리 결과의 표현을 원할때 사용 가능. 

- example
```
let a = 0;
console.log(a);   // 0
console.log(!a);  // true
console.log(!!a); // false
 
let b = null;
console.log(b);   // null
console.log(!b);  // true
console.log(!!b); // false
 
let c = undefined;
console.log(c);   // undefined
console.log(!c);  // true
console.log(!!c); // false


출처: https://nopanic.tistory.com/5 [당황하지않고_프로그래밍]
```

- 예제
```
!!false === false
!!true === true
 
!!0 === false
!!parseInt("foo") === false // NaN은 false
!!1 === true
!!-1 === true  // -1 는 true
 
!!"" === false // 빈 문자열은 false
!!"foo" === true  // 일반 문자열은 true
!!"false" === true  // false라는 문자열도 true
 
!!window.foo === false // 정의 되지 않은 변수는 false
!!null === false // null은 false
  
!!{} === true  // 빈 객체는 true
!![] === true  // 빈 배열은 true


출처: https://nopanic.tistory.com/5 [당황하지않고_프로그래밍]
  
```
  
  
- 아래같은 처리  
- NativeLayout를 실행하기 위해 player에 true 혹은 false를 실행시킨다는 것 같은데.. ㅜㅜ .. 이해가 잘 안간다..  
    
```
  native
        .executeAsync(
          'ShowNativeView',
          JSON.stringify({
            isTitle: !!titleContext,
            isPlayer: !!playerContext
          })
        )
        .catch(e => {
          console.error(e)
        })
```
  
- https://nopanic.tistory.com/5
