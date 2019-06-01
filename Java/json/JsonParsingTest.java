package com.example.demo.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParsingTest {
	
	public static void main(String[] args) {
		
		// String str = "[{'NO':1,'NAME':'APPLE','KOR':'사과','PRICE':'1000'},{'NO':2,'NAME':'BANANA','KOR':'바나나','PRICE':'500'},{'NO':3,'NAME':'MELON','KOR':'메론','PRICE':'2000'}]";
		
		String str = "{'fruit':[{'NO':1,'NAME':'APPLE','KOR':'사과','PRICE':'1000'}," +
				            "{'NO':2,'NAME':'BANANA','KOR':'바나나','PRICE':'500'}, " +
				            "{'NO':3,'NAME':'MELON','KOR':'메론','PRICE':'2000'}], " +
					  "'animal':[{'NO':1,'NAME':'cat','KOR':'고양이','age':'3'}, " +
					           " {'NO':2,'NAME':'dog','KOR':'개','age':''}, " +
					           " {'NO':3,'NAME':'rabbit','KOR':'토끼','age':'2'}]}";
		
		
		JsonParser jsonParser = new JsonParser();
		
		JsonObject jsonObj = (JsonObject) jsonParser.parse(str);
		
		JsonArray memberArray = (JsonArray) jsonObj.get("fruit");
		
		System.out.println("===fruit====");
		
		for (int i = 0; i < memberArray.size() ; i++) {
			JsonObject object = (JsonObject) memberArray.get(i);
			System.out.println("번호 :" + object.get("NO"));
			System.out.println("영어 :" + object.get("NAME"));		
			System.out.println("한글 :" + object.get("KOR"));		
			System.out.println("가격 :" + object.get("PRICE"));		
			System.out.println("========");
		}
		
		memberArray = (JsonArray) jsonObj.get("animal");
		
		System.out.println("===animal====");
		
		for (int i = 0; i < memberArray.size() ; i++) {
			JsonObject object = (JsonObject) memberArray.get(i);
			System.out.println("번호 :" + object.get("NO"));
			System.out.println("영어 :" + object.get("NAME"));		
			System.out.println("한글 :" + object.get("KOR"));		
			System.out.println("나이 :" + object.get("age"));		
			System.out.println("========");
			
		}
		
//		JsonArray jsonArray = (JsonArray) jsonParser.parse(str);
//		
//		for (int i = 0; i < jsonArray.size() ; i++) {
//			JsonObject object = (JsonObject) jsonArray.get(i);
//			String No = object.get("NO").getAsString();
//			String Name = object.get("NAME").getAsString();
//			String Kor = object.get("KOR").getAsString();
//			String Price = object.get("PRICE").getAsString();
//			
//			System.out.println(No);
//			System.out.println(Name);
//			System.out.println(Kor);
//			System.out.println(Price);
//			System.out.println();
//		}
	}

}
