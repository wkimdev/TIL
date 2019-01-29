package com.home.test.objectIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class SerializableReader {
	public static void main(String[] args) throws Exception {
		// 역직렬화 
		FileInputStream fos = new FileInputStream("C:/Temp/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fos);
		
		ClassA a = (ClassA) ois.readObject();
		System.out.println("field1 : "+a.field1);
		System.out.println("field2.field1 : "+a.field2.field1);
		System.out.println("field3 : "+a.field3); // 복원되지 않는 필드 : 0
		System.out.println("field4 : "+a.field4); // 복원되지 않는 필드 : 0
	} 
	
}
