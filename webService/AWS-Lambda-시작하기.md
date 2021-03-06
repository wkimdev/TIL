# AWS Lamda

## 문제정의

- 큐시트 ..
- 데이터 속도

## 찾아봐야 할 것

1. 스케줄러
2. dynamo에 스케줄 어떻게 update 
3. ec2가 스케줄을?
4. 큐시트가 변경될 경우 어떻게 클라이언트에 응답을 쏠 것 인지(사용자가 몰렸을 경우) 
5. 람다 자체가 스케일 아웃이 되는지 ⇒ vpc container 

## 개념

- AWS Lambda : 함수!
    - 언제 동작할시
    - 어떤 동작을 할지 설정할 수 있다.
    - event : 다양함.
        - 1. 로그
        - 2. 별도의 웹서버 처럼 운용 (클라에 요청이 발생했을때, 람다에 요청이 발생해서 반환할 수 있게 끔)
        - 3. 처리 후 db에 로그 남기기 가능
        - 4. 처리 후 data를 남길 수 있다.

- 서버에 대한 걱정 없이 코드를 실행하고, 사용한 컴퓨팅 시간에 대해서만 비용을 지불하는 구조
- Lambda 서비스에 작성한 비즈니스 로직을 올려놓고 http 요청이나 AWS 내의 이벤트가 발생하면 해당 코드가 실행되는 구조.
- 그래서 소스코드만 관리하면 EC2처럼 서버를 직접 관리하지 않아도 되므로 복잡하지 않은 처리에 사용하기에 최적화 되어 있다. 가격은 월별 1백만 회, 400,000GB-초의 컴퓨팅 시간까지는 무료다.
- Lambda는 이벤트 기간으로 이벤트가 발생했을 때 함수를 실행하기 때문에 단위당 하나의 Lamda function을 만들어야 한다. (aws에서의 lambda function을 말함)

## 기존 방식

서버 인스턴스 + 톰캣 구동  ⇒ 이 위에 웹서비스를 올릴 수 있음. lamda에는 이런 절차가 필요 없음? 

단 웹서비스처럼 이용하기 위해서 'API Gateway'가 필요하다.  

계정 복구 중 이슈

- Amazon Web Services에서 1 USD를 청구한 이유는 무엇입니까?  ⇒ 계정 확인 용, 3-5일 이내로 돌려줌 ㅇㅇ

Lambda Create

- 보통 파이선과 node.js를 많이 사용한다.

## TODO
- API Gateway
- cloudWatch
- step function
- Lambda
- Dynamo DB
  



#### 아래의 글도 더 자세히 읽어보면 좋을 것 같다. 
- [AWS Lambda를 시작하기 전 알았으면 좋았을것](https://medium.com/harrythegreat/aws-lambda%EB%A5%BC-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-%EC%A0%84-%EC%95%8C%EC%95%98%EC%9C%BC%EB%A9%B4-%EC%A2%8B%EC%95%98%EC%9D%84%EA%B2%83%EB%93%A4-788bd3b3bdd2)

## 출처

- 유툽 aws lambda 생성 강의
- [https://blog.outsider.ne.kr/1205](https://blog.outsider.ne.kr/1205)
