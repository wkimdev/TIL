## 가장 긴 체인
- 특정 시점에 옳은 체인은 하나만 존재해야 한다. 
- 체인이 길다는 것은 다른 노드가 아직 받지 못한 블록을 가지고 있다는 것이다. 

## 노드 사이에 통신이 있어야하는 것은 블록체인의 필수요소  
- 데이터의 ‘싱크’를 맞춰야 하기 때문
- 노드가 새 블록을 만들면 그것을 네트워크로 방출(발송,broadcast)해야한다.
- 노드 간에 연결될 때, 각자 지니고 있는 가장 마지막 블록이 무엇인지를 파악한다.
- 자기보다 긴 체인과 연결되면 상대가 가진 블록 중 내가 가진 블록 이후의 모든 블록을 추가하여 싱크를 맞춘다. 

## validate check
- 이전블록과 새로생성된 블록 인덱스를 비교해 검증.

## 다른 노드와의 통신 check
- 노드 사이의 통신은 블록체인의 필수요소!. --> 데이터의 '싱크'를 맞춰야 하기 때문.
- 노드간 제어가 필요함.
- 적용되어야할 룰.
> 1.노드가 새 블록을 만들면 그것을 네트워크로 방출(broadcast, 발송)해야 한다.   
 2. 노드간에 연결될때, 각자 지니고 있는 가장 마지막 블록이 무엇인지 파악한다.   
 3. 자기보다 긴 체인과 연결되면 상대가 가진 블록 중 내가 가진 블록 이후의 모든 블록을 추가하여 싱크를 맞춘다.   



## minig
- 마이닝을 구현하고, 트랜잭션 기능을 구현하기 위선 코드내에서 유효한 해시값을 찾고 난이도를 조절하는 메서드가 필요하다. !
- difficulty, nonce
- difficulty를 구하기 위해선 공식이 필요하다... (Steemit 이런데 자료 있음..)

## 작업증명
- 작업증명 : 마이닝 + 난이도 조절(difficulty, nonce)
- 트랜잭션을 구성하려면 채굴에 대한 보상이 코드에 있어야 함.
- 유효한 hash 값을 찾기 위해선 nonce값을 증가시켜야 한다. 
- 아래 코드를 통해 해시값을 찾고 유효한지 검증 가능.

```
// 유효한 hash값을 찾기위한 nonce값 증가
const findBlock = (index: number, previousHash: string, timestamp: number, data: string, difficulty: number): Block => {
    let nonce = 0;
    while (true) {
        const hash: string = calculateHash(index, previousHash, timestamp, data, difficulty, nonce);
        if (hashMatchesDifficulty(hash, difficulty)) {
            return new Block(index, hash, previousHash, timestamp, data, difficulty, nonce);
        }
        nonce++;
    }
};


// difficulty ....?
const hashMatchesDifficulty = (hash: string, difficulty: number): boolean => {
    const hashInBinary: string = hexToBinary(hash); //binary로
    const requiredPrefix: string = '0'.repeat(difficulty); //
    return hashInBinary.startsWith(requiredPrefix);
};
```

## 난이도 설정.
- 난이도(difficulty)를 어떻게 결정?
- 해시값 습득률 = 난이도   

