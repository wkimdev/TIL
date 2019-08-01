## IOS13에서 공유버튼 클릭시, 어플 설치가 되었음에도 스토어로 리다이렉트가 되는 현상
- 현재 소스코드는 커스텀 URL SCHeme 방식으로 되어 있음. 
- 구글에 널리고 널린 아래의 방법.. 

#### 기본 방법
  
```
setTimeout(function () { 
          //callback if the app is not installed.
}, 25);
window.location = "myapp://somethingyouwanttosend";
```
- 하지만 이슈를 해결하기 위해 다른 방법은 없는지 더 서칭해보았으나 위 처럼 처리 하는게 표준인 듯 하다. 
- 일단 settimeout 을 두번 거는 방법. time설정을 더 늘려보는 법을 시도해 본 뒤 다른 방법을 좀더 고민해 봐야 겠다. 
  
#### ios에서 모바일 공유버튼시 링크 처리 동작 기본 
- https://g-y-e-o-m.tistory.com/121 



## 모바일 앱 내부 콘텐츠를 연결하는 방법
- 딥 링크, 유니버설 링크, URI/URL 스킴 및 앱 링크...


- 현재 코드에 적용된 방법 -> URL Scheme
	- IOS의 URL체계에 따라 일반적으론 아래처럼 처리하는게 표준으로 보입니다. 
	window.location = 'imdb://title/tt3569230';
	setTimeout(function() {
	  window.location = 'itms-apps://itunes.apple.com/us/app/imdb-movies-tv/id342792525'
	}, 250);

참고 링크
(1) https://blog.branch.io/uri-schemes-and-universal-links-for-ios/	

- 대안?은 아니지만,, settimeout방법을 쓰지 않는다면 고민해볼만한 주제??? ==> Universal link
	- Universal link을 사용하면 URL Scheme의 기능을 대부분 대체할 수 있다.
	- 사용자가 웹에서 HTTP link를 탭하면 즉시 앱으로 서비스가 연결.. 
	- 애플 개발자 계정 등록 필요.. 
	- 처리해야 할게 많아진다..?

참고 링크
- (1) https://stackoverflow.com/questions/44903934/check-if-app-is-installed-from-webpage	   
- (2) https://rhammer.tistory.com/261 [고무망치의 Dev N Life]
