## timeout exception 발생시키기!
- 캐시에 timeout exception을 강제로 발생시켜 응답값을 확인해야 했다.. 
- 찾아본 소스 코드.. 

```
// timeout exception test
ExecutorService executor = Executors.newCachedThreadPool();

Callable<Object> task = new Callable<Object>() {
	public Object call() throws InterruptedException {
		// 60초 이상 timeout
		Thread.sleep(70000);
		return cJClipService.getCLPGMClipList(channelId, programId, pageNo, pageCnt);
	}
};
		
Future<Object> future = executor.submit(task);

try {
	Object result = future.get(60, TimeUnit.SECONDS);	// 수행 기대 시간
	System.out.println("result >>>>"+result);
	
} catch (TimeoutException ex) {	   
	ex.printStackTrace();
} catch (InterruptedException e) {   
	e.printStackTrace();
} catch (ExecutionException e) {  
	e.printStackTrace();
} finally {
   future.cancel(true); // may or may not desire this
  ```
    
