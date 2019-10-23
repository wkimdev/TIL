#### wyh should study serverless? 
3 specials routers  
AWS CLOUD Provider  
컨셉은 사용한 만큼만 내고 그것이 어떻게 운영되는지 (스케일, 빌딩) 상관할 필요가 없다.  
첫 step을 시작하기 쉽다.  
full -stack~ 으로서의 장점을 활용할 수 있다. 
   

## 1. serverless 설치하기
    
```
 `$ npm  install -g serverless`
 `sls --version`
```

## 2.  Serverless 로그인

## 3. AWS 사용자 및 크리덴셜 만들기
- Serverless 프레임워크를 통해 AWS에 우리가 만든 어플리케이션을 배포  
- 그렇게 하려면, 프레임워크가 해당 작업을 진행해 줄 수 있도록 권한 설정을 해줘야 한다. 
- AWS에 로그인해 lAM 페이지에서 작업
	* 사용자 추가

- aws에 접근가능하도록 아래처럼 명령어를 날린다. 	
- `serverless config credentials --provider aws --key {MYKEY} --secret {MYPW} `
	
## 4. Serverless 템플릿을 통하여 애플리케이션 생성하기
  
```
$ sls create -t
```
## 5. 로컬에서 함수 호출해보기
- serverless 를 통하여 함수가 잘 동작하는지 확인해볼 수 있다. 
- 함수를 사용할때는 `invoke`를 사용한다. 
    
## 6. serverless.yml 파일 수정하기 
- 함수에 events값을 추가하여 API Gateway와 연결할 수 있다. 
- 코드 몇줄이면... 함수에 API를 달아줄 수 있다!!!!! 
   
## 7. 배포하기  
  
```
$ sls deploy
```
#### 배포 후 로그 

```
>sls deploy
Serverless: Packaging service...
Serverless: Excluding development dependencies...
Serverless: Creating Stack...
Serverless: Checking Stack create progress...
.....
Serverless: Stack create finished...
Serverless: Uploading CloudFormation file to S3...
Serverless: Uploading artifacts...
Serverless: Uploading service hello-serverless.zip file to S3 (401 B)...
Serverless: Validating template...
Serverless: Updating Stack...
Serverless: Checking Stack update progress...
..............................
Serverless: Stack update finished...
Service Information
service: hello-serverless
stage: dev
region: ap-northeast-2
stack: hello-serverless-dev
resources: 10
api keys:
  None
endpoints:
  GET - https://zte3h8n426.execute-api.ap-northeast-2.amazonaws.com/dev/hello
functions:
  hello: hello-serverless-dev-hello
layers:
  None
Serverless: Run the "serverless" command to setup monitoring, troubleshooting and testing.

```
짠 하고 api가 만들어졌따~~
  
- 배포하고 만들어진 API로 요청 후 응답을 확인해 볼 수 있다!!
  
![image](https://user-images.githubusercontent.com/32521173/67403450-e7b50d00-f5ec-11e9-8f13-f41dbb6c903d.png)
  
   

## 출처
https://velopert.com/3549
