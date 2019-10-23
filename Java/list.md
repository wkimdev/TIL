#### Arrays.asList
- 배열을 리스트로 바꿀 경우 
- Arrays.asList는 배열을 리스트로 반환해 준다.

```
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class TestArrayAsList {
   public static void main(String[] args) {
      String[] strs = {"alpha", "beta", "charlie"};
      System.out.println(Arrays.toString(strs));   // [alpha, beta, charlie]
 
      List<String> lst = Arrays.asList(strs); // new ArrayList<String>(); 대신에 사용
      System.out.println(lst);  // [alpha, beta, charlie]
 
      lst.add("ttt");     // error : asList()로 List를 생성하면 원소를 새롭게 추가할 수 없음
 
      // Changes in array or list write thru
      strs[0] += "88";
      lst.set(2, lst.get(2) + "99"); // 2번째 인덱스 원소에 charlie99 넣음
      System.out.println(Arrays.toString(strs)); // [alpha88, beta, charlie99]
      System.out.println(lst);  // [alpha88, beta, charlie99]
 
      // Initialize a list using an array
      List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
      System.out.println(lstInt);  // [22, 44, 11, 33]
   }
}
[출처] 자바 Arrays.asList() - 배열을 List 처럼 사용|작성자 evelyn
```

## 출처
- http://blog.naver.com/PostView.nhn?blogId=evella&logNo=90195439020&parentCategoryNo=&categoryNo=44&viewDate=&isShowPopularPosts=true&from=search
  
