import java.util.HashMap;

public class JavaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//collection list, arrayList
		
		//collection은 순서나 집합적인 저장공간을 뜻
		
		//map : key, value로 data 핸들
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//data삽입
		map.put("id", "student");
		map.put("name", "kimwi");
		
		//map 
		System.out.println("id :"+map.get("id"));
		System.out.println("name :"+map.get("name"));
		
		
		

	}

}
