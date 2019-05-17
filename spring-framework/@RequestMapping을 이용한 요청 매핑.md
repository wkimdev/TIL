# @RequestMapping을 이용한 요청 매핑
- 컨트롤러는 사용자가 요청한 메서드를 처리할 url 과 메서드가 정의된 곳
- 클라이언트는 url로 요청을 전송
- **요청 URL을 어떤 메서드가 처리할지 여부를 결정하는 것이 “@RequestMapping“**
  
  
## @RequestMapping을 이용한 경로 지정
  
```
@Controoler 
public class EventController { 
  @RequestMapping("/event/list") 
  public String list(ModelMap model){
  .... 
  }
}
```

## 여러 경로를 한 메서드에 처리하고 싶다면, 배열로 경로 목록을 지정하면 된다.
```
@Controoler 
public class HomeController { 
  @RequestMapping({"/main", "/index"}) 
  public String list(ModelMap model){ 
    .... 
  } 
}
  
```
  
## 클래스와 메서드에 @RequestMapping 적용하기!!!!
- 컨트롤러와 메서드에 @RequestMapping 애노테이션을 모두 사용하면, 클래스에적용한 값과 메서드에 적용한 값을 조합해서 매핑될 경로를 결정한다.
    
```
@Controller 
@RequestMapping("/event") 
public class EventController{ 
  @RequestMapping("/list") 
  public String list(Model model) { 
    ... return "event/list";
  } 
  
  @RequestMapping("/home") 
  public String home(Model model){ 
  ... }
}
  
```
  
  
## 출처
- https://yang1650.tistory.com/133 [오늘과다른 양형!]
