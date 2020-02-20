- javascript argument 표현방법?? 
- 어떻게 아래처럼 쓸 수 있지????....

```
this.$parent.loginProcess(false, true, '', () => {
  // this.load()
  // this.$LoginEventBus.$emit('LoginComplete')
}, () => {
  this.Alert('FAILED_TO_GET_RESOURCE')
})

```


오잉
~~~
function func1(a, b, c) {
  console.log(arguments[0]);
  // expected output: 1

  console.log(arguments[1]);
  // expected output: 2

  console.log(arguments[2]);
  // expected output: 3
}
/*
this.$parent.loginProcess(false, true, '', () => {
          // this.load()
          // this.$LoginEventBus.$emit('LoginComplete')
        }, () => {
          this.Alert('FAILED_TO_GET_RESOURCE')
        })
*/
func1(1,() => { console.log(test) }, 
      () => { console.log('error~') })

~~~

https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Functions/arguments
