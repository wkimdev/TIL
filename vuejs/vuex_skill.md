## Vuex ��� ���
- state : ���� ������Ʈ�� �����Ǵ� ������ data
- getters : ����� state ���� �����ϴ� �Ӽ� computed
- mutations : state ���� �����ϴ� �̺�Ʈ ����/�޼��� - method
- actions : �񵿱� ó�� ������ �����ϴ� �޼��� async methods


# state ��?
- ���� ������Ʈ���� ������ ������ - ����

```
//vue
data: {
	message: 'test'
}

// vuex
state: {
	message: 'test'
}

<!-- vue -->
<p>{{ message }}</p>

<!-- vuex -->
<p>{{ this.$store.state.message }}</p>

```

# getters ��?
- state ���� �����ϴ� �Ӽ����� computed() ó�� �̸� ����� ���� �����ϴ� �Ӽ�
```
// store.js
state: {
	num: 10
},
getters: {
	getNumber(state){
	 	return state.num;
	},
	doubleNumber(state) {
		return state.num * 2
	}
}

<p>{{ this.$store.getters.getNumber }}</p>
<p>{{ this.$store.getters.doubleNumber }}</p>

```

## mutations��?
- state�� ���� ������ �� �ִ� ������ ������� �޼���
- �����̼��� commit() ���� ���۽�Ų��.
- �����̼����� state���� ����.

```
//store.js
state: {num: 10},
mutations: {
	printNumbers(state) {
		return state.num
	},
	sumNumbers(state, anotherNum) {
		return state.num + anotherNum;
	}
}


//App.vue
this.$store.commit('printNumbers');
this.$store.commit('sumNumbers', 20); //sumnumber��� �����̼� ȣ�� //30
```

## mutations�� commit() ����
- state�� �����ϱ� ���� mutations�� ���۽�ų�� ����(payload)�� ������ �� ����

```
//store.js
state: {storeNum: 10},
mutations: {
	modifyState(state, payload) {
		console.log(payload.str);
		return state.storeNum += payload.num; //30
	}
}

//app.vue
this.$store.commit('modifyState', {
	str: 'passed from payload',
	num: 20
});

```

