## vue project start
- webpack 잘모르니까 webpack-simple로 프로젝트 스타트 
- 1) `vue init webpack-simple 'project-name'`
  
- 2) document대로 셋팅한 뒤(bootstrap-vue install, import css in main.js) 보면 이미 webpack.config.js에 아래 처럼 모듈의 룰이 적용되어 있다. 저거 안건들고 그대로 쓰면 된다!!!
- 도큐먼트보면 style-loader 를 추가하라고 되어 있는데, 이미 있는 vue-style-loader에 추가하면 프로젝트 실행시 에러가 난다.. 
  
  
```
{
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },
```
  
- 3) main.js에 부트스트랩을 사용한다고 명시했고, 부트스트랩 태그를 읽어 CSS를 입힐 수 있도록 import할 수 있도록 다 설정해 놓았기 때문에 컴포넌트에서 태그 사용시, 따로 import할 필요가 없어진다.
  
- 4) 테스트용도로, app.vue에 <div>태그 아래 샘플을 복붙해서 화면에서 확인하면, 잘 나오는걸 확인할 수 있다. 
div id="app" 여기서 id속성을 빼야 부트스트랩을 읽을 수 있다. (id="app"은 컴포넌트 아래 스타일 속성이 이미 먹혀있어서 부스트랩 태그를 읽지 못하게 한다.)

```
<template>
  <div>
  <b-card title="Card Title"
          img-src="https://picsum.photos/600/300/?image=25"
          img-alt="Image"
          img-top
          tag="article"
          style="max-width: 20rem;"
          class="mb-2">
    <p class="card-text">
      Some quick example text to build on the card title and make up the bulk of the card's content.
    </p>
    <b-button href="#" variant="primary">Go somewhere</b-button>
  </b-card>

  </div>
</template>
```