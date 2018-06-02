### jade extends

### Node Module 정리정돈 방법
- 함수를 직접생성하여 호출하여 관리할 수 있다.
- 예를 들어 아래와 같이 함수표현식으로 함수를 선언하고, 
module.exports라는 객체에 접근할 수 있게 한다. 각각의 객체들은 sum, avg라는 프로퍼티값으로 함수가 정의되어 있다. 

```
module.exports.sum = function(a,b){
    return a+b;
}
//exports 내보내다@@@
module.exports.avg = function(a,b){
    return (a+b)/2; 
} 
```

- 아래는 모듈을 가져다 쓰는 코드이다.
- 아래와 같이 사용함으로서 코드의 복잡성을 낮출 수 있다.

```
var sum = require('./lib/sum');
console.log(sum(1,2));

var cal  = require('./lib/calculator');
console.log('cal sum', cal.sum(1,2));
console.log('cal avg', cal.avg(1,2));
```

### Route 정리정돈 방법
- 

var express = require('express');
var app = express();

var p1 = require('./routes/p1');
var p1 = express.Router(); //express의 router라는 함수를 호출
//파일로 분리할때 이렇게 사용하는게 의미가 있다.
// p1.get('/r1', function(req, res){
//   res.send('Hello /p1/r1');
// });
// p1.get('/r2', function(req, res){
//   res.send('Hello /p1/r1');
// });
app.use('/p1', p1); //p1으로 들어오는 것들은 router변수가 처리

require('./routes/p2');
app.use('/p2', p2);

app.listen(3003, function(){
 console.log('connected');
});


### 현재프로젝트 이슈/문제
- https 콜백 따로 받고 있음. 포트설정 따로함.
- 현재하고 있는것... 세션정보를 제대로 지우지 못함.. /auth/login할때 there is no user... 이런에러가 뜨면서 welcome화면으로 리다이렉트하지 못함.
- 최초 로그인정보를 어디서 가지고 있는지도 모르겠음......

- 저녁에 갑자기 이 에러가 남.. Warning
앱 설정 안 됨: 이 앱은 아직 개발 모드 상태이며 회원님에게는 액세스 권한이 없습니다. 등록된 테스트 사용자로 전환하거나 앱 관리자에게 권한을 요청하세요.
- 이메일인증이 안된다. 로그인은 되는데. 이메일값을 scope으로 받고 싶은데 계정값이 없어서 그런지 안된다.