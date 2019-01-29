package com.home.test.objectIOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializableWriter {
	public static void main(String[] args) throws Exception {
		
		// 파일을 써서 
		// 그 안에 시리얼라이즈 객체를 집어넣고 
		// 자원 닫기 
		FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassA a = new ClassA();
		a.field1 = 1;
		a.field2.field1 = 2;
		a.field3 = 3;
		a.field4 = 4;
		
		oos.writeObject(a);
		
		// 안에서 바깥 
		oos.flush();
		oos.close();
		fos.close();
		
	}
}
