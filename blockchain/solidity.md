# 블록체인과 이더리움 문제
- 프라이버시
- 트랜잭션 코스트 (gas fee)
- 트랜잭션 스피드 (이더 약 1초에 20개, 약 10번 정도의 컨펌 3분 소요 필요)
- 블록 사이즈 (매달 약 2g의 용량이 필요)
- 모든 비즈니스에 블록체인이 정답이 아니다.

# 솔리디티
- evm 타깃으로 디자인
- (ethereum virtual machine)
- 튜링완전 특징(반복문 제어문 사용 가능)
- msg.sender(보내는 주소), 
- msg.value(보내는 값)
- storage - 상태변수, 로컬변수
- 가시성(external, public, internal, pivate)

# 가스
- 가스 리밋 : 수수료의 한계치
- 가스프라이스 : 가스당 가격
- 가스 프라이스*가스 사용량 = 수수료
-5 이상이면 실행이 안되어서 가스를 실행할 수 있다?