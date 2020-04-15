#### 불변객체
- 1. 객체의 가변성에 따른 문제점
  - 객체는 내부 프로퍼티가 바뀐다.   
- 객체 가변성에 따른 문제 해결 방법. 
  
```
var user= {
  name: 'jelly',
  gender: 'male'
}

var changeName = function(user, newName) {
    var newUser = user;
    newUser.name = newName;
    return newUser;
}

var user2 = changeName(user, 'Jelly')

if (user !== user2) {
    console.log('유저 정보가 변경 되었습니다. ')
}

console.log(user.name, user2.name);
console.log(user === user2)

```

```
/* 
2. 객체의 가변성에 따른 문제점의 해결 방법. 
*/
/**
var user = {
  name: 'Jelly',
  gender: 'male'
}

// 객체 자체를 바꿈으로서 값을 달라지게 함
var changeName = function (user, newName) {
  return {
    name: newName,
    gener: user.gender
  }
}

// shallow copy 얕은 복사 - 기존 정보를 복사해서 새로운 객체를 반환하는 함수
var copyObject = function (target) {
  var result = {};
  for (var prop in target) {
    result[prop] = target[prop];
  }
  return result;
}

/**
 * 얕은 복사를 통한 비교
 * 이 함수를 사용한다는 전제하에, user 객체는 곧 불변 객체라고 할 수 있다. 
 * 시스템적 제약이 immutable.js ,, baobab.js 등이 있다. 
 */
// var user2 = copyObject(user);
//var user2 = changeName(user, 'Jelly');
// user2.name = 'Jelly'

// if (user !== user2) {
//   console.log('user 정보가 바뀌었습니다.')
// }
// */


var copyObject = function (target) {
  var result = {};
  for (var prop in target) {
    result[prop] = target[prop];
  }
  return result;
}

// 1-5-2 얕은 복사와 깊은 복사 
// 중첩된 객체에 대한 얕은 복사 
var user = {
  name: 'Jelly',
  url: {
    email: 'test@gmail.com',
    gender: 'male'
  }
}
```

```
var user2 = copyObject(user);
user2.url = copyObject(user.url); // 참조형 데이터는 다시 그 내부의 프로퍼티들을 복사해야 한다. 

user2.name = 'jellgom'
console.log(user.name === user2.name)

user.url.email = 'no email';
console.log(user.url.email === user2.url.email)


// 깊은 복사를 수행하는 범용 함수
var copyObjectDeep = function(target) {
  var result = {};
  if (typeof target === 'object' && target !== null) {
    for (var prop in target) {
      result[prop] = copyObjectDeep(target[prop]);
    }
  } else {
    result = target;
  }
  return result;
}

var obj = {
  a: 1,
  b: {
    c: null,
    d: [1,2]
  }
};

var obj2 = copyObjectDeep(obj)

obj2.a = 3;
obj2.b.c = 5;
obj.b.d[1] = 8;

console.log(obj)
console.log(obj2)


/** JSON을 활용한 간단한 깊은 복사 */
var copyObjectViaJSON = function (target) {
  return JSON.parse(JSON.stringify(target))
}

var obj3 = {
  a: 1,
  b: {
    c: null,
    d: [1,2,3],
    func1: function () { console.log(3); }
  },
  func2: function () { console.log(4); }
}

var obj4 = copyObjectViaJSON(obj3);

obj4.a = 3;
obj4.b.c = 3;
obj3.b.d[1] = 100;

console.log(obj3)
console.log(obj4)


var obj5 = {a:2}

console.log(obj5.b)
console.log(b)
```

  
