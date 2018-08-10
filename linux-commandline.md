# 권한 어찌고 하는건 전부 sudo 설정때문이다!

# 압축해제
$ tar xvfz multichain.tar.gz
$ sudo tar xvfz multichain.tar.gz

# mac에서 ip확인
$ ifconfig |grep inet

# rm = remove의 약어 ==> rm [옵션] 파일명
# test 파일을 삭제할때 삭제확인과정을 거치지 않음
$ rm -f test

# home 디렉토리를 삭제 - 비어있지 않은 디렉토리는 -r 옵션 없이는 삭제할 수 없다.
$ rm -r home/

# 아래는 권한 없이 삭제?
$ sudo rm -rf

# 권한을 준 상태로 mv로 이동함
$ sudo mv

# 새 디렉토리를 만드는 명령어 (make directory)
$ mkdir [옵션] 생성할디렉토리

# 리눅스에서 ps명령어를 이용해서 현재 시스템에서 구동중인 프로세스를 확인 
$ ps [옵션] 
$ ps -ef|grep multichain 이런식으로 날리면
==> skdev    23435 23302  0 18:22 pts/18   00:00:00 grep --color=auto multichain 이렇게 뜸


# -ef|grep는 무슨 옵션?

## 전체 다보기
- $ ps -ef
## 좀 더 유연하게 검색을 하고자 한다면 파이프로 'grep' 명령을 사용하는게 좋습니다.
$ ps -e | grep ssh

# nano 편집기 실행 -> nano multichain.conf  이런식으로 수행하면 dcc.user, dcc.host이런식으로 접속정보가 나온다. (conf파일이니까)
$ nano -m [파일명]

# 멀티체인 버전 확인(왜 알파인지, 버전은 2인지 3인지를 정확히 체크하기)
$ multichaind -version

# 아래 명령어는 언제 날리는가?
$ multichain-cli doublechain stop

# master에 넣는건 프로젝트 다 끝나고 함.

# curl은 뭔지

# scp?
$ scp multichain.tar.gz username@192.168.0.0:~/

# recursive 옵션이란?
==> 재귀적으로 디렉토리를 카피함. 해당 옵션을 지정하지 않으면, rsync명령어로는 디렉토리를 동기화 하지 않음.
==> 현재 프로젝트의 하위 모듈들을 recursive 옵션을 통해 쉽게 받을 수 있기도 하거니와, ...

-ico에 대해
https://steemit.com/kr/@maa/nfkav-ico

- 내가 ico에 대해 알아야할 정보
==> 기본적인 절차와
실제 개발을 위해 어떤 정보값이 주고받아져야 하고,
이걸 어떻게 구축해야 하는지.

- backend-dev1@Backend-Dev1:~/multichain$ multichain-cli name stop 해야