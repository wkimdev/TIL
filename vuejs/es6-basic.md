## ES6��?
- ECMAScript 2015�� ������ ���
- 2015���� ES5(2009)�̷��� ������ ù ������ ������Ʈ�� ���ε� ��
- �ֽ� Front-End FrameworK�� ����Ʈ, angular, vue���� �ǰ��ϴ� ��� ����
- ES5�� ���� ������ ���������� �ͼ������� �ڵ��� �ξ� ���ϰ� �� �� ����.

# Babel
- �� ���� ������ �߿��� es6�� ����� �������� �ʴ� �������� �����Ƿ� transpiling�� �ʿ�
- ES6�� ������ �� �������� ȣȯ ������ ES5�� ��ȯ�ϴ� �����Ϸ�.

# const & let - ���ο� ���� ���� ���
- ��� ���� {}�� ������ ������ ���ѵǾ���
- const :�ѹ� ������ ���� ���ؼ� ������ �� ����(��� ����)
- let : �ѹ� ������ ���� ���ؼ� �ٽ� ������ �� ����.

�� Ư¡�鿡 �˾ƺ��� ���� es5 �ΰ��� Ư¡ ����

1) �� ���Ҵ� �Ұ���.
const a = 10;
undefined
a = 20;
VM105:1 Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:3
(anonymous) @ VM105:1
var c = 10;
undefined
c = 20;
20

2) ���� ���Ҵ� ����
let x = 10;
undefined
let x = 20;
VM156:1 Uncaught SyntaxError: Identifier 'x' has already been declared
    at <anonymous>:1:1
(anonymous) @ VM156:1
x = 30;
30


# es5Ư¡ - 1) ������ scope(= ����)
- ���� �ڹٽ�ũ��Ʈ�� (es5)�� {}�� ������� �������� ������
var sum = 0;
for (var i = 1; i <= 5; i++) {
	sum = sum + i;
}
console.log(sum);
console.log(i); // global scope�� ���� - �ڹٶ�� ���� ����.


# 2) Hoisting
- Hoisting�̶� ������ �Լ��� ������ �ؼ��Ⱑ ���� ��ܿ� �ִ� ��ó�� �ν��Ѵ�.
- js �ؼ���� �ڵ��� ���� ������ ���� ���� '�Լ������'�� '����'�� ���� �޸� ������ ���� Ȯ���Ѵ�.
- ����, function a()�� var�� �ڵ��� �ֻ������ ���� �÷��� ��(hoisted)���� ���δ�.

function a() { return 6 + 10; } //function statement

var sum = function() {
	// function expression
	return 2 + 2;
}


# �Ʒ��� �ڵ� �����Ҷ� �ڹٽ�ũ��Ʈ �ؼ����� �ڵ� ���� ��������?
~~~
var sum = 5;
sum = sum+i; <-- �Ϲ������� �ָŸ�ȣ �ϴٰ� �����Ǵ� �κ�.
function sumAllNumbers() { 
}

var i = 10;
~~~

#1 - �Լ� ����İ� ���������� hoisting
var sum;
function subAllNumbers() {
	//..
}
var i;

// #2 - ���� ���� �� �Ҵ�
sum = 5;
sum = sum + i;
i = 10;


## es5 - let {} ������ ������ ������ ���ѵ�
let sum = 0;
for (let i = 1; i <= 5; i++) {
	sum = sum + i;
}
15
console.log(sum);
VM67:1 15
undefined
console.log(i); //Uncaught ReferenceError: i is not defined
    at <anonymous>:1:13
	

## es5 - const �� ������ �� ���� �Ұ���
const a = 1o;
a = 20; //XX

������, ��ü�� �迭�� ���δ� �����ų �� �ִ�.
a.num = 10;
10
console.log(a); //10 
 
const b= [];
b.push(200);

- let ������ ���� ���ؼ� �ٽ� ���� �Ұ���
let a = 10 ;
let a = 20 ; xx

* const �� �Ҵ��� �ٽ� �ȵǰ�, let�� ������ �ٽ� �ȵȴ�.

-----
function f() {
	{
	let x;
	{
		// ���ο� ��Ͼȿ� ���ο� x�� �������� ����
		const x = "sneaky"
		x = "foo"; //���� �̹� const�� x�� ���������Ƿ� �ٽ� �����ϸ� ������ �߻��Ѵ�.
	}
	// ���� ��� ������ ���ƿԱ� ������ 'let x'�� �ش��ϴ� �޸𸮿� ���� ����
	x = "bar";
	let x = "inner"; // uncaught syntaxError: Indentifier 'x' has already been declared
	}
}


## Arrow Function - ȭ��ǥ �Լ�
- �Լ��� ������ �� function �̶�� Ű���带 ������� �ʰ� => �� ��ü
- ���� ����ϴ� �ݹ� �Լ��� ������ ����ȭ ��.

//ES5 �Լ� ���� ���
var sum = function(a, b){
	return a + b;
}

//ES6 �Լ� ���� ���
var sum = (a, b) => {
	return a + b;
}

sum(10, 20);

// ES5
var arr = ["a", "b", "c"];
arr.forEach(function(value){
	console.log(value);
});

// ES6
var arr = [];
arr.forEach(value => console.log(value)); // a,b,c



# �Լ� ����
var arr = [1,2,3];

arr.forEach(function(value) { console.log(value); });

arr.forEach((value) => console.log(value); )

# ���� 2
//es5
var sum = function() {
	return 1 + 2;
};

//es6
var multiply = () => {
	return 1 * 2;
};
ES6��?

