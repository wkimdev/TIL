# javascript named function 

## javascript named function

- 아래와 같은 함수 표현식을 사용할 일이 생겼다.

```
    // 단순한 예제 
    var func = function Action(x,y){
    	result = x+y;
    	return result;
    }
    
    var test = func();
``` 
   
- **기명 함수 표현식은 익명함수 표현식과 달리 그 이름을 함수 내의 지역변수로 바인딩한다는 차이점**이 있다. 이 특징을 재귀 함수 표현식을 작성하는데 사용할 수 있다.출처:

    var f = function find(tree, key) {
    
        if ( !tree) {
            return null;
        }
    
        if ( tree.key === key) {
            return tree.value;
        }
    
        return find(tree.left, key) || find(tree.right, key);   
    };
    

- 기명 함수표현식(named function )이라고도 불리는 함수 표현식은 Error 객체와 디버거에서 스택 추적을 개선하기 위해 기명 함수 표현식을 사용-
    - Named functions are very useful for identifying what functions caused errors during development as well as when retrieving logs from your users. =⇒ 이걸 언제 확인할 수 있을까...

    [ 주의점 ]

    - 버그가 있는 자바스크립트 실행 환경에서 기명 함수 표현식의 호이스팅과 중복 할당을 주의-
    - **기명 함수 표현식의 사용을 자제하고, 배포하기 전에 제거하라.**
    - **ES5를 제대로 구현한 실행 환경에 배포한다면, 걱정할 필요가 없다.**

## 출처

- [https://weicomes.tistory.com/152](https://weicomes.tistory.com/152)
- [https://www.linkedin.com/pulse/javascript-named-vs-anonymous-functions-chris-ng](https://www.linkedin.com/pulse/javascript-named-vs-anonymous-functions-chris-ng)
-
