## 커스텀 어노테이션
- 만들기

1. 어노테이션 인터페이스 작성  
   
```
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InsertIntData {
    int data() default 0;
}
```
  
2. 어노테이션을 사용할 예제 클래스 작성 
    
```
public class AnnotationExam01 {
    @InsertIntData(data = 30)
    private int myAge;

    @InsertIntData
    private int defaultAge;

    public AnnotationExam01() {
        this.myAge = -1;
        this.defaultAge = -1;
    }

    public int getMyAge() {
        return myAge;
    }

    public int getDefaultAge() {
        return defaultAge;
    }
}
}

```
  

## Reference
- https://elfinlas.github.io/2017/12/14/java-custom-anotation-01/
