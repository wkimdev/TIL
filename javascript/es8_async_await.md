## async, await
- callback, promise를 보완하기 위해 나온것.
- async, await 는 ES8 스펙이라 몇몇 브라우저에서 호환되지 않기 때문에 bable 변환코드가 필요하다
- Babel에서는 async-wait를 generator를 이용해서 구현
- async, await를 이해하기 위해선 일단 promise, 사용법을 알아야 한다. 

#### 사용법
- function 앞에 async 붙여주기
- 비동기로 처리되는 부분앞에 await만 붙여주기
- 단, await 뒷부붑ㄴ에 반드시 promise를 반환해야 한다
- async function 자체도 promise를 반환한다.  
  
```
async function goWork(time1, timeStartWork) {
    const time2 = await wakeUp(time1)
    const time3 = await takeSubway(time2)
    const time4 = await takeOffSubway(time3)
    const arrivalTime = await arriveWork(time4)
    if(arrivalTime > timeStartWork) {
        fire()
    }
}
```

  
  
- 난 지금 connection 이후 비동기처리를 해야 한다. 
- 이해가 잘 안된다 ㅠㅠ 일단 굳이 이걸 안쓰고 promise로 처리할 방법을 생각해봐야 겠다.
