## issue
- 아래처럼 응답받는 데이터가 있다.
- 내려오는 데이터 타입은 변경 불가능. 
  
#### input
- `|header|value01|value02|main|main01|main02|`

#### response
- `header`일 경우 처리 
- `main`일 경우 처리 
 
```
// 에러나는 코드입니다~ 
public static void main(String[] args) {
		
		String[] arrInfo = {"|header|value01|value02|main|main01|main02|"}; // 실제 예제는 클래스 타입 (오브젝트) 
		String[] test = new String[arrInfo.length];
		test = arrInfo.split("|");
		
		String header = test[0];
		String main = test[4];
		
		System.out.println(header);
		System.out.println(main);
		
	}
```
  
 
#### todo 
- 전부를 처리하지 않고 주어지는 type에 묶여진(?)데이터의 길이 만큼 반복문을 돌면서 list에 넣기..
- string을 header, main미리 자르고... 
- https://stackoverflow.com/questions/41604471/split-string-in-an-array

  
#### solved
- 원인은, for문 loop안에서 모델을 맵핑하는 처리를 하고 있었기 때문이었다. 
- header부터 넣으면서 갯수만큼 list로 들어가는지 확인, main도 2개 들어가는지 확인
- for문 내에서 list안에 list를 넣으면서 헤깔렸던 것 같다... 
- 대략 아래처럼 해결하니 원하는 대로 구현이 되었다. 
- 결국 또 엄한데서 헤매이고 있었구나 ㅜㅜ 
  
  
```
List<AllDataModels> allDataModels = new ArrayList<AllDataModels>();
List<MainModels> mainModels = new ArrayList<MainModels>();
List<FooterModels> footerModels = new ArrayList<FooterModels>();


if( response != null && response.length > 0 ){
	
	ModelData modelData = new ModelData(); // 이동
	
	for( //... ){
		
		if(header){
			// 맵핑 1번 
			modelData.setData(data);
		} else if(main){
			// 맵핑 2번 (데이터 갯수만큼)
			MainModel mainModel = new MainModel()
			mainModel.setItem(data);
			mainModels.add(mainModel);
		} else if(footer){
			// 맵핑 24번 (데이터 갯수만큼)
			FooterModel footerModel = new FooterModel();
			footerModel.setItem(data);
			footerModels.add(footerModel);
		}
		
	} // for loop end
	
	// 최종으로 담기
	modelData.setMainModel(cuesheetitems);
	modelData.setFooterModel(footerModels);
	allDataModels.add(modelData);
}

  
```
