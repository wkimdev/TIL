## Intro
- 이벤트배너의 swiper 동작이 이상하게 슬라이딩 되는 현상이 발생했다. 
- 사용 lib

## 조치 한점
- 우선 퍼블 문제 인지 파악하고자 했으나 퍼블 문제는 아닌걸로 판단함. (스크립트 이슈) 
- (1) 사용 css 속성 자체를 줄여보고 늘려보았지만 변경사항이 확인이 잘 안되었다. 
- (2) 모션이 감지되는 클릭 이벤트 시점에 아래의 코드를 추가하여 화인해 보았지만 확인이 잘 되지 않았다. 
  이런 swiper 애니메이션엔 아래 속성이 꼭 걸어져야 한다고? 하는데.. 
  
```
clickEevent(){
  event.stopPropagation()
  event.preventDefault()
}
  
```

## 필요한 배경지식
# javascript에서 이벤트를 중단하는 네가지 방법
- 자바스크립트 이벤트 리스너에서 프로그래밍을 할 때 이벤트 중단을 위해 자주 사용되는 코드들. 
 * preventDefault()
 * stopPropagation()
 * return false
  
  

## reference
- https://programmingsummaries.tistory.com/313
