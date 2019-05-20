## 외부jar를 로컬프로젝트에 추가하는 법
#### 1) local에 maven install, pom.에 artifact id.. 등 지정
- jar파일을 받아서, maven insatll 명령을 로컬에서 직접 날려야 한다. 

#### 2) systempath추가 
- 지난 프로젝트에서 사용하던 방법 
- 프로젝트에 포함된 jar만 불러오면 상대경로로 jar파일을 가져오기 때문에 편하다. 
- 이게 더 편한것 같은데, 현재 회사에선 위의 방법으로 외부 jar를 관리한다... 왜일까?... 

## reference
- https://kaling88.tistory.com/3
- https://kamang-it.tistory.com/entry/Eclipsejava%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%97%90-jar%ED%8C%8C%EC%9D%BC-%EC%B6%94%EA%B0%80%ED%95%98%EA%B8%B0-jar%ED%8C%8C%EC%9D%BC-%EC%83%81%EB%8C%80%EA%B2%BD%EB%A1%9C%EB%A1%9C-%EB%84%A3%EA%B8%B0
