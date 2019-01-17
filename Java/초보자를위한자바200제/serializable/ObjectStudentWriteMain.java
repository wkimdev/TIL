package com.home.test.serializable;

import java.io.IOException;
import java.util.Vector;

public class ObjectStudentWriteMain {
	
	public static void main(String[] args) {
		
		ObjectStudentRWG<Student> osw = new ObjectStudentRWG<>();
		Vector<Student> v = new Vector<>();
		v.add(new Student("김미미", 1, "광주"));
		v.add(new Student("김진", 2, "서울"));
		v.add(new Student("김위", 3, "제주도"));
		v.add(new Student("젤고미", 4, "경기도"));
		
		try {
			osw.write("testFolder\\student.obj", v); //우와~~ 파일로 만들어졌다아~~
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}
}
