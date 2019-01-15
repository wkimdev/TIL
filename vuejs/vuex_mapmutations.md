## vuex mapMutations
- vuex에 선언한 mutations 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼
- map이라 함은 뷰 속상을 쉽게 연결할 수 있는, 접두어라 생각.
- map~ getter, state, mutations~  
  

```
import { mapMutations } from 'vuex'

// store 에 있는 액션을 가져오게 됨.
// 배열 오퍼레이터로 선언. 
methods: {
  ...mapMutations(['clickBtn']),
  authLogin(){},
  displayTable(){}
}

//store.js
// 아래 메서드로 넘어오게 된다.
mutations: {
  clickBtn(state){
    alert(state.msg);
  }
}

```
  
  
## mapActions
- vuex에 선언한 actions속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼  
  
  
```
// app.vue
import { mapActions } from  'vuex'

methods: {
  ...mapActions(['delayClickBtn']),
}

// store.js
actions: {
  delayClickBtn(context) {
    setTimeout(() => context.commit('clickBtn'), 2000);
  }
}

```  

## 헬퍼의 유연한 문법
- vuex에 선언한 속성을 그대로 컴포넌트에 연결하는 문법  
  
```
// 배열 리터럴
...mapMutations([
  'clickBtn', // 'clickBtn' : clickBtn
  'addNumber' //  addNumber(인자)
])
```

- vuex에 선언한 속성을 컴포넌트 특정 메서드에 연결하는 문법  
  
```
// 객체 리터럴
...mapMutations({
  popupMsg: 'clickBtn' // 컴포넌트 메서드 명 : Store의 뮤테이션 명  
})

```
  





