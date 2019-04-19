## prototype
- 원형
- javascript는 이를 통해 상속을 가능.. 
  
  
```
var arr = [];
for(var i = 0; i < 5 ; i++){
  arr[i] = function(id){
    return function(){
      return id;
    }
  }(i);
  
}

for(var index in arr){
  console.log(arr[index]());
}
```
