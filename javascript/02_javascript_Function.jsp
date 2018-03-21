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
	//함수선언, 끝에 ;붙이지 않는다.
	function addOne(x){	//이때 x는 매개변수(parameter)
		var y = x+1;
		return y;
	}
	
	//===위아래 표현식은 호이스팅 현상의 차이===
		
	//함수 표현식
	var addOne = function(x){
		var y = x+1;
		return y;
	}
	
	var i = addOne(1);	//이때 1은 인자(argument)
	i; //2
	
	//함수 중에는 return 을 하지 않는 함수도 있다.
	//return이 없는 함수는 자동으로 underfined를 반환한다.
	//alert는 return이 아니다.
	//ex
	var dateChecker = function(){
		var date = new Date();
		alert(date);
	}
	dateChecker(); //undefined 이게 return 값
				   //return 이후에는 함수가 종료되어 실행되지 않는다.
	
	//객체나 배열의 값으로 함수가 들어갈 수 있다.
	//아래 함수 호출시 a.b();
	//이렇게 속성값으로 사용되는 함수를 '메소드'라고 부른다.
	var a = {
		b : function(){
			return;
		}
	};				   
	
	var mother = function(func){
		func();
	};
	var children = function(){
		alert('function안의 func!!');
	};
	mother(children);	//인자 children function안의 func!!
						//이렇게 값으로 사용되는 함수를 '1급 함수'하고 	부른다.
						//함수가 인자값과 매개변수로 사용가능	
</script>

</body>
</html>