- ECMAScript 2015�� ������ ���
- 2015���� ES5(2009)�̷��� ������ ù ������ ������Ʈ�� ���ε� ��
- �ֽ� Front-End FrameworK�� ����Ʈ, angular, vue���� �ǰ��ϴ� ��� ����
- ES5�� ���� ������ ���������� �ͼ������� �ڵ��� �ξ� ���ϰ� �� �� ����.

# Babel
- �� ���� ������ �߿��� es6�� ����� �������� �ʴ� �������� �����Ƿ� transpiling�� �ʿ�
- ES6�� ������ �� �������� ȣȯ ������ ES5�� ��ȯ�ϴ� �����Ϸ�.

# const & let - ���ο� ���� ���� ���
- ��� ���� {}�� ������ ������ ���ѵǾ���
- const :�ѹ� ������ ���� ���ؼ� ������ �� ����(��� ����)
- let : �ѹ� ������ ���� ���ؼ� �ٽ� ������ �� ����.

�� Ư¡�鿡 �˾ƺ��� ���� es5 �ΰ��� Ư¡ ����

1) �� ���Ҵ� �Ұ���.
const a = 10;
undefined
a = 20;
VM105:1 Uncaught TypeError: Assignment to constant variable.
    at <anonymous>:1:3
(anonymous) @ VM105:1
var c = 10;
undefined
c = 20;
20

2) ���� ���Ҵ� ����
let x = 10;
undefined
let x = 20;
VM156:1 Uncaught SyntaxError: Identifier 'x' has already been declared
    at <anonymous>:1:1
(anonymous) @ VM156:1
x = 30;
30


# es5Ư¡ - 1) ������ scope(= ����)
- ���� �ڹٽ�ũ��Ʈ�� (es5)�� {}�� ������� �������� ������
var sum = 0;
for (var i = 1; i <= 5; i++) {
	sum = sum + i;
}
console.log(sum);
console.log(i); // global scope�� ���� - �ڹٶ�� ���� ����.


# 2) Hoisting
- Hoisting�̶� ������ �Լ��� ������ �ؼ��Ⱑ ���� ��ܿ� �ִ� ��ó�� �ν��Ѵ�.
- js �ؼ���� �ڵ��� ���� ������ ���� ���� '�Լ������'�� '����'�� ���� �޸� ������ ���� Ȯ���Ѵ�.
- ����, function a()�� var�� �ڵ��� �ֻ������ ���� �÷��� ��(hoisted)���� ���δ�.

function a() { return 6 + 10; } //function statement

var sum = function() {
	// function expression
	return 2 + 2;
}


# �Ʒ��� �ڵ� �����Ҷ� �ڹٽ�ũ��Ʈ �ؼ����� �ڵ� ���� ��������?
~~~
var sum = 5;
sum = sum+i; <-- �Ϲ������� �ָŸ�ȣ �ϴٰ� �����Ǵ� �κ�.
function sumAllNumbers() { 
}

var i = 10;
~~~

#1 - �Լ� ����İ� ���������� hoisting
var sum;
function subAllNumbers() {
	//..
}
var i;

// #2 - ���� ���� �� �Ҵ�
sum = 5;
sum = sum + i;
i = 10;


## es5 - let {} ������ ������ ������ ���ѵ�
let sum = 0;
for (let i = 1; i <= 5; i++) {
	sum = sum + i;
}
15
console.log(sum);
VM67:1 15
undefined
console.log(i); //Uncaught ReferenceError: i is not defined
    at <anonymous>:1:13
	

## es5 - const �� ������ �� ���� �Ұ���
const a = 1o;
a = 20; //XX

������, ��ü�� �迭�� ���δ� �����ų �� �ִ�.
a.num = 10;
10
console.log(a); //10 
 
const b= [];
b.push(200);

- let ������ ���� ���ؼ� �ٽ� ���� �Ұ���
let a = 10 ;
let a = 20 ; xx

* const �� �Ҵ��� �ٽ� �ȵǰ�, let�� ������ �ٽ� �ȵȴ�.

-----
function f() {
	{
	let x;
	{
		// ���ο� ��Ͼȿ� ���ο� x�� �������� ����
		const x = "sneaky"
		x = "foo"; //���� �̹� const�� x�� ���������Ƿ� �ٽ� �����ϸ� ������ �߻��Ѵ�.
	}
	// ���� ��� ������ ���ƿԱ� ������ 'let x'�� �ش��ϴ� �޸𸮿� ���� ����
	x = "bar";
	let x = "inner"; // uncaught syntaxError: Indentifier 'x' has already been declared
	}
}


## Arrow Function - ȭ��ǥ �Լ�
- �Լ��� ������ �� function �̶�� Ű���带 ������� �ʰ� => �� ��ü
- ���� ����ϴ� �ݹ� �Լ��� ������ ����ȭ ��.

//ES5 �Լ� ���� ���
var sum = function(a, b){
	return a + b;
}

//ES6 �Լ� ���� ���
var sum = (a, b) => {
	return a + b;
}

sum(10, 20);

// ES5
var arr = ["a", "b", "c"];
arr.forEach(function(value){
	console.log(value);
});

// ES6
var arr = [];
arr.forEach(value => console.log(value)); // a,b,c



# �Լ� ����
var arr = [1,2,3];

arr.forEach(function(value) { console.log(value); });
   
arr.forEach((value) => console.log(value); )

# ���� 2
//es5
var sum = function() {
	return 1 + 2;
};

//es6
var multiply = () => {
	return 1 * 2;
};
