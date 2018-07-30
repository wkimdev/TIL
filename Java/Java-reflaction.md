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


    