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
	
	// 생성자 오버로딩 
	public Car(String model) {
		// TODO Auto-generated constructor stub
		//this.owner = owner; // 중복제거
		this(model, "은색", 200);
		
	}
	
	
	// 생성자 오버로딩 
	public Car(String model, int speed) {
		// TODO Auto-generated constructor stub
//		this.owner = owner; // 중복제거 
//		this.speed = speed;
		this(model, "green", speed);
	}
	
	// 생성자 오버로딩
	Car(String model, String color, int speed){
		// 공통 실행 코드 
		this.model = model;
		this.color = color;
		this.speed = speed;
	}
	
}

// car 객체를 외부 클래스에서 생성해서 실행(main구문이 있는 클래스)
public class CarExample {
	
	public static void main(String[] args) {
		
		Car car = new Car();	// 기본 생성자 선택 
		System.out.println(car.company);
		
		Car car1 = new Car("자가");
		System.out.println(car1.model);
		
		Car car2 = new Car("초롱이", 800);
		System.out.println(car2.model);
		System.out.println(car2.color);
		System.out.println(car2.speed);
		
		
//		Car car1 = new Car(130, "wkimdev");
//		System.out.println(car1.speed);
//		System.out.println(car1.owner);
//		
//		Car car2 = new Car(135, "jelly");
//		System.out.println(car2.speed);
//		System.out.println(car2.owner);
		
		Car car3 = new Car("modelcar", "blue", 300); // 다른 생성자 선택
		System.out.println(car3.model);
		System.out.println(car3.color);
		System.out.println(car3.speed);
		
	}
}
