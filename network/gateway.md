## gateway
- 게이트웨이는 라우터와 동일한 개념
- 라우터는 네트워크 장비의 일종
- 컴퓨터 네트워크에서의 게이트웨이 : 현재 사용자가 위치한 네트워크에(Segment)에서 다른 네트워크(인터넷)으로
이동하기 위해 반드시 거쳐야 하는 거점.(톨게이트와 유사한 개념)
- 일반적으로 게이트웨이의 IP 주소는 해당 네트워크 내 컴퓨터에 할당된 IP 주소 중 끝자리(4번째 옥텟)만 다른 형태다. 대게 1을 지정
- 보통~ 192.168.xxx.1

## Loute
-

## subnet mask.
- 보통 : 255.255.255.0 ~ 

## 할당된 IP
- 192.168.XXX.XXX~~~
- 여기서 사설 IP와 공인 IP가 나뉜다.
- 회사내에서만 접속가능한 네트워크, 아닌 네트워크

## 인터넷 연결을 위해 필요한 것 세가지
-  내 컴의 ip주소 + subnet mask + gateway(router)

## 멀티체인노드 접속시, 아래 이슈의 원인과 해결(HTTP/1.1 403 Forbidden)
> java.lang.IllegalStateException: Not a JSON Object: "Forbidden"
> 
HttpResponseProxy{HTTP/1.1 403 Forbidden 
[Date: Thu, 09 Aug 2018 06:26:37 +0000, Connection: close, 
Content-Length: 9, Content-Type: text/plain, Server: 
bitcoin-json-rpc/v0.10.0.0-unk] 
ResponseEntityProxy{[Content-Type: text/plain
,Content-Length: 9,Chunked: false]}}
 


   
     
- 확인해본결과 mac에서 ip가 wifi로 잡혀있어서 노드에 붙질 못했었음.
- ifconfig날렸더니 내가 알던 ip가 아닌 다른 ip로 잡혀있었음..    
- mac에서 ip 확인하기
`$ ifconfig |grep inet` 

