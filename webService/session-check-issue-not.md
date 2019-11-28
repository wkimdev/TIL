## session check issue 현상
- 화면에 특정 컨텐츠가 비노출되어야 한다.  
- 컨텐츠는 session의 단말 타입으로 비노출/노출을 구분한다. 
- 문제는 서버에 반영 후 테스트 결과, 매번 페이지 진입시마다 컨텐츠가 노출/비노출이 되는 현상이 발생한다. 
- 캐시는 아닌걸로 추측....캐시 시간과(1시간) 데이터 갱신 속도(?1분 이내에서 바뀜)가 맞지 않다..
- 그리고 컨텐츠가 비노출 되는 경우가 있는것도 보아, 비노출 처리가 먹히는 건 같긴 하다.. 
원인이 뭘까.. 

## 원인 
- Cache 응답을 받고 난 뒤에 리스트에서 제외처리를 하지 않아서 발생했다. 
- 배포서버는 총 3대인데 타입이 담긴 세션별로, 같은 key값을 가지고 서버들에게 요청을 하기 때문에 매번 응답되는 리스트 값이 달라졌던 것이었다.. 
- 다른 부분은 리스트 응답을 받은 뒤 처리를 했지만, 오류가 났던 부분만 요청전에 제외처리를 하고 리스트 응답 후에는 아무런 처리를 하지 못했다. 
- 결국 내 코드 문제였고 세션체크 이슈는 아니었다 ㅠㅠ 

## f/b
- 배포/운영되던 상용서버가 3대 임을 고려하지 않았다. 
- 만약 로컬 환경이었다면 캐시 오류가 났을시 분명히 문제상황을 확인할 수 있었을 것이다. (서버하나에 캐시시간 1시간) 하지만
운영되는 서버는 3대 라서, 각각 다른 요청값으로 응답을 받은 리스트들을 서버마다 다르게 가지고 있고, 서비스 이용시 매번 페이지 진입시마다 다른 응답값을 반환할 수 밖에 없게 된 것이다.
  * 논외지만 팀의 역할은 빌드된 WAR파일을 운영서버에 넘긴 이후 배포/관리 등은 외부업체에서 진행한다. (정확한 절차는 잘모름)

- CACHE가 문제의 원인이라고 생각하지 않았던건 배포 서버가 3대 였다는걸 고려하지 못 했기 때문이었다. 
- 테스트시 '진입상황'을 제대로 체크하지 않아, 문제 상황을 잘 못 파악했다.(오류가 안나던걸 오류가 났다고 판단했다... )
  * 앞으로는 문제의 상황을 판단할때, 서비스에 진입을 어떻게 했는지를 정확히 되물어보자. 
- 뭐든지 판단의 근거를 '코드레벨'에서 봐야 한다. 
  - 당황하지 말고, 내가 코딩을 하지 않은 제외 정책은 코드를 보고 확인하고, 아니면 되묻자. 
- 프로퍼티에 설정된 초단위 시간들 변환을 실수하지 말자.   
  
  - 남한테 의지하려고 하지말고 내 서비스에 책임감을 갖자. 
  - 내가 실수한걸 남핑계 대지 말자. 