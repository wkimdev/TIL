

## 발생 오류 
- mutations 영역에서 state에 선언한 array 데이터를 호출하는데 undefined 에러가 발생 
- 콘솔로그를 찍어보면 아래처럼 [__ob__: Observer] 하단에 data를 가지고 있기는 하나 array로 인식하지 않는다. (데이터 추출이 안된다) 
  
```
state.playerPanel[0]값 확인 : 
[__ob__: Observer]
0: {…}
1: {…}
2: {…}
3: {…}
4: {…}
5: {…}
6: {…}
7: {…}
8: {…}
9: {…}
```



## 원인 분석
#### 1)  [__ob__: Observer] 이게 무슨 의미 인가? 
- https://stackoverflow.com/questions/57060140/extract-data-from-ob-observer 
  
```
All getters need to be synchronous with no side effects. Yours is asynchronous (using then) and has side effects (assigning state.items). 
Asynchronous activity in the store should be inside actions. The __ob__: Observer just means that Vue is observing that array. 
If the array really does contain the data you think it contains then you'd use it just like any other array.
```
  
#### 2) vuex를 어떻게 사용하고 있었는가 ?
- mutations에서 데이터를 조작하는 로직 중에 api를 비동기로 호출하는 부분이 있었음. 
- 하지만 이는 vuex 컨셉에 맞지 않는다. 문제의 여지가 있음?
- @see: [변이는-무조건-동기적이어야-합니다](https://vuex.vuejs.org/kr/guide/mutations.html#%EB%B3%80%EC%9D%B4%EB%8A%94-%EB%AC%B4%EC%A1%B0%EA%B1%B4-%EB%8F%99%EA%B8%B0%EC%A0%81%EC%9D%B4%EC%96%B4%EC%95%BC-%ED%95%A9%EB%8B%88%EB%8B%A4)
- @see : https://joshua1988.github.io/web-development/vuejs/vuex-getters-mutations/#mutations-%EC%82%AC%EC%9A%A9
  

  - Mutations 이란 Vuex 의 데이터, 즉 state 값을 변경하는 로직들을 의미한다. Getters 와 차이점은

  - 1) 인자를 받아 Vuex 에 넘겨줄 수 있고
  - 2) computed 가 아닌 methods 에 등록
   
  - Mutations 는 동기적 로직을 정의
  - Actions 는 비동기적 로직을 정의
  - Mutations 의 성격상 안에 정의한 로직들이 순차적으로 일어나야 각 컴포넌트의 반영 여부를 제대로 추적할 수가 있기 때문이다.
  
## 해결 방법 
- mutations에서 비동기로 호출하던 로직을 빼고, 비동기 호출 후 데이터를 완전히 다 받아온 시점에서 호출 하도록 변경 중.  
 


