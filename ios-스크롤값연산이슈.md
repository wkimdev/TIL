# IOS 스크롤 이슈
## 현황
- 미니디테일 및 연속재생 화면에 진입하는 경우 플레이어 하단의 공유하기 버튼옆 댓글 버튼을 클릭시, webui에서 댓글 영역까지의 요소의 위치값을 픽셀로 계산하여 네이티브에게 알려준다 
- 사용하는 소스코드는 아래와 같다.(offsetTop) 
   
```
const height = this.$parent.$refs.commentBox.$el.offsetTop
```
  

## 문제상황
- ios에서만 단말별로 댓글 영역을 계산해주는 픽셀값이 달라지는 것 같다. (android 단말에서는 정상작동한다.)
- 화면별과 단말별로 다르지만.. 예를 들어 se 단말에서는 댓글 버튼을 클릭시 실제 댓글 영역보다 하단/상단으로 스크롤이 이동된다. 
- ios는 개발서버 설정만 바라보기 때문에 로컬에서 곧바로 테스트를 해볼 수 가 없다ㅠㅠ 
   
  
## 문제원인은?
- ?.. ios에서만 offsetTop계산이 잘 안되고 있다? 왜??? 
   - 그렇다면 offsetTop이란 일단 무엇인지.. 대체할 수 있는게 뭘지 찾아볼까? 
- 네이티브에서 미니플레이어와 webview를 그릴때 일어나는 일은? 
   
   
## 조치해볼 것 
- (1) 플레이어 영역 대략(57-8 px?값을) 직접 빼서 스크롤까지의 길이를 계산해보기.
    => 사실 이건 어떻게 해야할지 감이 잘 안잡힌다. 
- (2) getBoundingClientRect 를 사용해보기?   
 ```
 const relativeTop = element.getBoundingClientRect().top;
 ```
 - (3) 아래 예시를 참고해서 조금씩 밀어내보면.. 안되겠구나 ㅠㅠ 안드로이드는 잘 되니까...
 https://stackoverflow.com/questions/46102020/offset-returns-different-values-in-mobile-browsers
   
    
#### 참조
- [Difference between getBoundingClientRect().top and offsetTop?](https://stackoverflow.com/questions/44172651/difference-between-getboundingclientrect-top-and-offsettop)  
- https://mommoo.tistory.com/85  
- https://stackoverflow.com/questions/20482154/javascript-difference-between-scrolltop-and-offsettop
  
  


