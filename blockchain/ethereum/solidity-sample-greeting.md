## test  
- remix에서 아래 코드를 컴파일 했더니 엄청난 에러가 난다.

```
pragma solidity ^0.4.16;

contract HelloWorld {
    
    string public greeting;
    
    // 생성자
    function HelloWorld(string _greeting) { // solidity는 메서드의 인수앞에 메서드 선언
        greeting = _greeting;
    }
    
    // 메서드 선언
    function setGreeting(string _greeting) {
        greeting = _greeting;
    }
    
    // 메서드 선언
    function say() constant returns(string) {
        return greeting;
    }
    
}
```