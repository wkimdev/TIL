[TOC]

### javascript Object
---
- 키는 문자열만 가능.
속성명은 따옴표가 없어도 된다(있어도 상관없다. 띄어쓰기가 있을경우 따옴표로 감싸기).
ex) var wrap = {'ex ample' : 'wrap' }

- 속성값은 문자열, 숫자, 객체, 함수 가능 (속성값이 함수일 경우 메소드라고 부른다.)
- 객체 생성시 var obj = {};  new로 생성하기보단 {}를 사용하는게 `권장사항`이다.
- {}를 사용해서 만든 객체를 객체 리터럴(literal)이라고 부른다. 
- var nm1 = 170, var testString = 'this is string' 이런식으로 값을 곧바로 쓰는 경우... 숫자 리터럴, 문자열 리터럴이라고 한다. 
리터럴은 문자 그대로의 것들을 의미한다.
- 객체중 특수한 객체 : 함수(Function)와 배열(Array)
- 배열안에 들어간 것들을 요소(item)이라고 부른다. 객체의 속성처럼 `쉼표`로 구분한다.



### javascript Function
---
- 속성값으로 사용되는 함수를 '메소드'라고 부른다.  
- 값으로 사용되는 함수를, '1급 함수'라고 부른다. (자바스크립트는 1급 함수를 사용하는 언어)
- 자바스크립트를 잘 사용하기 위해선 함수를 값으로서 자유자재로 다룰 수 있어야 한다.


### javascript 모듈화
---
- 자바스크립트는 줄이 바뀌면 명령이 끝났다고 인식.
- 탭키는 가독성을 높이기 위해 쓴다.

- 모듈 (부품) : 코드의 재활용성, 유지보수를 쉽게 할 수 있다.
- 코드를 여러개의 파일로 분리하여 사용한다. 필요할때마다 재활용 가능
- 코드 수정 시에 필요한 로직을 빠르게 찾을 수 있음.
- <script type="text/javascript"> ==> 생략가능  <script>
- 태그, 속성, 값.
    모듈화시, script태그를 만났을 때, 
    src 속성의 파일을 읽어서. 
    파일안의 javascript파일을 읽은다음
    <script>
    //이 안에 파일내용 불러오는것과 동일한 기능을 한다.
    </script>

### node.js에서의 모듈의 로드
```
//인클루드
var moduleJs = require('node.circle.js');	//로드되는 대상
```
    

### 라이브러리
---
- 모듈과 비슷한 개념. 모듈이 프로그램을 구성하는 작은 부품으로서의 로직을 의미한다면 라이브러리는 자주 사용되는 로직을 재사용하기 편리하도록 잘 정리한 일련의 코드들의 집합을 의미. 좋은 라이브러리를 선택하고 잘 사용하는 것은 프로그래밍의 핵심. 목적을 쉽게 달성할 수 있게 해주는 코드. ex) jQuery
- jqurey documentation여기서 라이브러리 사용법을 알 수 있다. (test_main.html에서 include한 greeting.js에서 어떤 액션이 있는지 아는게 필요한것 처럼.)
- jQuery의 예약어 $. 달러!!!!

### 웹페이지 로딩 원리/순서?! 
--- 
- //웹 페이지에서 다운을 받았다????
네트워크 탭을 열면, 현재 웹페이지에서 다운받은 파일들이 표시된다.
//다운을 받았다고??? 무슨소리지????
해당 페이지에서 다운받은
것들이 
- [https://code.i-harness.com/ko/q/1b656e]
- [https://www.slideshare.net/JinKyoungHeo/1-2-53043752]
- [https://joshua1988.github.io/web-development/translation/javascript/how-js-works-inside-engine/]
- [http://d2.naver.com/helloworld/59361]

### 웹페이지 로딩 원리/순서?!
--- 

### API와 UI
---
- UI(user interface), API(Application Programming interface)
- alert창조차, 웹브라우저를 제어하기 위한 interface.(사용자 interface와 구분하기 위해 api라고 부른다.)
- 개발자는 api를 이용해 브라우저 웹 플랫폼을 제어하게 됨.
브라우저 (플랫폼 ), 브라우저 api(운영체제가 제공하는 api)를 이용해서 개발(운영프로그램 개발)
- 프로그래밍을 공부하기 위한 자료는 크게 레퍼런스(reference)와 tutorial(안내서)가 있다.
- 자바스크립트가 동작하는 호스트환경의 api (호스트환경이란??)

