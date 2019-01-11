## actions란?
- 비동기 처리 로직을 선언하는 메서드. 비동기 로직을 담당하는 mutations
- 데이터 요청, promise, es6 async과 같은 비동기 처리는 모두 actions에 선언되어 있음.
- ***mutation은 commit을 통해 액션을 호출, actions는 dispatch를 이용해 액션을 호출한다. ***
  
```
// store.js
state: {
  num: 10
},
mutations: {
  doubleNumber(state){
  state.num * 2;
  }
},
actions: {
  delayDoubleNumber(context){ // context로 store의 메서드와 속성 접근
    context.commit('doubleNumber');
}

// app.vue
this.$store.dispatch('delayDoubleNumber');
```  

#### actions 비동기 코드 예제2  
    
```
//store.js
mutations: {
  setData(state, fetchedData) {
    state.product = fetchedData;
  }
},
actions: {
  fetchProductData(context) {
    return axios.get("uri~").then(response => context.commit('setData', response));
  }
}

// App.vue
methods: {
  getProduct() {
    this.$store.dispatch('fetchProductData');
  }
}

```

## 왜 비동기 처리 로직은 actions에 선언해야 할까??
- 언제 어느 컴포넌트에서 해당 state를 호출하고, 변경했는지 확인하기가 어려움
- [그림]여러개의 컴포넌트에서 mutations로 시간차를 두고 state를 변경하는 경우
> 결론: state값의 변화를 추적하기 어렵기 때문에 mutations 속성에는 동기 처리 로직만 넣어야 한다. 
  
  

