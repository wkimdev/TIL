# 1226_beanstalk_log

[개념](1226_beanstalk_log/Untitled.md)

### 0102질문

1. 여기까지 해봤습니다.

    아래 시나리오대로 구성해보려고 테스트를 해봤는데 cloudwatch로 로그그룹 생성하는게 잘 안된다. 

    여기는 문법적으로 틀린게 있는지 좀더 점검해볼 필요가 있는것 같고.

2. 질문은 beanstalk로 코드 업로드 이후에 곧바로  s3에 적재할 수 있는 방법을 찾을 만한 키워드? 

( 아래 시나리오 대로 구성하는게 맞는건지 잘 모르겠음. )

beanstalk에서 곧바로 s3로 업로드 할 수 있는 구성이 있다면 단순한 설정만 바꾸면 되는건지, 

꼭 cloudwatch 를 거쳐야 하는건지 잘 모르겠음. 

그리고 비슷한 방법으로 구현한 글을 읽었는데 아래 사항들을 고민해봐야 하는지도 모르겠음. 

> 어플리케이션 로그 파일을 S3로 백업하는 방법을 단순하게 생각다가 Auto Scaling 환경에서 추가된 인스턴스의 로그파일 백업 문제라던가 용량이 큰 로그 파일들을 한번에 전송할 경우 네트워크 대역폭 Alert을 관련 문제가 발생할수 있습니다.
Java Application에서 logback을 이용하여 cloudwatch logs로 로그를 보내고 해당 로그는 lambda로 구독하여 S3로 저장하는 방식으로 구성하였다.

