- ProceedingJoinPoint
- invoke
- interface
- java reflaction


## @Around 애노테이션 적용 메서드 
- 아래 aspect클래스 중 @Around 애노테이션 적용 메서드 
```
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		long begin = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		System.out.print("aspect around 적용 : [");
		System.out.print(System.currentTimeMillis() - begin);
		System.out.print("]");
		System.out.println();
		return retVal;
	}
```
  
    
## reference  
- spring 4.0 프로그래밍 
