import java.util.HashMap;

public class JavaTest {

	public static void main(String[] args) {
		//map : key, value로 data 핸들		
		HashMap<String, String> map = new HashMap<String, String>();
		
		//data삽입
		map.put("id", "student");
		map.put("name", "kimwi");
		
		//map 
		System.out.println("id :"+map.get("id"));
		System.out.println("name :"+map.get("name"));
		
		/*
		 * 
		result 
		id :student
		name :kimwi	
		*/
	}

}
