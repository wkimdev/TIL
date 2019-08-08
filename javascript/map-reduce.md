## map  
- 정리하자면, map은 배열을 1대1로 짝짓되 기존 객체를 수정하지 않는 메서드
- sample 
- code의 items가 webui에서 데이터들을 받아 map으로 각각 바인딩을 시켜 items로 묶는다..
   
```
const oneTwoThree = [1, 2, 3];
let result = oneTwoThree.map((v) => {
  console.log(v);
  return v;
});
// 콘솔에는 1, 2, 3이 찍힘
oneTwoThree; // [1, 2, 3]
result; // [1, 2, 3]
oneTwoThree === result; // false
```
   
