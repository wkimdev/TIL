# eslint 
- 오류가 없더록 유도하는 툴 ?
- // 트레일링 콤마? - 

# eslint off
- lintOnSave
- https://cli.vuejs.org/config/#lintonsave

``` 
module.export = {
    lintOnSave: false
}
``` 


/* eslint-disable */
export default {
  name: 'app',
  // 트레일링 콤마? - 
  components: {
    fetchData(){
      console.log(data);
    }
  }
}


// 해당 컴포넌트에만 적용되는 스타일링 scoped
// 상위 컴포넌트에 쓰면, 상위 께 하위까지 전달됨



## router
- app의 실제 동작을 담당하는 애들이 이 아래로 들어와야 한다. 

```
"dependencies": {
    "vue": "^2.5.22"
},
```
# main.js
- 기본적인 어플리케이션 (플러그인, 라이브러리 등의 기본 구조를 파악할 수 있는 청사진을 제시해주는 곳)


# views에는 라우팅 하는 애들만 들어가는게 좋다 !!
- views는 페이징 역할만 하기 때문!!!!
- view에 들어가는 로직은 별도의 컴포넌트에서 처리하도록 한다. 