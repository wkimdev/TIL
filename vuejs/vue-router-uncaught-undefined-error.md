#### 네비게이션가드에서 발생한 vue-router-uncaught-undefined-error
#### error
- in promise에서 잡혀지지 않은 에러. 
- 네비게이션가드로 hotvod에서 detail로 넘어가는데?(탐색되는데) 중단 되었다. 연속재생 화면 넘어가기 전에 이미 중단이 되었다. 하지만 화면은 잘 넘어간다?! 에러만 발생될 뿐... 
  
```
vue-router.esm.js:1958 Uncaught (in promise) Error: Navigation aborted from "/hotvod/detail?menuId=M047318&categoryId=C000235836" to "/detail?albumId=M012092851PPV00&badgeData=" via a navigation guard.
    at ht (vue-router.esm.js:1958)
    at dt (vue-router.esm.js:1949)
    at vue-router.esm.js:2256
    at vue-router.esm.js:2437
    at Detail.vue:102
```
  
#### 재현 문제 현상
- router를 두번 거쳐가는 동작에서만 발생됨 

#### 그런데..이게 무슨에러지?
- 처음에는 단순히 빌드했을때 발생한 문제로 생각하고 넘어갔는데, 특정 환경에서만 문제가 재현이 되고 빌드 및 npm update 같은 것만으로는 해결되지 않았다.
- 그리고 재현되는 루트가 분명해 보인다.

#### 참조 문서 분석해보기
- [stackoverflow:Uncaught (in promise) undefined - Vue-router](https://stackoverflow.com/questions/57493516/uncaught-in-promise-undefined-vue-router)
  
- 1. 에러가 발생했는데 잡는게 없기 때문에(catches the error), 에러가 발생해도 app이 아무것도 하지 않는 것 이다. => 에러를 그냥 삼키지 말고?(swallow) 어디선가 에러를 잡는게(catch) 중요하다. 
- 2. 오류의 내용은 경로가 변경됨에 따라 vue 구성 요소 언로드 및 로드와 관련이 있을 수 있다. 예를 들어.. 컴포넌트에서 this.$router.push() 를 호출한 다음, 경로 변경이 진행되는 동안, 해당 컴포넌트가 파괴되는 경우 
이와 같은 오류가 표기 될 수 있다. (hotvod => play.js에서 detail 라우팅 요청 => detail.vue의 beforeRouter에서 autoplay 라우팅 )
- 3. 문제의 확장으로.. 경로 변경이 발생하고 **결과 구성 요소가 promise가 해결되기 전에 .push() 이벤트에서 데이터를 읽으려고 하면** 이 오류가 발생될 수 도 있다. await를 사용해서 읽기 전에 어플리케이션을 대기 하도록 
지시하여 이와 같은 오류를 중지시킬 수도 있다.

#### 조사해봐야 할 2가지
- 1. this.$router.push()가 실행되는 동안 어떻게든 컴포넌트가 destorying 혹은 creating을 하는지?
- 2. 다음 컴포넌트가, 라우트 변경 완료가 되기 전에 라우트 파라미터(매개변수)에 대한 데이터를 읽을 수 있는지?? 

- 이 중 일부가 발생할 수 있음을 발견하면 데이터 흐름을 고려하고 오류를 억제하는 것뿐만 아니라 비동기 동작을 길들이는 방식으로 문제를 해결하라~
- 디버깅 중에 console.log ()를 모든 구성 요소의 생성 / 마운트 및 삭제 된 **수명주기 메서드**와 **경로 변경**과 관련된 함수에 추가합니다. **데이터가 흐르는 방식을 파악할 수 있어야합니다.** 
- 이 문제의 본질은 라우트의 변경중에 this.$route.params 의 downstream usage에서 오는 것 같다~. Add lots of console.logs and/or step through a debugger.
- 예시로든 해결 방법?
```
// 1
handleSomething() {
    this.$router.push({}).catch((err) => {
        throw new Error(`Problem handling something: ${err}.`);
    });
},

// 2
async handleSomething() {
    try {
        await this.$router.push({});
    } catch (err) {
        throw new Error(`Problem handling something: ${err}.`);    
    }
},
  
```
   
#### try
- vue-router version up
- next(false)를 beforerouterenter에서 테스트 
- try catch문 안에서 done값이 어떻게 들어오는지, 확인 등.. 
  
