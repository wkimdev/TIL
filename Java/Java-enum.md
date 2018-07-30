## java enum class
- 한마디로, 클래스 처럼 보이게 하는 상수
- 서로 관련 있는 상수들을 모아 심볼릭한 명칭의 집합을 만드는것.
- Enum class를 기반으로한 클래스형 선언
- 새로운 열거형을 선언하면, 내부적으로 enum 클래스형 기반의 새로운 클래스가 만들어진다.
- 열거된 순서에 따라 0부터 순서값을 가지게 된다.
- enum 열거형으로 지정된 상수는 대문자를 사용.  
- 개발을 진행할때 Enum을 통해 얻는 기본적인 장점  
	* 문자열과 비교해, IDE의 적극적인 지원을 받을 수 있다.  
   * 자동완성, 오타검증, 텍스트 리팩토링 등등
	* 허용 가능한 값들을 제한할 수 있다.  
	* 리팩토링시 변경 범위가 최소화 됩니다.
	* 내용의 추가가 필요하더라도, Enum 코드외에 수정할 필요가 없다.
	* C/C++의 경우 Enum이 결국 int값이지만, Java의 Enum은 완전한 기능을 갖춘 클래스이기 때문입니다    	


  

```

	public enum UnitCode{
	
	ETHER("ether", 18);	
	public String name;
	public BigDecimal weiFactor;

	//UNUTCODE가 ETHER상수로서 받아들여진다???
	UnitCode(String name, int factor) {
        this.name = name;
        this.weiFactor = BigDecimal.TEN.pow(factor); //18
    }
	
	public BigDecimal getWeiFactor() {
        return weiFactor; //나누는 단위
    }


}

```