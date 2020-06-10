## equals와 contentsEquals의 차이 
#### equals()
- 문자열의 내용을 비교할 뿐만 아니라 다른 문자열이 string 인스턴스인 것 까지 확인 
- 즉, String 객체와 StringBuffer 객체의 문자열을 비교할 수 없음

#### contentsEquals
- 내용(문자순서)만 비교하고 string 인스턴스인 것 까지 확인하지 않음. 
- 즉, String 객체를 StringBuffer / StringBuilder / Char Array 객체들과 비교 가능

#### `==`
- 단순한 비교연산자로서 주소값으로 비교한다. 


