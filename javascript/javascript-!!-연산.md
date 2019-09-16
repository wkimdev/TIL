## !! 연산
- 아래같은 처리  
  
```
  native
        .executeAsync(
          'ShowNativeView',
          JSON.stringify({
            isTitle: !!titleContext,
            isPlayer: !!playerContext
          })
        )
        .catch(e => {
          console.error(e)
        })
```
  
- https://nopanic.tistory.com/5
