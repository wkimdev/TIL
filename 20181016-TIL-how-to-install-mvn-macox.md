## mac에서 maven 설치하기 
- mac 에서 mvn설치하는데 애를 먹었다.
- $bash로 들어가 vi .profile 를 수정해 저장 후 다시 실행해보니 설치가 되었다.
- 미리 내 컴퓨터의 자바경로와, maven설치경로를 제대로 확인한뒤 셋팅하자.(그냥 복붙 노노)

## 설치 과정
- 1. 메이븐 다운받기
- http://maven.apache.org/download.cgi
- 여기서 http://apache.mirror.cdnetworks.com/ 클릭하고 들어가서, maven 클릭 -> binaries/   클릭 --> apache-maven-3.2.2-bin.tar.gz 클릭함.  


- 2. 다운받은 후, 압축을 풀어 내 mac의 홈경로에 maven3.2.2라는 이름으로 변경하여 이동시킴.
- /Users/(my_pc_name) 으로 이동    


- 3. 여기부터 다른 블로그를 참고해서 profile를 수정해서 반영해도 설치가 잘 안되자 다르게 해봄.
- 여기부터 [How to Install Maven on Mac OS X manually?](https://crunchify.com/how-to-install-maven-on-mac-os-x-manually-fix-unsupportedclassversionerror-orgapachemavenclimavencli/) 참고함.
- `$ bash` 를 실행해서 들어간다.
-  `bash-3.2$ vi ~/.bash_profile` 실행
- 내 java경로와 메이븐 경로 확인한 후 저장 한뒤 vi 나오기.(저장명령어 `:wq`)

```
export M3_HOME=/Users/(my_home)/maven3.2.2
export PATH=$PATH:$M3_HOME/bin
```

- `bash-3.2$ source ~/.bash_profile` 실행
- `bash-3.2$ mvn -version` 으로 설치 확인. 아래와 같이 설치 성공 확인 가능. 

```
Apache Maven 3.2.2 (45f7c06d68e745d05611f7fd14efb6594181933e; 2014-06-17T22:51:42+09:00)
Maven home: /Users/doublechain/maven3.2.2
Java version: 1.8.0_171, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre
Default locale: ko_KR, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.5", arch: "x86_64", family: "mac"

```


## 기본 명령어
- 터미널 명령어와 편집기 vi 편집기 사용이 익숙치 않아 애먹었다...
- vi, vim, nano : 유닉스에서 사용할 수 있는 에디터
- vi(visual display editor ) vim (vi improved = 향상된 vi)
- vim에는 vi기능이 모두 들어가 있음.
- 시작하기 `vi`
- 입력모드 전환은 i를 누르면 됨.
- 명령모드 전환은 esc 누르기. (그럼 에디터창에 Insert가 사라짐.) 
- `:w` 저장하기, `:wq` 또는 `:wq!` 저장하면서 종료하기. 
- `:q` 종료하기,`:q!` 강제종료하기 
- 

## mvn 설치이후 
- springboot 에서 profile에 따라 실행 옵션을 다루게 주니 잘 적용되며 프로젝트가 올라왔다.
- 프로파일 분리 완료.

## 테스트 명령어
- spring boot profile 분리  
- 개발옵션 : `mvn spring-boot:run -Dspring.profiles.active=dev;` 실행
- 로컬옵션 : `mvn spring-boot:run -Dspring.profiles.active=local;` 실행
   
## 발생했던 에러 메세지
- E325: ATTENTION Found a swap file by the name ".profile.swp"()
- vi는 파일을 열면 스왑 파일을 만듭니다. 편집을 종료되면 스왑 파일을 삭제하고요. 스왑 파일이 이미 존재하기 때문에 나오는 메시지
- https://kldp.org/node/116058
- 

## bash란?

## 참고 블로그
- https://zeddios.tistory.com/122
- http://kamang-it.tistory.com/entry/Mac-Maven-%EC%84%A4%EC%B9%98-%ED%95%98%EA%B8%B0
- https://www.baeldung.com/install-maven-on-windows-linux-mac
- https://joonyon.tistory.com/15
- [maven설치](https://wikidocs.net/17298)