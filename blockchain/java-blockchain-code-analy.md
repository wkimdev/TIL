## 가장 긴 체인
- 특정 시점에 옳은 체인은 하나만 존재해야 한다. 
- 체인이 길다는 것은 다른 노드가 아직 받지 못한 블록을 가지고 있다는 것이다. 

## 노드 사이에 통신이 있어야하는 것은 블록체인의 필수요소  
- 데이터의 ‘싱크’를 맞춰야 하기 때문
- 노드가 새 블록을 만들면 그것을 네트워크로 방출(발송,broadcast)해야한다.
- 노드 간에 연결될 때, 각자 지니고 있는 가장 마지막 블록이 무엇인지를 파악한다.
- 자기보다 긴 체인과 연결되면 상대가 가진 블록 중 내가 가진 블록 이후의 모든 블록을 추가하여 싱크를 맞춘다. 

## minig
- 마이닝을 구현하고, 트랜잭션 기능을 구현하기 위선 코드내에서 유효한 해시값을 찾고 난이도를 조절하는 메서드가 필요하다. !
- difficulty, nonce

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
