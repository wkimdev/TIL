## vue.component와 export default방식의 차이점
- 맨처음 봤던 도큐먼트는 vue.component로 설명을 해주는데, 나는 Vue-cli를 사용해, 싱글 컴포넌트 방식으로 webpack을 이용해 빌드하는 방식을 사용해서 적용할때마다 헤깔렸다. 그래서
정리를 좀 해본다. 
- 많은 Vue 프로젝트에서, 전역 컴포넌트는 Vue.component를 사용해 정의되고, 다음에 모든 페이지의 container 엘리먼트를 대상으로 하는 new Vue({el: '#container'})가 정의
- 이것은 특정 뷰를 향상시키는 용도로만 사용되는 중소 규모 프로젝트에서 유용합니다. 하지만 좀 더 복잡한 프로젝트의 경우 또는 프론트엔드가 JavaScript 기반인 경우 단점이 분명해집니다...  
  
```
- 전역 정의 모든 구성 요소에 대해 고유한 이름을 지정하도록 강요됩니다.
- 문자열 템플릿 구문 강조가 약해 여러 줄로 된 HTML에 보기 안좋은 슬래시가 많이 필요합니다.
- CSS 지원 없음 HTML 및 JavaScript가 컴포넌트로 모듈화 되어 있으나 CSS가 빠져 있는 것을 말합니다.
- 빌드 단계 없음 Pug (이전의 Jade) 및 Babel과 같은 전처리기가 아닌 HTML 및 ES5 JavaScript로 제한됩니다.  

```
- 위 모든 것들은 Webpack 또는 Browserify와 같은 빌드 도구를 이용해 .vue 확장자를 가진 싱글 파일 컴포넌트 로 해결 됩니다.
- Vue cli를 사용하시는 경우는 하나의 .vue 파일이 하나의 독립적인 컴포넌트를 정의 한다고 생각.


## reference
- https://jsdev.kr/t/vue-component-export-default/3696
- https://kr.vuejs.org/v2/guide/single-file-components.html
