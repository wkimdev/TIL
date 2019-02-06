# this
- javascript 는 기본적으로 전역으로 this를 사용...
- 브라우저, 윈도우 객체 10 



# this 1
- 브라우저, 윈도우 객체 10 
- var a = 10;

# this 2
- 아래처럼 function내에서 사용할 경우에도 전역객체를 가리킴
- es6에서 이런것들을 방지하기 위해 use stricts 가 있음... 

```
function sum(a, b){
  console.log(this) // 전역을 가리킴 
  return a+B;
}
```

# this 3
- 인스턴스 생성 후 호출할 경우의 this

```
function sum(a, b){
  console.log(this) // 전역을 가리킴 
  return a+B;
}

function Vue(el){
  console.log(this);  // 여기선 생성자 함수를 가리킴
  this.el = el;
}

new Vue('#app');
```

## this 4
- 비동기 처리에서의 this
- 비동기 호출
- es6로 하면 호출되는 애의 this를 가져온다. 
- api사용 할때마다 바인딩을 해줘야 하는 번거로움을 줄이기 위해 화살표를 쓰게 된다. 
- 컴포넌트에서 사용하는 this를 그대로 가져다 쓸 수 있으니까 사용한다. 
- 화살표 함수를 쓰게 되면 기본적으로 컴포넌트를 가리키는 this를 그대로 가져다 쓸 수 있게 된다. \\\
