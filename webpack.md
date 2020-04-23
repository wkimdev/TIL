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
  
#### 웹팩의 주요 속성 4가지
- mode가 3과 4의 차이

#### entry
- 진입점
- 변환, 빌드, 컴파일, 번들링 => 같은 말 

#### output
- 결과물
- 웹팩을 돌리고 난 결과물의 파일 경로를 의미. 
- Output 파일 이름 옵션을 지정할 수 있다. 예를 들어 아래처럼 지정하면, 해시 값을 붙여 생성해 사용자가 새로고침을 하지 않더라도(캐시 되지 않도록) 설정해 준다. 
   
```
module.exports = {
  output: {
    filename: '[chunkhash].bundle.js'
  }
};
```
  
#### loader
- 자바스크립트 파일이 아닌 웹자원(html, css, image, font 등)들을 변환할 수 있도록 도와주는 속성. 

#### 실습 ing
- 두 번째 튜토리얼 - 로더가 없는 경우의 에러 확인과 css 로더 적용
- javascript안에 css가 들어갈 수 없다. 
- 빌드 후 에러는 안났지만, 왜 p tag에 style이 적용되지 않았을까?? next episode... 

#### plugin
  
## 출처
- 인프런 webpack 캡틴판교~
  
