#### lebel 태그
- label 태그는 input태그를 설명하는데 사용된다!
- label 태그는 어떠한 input 태그를 설명하고 있는지 표시해줘야 한다.
- input 태그에 id 속성을 입력하고 label 태그에 for 속성을 입력한다. 
  
```
//(1)
<form action="">
  <label for="autoplay">자동재생</label>
  <input type="text" id="autoplay">
</form>

//(2)
<form action="">
  <label for="autoplay">자동재생</label>
  <input type="checkbox" id="autoplay">
</form>
```
  
