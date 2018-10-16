## enhanced Object Literals - ���� ��ü ���ͷ�
- ��ü�� �Ӽ��� �޼���� ����Ҷ� function ���� �����ϰ� ���� ����
```
var dictionary = {
	words: 100,
	// es5
	lookup: function(){
		console.log('this is es5~');
	},
	// es6
	lookup() {
		console.log('this is es6~');
	}
};

```

## ��ü�� �Ӽ���� �� ���� ������ �� �Ʒ��� ���� ��� ����
```
var figures = 10;
var dictionary = {
	// figures: figures,
	figures
}

```


## Modules - �ڹٽ�ũ��Ʈ ���ȭ ���(�̰� �� ������ ���)
- �ڹٽ�ũ��Ʈ ��� �δ� ���̺귯��(AMd, Common Js)����� js ��� ��ü���� ����
- ���� ����� �پ ����� ��� �ʿ��Ҷ��� ������ ���� ���
- ȣ��Ǳ� �������� �ڵ� ����� ������ ���� �ʴ� Ư¡�� ����

```
// libs/math.js
export function sum(x, y) {
	return x + y;
}

export var pi = 3.1415;

// main.js
import {sum} from '';
sum(1,2);

```

- vue.js ���� ����ĥ default export
- default : �Ѱ��� ���Ͽ��� �ϳ��� export �ȴ�.


```
// util.js
export default function (x) {
	return console.log(x);
}

// main.js
import util from 'util.js';
console.log(util); //function (x) {}
util("hi");


// app.js
import log from 'util.js';
console.log(log);
log("hi");

```


