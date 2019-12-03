## Vuex - 상태 관리 라이브러리
## 복잡한 어플리케이션의 컴포넌트들을 효율적으로 관리하는 Vuex
- vuex 라이브러리의 등장 배경인 flux 패턴
- vuex 라이브러리의 주요 속성인 **state, getters, mutations, actions** 학습
(쉽게, 여태까지 배운걸로 본다면 state=data property, getters=computed, mutations= methods, actions = 비동기 methods)
- vuex를 더 쉽게 코딩할 수 있는 방법인 helper 기능.
- vuex로 프로젝트 구조화 및 모듈 구조화 방법.
- flux패턴과 비슷...

## vuex?
- **무수히 많은 컴포넌트의 데이터를 관리하기 위한 상태 관리 패턴이지 라이브러리.**
- react의 flux 패턴에서 기인함.
- vue.js 중고급 개발자로 성장하기 위한 필수 관문.


## Flux란?
   
![image](https://user-images.githubusercontent.com/32521173/70055759-90f41780-161d-11ea-96bf-98803bd42b9b.png)
      
- MVC 패턴의 복잡한 데이터 흐름 문제를 해결하는 개발 패턴 (단방향 - 이미지!) - unidirectional data flow
- ex) 뷰에선 부모 -> 자식 (props로 데이터 보냄)// 자식 --> 부모 (자식에서 부모에게 데이터를 보낼땐 event발생해서 보냄) //제한함-흐름 제어
   
   

***  
  
- 1. action : 화면에서 발생하는 이벤트 또는 사용자의 입력
- 2. dispatcher : 데이터를 변경하는 방법, 메서드 (dispatcher --> store --> view )
- 3. model : 화면에 표시할 데이터
- 4. view : 사용자에게 비춰지는 화면

## mvc 패턴과 flux패턴 비교  
   
```
- mvn : controller(model과 view를 제어) --> model <===> view  (양방향)
- flux : actions ---> dispatcher ---> model ---> view (단방향)  
```
  
  
#### mvc패턴의 문제점
- 기능 추가 및 변경에 따라 생기는 문제점을 예측할 수 없음.
- 앱이 복잡해지면서 생기는 업데이트 루프  

## flux 패턴의 단방향 데이터 흐름
- 데이터의 흐름이 여러 갈래로 나뉘지 않고 단방향으로만 처리된다.
- 이미지!


## vuex가 필요한 이유?
- 복잡한 어플리케이션에서 컴포넌트 갯수가 많아지면 컴포넌트간의 데이터 전달이 어려워진다.
- 이벤트 버스로 해결? --> 어디서 이벤트를 보냈는지 혹은 어디서 이벤트를 받았는지 알기 어려움.    

```
// login.vue
eventBus.$emit('fetch', loginInfo);

// Lis.vue
eventBus.$emit('refresh', refresAction);
```
  
- 컴포넌트간 데이터 전달이 명시적이지 않음.

# VUEX로 해결할 수 있는 문제
- 1. MVC 패턴에서 발생하는 구조적 오류
- 2. 컴포넌트간 데이터 전달 명시
- 3. 여러 개의 컴포넌트에서 같은 데이터를 업데이트 할 때 동기화 문제

# vuex 컨셉
- state : 컴포넌트 간에 공유하는 데이터 data()
- view : 데이터를 표시하는 화면 template
- action : 사용자의 입력에 따라 데이터를 변경하는 methods  
- ***단방향!!! 이라는걸 기억하기!!!!***

## vuex 구조
- 컴포넌트 -> 비동기 로직 -> 동기 로직 -> 상태(이미지!)


--
