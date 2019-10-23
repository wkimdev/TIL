## Vuex 기술 요소
- state : 여러 컴포넌트에 공유되는 데이터 data
- getters : 연산된 state 값을 접근하는 속성 computed
- mutations : state 값을 변경하는 이벤트 로직/메서드 - method
- actions : 비동기 처리 로직을 선언하는 메서드 async methods


# state 란?
- 여러 컴포넌트간에 공유할 데이터 - 상태

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

# getters 란?
- state 값을 접근하는 속성이자 computed() 처럼 미리 연산된 값을 접근하는 속성
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

## mutations란?
- state의 값을 변경할 수 있는 유일한 방법이자 메서드
- 뮤테이션은 commit() 으로 동작시킨다.
- 뮤테이션으로 state조작 가능.

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
this.$store.commit('sumNumbers', 20); //sumnumber라는 뮤테이션 호출 //30
```

## mutations의 commit() 형식
- state를 변경하기 위한 mutations를 동작시킬때 ***인자(payload)*** 를 전달할 수 있음

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

