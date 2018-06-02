### Node js
---
- node js 가 이미 만들어놓은걸 갖다쓰기.

- 모듈, 부품이 필요하다.
ex) const http = require('http'); 이걸 로드해서 사용한다.

- const 는 일단 값이 할당하면 항상 쓸 수 있음.
- node js 는 모듈을 require로 호출한다.
- ndoe js는 http라는 부품 모듈을 제공한다. [https://nodejs.org/dist/latest-v8.x/docs/api/http.html#http_class_http_server]


- NPM 모듈사용 (Node계의 앱스토어)
- 설치, 삭제, 업그레이드, 의존성 관리

#### express session store file
- npm install session-file-store --save (실제 application ==> package.json에 저장되기 위해선 --save 를 붙여야 한다!!!)
- session-file-store 는 express-session를 바탕으로 하고 있기때문에 의존관계를 아래와 같이 표현한다.

```
var session = require('express-session');
var FileStore = require('session-file-store')(session);
```

- 서버를 껐다켜도 파일에 세션데이터가 저장되어 있기 때문에 데이터가 지워지지않는다. 

#### express session store mysql

```
npm install express-mysql-session --save
```


#### security password
- md5, 해싱
- 아래 md5 확인 (단방향 방법 :  원래의 문자를 암호화로 바꿀 수있다. 암호화된걸 원래 문자로 바꿀 수 없다. (복호화는 불가능)) 
- md5는 암호화로서는 가치가 없다. 이제 안쓴다고 한다......
- 암호화되지 않을걸 평분이라고 함.
- https://crackstation.net/ 여기서 crack시키면 복호화가 되버림.. 너무 치명적이다!!
- 

```
PS C:\workspace\node\nodeExBoard> node
> var md5 = require('md5');
undefined
> md5
[Function]
> md5('javascript');
'de9b9ed78d7e2e1dceeffee780e2f919' //이렇게 나온걸 해싱코드라고 함
```

- 그래서 아래와 같이 함

```
> var md5 = require('md5');
undefined
> var salt = '123%@$#%$!@4334364@&$@$%26';
undefined
> var pwd = '111';
undefined
> md5(pwd + salt);
'73d352b18834e8958f9674c2084e7a64'
```

- md5의 어떤 결함때문에 사용이 지양되고 있다고 한다. 그대신 sha를 써보기로한다.
(sha512, 어떤 암호화가 더 좋은지는 세월에 따라 계속 변한다)
- 키스트레칭, salt가 단방향 처리...
-

#### PBKDF2
- 암호화 구현을 잘할 수 있게 해주는 함수.
- salt값 hash값이 알아서 달라져서 나옴.
- 비밀번호 보안은 중요!!
- npm i pbkdf2-password