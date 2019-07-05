## continue  
- 지면 비노출처리시 continue를 써서 특정 조건때 아예 모델에 맵핑하지 않는 방식으로 처리하고 있다. 
- 조건  
  
```
String session = "session";
String menu = "menu";
```  
  
  
  
```
System.out.println("11");
for (int i = 0; i < 3; i++) { // 정답. for문으로 빠짐 (for문에서 다음순서로 넘어감)
	
	if (true) {
		if (session.equals("session")) {
			continue;	// 여기에 걸리면 어디로 빠지는지 
		} else if(menu.equals("menu") ) {
			System.out.println("menu~");
		}
	}
	
	System.out.println("22");
	if(session.equals("menu")) {
	}
}
```
  
