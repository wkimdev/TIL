## @cacheable 
- 7시 부터 고민하게 만든 @cachealbe 테스트. 
- @cachealbe는 어떻게 테스트 해야 좋을까?  
- adapter와 그냥 adapter front implement 동작은 제대로 구분하고 있나? 못하고 있는 듯... 

```
condition = "#fromCache and #request.startNum == 1"
// fromCache가 true 이고 stasrtnum이 1이어야 캐시에 걸린다.  
// 이 조건이 안맞거나 key값이 다를경우, adapter에서 가져오게 된다.  
```

