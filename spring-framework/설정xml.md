# web.xml
- Web Application의 Deployment Descriptor(환경 파일)로서 XML 형식의 파일

## web.xml에 작성되는 내용
   
```
-ServletContext의 초기 파라미터 (servlet-context.xml)  
-Session의 유효시간 설정
 
-Servlet/JSP에 대한 정의
-Servlet/JSP 매핑
  
-Mime Type 매핑
-Welcome File list
  
-Error Pages 처리
-리스너/필터 설정
-보안

```
  
#### 역할 
  
```
- (1) dispatcher 등록
- (2) servlet-context.xml(스프링 설정파일)을 넣었다.  ==> init-param (초기 파라미터)  
```
   * 스프링 컨테이너가 만들어져야 한다. 
     * 컨테이너가 만들어지면!! handler mapping, handler adapter, view resolver는 자동으로 생성된다.(기본 객체가 자동 생성)     
     * 여기선 view파일을 bean 생성해서 설정하고 있다. (유기적 연결관계!!)  
    
- 실제 작업은 controller, view밖에 없다.. 
  
## servlet-context 
- `<annotation-driven/>` 어노테이션 설정 가능하게 해주는 설정.
  
  
## root-context  
- spring설정 파일 

## model.setAttribute  
- 개발자는 model 객체에 데이터를 담아서 dispatcherServlet 에 전달 가능.
- `dispatcherServlet` 에 전달된 model data 는 view에서 가공 되어 클래스에 응답 처리. 

## Reference
- web.xml이란?|작성자 theone
