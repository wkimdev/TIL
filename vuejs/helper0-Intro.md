# 각 속성들을 더 쉽게 사용하는 방법 - Helper
- Store에 있는 아래 4가지 속성들을 간편하게 코딩하는 방법  
  
 ```
 - state -> mapState
 - getters -> mapGetters
 - mutations -> mapMutations
 - actions -> mapActions
 
 ```
 - 컴포넌트가 많아질수록 사용하기가 불편해진다. 
 
 
## 헬퍼의 사용법
- 헬퍼를 사용하고자 하는 VUE파일에서 아래와 같이 해당 헬퍼를 로딩한다. 
- ...은 es6의 **object spread operator**이다.  

```
// App.vue
import { mapState } from 'vuex'
import { mapGetters } from 'vuex'
import { mapMutations } from 'vuex'
import { mapActions } from 'vuex'


export default {
  computed() { ...mapState(['num']), ...mapGetters(['countedNum']) },
  methods: { ...mapMutations(['clickBtn']), ...mapActions(['asyncClickBtn']) }
}
    
```
  
## jsbin으로 아래와 같이 테스트 할시..
- 스프레드 연산자로 다른 오브젝트에 접근할 수 있었다~!!
- https://jsbin.com/rocuteyike/edit?html,js,console,output
  
```
let jelly = {
  field: 'web',
  language: 'js'  
};

let developer = {
   nation: 'korea',
   ...jelly
//   field: jelly.field,
//   language: jelly.language
};

console.log(developer);
```





 
 
 
 

