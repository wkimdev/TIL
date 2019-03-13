## java collection framework
- 자바의 컬렉션 프레임워크는 list, set, map이 있다. 알고 있다고 생각을 하는데 왜 면접때 말을 못했는지.... 긴장했다는것은 핑계겠지? 내 실력이 부족해서겠지? .. ㅜㅜ
- 각설하고 
- 자바의 list는 중복을 허용한다. 
- set은 중복을 허용하지 않는다. 
- 아래의 코드를 돌리면 차이를 확인할 수 있다. 
- 이제라도 제대로 알고 담에는 실수 하지 말자.   
  
```
//Please don't change class name 'Main'
import java.util.ArrayList;
import java.util.HashSet;

import java.util.Iterator;

class Main {

  public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("one");
        al.add("two");
        al.add("two");
        al.add("three");
        al.add("three");
        al.add("five");
        System.out.println("array");
        Iterator ai = al.iterator();
        while(ai.hasNext()){
            System.out.println(ai.next());
        }

        HashSet<String> hs = new HashSet<String>();
        hs.add("one");
        hs.add("two");
        hs.add("two");
        hs.add("three");
        hs.add("three");
        hs.add("five");
        Iterator hi = hs.iterator();
        System.out.println("\nhashset");
        while(hi.hasNext()){
            System.out.println(hi.next());
        }
    }
}


```
