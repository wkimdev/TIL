## router폴더는 routes로
- main.js에서 routes의 index.js를 가져오는 걸로 설정하기. 

## vue-rouete
- 네비게이션을 위해 `router-link` 컴포넌트에 사용한다. 
- 기본적으로 `<router-link>`는 `<a>`태그로 렌더링 된다. 
- **`<router-view>는 현재 라우트에 맞는 컴포넌트가 렌더링 되도록 해준다.`**

#### 작업할때
- 1. api --> 2. store

#### project 구조 설정 
- views : page의 라우팅 관련된 부분만 설정(데이터를 patching~ 패칭하는게 뷰에 있으면 좋지 못한 설계..., 
설계가 추후에 바뀌었을때 유연하게 대응하기 위해선 별도의 컴포넌트에 등록해 데이터를 관리하도록 한다. ) 
- 

### axios
- axios는 promise기반으로 객체반환을 해준다. 

