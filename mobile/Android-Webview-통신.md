- 아이돌라이브는 모바일 서비스(하이브리드 앱)이다.
- 하지만 서비스를 이루는 영역엔 native와 api를 주고 받는 webview로 구성된다. 그렇다면 네이티브와 webview는 서로 어떻게 통신을 할까?
- 일반적으로 내가 해왔던 backend와 frontend간의 api요청/응답을 주고 받는 것과 달랐다. 

- 구글링을 해보니 안드로이드 Native와 WebView 연동을 어떻게 하는지에 대한 많은 글이 있어 정리해보도록 한다. 

## 안드로이드 Native와 WebView 연동방식 
- 안드로이드 Native와 WebView 연동방식을 사용하면, 이미 개발된 웹 페이지를 수정하지 않고, 안드로이드에서 WebView를 통해 그 웹페이지를 보여주면서 
Native와 값을 주고 받을 수 있다(실제로 아이돌live의 플레이어 영역은 네이티브, 하단부의 컨텐츠들이 리스팅 되어 있는 view는 웹뷰로 구분된다).

- Native와 WebView사이의 데이터를 주고 받는 것은
   
```  
 (1) Native의 값을 WebView로 넘기는 것과 
 (2) 반대로 WebView의 값을 Native로 넘기는 것이 있다. 
```   
  
- 위의 부분에서 헤깔렸던것은, native와 주고 받는 api(브릿지 인터페이스라고도 하던데)는 **단방향** 이라는 것이다.  
- 그리고 이처럼 통신을 하면, (프론트의 경우 vuejs로 이뤄져 있는데)javascript를 이용해 데이터를 주고 받음으로서 
native와 webui가 **한몸**처럼 행동할 수 있다는 것이다!!!   

- 그리고 웹과 앱사이에 데이터를 주고 받는 패턴에는 두가지가 있다고 한다.   
  
```  
1) 스킴(Scheme)값을 이용한 방법 
2) 안드로이드 브릿지를 이용한 호출 - interface를 선언해서 만드는 듯.. 
``` 
  


## 사용경우 
- 네이티브 영역으로 되어 있는 activity로 이동을 해야 한다던지, 카메라기능을 연다던지 할 경우, 웹페이지에서 앱의 모든 기능을 사용할 수가 없는 경우.. 
(ex: backkey이용, 공유하기 기능, clickbutton감지 등-사용자가 단말의 클릭버튼을 클릭할 경우, native에서 이벤트를 전달해주지 않는 이상, 
웹뷰는 이를 인식할 수 없다. )     
  
 


## 출처 
- http://zeany.net/10 
- https://gorakgarak.tistory.com/758  
- https://kwon8999.tistory.com/entry/Webview%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%ED%86%B5%EC%8B%A0Scheme-Androidbridge  
  
