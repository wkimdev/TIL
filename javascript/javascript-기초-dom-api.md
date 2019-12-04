# javascript 환경
- 원래 자바스크립트는 `웹 브라우저`안에서만 실행할 수 있는 프로그래밍 언어로 탄생했다. 
  * 웹브라우저 : 웹 브라우저 또는 브라우저(영어: web browser 또는 browser, 문화어: 열람기)는 웹 서버에서 이동하며(navigate) 쌍방향으로 통신하고 HTML 문서나 파일을 출력하는 그래픽 사용자 인터페이스 기반의 응용 소프트웨어이다. 웹 브라우저는 대표적인 HTTP 사용자 에이전트의 하나이기도 하다.  
    
- 시간이 흐르면서 테스크톰, 서버 등에서도 자바스크립트 프로그래밍 환경이 제공되었다. 
- 지금은 아래처럼 다양한걸 자바스크립트로 해볼 수 있따!
- [자바스크립트로 세상을 지배하는 방법 5가지](https://www.youtube.com/watch?v=NMHQkAS7XEc)
  
  
## javascript 돔조작
#### DOM정의
- 문서 객체 모델(Document Object Model)은 JavaScript Node 개체의 계층화된 트리다.
- DOM은 HTML, XML 문서의 프로그래밍 API이다.
- 문서의 구조화된 표현을 제공하며 프로그래밍 언어가 DOM 구조에 접근할 수 있는 방법을 제공한다.
- 문서 구조, 스타일, 내용 등을 변경할 수 있게 돕는다.
- JavaScript는 브라우저가 읽고 사용하는 언어입니다. 하지만 DOM은 그 일이 일어나는 곳입니다.
- 사실은 JavaScript의 것라고 생각하는 것들이 정확히는 DOM API이다.
- 예를 들면, element에 있는 mouseenter event를 확인하기 위해 JavaScript를 사용한다.
- element는 사실 DOM node이다. DOM node의 DOM 속성을 통해 해당 event listener를 연결합니다.
- event가 발생할때 DOM node는 event를 내보낸다(발생시킨다).
- node란 어떤 객체의 구성 요소를 의미한다.
   
#### 1) 돔 요소를 생성 (MDN Reference)
 - HTML 문서 안에서 HTML 요소나 HTMLUnknownElement를 생성한다. 
 `var element = document.createElement(tagName);`  
- element는 element의 객체로 생성 되었다.
- tagName은 element가 어떤 타입으로 생성될 지 정해주는 문자 값이다. 
- 어진 element의 nodeName은 tagName의 값으로 초기화 될 것이다. 이 값으로 예약어(html:a와 같은)를 사용해서는 안 된다.
    
#### 2) 돔에 새로운 요소를 추가  
- 상위 노드의 하위 리스트 제일 마지막에 하나의 노드를 추가한다. 
- 노드가 이미 존재한다면, 그것은 현재 상위 노드에서 제거되고 새운 상위 노드에 추가 된다.
  `var child = element.appendChild(child);` 
- `element`는 상위 요소다.
- `child`은 element의 아래에 추가될 노드다.

#### 3) HTML 요소의 스타일을 변경
- `HTMLElement.style` 속성은 element의 style 속성을 나타내는 객체다. 
- 하나의 요소에 적용된 모든 CSS 속성 값을 알아보기 위해서는 `window.getComputedStyle()`을 사용하면 된다.
   
```
element.style.color = "#ff3300";
element.style.marginTop = "30px";
element.style.paddingBottom = "30px";
```
   


 ## reference
 - https://ko.wikipedia.org/wiki/%EC%9B%B9_%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80
 - http://webframeworks.kr/tutorials/translate/javascript-dom-manipulation/  
 - https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/%EC%86%8C%EA%B0%9C  
 - https://shldhee.github.io/2018/04/08/DOM/
