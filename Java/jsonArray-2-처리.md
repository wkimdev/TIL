## jsonArray type 처리
- jsonArray type 두개 처리 방법

#### json array data type
- 아래 예시 타입
```
    "total_cnt": "10",
    "list1": [
        {            
            "key": "N",
            "value1": "20190317",
            "value2": "0000011",
            "list2": [
                {
                    "key2": "1111",
                    "applie": "ssss",
                    "banana": "dadada"                    
                },
                
                {
                    "key2": "1111",
                    "applie": "ssss",
                    "banana": "dadada"                    
                }
            ]
        }
``` 
  

#### 구현
- 모델두개 만들어서 구현하기. 

```
{
....

EProgramList[] eProgramList = result.getProgramList();
		List<CJEProgramModel> cjEProgramList = new ArrayList<CJEProgramModel>();
		List<CJEClipModel> cJEClipList = new ArrayList<CJEClipModel>();
		
		for(EProgramList epList : eProgramList) {
			
			// 1. programModel 	
			CJEProgramModel cjEProgramModel = new CJEProgramModel();
			cjEProgramModel.setChannelId(epList.getChannelId())
							.setChannelName(epList.getChannelTitle())
							.setProgramId(epList.getProgramId())
							.setProgramName(epList.getTitle())
							.setContentsNumber(epList.getContentNumber())
							.setBroadDate(epList.getBroadDate());
			
			
			// 2. clipModel
			CommonClipList[] commonClipList = epList.getClipList();
			
			for (CommonClipList ecList : commonClipList) {
				CJEClipModel cjEClipModel = new CJEClipModel();
				cjEClipModel.setClipId(ecList.getClipId())
							.setContentsName(ecList.getClipTitle())
							.setImgUrl(ecList.getContentImg())
							.setRunningTime(ecList.getPlayTime());
				
				cJEClipList.add(cjEClipModel);
			}
			
			cjEProgramModel.setCilpList(cJEClipList);
			cjEProgramList.add(cjEProgramModel);
		}
		
		return cjEProgramList;
```
