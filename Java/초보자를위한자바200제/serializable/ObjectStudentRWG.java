package com.home.test.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

// 들어오는 파일을 읽는 시스템
public class ObjectStudentRWG<T> {
	
	public int write(String fname, Vector<T> v ) throws IOException {
		int objectNumber = 0;
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			objectNumber = v.size();
			
			oos.writeInt(objectNumber);
			System.out.println(objectNumber+"개의 data가 입력됨.");
			for (int i = 0; i < objectNumber; i++) {
				oos.writeInt(i);
				oos.writeObject(v.get(i));
				oos.flush();
				System.out.println(i+"번째의 data가 입력됨");
			}
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("잘못된 파일 이름을 입력함");
		} catch (Exception ee) {
			throw new IOException("타입이 이상합니다. "+ee);
		}
		return objectNumber;
	}
	
	// file read system
	public void read(String fname) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis); // throw
			int objectNumber = ois.readInt();
			
			System.out.println(objectNumber+ "개의 data를 읽음");
			for (int i = 0; i < objectNumber ; i++) {
				try {
					System.out.println(ois.readInt()+"번째:");
					System.out.println(ois.readObject());
					
				} catch (ClassNotFoundException e1) {
					// TODO: handle exception
					System.out.println("잘못된 타입입니다. ");
				}
			}
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("잘못된 파일 이름을 입력했습니다.");
		}
	}
}
