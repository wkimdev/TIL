# 
# Vue Loader
- .vue 형태의 파일을 javascript 모듈 형태로 변환해주는 webpack Loader
- 한 파일안에 html, css, javascript를 다 가져와서 component에 등록되는 순간,

- webpack.config.js
- 여기서 모듈 번들링을 해주게 된다.
- 이걸통해 build.js가 번들링을..

- vue loader 로 얻게 되는 장점
    - es6 지원
    - <style>과 <template>에 대한 각각의 webpack loader 지원. ex) sass, jade
    - 각 .vue 컴포넌트의 스코프로 좁힌 css 스타일링 지원.
    - webpack의 모듈 번들링에 대한 지원과 의존성 관리가 제공.
    - 개발 시 hot reloading 지원. //바로바로 반영됨..

Vue 고급으로 레벨업
Vue Reactivity System
Render Function
State Management, Vuex 튜토리얼
Server Side Rendering



# Single File Component with JSX(ES6)
- 앱의 복잡도가 증가할 때, .vue 라는 파일 단위 안에 html, js, css를 관리할 수 있는 방법.
* 복잡도가 커짐에 따라 야기될 수 있는 문제들
<싱글파일 컴포넌트 적용을 해야 하는 이유>
2. css 
3. es5를 이용하여 계속 앱을 작성할 경우, babel 빌드가 지원되지 않음
- es5만 사용하는 경우 single file component의 혜택을 볼 수 없음. 
(내가 지금 es5만 쓰고 있지.. ㅠㅠ)


# Vue Development workflow
- vue cli로 간단한 webpack 설정이 되어 있는 프로젝트 생성이 가능

npm install -global vue-cli
vue init webpack-simple (입문자용 /webpack은 좀더 전문가용 - 잘 아는 사람들 사용 추천)
npm install
npm run dev

```
export default {
    // 이 안의 내용은 모두 vue instance 에 포함되어 생성된다.
}

```
- webpack에서 지원하는 서버를 통해 웹어플을 실행할 수 있는 것임.
- 'pwa'도 웹개발자로서 알아두면 좋다고 한다..

# es6 참조 강의
- https://babeljs.io/docs/en/learn/#ecmascript-2015-features-modules

