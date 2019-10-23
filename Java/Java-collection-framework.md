## java collection framework
- 자바의 컬렉션 프레임워크는 list, set, map이 있다. 
- 자바의 list는 중복을 허용한다. 
- set은 중복을 허용하지 않는다. 
- 아래의 코드를 돌리면 차이를 확인할 수 있다. 
- 이제라도 제대로 알고 담에는 실수 하지 말자.   
  
```
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
## collection인터페이스
- collection 인터페이스에 정의된 메서드는 다음과 같다. 
- add, addAll 
- contains, containsAll : 지정된 객체또는 collection의 객체들이 Collections에 포함되어 있는지 확인한다. 
- equals : 동일한 collection인지 확인한다. 
- remove, removeAll : 지정된 객체 / 지정된 Collection에 포함된 객체들을 삭제한다. 

## List인터페이스
- 순서가 있는 데이터의 집합을 말함. 데이터의 중복을 허용한다. 
- 구현클래스 : ArrayList, LinkedList, Stack, Vector
- Vector와 ArrayList는 컬렉션 프레임웍에서 가장 많이 사용되는 컬렉션 클래스 이다. 
- 이둘은 List인터페이스를 구현하기 때문에 데이터 저장순서가 유지되고, 중복을 허용한다는 공통적 특성을 가지고 있다. 
- 공통점 : 
```
List인터페이스를 구현한다. 
          , 저장순서가 유지되고 중복을 허용한다. 
          - 데이터의 저장공간으로 **배열**을 사용한다. 
```  
  
- 차이점 : 
```  
Vector는 멀티쓰레드에 대한 동기화가 되어 있으나 ArrayList는 그렇지 않다.  
```
  
- Vector와 ArrayList는 **Object배열** 을 이용해서 데이터를 순차적으로 저장한다.  예를 들어 , 첫번째로 저장한 객체는
object배열의 0번째 위치에 저장되고, 그 다음에 저장하는 객체는 1번재 위치에 저장된다. 이런 식으로 계속 배열에 순서대로 저장되며, 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 저장된다. 
  

## Map
- key, value쌍으로 이루어짐
- 순서는 유지 되지 않으며 키는 중복을 허용하지 않고 값은 중복을 허용한다. 

## 출처
- 자바의 정석
