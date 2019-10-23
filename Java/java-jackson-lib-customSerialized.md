## jackson lib로 Serialization 
- json으로 받는 데이터와 클래스들을 deserialized하는 코드가 있다. 
- 아래 링크의 글을 읽으며 다시 분석중이다. 
- https://homoefficio.github.io/2016/11/18/%EC%95%8C%EA%B3%A0%EB%B3%B4%EB%A9%B4-%EB%A7%8C%EB%A7%8C%ED%95%9C-Jackson-Custom-Serialization/
- 코드를 보며 java의 stream classes에 대한걸 다시 복습했다. 기초가 부족함을 다시 한번 ㅠㅠ ... 
  
  
```
public class MimsObjectMapper extends Jackson2JsonObjectMapper {

	/**
	 * 
	 */
	public MimsObjectMapper(final ObjectMapper objectMapper) {

		super(objectMapper);

		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(Include.NON_NULL);

		final SimpleModule module = new SimpleModule();
		// PanelPaper class는  PanelPaperDeserializer로 deSerialized를 한다는 의미. 
		// 객체를 '출력'(write)하기 위해 필드들을 연속적인 바이트로 변경한다. => 직렬화 (1)
		// 네트워크에서 전송된 객체 (혹은 파일제 저장된 객체)를 '읽을 경우'(read) 입력스트림으로부터 읽어들인 연속적인 바이트를(1) 객체로 복원한다. => 역직렬화 (2)
		// 즉, 아래코드는 직렬화환 클래스를, 다시 읽기 위해 객체로 복원하는 과정이다. (customSerializer의 과정)  
		module.addDeserializer(PanelPaper.class, new PanelPaperDeserializer());
		objectMapper.registerModule(module);
	}
}
  
```
  
  
  
