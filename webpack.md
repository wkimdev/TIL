## webpack
- webpack을 통해 해결할 수 있는 기존 문제점  
  (1) 자바스크립트 변수 유효 범위  
  (2) 브라우저별 http 요청 숫자의 제약  
  (3) 사용하지 않는 코드 관리  
  (4) dynamic Loading & Lazy Loading 미지원.
       
  
#### 바벨과 es6 modules 빌드 결과물 분석 - sourcemap
- sourcemap : 빌드전과 빌드 후 코드를 연결해 줌(빌드 이후 난독화된 코드를 확인하기 위해 사용) 
 - `devtool: 'source-map'` 

- live server로 열게 되면 production mode로 빌드할 경우, math.js를 확인할 수가 없다. (app.js만 확인 가능) 
   
```
module.exports = {
	mode: 'none',
  ...
  devtool: 'source-map'
}  
  
```
  

