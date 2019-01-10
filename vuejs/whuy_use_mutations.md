## 왜 Mutations로 상태를 변경해야 하는가?

#### state는 왜 직접 변경하지 않고 mutations로 변경할까?
- 여러 개의 컴포넌트에서 아래와 같이 state 값을 변경하는 경우 **어느 컴포넌트에서 해당 state를 변경했는지 추적하기가 어렵다.** 
  
```
methods : {
  inceaseCounter() {this.$store.state.counter++}
}
```
  
- 특정 시점에 어떤 컴포넌트가 state를 접근하여 변경한건지 확인하기에 어렵기 때문
- 따라서, 뷰의 반응성을 거스르지 않게 명시적으로 상태 변화를 수행. 반응성, 디버깅, 테스팅 혜택. 

* vuex 구조 유념
