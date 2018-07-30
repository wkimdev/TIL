## gson
- JSON을 자바에서 다루기 위햔, 구글 라이브러리 파일
- JSON파일을 자바 오브젝트로 변환할 수 있게 해준다.


## json
- json값의 종류는 다음과 같다
	* array : []
	* null
	* object : {}
	* primitive : boolean, String, int, double

## jsonelement
- GSON에서 기본적인 element는 jsonelement.
- jsonelement가 json값의 value에 해당된다.
- jsonelement 를 상속받는 subclass는 다음과 같다.
	* jsonArray
	* jsonNull
	* jsonObject
	* jsonPrimitve
	

#### jsonprimitive type을 Jsonobject로 바꿔야할 경우?!
- 변경 불가능 key값이 없기때문에
- 변경하려면 key값을 생성해야함
```

	@Override
	public jsonObject getInfo() throws Exception{
		
		//false를 리턴함.
		//false를 jsonObject형식으로 변환하고 싶음.
		
		JsonObject convertJ = new JsonObject();
		convertJ.addProperty("testKey", "testValue");
		//Gson.toJson(JsonElement jsonElement)
		//jsonelement형식을 string으로 변환해줌.
		System.out.println(new Gson().toJson(convertJ));
		return convertJ;
	} 

```


#### jsonElement type을 String으로 변환시켜야 할 경우?!

```

	List<Object> list = new ArrayList<>();
			list.add("kdexusertmp");
			JsonElement jsonElement =(JsonElement)RPCCall(RPCCommandCode.ETH_CREATEADDRESS.CODE, list);
			String address = jsonElement.toString();
			return address;

```


try catch
jsonObject
jsonElement
JsonParse

@Override
    public JsonObject getInfo() throws Exception {
        List<Object> list = new ArrayList<>();
        JsonElement jsonElement = (JsonElement)RPCCall(RPCCommandCode.ETC_GETINFO.CODE, list); //jsonPrimitive
        String jsonObj = jsonElement.getAsString();    // "false"
        
        //안맞으면 변형을 해야한다.
        JsonObject newGO = new JsonObject();
        newGO.addProperty("ddd", jsonObj);
        System.out.println(new Gson().toJson(newGO));
        return newGO;
    }

    
com.fasterxml.jackson.databind.JsonMappingException: For input string: "0xaac53a1ce782ea911d32542fc2aeb3c44afe7f8c" (through reference chain: com.google.gson.JsonPrimitive["asInt"])


java.lang.NumberFormatException: For input string: “x28818d"


    