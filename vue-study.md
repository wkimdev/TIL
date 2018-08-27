## vue.js
- Vue insance 라이프사이클 초기화
- 뷰 객체가 생성될때 아래의 초기화 작업을 수행한다.
- 데이터 관찰
- 템플릿 컴파일
- DOM에 객체 연결
- 데이터 변경시 DOM 업데이트

- 라이프사이클 단계에 따라 아래 메서드를 사용할 수 있다.
- mounted
- updated
- destroyed

## vue components
- 화면에 비춰지는 뷰의 단위를 쪼개어 재활용이 가능한 형태로 관리하는 것이 컴포넌트.
- 컴포넌트 : 화면의 한 단위.

## ESLint
- code validation 설치 --> 기본적으로 할거면 안해도 됨.



## vue cli로 간단한 webpack 설정이 되어 있는 프로젝트 생성이 가능하다.
- 아래의 절차로 설치하면 프로젝트 기본 구조가 만들어진다.

```
npm install -global vue-cli
vue init webpack-simple
npm install
npm run dev

export default {
}
```
- webpack 에서 지원하고 있는 서버를 통해, 우리 서버에 간단한 서버를 띄운 것.
- webpack을 해비하게 쓰지 않은 경우라면 webpack-simple 사용을 지향.

# browserfy-simple
- webpack 번들러~
- PWA도 웹개발 트랜드????






