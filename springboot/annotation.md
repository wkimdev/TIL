## Annotation

#### event
- application event는 느슨하게 결합된 구성 요소 사이의 정보를 교환하는 수단.

#### annotation 기반 이벤트 Listener
- annotation 기반 이벤트 Listener를 지원한다.
- 메소드의 Signature와 일치하는 ApplicationListener를 자동으로 등록하기 위해 관리 Bean의 메소드에 @EventListener를 사용하여 Annotation을 붙일 수 있다.


#### DTO와 DAO
- DTO(Data Transfer Object) : VO(Value Object)라고도 함. 계층간 데이터를 교환하기 위한 자바빈즈.
- DAO(Data Access Object) : db를 사용해 데이터를 CRUD 하는 기능을 전담하도록 하는 오브젝트. 


 #### POJO
 - Plain Old Java Object
 - Java Bean
 - getter, setter 로 이루어진 value object성의 java bean
 - 그것은 클래스 상속을 강제하지 않고, 인터페이스 구현을 강제하지 않으며, 애노테이션 사용을 강제하지 않는다.
   
   
 ```
 public class SimpleBean {
    private String name;
    private String age;
 
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
 
    public void setAge(String age) {
        this.age = age;
    } 
    public String getAge() {
        return this.age;
    }
 
}
 ```
   
 ## reference
 - https://joonyon.tistory.com/18
