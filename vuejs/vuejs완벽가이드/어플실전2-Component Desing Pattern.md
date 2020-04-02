# Component Design Patterns 
  
```    
1. Common - 기본적인 컴포넌트 등록과 컴포넌트 통신  
2. Slot - 마크업 확장이 가능한 컴포넌트
3. Controlled - 결합력이 높은 컴포넌트 (써드 파티, 체크박스 같은걸 만들때 유용. 하위 상위 컴포넌트 밀착 형태 구현) 
4. Renderless - 데이터 처리 컴포넌트 
```
 
#### 1. Common
- App.vue상위 컴포넌트에서 하위 컴포넌트로 내려옴. 
- 이벤트는 $emit("evnet")형태로 상위 컴포넌트에 요청함.  
- 기본적인 vuejs data호출 플로우를 따름.  
* props validation 
  
  
#### 2. Slot
- 하위 컴포넌트에 데이터 의존성이 사라진다. 
- 그래서 왜 쓰냐????
  * 확장이 가능해서 유용하다(버튼, 이미지, style 을 상위 컴포넌트에서 추가해서 확장 해서 쓸 수 있다. ) 
  
  
#### 3. Controlled
- 직접 이름 붙이신 것.. Controlled Component - Input박스를 다룰때 생기는 문제 점 
- checkbox컴포넌트를 만듬..=> 컴포넌트를 세밀화 할 경우 아래처럼 인풋박스같은 것 까지 분리하게 될 수 도 있음
- 진행대로 하면 아래 에러가 발생함. 
  
```
[Vue warn]: Avoid mutating a prop directly since the value will be overwritten whenever the parent component re-renders. Instead, use a data or computed property based on the prop's value. Prop being mutated: "checked"
```
  
- 하위 컴포넌트에서 상위 컴포넌트로 받는 props 데이터를 바꾸려다보니 발생한 문제. 
- 컴포넌트와 의존성 분리 => 결합력 높은 컴포넌트로 만들기 (캘린더, 모달,, 간단한 입력폼 세부적인 컴포넌트로 쪼갤때/만들때 유용)


#### 4. Renderless Component 
- 표현을 하지 않는 컴포넌트 => script만 있는 컴포넌트!!! 
  * (프로젝트에 있었는데 이게 이런 원인이 있었구나.. => MIMSContentBase같은 것)

## render function
- https://vuejs.org/v2/guide/render-function.html#ad
- vuejs에서 돌아가는 render() 
- live server load?
  
```
render: h => h{App} // virtual dom을 지칭하는 용어 -하이퍼 스크립트
```





