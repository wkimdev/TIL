## DI(dependency injection)
- 이것만 생각하자, 
- 배터리 일체형 장난감(재사용 불가), 배터리 분리 장난감(재사용 가능, 의존성 있는 무언가를 외부에서 주입한다.)

#### 개념
- 객체간의 의존성을 자신이 아닌 외부에서 주입하는 개념
- 아래 코드 예시를 가지고 학습 중... 

#### MainPrint
   
```
public class MainPrint {
	
	public static void main(String[] args) {
		// main 클래스가 printservice에 의존성이 있다. 
		// MainPrint의 기능을 바꾸고자 할때 PrintService도 같이 바꿔줘야 하기 때문이다. 
		
		PrintService bean = new PrintService();
		
		bean.printLetter("study ing..");
	}

}

```

#### printservervice  
```
public class PrintService {
	
	public void printLetter(String letter) {
		System.out.println("this is your letter ==>"+letter);
	}
	
}
``` 
  


## 출처 
https://mo-world.tistory.com/entry/IOC%EC%99%80-DI-%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC-%EC%8A%A4%ED%94%84%EB%A7%81-%EA%B0%9C%EB%85%90-%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-%EC%89%BD%EA%B2%8C-%EC%84%A4%EB%AA%85