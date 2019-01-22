## maven depengency

#### why <version>${rxjava2.jdbc.version}</version>
- 왜 이런식으로 버전을 명시할까?
- <version>${project.lombok}</version><!--$NO-MVN-MAN-VER$-->
- 이렇게 하면 상단에 properties에 미리 명시해 놓은 버전을 불러오게 된다.
- 왜 이런식으로 구성하는걸까??
- 메이븐 (Maven)이 권장하는 관행 중 하나는 반복하지 않는 것 입니다. 그러나 여러 다른 위치에서 동일한 값을 사용해야하는 상황이 있습니다. 값이 한 번만 지정되도록하는 데 도움을주기 위해 Maven에서는 POM에서 자신의 변수와 미리 정의 된 변수를 모두 사용할 수 있습니다.
- 공통화?,,, 반복을 피하기 위해??
- http://maven.apache.org/guides/introduction/introduction-to-the-pom.html#Project_Inheritance



```
	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
		<rxjava2.jdbc.version>0.1-RC42</rxjava2.jdbc.version>
		<project.lombok>1.18.4</project.lombok>
		<junit.jupiter.version>5.1.1</junit.jupiter.version>
		<junit.platform.version>1.1.1</junit.platform.version>
	</properties>
```

