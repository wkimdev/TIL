## issue
- 아래처럼 응답받는 데이터가 있다.
- 내려오는 데이터 타입은 변경 불가능. 
  
#### input
- `|header|value01|value02|main|main01|main02|`

#### response
- `header`일 경우 처리 
- `main`일 경우 처리 
 
```
// 에러나는 코드입니다~ 
public static void main(String[] args) {
		
		String[] arrInfo = {"|header|value01|value02|main|main01|main02|"}; // 실제 예제는 클래스 타입 (오브젝트) 
		String[] test = new String[arrInfo.length];
		test = arrInfo.split("|");
		
		String header = test[0];
		String main = test[4];
		
		System.out.println(header);
		System.out.println(main);
		
	}
```
  
 
#### todo 
- 전부를 처리하지 않고 주어지는 type에 묶여진(?)데이터의 길이 만큼 반복문을 돌면서 list에 넣기..
- string을 header, main미리 자르고... 
- https://stackoverflow.com/questions/41604471/split-string-in-an-array

  
