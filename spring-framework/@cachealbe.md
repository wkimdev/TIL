## @cacheable 
- 7시 부터 고민하게 만든 @cachealbe 테스트. 
- @cachealbe는 어떻게 테스트 해야 좋을까?  
- adapter와 그냥 adapter front implement 동작은 제대로 구분하고 있나? 못하고 있는 듯... 
- ㅎㅎㅎ... ㅠㅠ  
- 서비스의 화면들은 전부 외부서버를 통해 정보를 가져오고,그 데이터들은 배치로 돌려서 캐시에 넣던지(hazelcast), key값이 달라지면 혹은 key값 별로 cache에 담아서 뷰에 뿌려주게 된다.(트래픽 분산 때문..) 
- 캐시와 배치에서 화면 정보를 가져옴을 잊지 말자~   
  

## condition = "#fromCache and #request.startNum == 1" 
- fromCache가 true 이고 stasrtnum이 1이어야 캐시에 걸린다.  
- 이 조건이 안맞거나 key값이 다를경우, adapter에서 가져오게 된다.  

## key
- key조건 수정시 @cacheable에서 수정한 값을 batch에 넣을때도 수정해서 반영해야 한다. 같은 키값을 던저야 하니까!!!!

### front service  
- adapter 호출을 위한 frontservice설정  
```
@Cacheable(cacheNames = "cache.mims.getHotvod", key = "#request.serviceId+ '.' +  #request.page", condition = "#fromCache or #request.startNum == 1", unless = "#result == null")
	@Override
	public Result getList(HotVodRequest request, final boolean fromCache){
		return testAdapterService.getvod(request);
	}
``` 
  
  
#### batch 
- key를 아래 처럼 넣을시 위의 `key = "#request.serviceId+ '.' +  #request.page"`와 맞춰서 설정한다. 
  
```
String cacheHotVodKey = key + "." + key;
cacheHotVod.put(cacheHotVodKey, hotVodResult);
```
 
 ## spring @cacheable과 aop
- Spring @Cacheable은 내부적으로 Spring AOP를 이용하기 때문에 @Async, @Transactional 등과 마찬가지로 아래와 같은 제약사항을 갖습니다.
	* pulbic method에만 사용가능 합니다.
	* 같은 객체내의 method끼리 호출시에는 @Cacheable이 설정되어있어도 캐싱되지 않습니다. 
	 
 - http://dveamer.github.io/backend/SpringCacheable.html
 
 
 