[https://medium.com/@sungmok.sohn/aws-ec2의-application-log를-s3로-백업하기-67ff02be5e2c](https://medium.com/@sungmok.sohn/aws-ec2%EC%9D%98-application-log%EB%A5%BC-s3%EB%A1%9C-%EB%B0%B1%EC%97%85%ED%95%98%EA%B8%B0-67ff02be5e2c) 

# 시나리오

- cloudwatch는 로그는 모니터링 및 이벤트를 발생시키는 역할을 하고, 나는 beanstalk에 java application 환경으로 어플리케이션 환경을 구성하려고 한다.
- 그리고, Java Tomcat Platform을 사용하는 경우 Application 로그를 CloudWatch로 보내려면 .ebextensions의 추가 설정이 필요하다고 한다.
- 성공하면, cloudwatch로 받은 로그를 s3로 저장하는 방법으로 구성하려고 한다.
- 2020.01.01에 다시 테스트 해보고 생각해보니.. beanstalk에 올린 후 곧바로 s3에 올리는 방법이 있지 않을까라는 의문이 든당..

![1226_beanstalk_log/Untitled.png](1226_beanstalk_log/Untitled.png)

### 참고

1. [AWS Elastic Beanstalk Tomcat log를 CloudWatch로 Streaming](https://blog.msalt.net/255)

### 로그 환경 구성

- beanstalk에서 어플리케이션을 실행하는 EC2 인스턴스에 대해 정기적으로 로그를 보기 위해 아래의 방법이 있음
    - **교체된 인스턴스 로그를 S3버킷으로 업로드하도록 beanstalk 환경을 구성**
        - 인스턴스를 로그를 보기 위해선, 아래처럼 설정한다.
            - 인스턴스 로그를 보려면 Elastic Beanstalk 콘솔에서 **인스턴스 로그 교체**와 **로그 스트리밍을 활성화**

문서 

[https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/using-features.logging.html](https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/using-features.logging.html) 

# beanstalk에 업로드 후, cloudwatch에서 로그 스트리밍

실제 프로젝트 파일로 시도

### 1. EC2 인스턴스상의 로그 위치로 변경

    <!-- EC2 인스턴스상의 로그 위치로 변경 -->
    <property name="LOG_DIR" value="/var/log/tomcat8" />

- 위의 경로 이에도 `/var/log`, `/var/log/tomcat8/` , `/var/log/httpd/`  의 경로로도 시도
- 아래 경로와 파일이름으로 로그 파일이 생성될 거라 기대.

`/var/log/tomcat8/idolive-ws-batch-trace.log`

### 2. `.ebextensions`  파일 생성

- Tomcat Application Log는 기본적으로 스트리밍이 안되기 때문에, .ebextensions에 추가 설정이 필요하다.
- 생성경로 : `src/main/ebextensions`

    files:
        "/etc/awslogs/config/mycustom.conf" :
            mode: "060606"
            owner: root
            group: root
            content: |
                [/var/log/tomcat8/idolive-ws-batch-trace.log]
                log_group_name = `{"Fn::Join":["/", ["/aws/elasticbeanstalk", { "Ref":"AWSEBEnvironmentName" }, "/var/log/tomcat8/idolive-ws-batch-trace.log"]]}`
                log_stream_name = {instance_id}
                file =/var/log/tomcat8/idolive-ws-batch-trace.log*

- deploy이후 로그 그룹에는 안생김 ㅜㅜ

### Where to add .ebextensions in a WAR?

[https://stackoverflow.com/questions/18423932/where-to-add-ebextensions-in-a-war](https://stackoverflow.com/questions/18423932/where-to-add-ebextensions-in-a-war)

### 3. plugin추가

    <plugin>
            <artifactId>maven-war-plugin</artifactId>
            <configuration>
                <webResources>
                    <resource>
                        <directory>src/main/ebextensions</directory>
                        <targetPath>.ebextensions</targetPath>
                        <filtering>true</filtering>
                    </resource>
                </webResources>
            </configuration>
        </plugin>

### 3. Elastic Beanstalk 에 CloudWatch 권한 주기

- 인스턴스 내부에 CloudWatch Logs 에이전트가 /etc/awslogs/config/위치에 정의된 내용의 설정대로 로그를 CloudWatch로 스트리밍 해줄 수 있도록 권한 설정.

`CloudWatchLogsFullAccess`

### 4. Elastic Beanstalk 에서 Log를 CloudWatch로 스트리밍하도록 설정

- Configuration > Software > Instance log streaming to CloudWatch Logs 에서 설정
- cloudwatch에선 로그그룹으로 생성이 안되었지만,, 일단 beanstalk에선 로그 요청시 생성된게 확인됨...;;;(beanstalk ⇒ log ⇒ 로그요청)

    -------------------------------------
    /var/log/tomcat8/idolive-ws-payload.log
    -------------------------------------
    05:23:33.719 DEBUG [PayloadPrinter : print] - requestType : WebUiWSOnairstatusRequest, queryString : contentType=CHANNEL&serviceId=&albumId=&itemAlbumId=&duration=
    05:23:33.974 DEBUG [PayloadPrinter : print] - requestType : WebUiWSOnairstatusRequest, payload : {"status":"0000","result":{"albumId":"M01188V374PPV00"}}
    05:23:34.178 DEBUG [PayloadPrinter : print] - requestType : WebUiWSCuesheetRequest, queryString : contentType=CHANNEL&serviceId=080&albumId=M01188V374PPV00&itemAlbumId=&duration=
    05:23:34.198 DEBUG [PayloadPrinter : print] - requestType : WebUiWSCuesheetRequest, payload : {"notify":"info","item":{"type":"wscuesheet_v2","data":[{"totCnt":"57","contentsAlbumId":"M01188V374PPV00","angleSvcFlag":"Y","memberSvcFlag":"Y","channelImageUrl":"http://203.248.154.13/image/cuesheet/2018/08/C201808065_L_101647.png","mainLogoUrl":"http://203.248.154.13/image/cuesheet/2018/08/C201808065_M_151715.png","camLogoUrl":"http://203.248.154.13/image/cuesheet/2018/08/C201808065_O_151724.png","onAirStartDate":"202001010000","cuesheetItems":[{"itemInfo":["001","001","MS","093000","1000","1踰�","BTS","http://203.248.154.13/smartux/musicshow/people_img/20190424/20190424_6092826937_P2540_71.jpg","","",""],"members":["","","","","BTS","","","","","","","","","","","","","","","","","","",""],"membersImg":

- 그리고, 해당 beanstalk에 대한 로그가 s3에 저장되어 있음 (tail로그로 저장되어 있음)

경로 : **Amazon S3/elasticbeanstalk-ap-northeast-2-475270702751/resources/environments/logs/tail/**e-gficdjgfhu/i-0fe182cb0ffc939a4/TailLogs-1577856795527.out

### 참고 문서 내용

    Amazon S3에서의 로그 위치
    환경에서 테일 또는 번들 로그를 요청하거나 인스턴스가 교체된 로그를 업로드하면, 이러한 로그는 Amazon S3의 Elastic Beanstalk 버킷에 저장됩니다. Elastic Beanstalk는 환경을 생성하는 각 AWS 리전에 elasticbeanstalk-region-account-id라는 버킷을 생성합니다. 이 버킷 내에서 로그는 경로 resources/environments/logs/logtype/environment-id/instance-id 아래에 저장됩니다.
    
    예를 들어 계정 123456789012에서 AWS 리전 us-west-2의 Elastic Beanstalk 환경 e-mpcwnwheky에 있는 인스턴스 i-0a1fd158의 로그는 다음 위치에 저장됩니다.
    
    테일 로그 –
    
    s3://elasticbeanstalk-us-west-2-123456789012/resources/environments/logs/tail/e-mpcwnwheky/i-0a1fd158

## 출처

> Elastic Beanstalk 환경에서 Amazon EC2 인스턴스의 로그 보기

[https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/using-features.logging.html](https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/using-features.logging.html) 

### issue

- S3에서 생성이 되긴 하나, 보기좋게 생성되지 않음
    - s3에서 특정 그룹 하위에서 생성되도록 뭔가 설정을 주는 방법을 더 찾아봐야 함
    - cloudwatch에선 해당 그룹이 생성안되고 있으나.. 궁극적으로는 s3에서 생성되도록 해야함

### TODO

SSH 로 접속해서 /etc/awslogs/config/위치에 파일이 제대로 생성되었는지 내용 확인

### 더 찾아봐야 할 것?

- cloudwatch에 제대로만 로그 그룹에 생성된다면 아래처럼 구성해 볼 수 있을 것 같은데...
    - [https://medium.com/@sungmok.sohn/aws-ec2의-application-log를-s3로-백업하기-67ff02be5e2c](https://medium.com/@sungmok.sohn/aws-ec2%EC%9D%98-application-log%EB%A5%BC-s3%EB%A1%9C-%EB%B0%B1%EC%97%85%ED%95%98%EA%B8%B0-67ff02be5e2c)
    - 이렇게 복잡하게 해야 되나???

---

# ec2에 올렸을 경우 cloudwatch에서 로그 생기도록 하는건 성공(샘플코드)

### Logback AWSLogs appender 를 사용

git주소 : ([https://github.com/pierredavidbelanger/logback-awslogs-appender](https://github.com/pierredavidbelanger/logback-awslogs-appender))

### logback.xml

    <configuration>
        <appender name="AWS_LOGS" class="ca.pjer.logback.AwsLogsAppender"/>
        <root>
            <appender-ref ref="AWS_LOGS"/>
        </root>
    </configuration>

### pom.xml

    <project>
        <dependencies>
            <dependency>
                <groupId>org.slf4j</groupId>
                <artifactId>slf4j-api</artifactId>
                <version>1.7.21</version>
            </dependency>
            <dependency>
                <groupId>ca.pjer</groupId>
                <artifactId>logback-awslogs-appender</artifactId>
                <version>1.2.1</version>
            </dependency>
        </dependencies>
    </project>

### 참고한 질문

[aws-cloudwatch-logback-appender-for-spring-boot-applications](https://stackoverflow.com/questions/46281813/aws-cloudwatch-logback-appender-for-spring-boot-applications)

---

## 비슷한 질문

1. [https://stackoverflow.com/questions/42831327/how-to-log-on-amazon-elastic-beanstalk-with-a-spring-boot-application](https://stackoverflow.com/questions/42831327/how-to-log-on-amazon-elastic-beanstalk-with-a-spring-boot-application) 
2. [https://stackoverflow.com/questions/42831327/how-to-log-on-amazon-elastic-beanstalk-with-a-spring-boot-application](https://stackoverflow.com/questions/42831327/how-to-log-on-amazon-elastic-beanstalk-with-a-spring-boot-application)
3. [https://stackoverflow.com/questions/12761183/logging-slf4j-to-elasticbeanstalk](https://stackoverflow.com/questions/12761183/logging-slf4j-to-elasticbeanstalk) 

### I cannot locate production log files on Elastic Beanstalk ec2 instance

[https://stackoverflow.com/questions/30277164/i-cannot-locate-production-log-files-on-elastic-beanstalk-ec2-instance](https://stackoverflow.com/questions/30277164/i-cannot-locate-production-log-files-on-elastic-beanstalk-ec2-instance) 

### cloudwatch-logback-appender

[https://github.com/j256/cloudwatch-logback-appender](https://github.com/j256/cloudwatch-logback-appender)

### issue

- ec2에 logback 경로로 지정된 path도 생성되어 있지 않고, 즉 로그 파일이 생성되지 않고 있다.
- 왜 로그 폴더가 생성되지 않은걸까? 생성이 원래 안되는건가???

이것도 비슷한 컨셉인것 같고.. 

[AWS Elastic Beanstalk Tomcat log를 CloudWatch로 Streaming](https://blog.msalt.net/255)

아마 이걸 원하신것 같은데.. (이건 ec2라 이제 논외) 

[AWS EC2의 Application log를 S3로 백업하기](https://medium.com/@sungmok.sohn/aws-ec2%EC%9D%98-application-log%EB%A5%BC-s3%EB%A1%9C-%EB%B0%B1%EC%97%85%ED%95%98%EA%B8%B0-67ff02be5e2c)

로그 그룹을 만들어주는 maven depengency를 넣으면 cloudwatch에해당 그룹명으로 로그 파일이 생성됨(샘플로 테스트) beanstalk로 올리면 안됨. 

---

# 기타 구성

### AWS Elastic Beanstalk + Spring 환경 구축

1. [https://pangyo-dev.tistory.com/6](https://pangyo-dev.tistory.com/6)

2. [https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/environments-cfg-logging.html](https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/environments-cfg-logging.html)

---

---
