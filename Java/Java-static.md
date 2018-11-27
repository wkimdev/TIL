## static
- 정적 멤버
- 정적 멤버는 클래스 고정 멤버.
- 흔히 클래스의 멤버변수를 상수(final)로 만들고자 할땐, 클래스 상수(static final)로 만들어주곤 한다. 
- 객체생성될때마다 매번 해당 객체를 생성할 필요 없이, 초기 클래스 로딩시 한번만 생성해서 사용할 수 있다. 
- 객체마다 가지고 있을 필요성이 없는 공용적인 데이터라면 정적 필드로 선언하는게 좋다. 


## why logger always ==> 'private static final Logger logger~~??'
- private : 해당 클래스를 다른 클래스가 상속받아 사용하지 않게 하는 경우.
- static : static으로 선언한 이유는 객체가 생성될때마다 해당 객체를 매번 생성하지 않고 초기 클래스 로딩시 한번만 생성해서 사용하기 위함.
- final : 로그를 찍는 경우 Logger는 초기 생성된 이후에 변경될 필요가 없다. 
- 특별한 경우가 아니면 변경되는 경우는 거의 없다. 
- final로 선언하지 않더라고 이 logger에 대해 변경하는 경우는 거의 없겠지만 유지보수와 가독성을 위해 final로 선언하는것이 좋다. 
- LOGGER : 흔히 상수표현을 대문자로 하기 때문,,?!!


## Reference
- 이것이자바다/신용권
- http://atin.tistory.com/639
- https://djkeh.github.io/articles/Why-should-final-member-variables-be-conventionally-static-in-Java-kor/
