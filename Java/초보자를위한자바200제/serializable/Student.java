package com.home.test.serializable;

import java.io.Serializable;

// 객체 직렬화는 
// 네트워크를 통해 객체를 전송하거나, 
// 객체를 파일로 저장할때 사용한다. 

// Target : student라는 객체를 직렬화해서 다른 프로젝트에 복사해주는 프로젝트를 진행합니다.
public class Student implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 12345678L;
	private String name;
	private int age;
	private String addr;
	
	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String toString() {
		return name + " "+age+ " "+addr;
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			return this;
		}
	}
	
	// 멤버비교
	public boolean equals(Object obj) {
		
		boolean isE = false;
		
		Student temp = (Student) obj;
		
		if (temp.getName().equals(name) && temp.getAge() == age && temp.getAddr().equals(addr)) {
			isE=true;
		}
		return isE;
	}
	
	
	public int hashCode() {
		int temp=0;
		temp=name.hashCode()+addr.hashCode()+age+37;
		return temp;
	}		
	 
}
