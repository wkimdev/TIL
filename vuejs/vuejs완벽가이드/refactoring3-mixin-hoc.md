- spinning같은걸 **eventbus** 로 주고받기.
- 스피닝이 어디까지 돌것인가 한번 고민. 
- eventbus 같은 경우 beforeDestory에서 종료 시켜야 함
  - 이벤트 객체가 쌓였기 기때문에(on) 컴포넌트의 종료시점에서 off시켜야 한다. 


#### 어떤 시점에서 종료되는지 확인 
- network latency 설정해서 확인 

## 하이 오더 컴포넌트
- 컴포넌트를 재사용하기 위한 기술 
- referenec : https://reactjs.org/docs/higher-order-components.html
- 함수형, 컴포넌트 훅, 재사용.. 
- render() 함수

## Mixins
- 재사용로직을 컴포넌트에 넣는다. 
- 컴포넌트 옵션에 mixins에 넣는다
- 스피너나 다이알로그 모달 키고 닫는것들을 여기로 빼면 효율이 좋아진다. 
  
## mixin vs HOC
- HOC 단점... : 컴포넌트 레벨이 높아지면,컴포넌트간 통신하는데 불편해 질 수 있다? 
