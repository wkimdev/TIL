## JSON.parse()
- **JSON 표기법이 포함 된 문자열** 을 Javascript 객체로 변환하는 데 사용
- "[object Object]"값은 유효한 JSON이 아닙니다. 
-  **JSON 문자열의 구문을 분석** 하고, 그 결과에서 JavaScript 값이나 객체를 생성.    
  
```  
 
var json = '{"result":true, "count":42}';
obj = JSON.parse(json);

console.log(obj.count);
// expected output: 42

console.log(obj.result);
// expected output: true

``` 
  


## JSON.stringify()
- **JavaScript 값이나 객체를** JSON 문자열로 변환.  
  
```  
console.log(JSON.stringify({ x: 5, y: 6 }));
// expected output: "{"x":5,"y":6}"

console.log(JSON.stringify([new Number(3), new String('false'), new Boolean(false)]));
// expected output: "[3,"false",false]"

console.log(JSON.stringify({ x: [10, undefined, function(){}, Symbol('')] }));
// expected output: "{"x":[10,null,null,null]}"

console.log(JSON.stringify(new Date(2006, 0, 2, 15, 4, 5)));
// expected output: ""2006-01-02T15:04:05.000Z""
```   
  
  
## 헤깔리지 말자!
- 배열은 객체 [] --> Object 


## 참고
- https://stackoverflow.com/questions/14432165/uncaught-syntaxerror-unexpected-token-with-json-parse
- https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/JSON/parse

