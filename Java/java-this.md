# java -this
- 같은 클래스의 멤버들 간에 서로 호출할 수 있는 것처럼, '생성자' 간에도 서로 호출이 가능하다.
- 단, 아래 두조건을 만족시켜야 한다.
~~~
1. 생성자의 이름으로 클래스 이름 대신, this 를 사용한다.
2. 한 생성자에서 다른 생성자를 호출할 때는 반드시 첫 줄에서만 호출이 가능하다.


public class Member {
	
	// 자바에서 this는 객체 자기 자신을 나타낸다.
	// 이 test code에서 this는 Member class이다.
	
	/**
	 * 주 사용형태.
	 * 1. 클래스 속성 생성자/메소드 매개변수(input parameter)의 이름이 같은 경우.
	 * 2. 
	 * 3. 객체 자신의 참조값을 전달하고 싶을 때 return this.
	 * 
	 * 
	 * */

	
	// class 변
	public String name;
	public double weight;
	
	public Member(String name, double weight) {
		// Member 객체의 name 속성 = name 매개변수.
		// Member 객체의 속성에 값을 입력한다.
		// this는 객체 자신의 속성을 나타낸다(여기서는 Member)
		this.name = name;
		this.weight = weight;
	}
	
	public Member getMemberInstance() {
		System.out.println("this is return this "+this);
		return this;
	}
	
	public static void main(String[] args) {
		Member m = new Member("wkim", 45.6);
		System.out.println(" name "+m.name);
		System.out.println(" name "+m.weight);
		
	} 	


~~~
