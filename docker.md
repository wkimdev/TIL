## docker
- docker는 리눅스 컨테이너 가상화 기술을 사용해, 어플리케이션의 개발, 패키징, 배포를 편리하게 해준다.
- docker는 운영체제의 설치없이 호스트의 자원을 사용하는 형태로 어플리케이션과 라이브러리를 '컨테이너화' 하여 설치하여 독립적으로 운영할 수 있다.
- Docker는 리눅스 커널을 사용하여 컨테이너 개념으로 사용하기 때문에 오직 리눅스 운영체제에서만 사용할 수 있다. 
- 하지만 boot2docker 를 사용하여 Mac OS X에서도 virutaled docker engine을 사용하여 Docker를 운영할 수 있도록 Docker에서 공식 지원을하고 있다. 

## image
- 도커에서 가장 중요한 개념은 '컨테이너'와 함께 '이미지' 라는 개념.

#### 이미지
- 이미지는 **컨테이너 실행에 필요한 파일과 설정값등을 포함하고 있는 것 **으로 상태값을 가지지 않고 **변하지 않습니다(Immutable).** 

#### 컨테이너
- 컨테이너는 이미지를 실행한 상태라고 볼 수 있고 추가되거나 변하는 값은 컨테이너에 저장됩니다. 
- 같은 이미지에서 여러개의 컨테이너를 생성할 수 있고 컨테이너의 상태가 바뀌거나 컨테이너가 삭제되더라도 이미지는 변하지 않고 그대로 남아있습니다.

## 특징?!
#### 레이어 저장방식
#### dockerfile
- 도커는 이미지를 만들기 위해 Dockerfile이라는 파일에 자체 DSLDomain-specific language언어를 이용하여 이미지 생성 과정을 적습니다. 
- 이것은 굉장히 간단하지만 유용한 아이디어인데, 서버에 어떤 프로그램을 설치하려고 이것저것 의존성 패키지를 설치하고 설정파일을 만들었던 경험이 있다면 더 이상 그 과정을 블로깅 하거나 메모장에 적지 말고 Dockerfile로 관리하면 됩니다.


## install
- 도커는 리눅스 컨테이너 기술이므로 macOS나 windows에 설치할 경우 '가상머신에 설치'가 됩니다. 

#### Docker for Mac(me) / Docker for Windows
- 도커를 맥이나 윈도우즈에 설치하려면 [Docker for mac](https://docs.docker.com/docker-for-mac/) 또는 Docker for windows를 설치하면 된다.
- docker for mac은 xhyve라는 macOS에서 제공하는 가상환경을 이용
- Mac용 Docker를 설치하면 자동적으로 Virtual Box라는 운영체제가 설치되고(!!!), 가상 OS로 리눅스가 설치되는데 그것이 boot2docker라는 아주 간단하게 구성된 리눅스라고 합니다.

#### 가상머신에 설치하기
 - 이런저런 이유로 Docker for … 를 사용하지 못하는 경우 Docker machine을 이용할 수 있는데 
 - 처음 도커를 공부하는 경우에는 Virtual Box(설치함)나 VMware같은 가상머신에 '리눅스'를 설치하고 '리눅스에 접속하여 도커를 사용하는 방법을 권장'합니다. 
 - 처음부터 Docker machine을 사용하면 환경이 약간 혼란스러울 수 있습니다.(어쩌다 보니 애를 설치해 버려서 혼란스러웠던 듯..)

#### 설치결과 확인
- `$ docker version`  
- Client와 Server 정보가 정상적으로 출력되었다면 설치가 완료된 것 입니다.  

```
Client: Docker Engine - Community
 Version:           18.09.0
 API version:       1.39
 Go version:        go1.10.4
 Git commit:        4d60db4
 Built:             Wed Nov  7 00:47:43 2018
 OS/Arch:           darwin/amd64
 Experimental:      false

Server: Docker Engine - Community
 Engine:
  Version:          18.09.0
  API version:      1.39 (minimum version 1.12)
  Go version:       go1.10.4
  Git commit:       4d60db4
  Built:            Wed Nov  7 00:55:00 2018
  OS/Arch:          linux/amd64
  Experimental:     false

```

#### docker client and server
- 버전정보가 클라이언트와 서버로 나뉘어져 있다.
- '도커'는 하나의 실행파일이지만 **실제로 클라이언트와 서버역할을 각각 할 수 있다.**
- 도커 커맨드를 입력하면 도커 클라이언트가 도커 서버로 명령을 전송하고 결과를 받아 터미널에 출력해 줍니다.
- 이미지 필!!
- 기본값이 도커 서버의 소켓을 바라보고 있기 때문에 사용자는 의식하지 않고 마치 바로 명령을 내리는 것 같은 느낌을 받습니다. 
- 이러한 설계가 mac이나 windows의 터미널에서 명령어를 입력했을때 가상 서버에 설치된 도커가 동작하는 이유입니다.

## 컨테이너 실행하기
#### 기본 명령어
- 도커 실행명령어 : `docker run [OPTIONS] IMAGE[:TAG|@DIGEST] [COMMAND] [ARG...]`
- ex) docker run -d -p 80:80 --name webserver nginx

