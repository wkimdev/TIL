# window
- **window** 객체란, **브라우저** 요소들과 **자바스크립트 엔진**, 그리고 모든 **변수를** 담고 있는 객체 
- 인터넷 브라우저를 보면, 위에 탭과 주소창, 즐겨찾기 등이 있다. 그리고 툴바도 있다~
- 그 이후엔 웹사이트가 표시되는데, 여기서 **브라우저 전체를 담당하는게 Window 객체**이고, 
웹사이트만 담당하는게 **Document** 객체라고 이해하면 된다. 
- Document도 Window객체 안에 들어있다. 
- ex) 콘솔에 window.(dot) 에서 나오는 추천목록들.. 
- 이게 다 윈도우 객체의 속성과 메서드들이다. 
- window는 모든 객체의 조상, 전역객체(글로벌객체)라고 하는데, 모든 객체를 다 포함하고 이기 때문에 window는 생략 가능. 
  
#### 자주쓰는 window 객체 
- screen
- location
- history
- documemnt

#### 자주쓰는 window 메서드
- parseInt, 
- isNaN
- window.close()
- window.open()
- window.encodeURI()
- window.decodeURI()

## 전역객체 중 document => DOM
- 전역객체 중 document는 따로 DOM이라고 불린다.  
    
## BOM(Browser object model)
- 브라우저에 대한 정보를 가지고 있음.  

#### navigator
- 브라우저나, 운영체제(os)에 대한 정보가 있다.(navigator.userAgent).  
- 기타 정보들도 확인 가능하고, serviceworker같은 정보도 확인 가능 하다.   
  
``` 
navigator.language; // "ko"
navigator.cookieEnabled; // true
navigator.vendor; // "Google Inc"
```
  
  
# 전역객체

## 참고
- https://www.zerocho.com/category/JavaScript/post/573b321aa54b5e8427432946
