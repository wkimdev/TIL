## rebase
- Git에서 한 브랜치에서 다른 브랜치로 합치는 방법은 두 가지가 있다. 
- 하나는 Merge이고 다른 하나는 Rebase다. 


- Rebase를 하든지, Merge를 하든지 최종 결과물은 같고 커밋 히스토리만 다르다는 것이 중요하다. 
- Rebase의 경우는 브랜치의 변경사항을 순서대로 다른 브랜치에 적용하면서 합치고 Merge의 경우는 두 브랜치의 최종결과만을 가지고 합친다.
- 서버의 히스토리를 새로 덮어씌우려면 git push --force 명령을 사용해야 한다. 이후에 저장소에서 Fetch하고 나면 아래 그림과 같은 상태가 된다:


## 나의 경우 항상 헤깔리는 점
- 내가 실수로 건드린 소스코드를 commit하거나 push하지 않고, master를 그대로 merge?강제로 PUSH 받고 싶다. 
- 그러면 수정한 부분만 찾아서 지우고, push받으면 되는데, 정신없이 건드린게 많을때는 그냥 강제로 엎어치기를 하고 싶은데 이럴땐 어떻게???
  
```
git fetch --all
git reset --hard origin/master
```

- https://stackoverflow.com/questions/1125968/how-do-i-force-git-pull-to-overwrite-local-files
  


## head
- 브랜치의 시작('HEAD')
  


## reference 
- https://backlog.com/git-tutorial/kr/stepup/stepup2_8.html 
