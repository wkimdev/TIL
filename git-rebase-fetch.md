## rebase
- Git에서 한 브랜치에서 다른 브랜치로 합치는 방법은 두 가지가 있다. 
- 하나는 Merge이고 다른 하나는 Rebase다. 


- Rebase를 하든지, Merge를 하든지 최종 결과물은 같고 커밋 히스토리만 다르다는 것이 중요하다. 
- Rebase의 경우는 브랜치의 변경사항을 순서대로 다른 브랜치에 적용하면서 합치고 Merge의 경우는 두 브랜치의 최종결과만을 가지고 합친다.
- 서버의 히스토리를 새로 덮어씌우려면 git push --force 명령을 사용해야 한다. 이후에 저장소에서 Fetch하고 나면 아래 그림과 같은 상태가 된다:


## 항상 헤깔리는 점
- 내가 실수로 건드린 소스코드를 commit하거나 push하지 않고, master를 그대로 merge?강제로 PUSH 받고 싶다. 
- 그러면 수정한 부분만 찾아서 지우고, push받으면 되는데, 정신없이 건드린게 많을때는 그냥 강제로 엎어치기를 하고 싶은데 이럴땐 어떻게???
  
```
git fetch --all
git reset --hard origin/master
```

- https://stackoverflow.com/questions/1125968/how-do-i-force-git-pull-to-overwrite-local-files

## fetch
- 원격 저장소의 데이터를 로컬에 가져오기만 하는 것. 
- pull 을 실행하면, 원격 저장소의 내용을 가져와 자동으로 병합 작업을 실행하게 됩니다. 
- 그러나 단순히 원격 저장소의 내용을 확인만 하고 로컬 데이터와 병합은 하고 싶지 않은 경우에는 fetch 명령어를 사용할 수 있습니다.
- fetch 를 실행하면, 원격 저장소의 최신 이력을 확인할 수 있습니다. 이 때 가져온 최신 커밋 이력은 이름 없는 브랜치로 로컬에 가져오게 됩니다. 
- 이 브랜치는 'FETCH_HEAD'의 이름으로 체크아웃 할 수도 있습니다.
- 예를 들어, 로컬 저장소와 원격 저장소에 B에서 진행된 커밋이 있는 상태에서 fetch 를 수행하면 아래 그림과 같이 이력이 남겨집니다.
- 이 상태에서 원격 저장소의 내용을 로컬 저장소의 'master'에 통합하고 싶은 경우에는, 'FETCH_HEAD' 브랜치를 merge 하거나 **다시 pull 을 실행** 하면 됩니다.  

#### 소스트리에서, fetch이후 pull 할경우  
  
```
1. 원격 저장소(github.com) 에서 Create new file로 새로운 파일을 직접 생성하여 커밋한다.

https://github.com/poormanY/test

2. SourceTree 에서 폐치(petch)를 선택하여 원격 저장소의 정보를 갱신한다.

3. SourceTree 에서 풀(pull)을 선택하여 가져올 원격 저장소와 브랜치를 선택한다.

4. SourceTree 에서 하단에 있는 로그/히스토리를 선택하여 확인한다.


출처: https://poorman.tistory.com/113 [poorman]
```

#### fetch와 pull의 명확한 차이  
  
```
Fetch : 중앙 저장소의 소스를 로컬 저장소로 가져온다!  그러나 현재 작업중인 소스들을 변경하는 Merge 작업을 하지는 않는다
Pull : 중앙 저장소의 소스를 로컬 저장소로 가져온다! 또한 현재 작업중인 소스들의 Merge 작업까지 통합하여 수행한다  
```
  
## head
- 브랜치의 시작('HEAD')
  

  
## reference 
- https://backlog.com/git-tutorial/kr/stepup/stepup2_8.html 
- https://backlog.com/git-tutorial/kr/stepup/stepup3_2.html
- https://poorman.tistory.com/113
