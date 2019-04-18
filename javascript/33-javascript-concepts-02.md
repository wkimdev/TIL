## Function Scope, Block Scope and Lexical Scope
- 정리 중.. 
 
```
// 그냥 scope, closer

// global scope
var d = 'x';

// 외부 함수
function outer(){
  var a = 1;
  var b = 'B';
  
  // 내부 함수
  function inner(){
    var a = 2;
    console.log(b); // x
  }
  inner();
}

var someFunc = outer() // outer의 inner를 받는다. 
console.log(someFunc); 

// a 에 무슨 값이 있는지 찾을때가 scope!

// javascript는 '함수단위'로 scope가 존재 (es6는 조금 다름.. )


// 생성한 시점의 scope 값을 가지고 있다. 
// outer가 실행된 다음에도 innser function이 글로벌값과, 아웃터가 끝난 뒤에도 스코프 값을 가지고 있다. 

```  

- 내부 함수에서 외부함수의 지역변수에 접근할 수 있다.  --> 이게 클로저?  
  
## 클로저( Closure ) 
#### case 02  
```
function outter(){
  var a = 'working on';

  // 내부 함수 정의 
  return function(){
    console.log(a);
  }

}

inner = outter();
console.log(inner()); // 이미 outer는 끝났지만 아직 실행 가능하다. 
```
  
#### 실용 예제  (클로저 - private variable)   
- **코드가 커졌을때 아무나 변수를 수정하는걸 방지하기 위해 private variable이 필요하다!!!!**   
- 객체안에 함수가 선언되어 있는 모양
- 메서드들은 내부 함수이고, 객체안에 선언되어 있다. 
- 내부함수를 가지고 있는 외부함수 지역변수에 접근 할 수 있따. 
- 오.. 어렵다.. 고민 안해본건데 ㅜㅜ 내일은 아래것부터 이어서 듣기.. 
- https://www.youtube.com/watch?v=9A0pMrS6Bh0

```
function movie(title){
  return {
    get_title: function(){
      return title;
    },
    set_title: function(_title){
      title = _title
    }
  }
}

g = movie('ghost in the shell');
m = movie('matrix');

console.log(g.get_title());
console.log(m.get_title()); 

g.set_title('공각기공대');

console.log(g.get_title());
console.log(m.get_title());

```



  
## Expression vs Statement
  
  
## Modules and Namespaces
  
  
## Message Queue and Event Loop



## repo
- 생활코딩
- 코드종
- 노마드코더 
