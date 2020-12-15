## 질문 정리하기
#### 지금 이슈가 된 것이 무엇인가?
- npm build시 UglifyJs에서 Unexpected token: name (result) 오류 
   
```
ERROR in static/js/vendor.364dbe9e2be06e50df5d.js from UglifyJs
Unexpected token: name (result) [./node_modules/asn1.js/lib/asn1/base/node.js:282,0][static/js/vendor.364dbe9e2be06e50df5d.js:30971,6]
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
- Uglify는 ES6를 구문 분석 할 수 없으며 구문 오류가 발생합니다. 
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






