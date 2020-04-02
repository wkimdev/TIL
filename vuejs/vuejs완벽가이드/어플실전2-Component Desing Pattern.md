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


