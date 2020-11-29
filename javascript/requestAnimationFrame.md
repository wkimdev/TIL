## requestAnimationFrame. 
```
button.addEventListener('click', () => {
  requestAnimationFrame(() => {
    // 브라우저 렌더링 마지막에서 실행해라!
  });
  
  // 비슷하게 자주 쓰이는 용법
  setTimeout(() => {
    // 실행 구문 - 이벤트 루프가 끝나고 코드 블럭을 실행하고 싶을 때, (다음 이벤트 루프가 동작할 때 실행되기 원할때)
  }, 0)
})

```


