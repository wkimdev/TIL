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


