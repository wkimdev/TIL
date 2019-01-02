// car class의 필드, 생성자
public class Car {
	
	// 필드
	String company = "car";
	String model = "doublever1";
	String color = "black";
	String owner;
	int maxSpeed = 350;
	int speed;
	boolean saleOpen;
	
	public Car(int speed, String owner) {
		// TODO Auto-generated constructor stub
		this.owner = owner;
		this.speed = speed;
	}

	// 생성자 
//	public void car(int speed, String owner){
//		this.owner = owner;
//		this.speed = speed;
//	}
	
}

// car 객체를 외부 클래스에서 생성해서 실행(main구문이 있는 클래스)
public class CarExample {
	
	public static void main(String[] args) {
		
		// 객체 생성
//		Car myCar = new Car();
//		Car myCar2 = new Car();
//		
//		// 필드값 읽기
//		System.out.println("make company :"+myCar.company);
//		System.out.println("make company :"+myCar.model);
//		System.out.println("make company :"+myCar.speed);
//		System.out.println(" sale open default value : "+myCar.saleOpen);
//		
//		myCar.model = "granda";
//		System.out.println("changed model name :"+myCar.model);
		
		Car car1 = new Car(130, "wkimdev");
		System.out.println(car1.speed);
		System.out.println(car1.owner);
		
		Car car2 = new Car(135, "jelly");
		System.out.println(car2.speed);
		System.out.println(car2.owner);
		
	}
}