#### ubuntu container 생성
- `$ docker run ubuntu:16.04`
- 결과값  
- run 명령어를 사용해, 이미지가 저장되었는지 확인하고 없다면 다운로드(pull)
- 그 이후 컨테이너를 생성(create)하고 (start)한다. 

```
Unable to find image 'ubuntu:16.04' locally
16.04: Pulling from library/ubuntu
7b8b6451c85f: Pull complete 
ab4d1096d9ba: Pull complete 
e6797d1788ac: Pull complete 
e25c5c290bde: Pull complete 
Digest: sha256:e547ecaba7d078800c358082088e6cc710c3affd1b975601792ec701c80cdd39
Status: Downloaded newer image for ubuntu:16.04
```

#### redis container 생성
- redis에 접속하여 새로운 키를 저장하고 불러오는데 성공했습니다. 
- 실행이 간단한건 물론이고 호스트의 포트만 다르게 하면 하나의 서버에 여러개의 redis 서버를 띄우는 것도 매우 간단합니다.
- 아래에서 키까지 생성한걸 확인할 수 있다.
- `$ docker run -d -p 1234:6379 redis`  
```
Unable to find image 'redis:latest' locally
latest: Pulling from library/redis
a5a6f2f73cd8: Already exists 
a6d0f7688756: Pull complete 
53e16f6135a5: Pull complete 
78a675d939ba: Pull complete 
91255f6fabf6: Pull complete 
4ea832befeee: Pull complete 
Digest: sha256:19f4621c085cb7df955f30616e7bf573e508924cff515027c1dd041f152bb1b6
Status: Downloaded newer image for redis:latest
27aabc9732e67ee77f90dcbbc78c7d791559dd0970f8467f9e13e442f34bd696
```



#### 설치순서
- docker install
- virtualBox install
- 서버를 실행시키기 위해선, docker client외에 docker application이 필요하다. 
- docker-machine : toolbox

- docker-machine version 0.16.0, build 702c267
- docker version 을 터미널에 입력하면 아래와 같이 나온다. 
```
Client:
 Version:           18.09.0-ce
 API version:       1.39
 Go version:        go1.11.2
 Git commit:        4d60db4
 Built:             unknown-buildtime
 OS/Arch:           darwin/amd64
 Experimental:      false
Cannot connect to the Docker daemon at unix:///var/run/docker.sock. Is the docker daemon running?
```

## 잘안되서... 아래 참고해 계정생성후, docker application 다운받음


#### docker image 생성
#### docker 시작
#### docker 접속

- 괜히 오래된 블로그글을 보다가 헤깔렸다.. ㅠ

## reference
- http://blog.saltfactory.net/upgrade-latest-docker-using-with-homebrew/
- https://junn.in/archives/2323
