# 리눅스 자주 쓰는 명령어들과 개념
-apt sudo 명령어 의미



그리고 맥에 vnc 프로그램을 설치했다. 

ng serve &
⇒ 이렇게 하면 백그라운드에서 돌게 하는것
터미널 꺼도 돌아감


ps -ef|grep "ng serve", ps -ef|grep EOSTracker
ps -ef|grep npm
⇒ 프로세스 확인 명령어. 아래처럼 뜨면 프로세스가 돌아가고 있지 않다는 것.


---

## axio call issue

## 발생상황
- 사내 프라이빗 서버와 오픈소스를 받아 연동해 올린다음, 서버로 요청을 보내는데 corb, cors 이슈가 발생했다. 

## Cors 원인
- ...로 불리며
- 발생하는 원인은 크로스 도메인 충돌때문에 발생한다. 


# 그렇다면 로컬호스트로 호출할때와 (localhos), ip로 요청하는것의 차이가 무엇이지??
- 그냥 ip와 로컬호스트 ip 의 차이 

# 그리고 angular코드에서 host ip를 받기위해 아래처럼 설정해서 ip로 볼 수 있도록 수정했다.! 
  
  
```
"serve": {
          "builder": "@angular-devkit/build-angular:dev-server",
          "options": {
            "browserTarget": "eos-explorer:build",
            "host": "0.0.0.0"
        },
          
```

- 서버냐 로컬이냐..

- 이런게 있다 정도만 따로 공부하지는 말고 



---

## nodejs 는 버전을 많이 타기 때문에 
- 어떤버전이 호환되는지보고 그버전을 명시적으로 지목해주세여 
- ^가 있는게 좋다고 함 / 크리티컬한 이슈가 없다면 

- angular webpack bound ip 
- https://github.com/angular/angular-cli/issues/1793#issuecomment-413798094


# & 애는 백그라운드에서 서버가 돌게 해준다.


# 아래 에러 
- "@angular/core": "^6.1.2", 에서 ^ 빼서 해결 
- 하지만 ^를 빼는걸 지양.. nodejs가 버전을 많이 타기 때문에
ERROR in ./node_modules/cipher-base/index.js Module not found: Error: Can't resolve 'stream' in


---

(복습!)

## 컨트랙트 배포 과정
- 컨트랙트를 컴파일(abi파일이 만들어짐 : --abigen ) --> deploy token contract(--abi) 





