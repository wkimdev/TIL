## 프로젝트 구조화와 모듈화 방법1
- 아래와 같은 store구조를 모듈화 하는 방법?
- 힌트! Vuex.Store({ })의 속성을 모듈로 연결 

```
// store.js
import Vue from 'vue'
import Vue from 'vue'

export const store = new Vuex.Store({
 state: {},
 getters: {},
 mutations: {},
 actions: {}
})

```

- 1. 파일로 분리해서 모듈화 


## Modules - 자바스크립트 모듈화 방법
- 모듈, 덩어리
- 재사용성이 뛰어난 녀석들을 묶어서 사용
- 자바스크립트 모듈 로더 라이브러리(amd, commons js)기능을 js언어 자체에서 지원
- 호출되기 전까진 코드 실행과 동작을 하지 않는 특징이 있다.
- 변수 충돌에 있어 좀더 안정성을 제공..
- export, import

## vue.js 에서 마주칠 default export
 - 스캐폴딩..
 - 템플릿, 스크립트, 스타일
 - 스크립트에서 exprot, export defualt function(x) {}
 - 한개의 파일에서 하나만 export되는 것.
 - 인캡츌, 모듈화,
 - 사용할때 원하는 이름을 부여해줄 수 있다.  
   
 ```
 // 같은 lib를 다른 이름으로 사용가능
 - import util from 'util.js'
 - import log from 'util.js'
 ```
 
 

