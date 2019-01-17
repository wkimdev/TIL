package com.home.test.serializable;

import java.io.IOException;

public class ObjectStudentReadMain {
	
	// 자, 저장된 객체를 읽어라~~
	public static void main(String[] args) {
		
		ObjectStudentRWG<Student> osw = new ObjectStudentRWG<Student>();
		 
		try {
			osw.read("testFolder\\student.obj");
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
