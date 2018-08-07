## Exception handling
- 1. 에러 발생시 redis로 다시 생성 요청 ==> 이때의 데이터를 모르겠다.
- 2. 생성 요청시 객체에 retry횟수 증가후 보낸다. ?  
	==> 은행같은곳에서 비번 입력후 5회 이상 인증 실패하면 계정 잠기고,, 뭐 어디연락하라고 처리하는것처럼.  
	이 서비스에도 create address를 하는데 그런 처리를 해둔거임.    
	- 3. 특정 횟수에 도달하면 에러 메세지를 redis로 publish한다.  
- 4. 횟수에 도달전에는 다시 한번 요청한 정보를 통해서 주소가 생성되었는지 확인하고 재요청을 할것인지 결정한다.  

#### @value의 Properties값 설정
- ICO-Server에서 **rightpush**로 큐데이터를 던져줌 ==> WalletService - **leftpop**으로 큐데이터 꺼내옴.
- walletService에서 아래의 프로퍼티값을 사용하도록 설정해놓았다.

> @Value("${redis.queue.key}")
private String REDIS_QUEUE_KEY;	//dc:create:address ??
	
> @Value("${redis.retry}")
private Integer REDIS_QUEUE_RETRY; //5
	
	

```	
	// 에러가 발생했을 경우, requestCreateWalletInfo를 다시 retry로 메세지를 보낸다.
try {
	// json String convert Object
	// requestCreateWalletInfo --> SRING
	// WalletVO.class --> class type
	// 이걸 그냥 walletVO type으로 받는다.	
	WalletVO retryMessageVO = CommonUtil.convertObjectFromJsonString(requestCreateWalletInfo, WalletVO.class);
	
	// 생성한VO에서 getretry를 가져온다. ==> 아니 이걸 어디서 가져오지???
	// 기본 5로 프로퍼티에 설정되어 있음.
	// 아래 if문 안으로 들어왔다는건, 이미 5회 retry를 실행했다는 것.
	if(retryMessageVO.getRetry() == REDIS_QUEUE_RETRY){
		
		//무한 반복을 회피하기 위해서 retry횟수가 일정 회수에 도달하면 그냥 에러 메세지를 보낸다. ?
		// 아까 생각한 은행 계정 잠금 같이.. 화면으로 다시 돌아가서 뭔가 처리를 다시 해야 함.
		redisMessagePublisher.publish("주소 생성 다시 하삼");
		
	} else {
	     // 위에서 생성한 주소가 업데이트 이후에 발생한 에러인지 한번더 확인해야한다. ==> ???
		 // retry가 5회 이내일경우,,
		 // 주소가 업데이트 되지 않았다면 주소 생성 요청을 다시한다. /위의 IF문과 뭐가 정확히 다르지??
		WalletVO checkWallet = this.getwallet(retryMessageVO); //==> 여기에 무슨 값이 들어갈까???????, retryMessageVO에 뭐가 들어가 있지????		
		if( checkWallet == null || checkWallet.getAddress() == null || checkWallet.getAddress().toString().equals("")){
				int retry = retryMessageVO.getRetry() + 1;
				retryMessageVO.setRetry(retry);
				// queue를 밀어넣네?? -> 큐에 집어넣는거라고 생각해도 되나???
				// 뭔지는 모르겠는데 저 redis_queue_key가 create_address임.
				listQueueOperations.rightPush(REDIS_QUEUE_KEY, CommonUtil.convertJsonStringFromObject(retryMessageVO));
				// retryMessageVO를 인자로 삼아, 
				// redis retry pub message 기능을 하는 메서드를 호출하네?
				// 왜 이렇게 하는게 새로운 주소 요청이 되지?????
				redisMessagePublisher.retry(CommonUtil.convertJsonStringFromObject(retryMessageVO));												
		}		
	}
	
	//저 위에것도 안먹혔다니.. 아래 익셉션 처리를 해야겠다.
} catch(Exception e1){
	// requestCreateWalletInfo가 API 서버로부터 잘못 왔기 때문에 
	// String에서 Object로 매핑하는 과정중 발생하는 이 에러는 에러메세지를 publisher한다.	==> 이건 어떻게 예측하지??
	// 아래 메세지 내역을 바뀔 수 있음
	redisMessagePublisher.publish("Request Info is Bad Request");
  }
} else {

// 이미 다른 클러스터링 되고 있는 다른 노드 서비스에서, 푸시된 큐 메세지?키를?가지고 갔다면, 아래의 메세지를 던져준다.
			LOG.info("Already Queue is Pop by Other Node!!!!!");
}

```