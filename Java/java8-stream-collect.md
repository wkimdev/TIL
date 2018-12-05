## java8
#### collect()
- collect()는 Collector를 매개변수로 하는 스트림의 최종 연산.
- Collector는 collect에서 필요한 메서드를 정의해 놓은 인터페이스.


#### groupingBy
- 스트림의 요소를 그룹화.
- 분류 기능에 따라 요소를 그룹화해 결과를 map으로 돌려주는 collector로 돌려준다.

### entrySet
- 이 맵에 포함되고있는 매핑의 Set 뷰를 리턴합니다. 집합은지도에 의해 뒷받침되므로지도에 대한 변경 사항은 집합에 반영되며 그 반대의 경우도 마찬가지입니다.



Set<Entry<String, List<String>>> java.util.Map.entrySet()
Returns a Set view of the mappings contained in this map. The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by the iterator) the results of the iteration are undefined. 
  
  
