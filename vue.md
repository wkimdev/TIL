# vue.js
- PWA 기반, single page app 을 제작하기 위한, 화면 앞단 라이브러리 Vue.js.
- PWA : Progressive Web Apps 의 약자. 관련 내용은 https://joshua1988.github.io/web-development/opinions/where-are-we-and-where-are-we-heading/ 참고
- vue의 주요 구성요소(component, router, resource, templates)


# mvvm 패턴?
- 화면 앞단의 화면 동작 관련 로직과 뒤단의 디비 데이터 처리 및 서버 로직을 분리하고, 
- 뒷단에서 넘어온 데이터를 model에 담아 view에 담아주는 중간지점.


# vue instance
- vue 인스턴스 생성자가 필요하다.
- vue 생성자로 인스턴스를 만드는 방법  
- vue 객체를 확장하여 재사용이 가능하다. 컴포넌트 사용을 권장한다.

~~~
var vm = new Vue({
    template:..., // 화면에 나타나는 요소들 dic, tag
    el:..., 
    methods : {

    },
    created : {

    }
    // ...
})

// vue 객체를 확장하여 재사용이 가능하다.
var MyComponent =  Vue.extend({
    //
})
~~~



v-on : directive
v- : directive

# 설치

# java와의 연동 how?

# 그래서 vue애서 api 어떻게 불러올지?

사용자 정의 엘리먼트와의 관계
Vue 컴포넌트는 Web Components Spec의 일부인 사용자 지정 엘리먼트 와 매우 유사하다는 것을 눈치 챘을 수 있습니다. Vue의 컴포넌트 구문은 스펙 이후 느슨하게 모델링 되었기 때문입니다. 예를 들어 Vue 컴포넌트는 Slot API와 is 특수 속성을 구현합니다. 그러나 몇가지 중요한 차이가 있습니다.

Web Components Spec은 여전히 초안이며 모든 브라우저에서 기본적으로 구현되지 않습니다. 이에 비해 Vue 컴포넌트는 지원되는 모든 브라우저 (IE 9 이상)에서 폴리필을 필요로 하지 않으며 일관되게 작동합니다. 필요한 경우 Vue 컴포넌트는 기본 사용자 정의 엘리먼트 내에 래핑할 수 있습니다.

Vue 컴포넌트는 일반 사용자 정의 엘리먼트에서 사용할 수 없는 중요한 기능을 제공합니다. 특히 컴포넌트 데이터 흐름, 사용자 지정 이벤트 통신 및 빌드 도구 통합이 중요합니다.

- 최신 안정 버전: 2.5.16
- Vue로 대규모 응용 프로그램을 빌드할 때 NPM을 권장

# 최신 안정화 버전
$ npm install vue

# vue-cli 방식과. vs vue- 스크립트 임베디드 방식.

# webpack? --> vue에서 제공하는 템플릿? --> 이걸로 설치함.

# vue에서 제공하는 여러가지 템플릿 이란? 

# npm run dev
- 컴파일, ESLint 과정을 거치고 로컬서버로 페이지를 실행시켜준다(http://localhost:8080/)
- 코드 수정후 저장하면 ESLint, hot-reload 동작(변경된 상태만 변경)
- Source maps 설정

# 어떻게 프로젝트를 구성하고, 어떻게 설계를 해서 어떻게 자바와 연동하고 , 빌드하고, 배포해야 하나???....

# vue의 라이프사이클
- creation, mounting, updating, destruction





