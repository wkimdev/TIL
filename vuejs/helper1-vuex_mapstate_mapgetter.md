## mapState
- Vuex에 선언한 state속성을 뷰 컴포넌트에 **더 쉽게** 연결해주는 헬퍼  
- spread operator : 기존에 존재하는 computed속성과 mapgetter를 함께 쓰기 위함으로 보자  
   
```
// App.vue
import { mapState } from 'vuex'

computed() {
  ...mapState(['num']) //spread operator
  // num() { return this.$store.state.num; }
}


state: {
  num: 10
}
```

```
<!-- <p>{{ this.$store.state.num }}</p> -->
<p>{{ this.num }}</p>
```

## mapGetters
- vuex에 선언한 getters 속성을 뷰 컴포넌트에 더 쉽게 연결해주는 헬퍼  
- computed랑 같은거지만 store에 존재한다는 차이가 있다. (computed는 component에 존재!) 
  

```
// App.vue
import { mapGetters } from 'vuex'

computed() { ...mapGetters(['reverseMessage']) }

// store.js
getters: {
  reverseMessage(state) {
    return state.msg.split('').reverse().join('');
  }
}
```

