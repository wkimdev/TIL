<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>javascript array test!!!</title>
</head>
<body>
<script>
	var arr = [];
	var obj = {}; //literal
	
	//javascript object
	var obj = {
			name : 'wkim',
			job  : 'coder'
	}
	
/* 
	객체 : obj
	키(Key) : name, job
	값(Value) : wkim, coder
	속성(property) : ,로 구문하고 키:값의 관계로 이루어져 있다.  ==> name : 'wkim', job  : 'coder'
	
	
	키는 문자열만 가능.
	속성명은 따옴표가 없어도 된다(있어도 상관없다. 띄어쓰기가 있을경우 따옴표로 감싸기).
	ex) var wrap = {'ex ample' : 'wrap' }
	
 */
 
 	//속성값(value)을 가져오고 싶을때 속성의 이름(키)를 호출
 	//접근 1) .닷 연산을 이용해 obj객체 안의 속성들에 접근하기.주로 닷연산-마침표로 사용
 	//접근 2) []안에 속성명을 적어서 접근. 속성명에 띄어쓰기가 있는경우 []를 사용
 	
 	obj.name;	//wkim
 	obj.['name']; //wkim
 	obj.['ex ample'];
 	
 	
 	//객체안의 속성바꾸기, 
 	//객체안에 객체가 들어간 경우. 객체를 사용해 복잡한 데이터 구조 접근 가능
 	var obj = {
 			body : {
 				height : 160
 				weight : 45
 			}
 	};
 	obj.body.height;	//160
 	//객체 속성 삭제
 	delete obj.body.height;
	
 	
 	//배열(Array)
 	//배열은 []로 감싸서 나타내고, 객체 리터럴처럼 안에 무엇이든지 들어갈 수 있다.
 	//배열안에 배열, 배열 안에 객체, 함수가 들어가기도 한다.
 	//자바스크립트는 배열의 길이를 미리 정할 필요 없다.(자동으로 증감)
 	//배열은 객체보다 몇가지 추가적인 기능을 제공
 	var array = [];	//var array = new Array();보단 []로 선언하는게 권장사항
 					//[]게 선언하는 배열을 '배열 리터럴'이라고 부른다.
	 					
 	
 	
	
</script>

</body>
</html>