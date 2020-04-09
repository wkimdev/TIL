#### javascript 메서드
- 객체 프로퍼티에 할당된 함수를 메서드(method) 
- 객체의 프로퍼티에 함수를 할당해 객체에게 행동할 수 있는 능력을 부여해준다. 

```
let user = {
  name: "jelly",
  age: 30
};

user.sayhi = function() {
  alert('hello!')
}

user.sayhi(); // hello!
```


