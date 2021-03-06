## 질문 정리하기
#### 지금 이슈가 된 것이 무엇인가?
- npm build시 UglifyJs에서 Unexpected token: name (result) 오류 
   
```
ERROR in static/js/vendor.364dbe9e2be06e50df5d.js from UglifyJs
Unexpected token: name (result) [./node_modules/asn1.js/lib/asn1/base/node.js:282,0][static/js/vendor.364dbe9e2be06e50df5d.js:30971,6]
```
#### 에러를 해석해보자
- node_modules내 설치된 asn1.js패키지내 파일에 예상치 못한 name(result)라는게 있따. 
- 해당 부분의 코드로 찾아들어가면 아래와 같다. 
- 저 부분의 es6 선언이 문제인걸까???  
```
let result = state['default'];
```





#### 이슈가 발생한 환경
- 맥에서 발생. npm과 node버전은 업무용 윈도우pc와 동일한 버전임
- npm: 6.5
- node: 10.15.3

#### 어떤 상황에서 발생하는지
- npm run build-stage시 발생함.
  - build-stage는 `webpack.stage.conf.js` 파일을 참조. (프로젝트 내부 파일)
  
  
#### 어디까지 시도해 봤는지?
#### 기본 개념 서칭 
## Uglify가 뭘까? 
- [Uglify란? UglifyJS is a JavaScript parser, minifier, compressor and beautifier toolkit.](https://github.com/mishoo/UglifyJS)
- Uglify는 ES6를 구문 분석 할 수 없으며 구문 오류가 발생합니다. (es5로 해석할 수 있는 transfiler가 필요-바벨 같은)
- TypeScript를 ES5를 대상으로 설정하거나 생성 된 JS를 babel로 후 처리하거나 다른 축소기를 사용하십시오.
  - 하지만 이미 프로젝트 내부에 babel이 있는데 해당 오류가 왜 발생하지??? 

## webpack Uglify에서 쓰는 uglify? 
- webpack에서는 자바스크립트를 축소,압축 하기 위해 uglify-js를 이용한 플러그인이 있다. 

#### 참고한 stackoverflow 글 
- https://stackoverflow.com/questions/46901443/uglifyjs-webpack-plugin-throws-unexpected-token-name-features

#### 참고한 stackoverflow 글을 바탕으로 서칭 
- [webpack에서 지원했던 uglifyjs-webpack-plugin가 deprecated되어 이제는 terser-webpack-plugin 라는걸 사용하라고 한다.](https://github.com/webpack-contrib/uglifyjs-webpack-plugin)

#### 참고한 stackoverflow 글을 바탕으로 적용 
#### (1) try installing babel-preset-env and adding presets": [ "env" ] to your webpack.config.js or babelrc.
=> 설치 후 적용해보았으나 여전히 오류 발생. 

#### (2) Babelify를 사용해보기
- 시도해보는 중 
- babel 적용이 제대로 된건지 확인하게 위해 이 글을 좀 더 읽어보자 => https://velog.io/@pop8682/%EB%B2%88%EC%97%AD-%EC%99%9C-babel-preset%EC%9D%B4-%ED%95%84%EC%9A%94%ED%95%98%EA%B3%A0-%EC%99%9C-%ED%95%84%EC%9A%94%ED%95%9C%EA%B0%80-yhk03drm7q


#### (3) webpack.optimize.UglifyJsPlugin 를 선언한 방식이 문제일 수도 있다?
=> 변경해보았으나 여전이 오류 발생.         
```
  new UglifyJSPlugin({
      compress: {
            warnings: false,
            drop_console: false
      },
      sourceMap: true
    }),
```
  
#### (4) terser-webpack-plugin를 적용해보기. 
- 적용해봤더니 `TypeError: Cannot read property 'compilation' of undefined` 라는 오류가 발생;; 
   
```
compiler.hooks.compilation.tap(pluginName, compilation => {
                   ^

TypeError: Cannot read property 'compilation' of undefined
    at TerserPlugin.apply (/Users/medialog/lguplus/LG_Uplus_Music_Concert/src/front/node_modules/terser-webpack-plugin/dist/index.js:565:20)
```

- 다시 서칭해보니 webpack4 로 업그레이드 하라는 몇몇 답변을 확인했으나 webpack4로 맘대로 업그레이드 할 수 있는 상황이 아니다;; 
https://stackoverflow.com/questions/49347715/uglifyjs-unexpected-token-error

==> 다운그레이드하래!!! 오마이갓.... 왜 이걸 못 읽었지 

#### (5) uglify-js 3버전으로 변경 적용해보기. 
- package.json에 설치된 ugilfy js는 `“uglify-es”: “^3.1.3”,/` 이었는데 이를 호환이 가능한 uglify-js 3버전으로 변경. 
- 그래도 오류는 여전함.. 

### (6) uglifyjs-webpack-plugin를 다시 설치해서 설정해보기. 
- 아래 글을 참고로 다시 설정
- https://codereviewvideos.com/blog/how-i-fixed-uglifyjs-unexpected-token-name-dropin/
  
```
compiler.hooks.compilation.tap(plugin, compilation => {
                   ^
TypeError: Cannot read property 'compilation' of undefined
    at UglifyJsPlugin.apply (/Users/medialog/lguplus/LG_Uplus_Music_Concert/src/front/node_modules/uglifyjs-webpack-plugin/dist/index.js:328:20)
```
  




