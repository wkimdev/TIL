// variable이 존재하는가 아닌가 ==> 심플 스코프
// 접근할 수 있냐, 없냐 ==> 스코프

// if(true){
//   const hello = "hi";
//   console.log(hello);
// }

// console.log(hello);

// 2.
// const h = "hello";

// function a(){
//   console.log(h);
//   const b = "b";
// }

// a();

// console.log(b);

// 3. 예전에 var 썻을때
// var 을 사용하지 말아야 하는 이유중 하나
// if(true){
//   var hell =  "h";
// }

// console.log(hell);

// let, const 둘다 block scope 
// if(true){
//   //const hell =  "h";
//   let hell =  "h";
// }

// console.log(hell);

// try{
//   do
// } catch(e){

// }

let hello;
if(true){
  hello = "test";
}
console.log(hello);

https://www.youtube.com/watch?v=WrjlQstaCwo&list=PL7jH19IHhOLMmmjrwCi7-dMFVdoU0hhgF