```
// BLOCK_GENERATION_INTERVAL: 블록은 얼마나 자주 채굴되는가(Bitcoin의 경우 10분 간격이죠.)
// DIFFICULTY_ADJUSTMENT_INTERVAL: 난이도difficulty는 얼마나 자주 조정되는가(Bitcoin은 2016블록마다 조정돼요.)

const getDifficulty = (aBlockchain: Block[]): number => {
    const latestBlock: Block = aBlockchain[blockchain.length - 1];
    if (latestBlock.index % DIFFICULTY_ADJUSTMENT_INTERVAL === 0 && latestBlock.index !== 0) {
        return getAdjustedDifficulty(latestBlock, aBlockchain);
    } else {
        return latestBlock.difficulty;
    }
};

// 난이도 조정
const getAdjustedDifficulty = (latestBlock: Block, aBlockchain: Block[]) => {
    const prevAdjustmentBlock: Block = aBlockchain[blockchain.length - DIFFICULTY_ADJUSTMENT_INTERVAL];
    const timeExpected: number = BLOCK_GENERATION_INTERVAL * DIFFICULTY_ADJUSTMENT_INTERVAL;
    const timeTaken: number = latestBlock.timestamp - prevAdjustmentBlock.timestamp;
    
    if (timeTaken < timeExpected / 2) {               // ( 블록채굴 빈도수 * 난이도 조절 빈도수 ) / 2 가 더 클경우 .... ? 
                                                      // 그러니까.. 예상했던 것보다 블록채굴시간이 더 빠르다...? 더 빨리 채굴된다. 쉬워서. 
        return prevAdjustmentBlock.difficulty + 1;    // 난이도를 높인다. 
    } else if (timeTaken > timeExpected * 2) {        // 예상했던 시간보다 채굴되는 시간이 더 길경우 
        return prevAdjustmentBlock.difficulty - 1;    // 난이도를 줄인다. 
    } else {
        return prevAdjustmentBlock.difficulty; 
    }
};
```

- 블럭이름 바꾸기

## timestamp를 통해서 정상적인 난이도를 거쳤는지 체크한다.
- timestamp를 이용하면 정상적인 난이도를 거쳤는지 체크할 수 있다.
- 출처 : https://bitcoin.stackexchange.com/questions/68653/the-role-of-timestamp
- 타임 스탬프는 주로 '난이도를 설정'하는 데 사용됩니다. 
- 타임 스탬프가 없으면 새로운 노드는 각 블록을 채취하는 데 걸리는 시간을 알 수 없으므로 각 2016 블록 기간에 사용할 올바른 어려움을 결정할 수 없습니다. 
- 모든 사람들이 난이도를 올바르게 계산할 수 있도록 블록 타임 스탬프가 실시간 대신 사용됩니다.
- 이것은 물론 타임 스탬프가있는 광부가 난이도를 조작 할 수 있음을 의미하지만 노드는 실시간으로이를 확인하고 자체 내부 시계 시간을 기준으로 특정 범위를 벗어난 블록을 무시합니다.


## transaction
- 트랜잭션을 구현하기 위해선 이런 개념을 알아야 한다. ==> publick-key 암호화, 서명, 트랜잭션인풋과 아웃풋 등등.
- 퍼블릭키를 암호화하기 위해선 키 한쌍이 필요하다(public key + secret key)
- public key는 secret key로 부터 만들어진다. 
- 메시지(?)는 private key를 이용하여 signature를 만들 수 있고, 
- 이 signature와 public key를 가진 누구나 그 signature가 특정 private key에 의해 만들어졌다는 걸 증명할 수 있죠. 

## public key 암호화
- 퍼블릭 키 암호화를 위해 elliptic이라는 라이브러리에 포함된 다음의 두 개의 암호화 함수를 사용하
>  1. Hash function (SHA256) for 작업 증명과 블록의 고유성 확보  
   2. Public-key cryptography (ECDSA) for 트랜잭션

## pricate , public
- 

## signature
- 

## 이론
- a주소에서 b주소로 코인을 전송시, 거래시 다음을 검증해야 한다. (비트코인)
> 1. A가 돈이 있는거야?  
2. A가 보낸거 맞아?


- 2를 해결하기 위해 트랜잭션이라는 구조를 사용합니다.
```
트랜잭션의 구조
전송번호 (transaction id, txid)
이전 전송번호 : 나에게 코인을 보내준 전송번호. (transaction id, txid)
서명 : 내가 주소의 주인이 맞다는 서명. (암호화 서명. scriptSig)
받는 주소
받는 금액
```
- 1단계로 트랜잭션을 만들고 이 트랜잭션을 통째로 SHA256 해쉬를 합니다. 그러면 비로소 전송번호 nowtxid가 나옵니다.
- "내가 이 코인의 주인이 맞아" 라는 과정이 들어갑니다. 이것을 암호화서명이라고 합니다.
- 암호화서명!!!
> A개인키를 이용해서 nowtxid를 암호화 함.
A주소를 이용해서 복호화하면 nowtxid가 나옴.( A공개키로 복호화합니다.)




