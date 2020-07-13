## javascript-async-defer.md
- https://blog.asamaru.net/2017/05/04/understanding-the-critical-rendering-path/
- https://blog.asamaru.net/2017/05/04/script-async-defer/

#### async
```
<script async src="main.js"></script>
```
- 패칭이 좀더 빨리 병렬적으로 수행되지만
- 스크립트 순서가 있을 경우 문제가 될 수 있음. 

#### defer
```
<script defer src="main.js"></script>
```
- 미리 다운로드 받고 순서대로 실행하기 때문에 효율적이고 안전


#### 'user strict'
- typescript를 사용할때는 필요없지만
- 바닐라 자바스크립트에서는 위의 선언을 사용 
- add ecmascript 5에 추가가 되어 사용될 수 있다. 
- `user strict`를 사용하게 되면 자바스크립트 엔진이 좀더 효율적으로 스크립트를 돌릴 수 있게 해준다.  
  
  
```
'use strict';

console.log('hll')

let a;
a = 6; // error 
```
  
  
