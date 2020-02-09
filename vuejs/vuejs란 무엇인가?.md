# vuejs란 무엇인가?
- 업무 중에 vuejs를 사용하고 있는데, 얼마전 다른 프레임웍과 비교했을때 vuejs의 사상이 무엇인가?라는 질문에 꿀먹은 벙어리가 되었었다. 
반성하는 마음으로 vuejs에 대한 공부를 다시 해본다. 

## vuejs란?
- vue.js는 (이하 '뷰'로 약칭) 웹 페이지 화면을 개발하기 위한 프런트엔드 프레임워크 이다.
- 뷰는 화면단 라이브러리이자 프레임워크라고도 볼 수 있다. 
- 점진적인 프레임워크로서의 뷰의 의미(아래 이미지 참고)  
![image](https://user-images.githubusercontent.com/32521173/69494518-1aaa3380-0f00-11ea-9e35-75519e628ade.png)  
  
(위 그림은 Vue의 창시자인 에반 유가 2017년 Vue.js 컨퍼런스에서 발표한 내용 중에 있는 그림)

- 뷰 코어 라이브러리는 화면단 데이터 표현에 관한 기능들을 중점적으로 지원하지만, 
프레임워크의 기능인 `라우터,상태관리,테스팅` 등을 쉽게 결합할 수 있는 형태로도 제공해준다. 
  * 즉, 라이브러리 역할뿐만이 아닌 프레임워크 역할도 할 수 있다는 의미 
- 그래서 공식사이트에선, 뷰를 점진적인 프레임워크(progressive framework)라고 부르고 있다. 

## 프레임워크 시장 속에서 뷰의 위치와 성장성
- 프런트엔드 프레임워크 시장은 `리액트(React)`와 `앵귤러(Angular)`가 높은 점유율을 차지 하고 있다. 
  * 상대적으로 오래되고, 이미 많은 기업에서 해당 프레임워크로 구축을 해 서비스를 하는 상태 
- 구글에서 일하던 에반유는 앵귤러의 데이터 바인딩 방식과 돔(dom)에 직접 접근하지 않고도 데이터를 표현하는 방식에 흥미를 느꼈지만,
앵귤러를 이해하기 위해선 방대한 크기의 프레임워크 구조를 이해해야 했기 때문에 큰 부담을 느꼈어야 했다고 한다. 
- 그래서 에반은 앵귤러의 명시적 데이터 바인딩과 같은 필수적은 요소들만 가지고 화면을 구성하기 시작했고, 오픈소소화를 하면서 뷰를 탄생시켰다@!
- 2014년 2월 뷰는 공식 배포
- 하지만 시장 점유율은 기존의 프레임워크에 비해 상대적으로 낮은 편 
- 그래도 배포이후 꾸준히 인기를 얻는중 현재 기준으로(2019년 11월) 깃허브 리포지터리 별 갯수 `153k!` 

##  뷰의 장점
 1. 낮은 러닝커브
 2. 리액트와 앵귤러에 비해 성능이 우수하고 빠르다
  * 리액트와 앵귤러를 가지고 같은 테스트 케이스에서 성능을 비교한 결과 뷰가 가장 빨랐음
 3. 리액트의 장점과 앵귤러의 장점을 둘다 갖고 있다는 점. 
  * 뷰는 앵귤러의 `데이터 바인딩 특성`과 `리액트의 가상 돔(Virtual Dom) 기반 렌더링 특징`을 모두 가지고 있다.  

#### 뷰가 리액트와 앵귤러보다 배우기 쉬운 이유!
- 앵귤러1은 프레임워크로서 완전한 기능을 제공하는 MVC 구조로 출발하여 컴포넌트 기반의 앵귤러2로 진화함
- 이 과정에서 타입스크립트(TypeScript), ES6(ECMAScript 2015)등 기타 어느 프레임워크보다 많은 학습이 필요하게 됨
- 리액트는 입문자가 학습하기엔 es6나 JSX라는 장벽이 존재 *[jsx : javaScript 언어의 확장](https://ndb796.tistory.com/204)
- 게다가 ES7, 웹팩(webpack)등 신기술이 마구 튀어나오는 상황에서 쉽게 배울 수 있는 뷰의 특징이 환영받는 중!
  
## 다른 프레임웍과의 비교
- [다른 프레임워크와의 비교(상세)](https://kr.vuejs.org/v2/guide/comparison.html)

## vuejs의 특징 간단 요약..
- Reactive
- Lightweight
- Simple
- Easy
- Progressive

## Vuejs concept
- PWA 기반, single page app(SPA)을 제작하기 위한, 화면 앞단 라이브러리 Vue.js.
- PWA : **Progressive Web Apps** 의 약자. 관련 내용은 [https://joshua1988.github.io/web-development/opinions/where-are-we-and-where-are-we-heading/](https://joshua1988.github.io/web-development/opinions/where-are-we-and-where-are-we-heading/) 참고
- vue의 주요 구성요소**(component, router, resource, templates)**

### 2. pattern

Vue.js는 **MVVM 패턴**에서 ViewModel 계층에 초점을 둔 프레임워크이다. 뷰모델을 통해서 **양방향 데이터 바인딩**이 가능하게 해주며, **뷰 계층을 좀 더 간단하고 유연하게 디자인하게 해준다.**

- 뷰모델(ViewModel)은 모델(Model)과 뷰(View)사이에 인터페이스 역할

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d986db31-b1fc-46ee-87b3-cfd07f42a36d/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d986db31-b1fc-46ee-87b3-cfd07f42a36d/Untitled.png)

### 3. data processing

- Component 간 통신의 기본 골격은 React의 **1way data flow**(부모 -> 자식)와 유사

## reference
- doit vue.js입문/장기효/vuejs소개
- https://www.slideshare.net/ToshiroShimizu/progressive-framework-vuejs-20
