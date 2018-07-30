## BigInteger 
- BigInteger는 거의 무한한 크기의 정수형 숫자를 다루기 위한 것

```

	@Override
		public BigInteger testCnt() throws Exception {
			JsonElement jsonElement = (JsonElement) RPCCall(CODE, new ArrayList<>());  
			return CommonUtil.jsonElement.getAsString());
		}

```


## BigDecimal 
- BigDecimal은 무한한 크기의 부동소수점 숫자를 다루기 위한 것이다

```

	//통화단위
	@Override
		public BigDecimal convertWeiToEther(BigDecimal number, UnitCode ETHER) {
			return number.divide();
		}
```
