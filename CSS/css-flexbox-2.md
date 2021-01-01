# Flex Box

- 박스들을 행 열로 배치할 수 있게 도와주는 css의 꽃!!
- flex box를 통해 웹사이트의 구조를 유연하게 짜게 될 수 있다.

레이아웃 구성시 ⇒ position | float | table |

이제는 flex box가 없기 때문에 

### float

- 원래 목적은 이미지와 text를 어떻게 배치할 것 인가에 대한 것
    - float:left , float:center , float:right

### flexbox

- 이해 해야 할 것 두가지
- 1) container
    - container에 쓰일 수 있는 속성

```css
- display ex) diplay: flex;
- flex-direction ) row;
- flex-wrap
- flex-flow
- justify-content
- align-items
- align-content
```

- 2) item

```css
- order
- flex-grow
- flex-shrink
- flex
- align-self
```

div.container>div.item.item${$}*10 (tap키!) 

# flexbox - container관련 속성

100vh 100%

- color tool material tool

### flexbox mdn

- 호환성을 확인해봐야 한다.
    - can i use ? 페이지 및 mdn 사이트로 확인
    - flexbox 관련 사이트: [https://css-tricks.com/snippets/css/a-guide-to-flexbox/](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)

### flex-directions

- 정렬할 방향을 지정해준다.

```css
row (default)
row-reverse
column
column-reverse
```

- **Flex의 방향이 column일 경우 justify-content의 방향이 세로로,** align-items의 뱡향이 가로로 바뀝니다.

```css
display: flex;
flex-direction: column;
justify-content:flex-end;
```

### justify-content 속성

- flex 요소들을 **가로선 상**에서 정렬해준다.
- **Flex의 방향이 column일 경우 justify-content의 방향이 세로로 바뀐다.**

```css
flex-start: 요소들을 컨테이너의 왼쪽으로 정렬합니다.
flex-end: 요소들을 컨테이너의 오른쪽으로 정렬합니다.
center: 요소들을 컨테이너의 가운데로 정렬합니다.
space-between: 요소들 사이에 동일한 간격을 둡니다.
space-around: 요소들 주위에 동일한 간격을 둡니다.
```

### align-items

- flex요소를 세로선 상에서 정렬한다

```css
flex-start: 요소들을 컨테이너의 꼭대기로 정렬합니다.
flex-end: 요소들을 컨테이너의 바닥으로 정렬합니다.
center: 요소들을 컨테이너의 세로선 상의 가운데로 정렬합니다.
baseline: 요소들을 컨테이너의 시작 위치에 정렬합니다.
stretch: 요소들을 컨테이너에 맞도록 늘립니다.
```

### flex-direction

- 정렬할 방향을 지정한다.

```css
row: 요소들을 텍스트의 방향과 동일하게 정렬합니다.
row-reverse: 요소들을 텍스트의 반대 방향으로 정렬합니다.
column: 요소들을 위에서 아래로 정렬합니다.
column-reverse: 요소들을 아래에서 위로 정렬합니다.
```

### flex-wrap

- flex 요소들을 한 줄 또는 여러줄에 걸쳐 정렬한다.

```css
nowrap (default)
wrap
warp-reverse
```

### flex-flow

- flex-direction과 flex-wrap 을 간략히 한줄로 정의할 수 있음
- 공백문자를 이용하여 두 속성의 값들을 인자로 받습니다.

```css
ex: flex-flow: row wrap
```

### align-content

- 세로선 상에  여분의 공간이 있는 경우 flex 컨테이너 사이의 간격을 조정한다.
- 이 속성을 사용하는 방법이 어려울 수 있습니다. align-content는 여러 줄들 사이의 간격을 지정하며, align-items는 컨테이너 안에서 어떻게 모든 요소들이 정렬하는지를 지정합니다. 한 줄만 있는 경우, align-content는 효과를 보이지 않습니다.

```css
flex-start: 여러 줄들을 컨테이너의 꼭대기에 정렬합니다.
flex-end: 여러 줄들을 컨테이너의 바닥에 정렬합니다.
center: 여러 줄들을 세로선 상의 가운데에 정렬합니다.
space-between: 여러 줄들 사이에 동일한 간격을 둡니다.
space-around: 여러 줄들 주위에 동일한 간격을 둡니다.
stretch: 여러 줄들을 컨테이너에 맞도록 늘립니다.
```

---

# flexbox - item관련 속성

flex-shrink : 얼만큼 줄어들지  

- 줄어들 되 얼만큼 줄어들어라! `flex-shrink: 1`

flex-grow:  얼만큼 늘어날지 (유연하게 늘어남) 

- container 만큼 늘어난다
- 늘어나는데 얼만큼 늘어나는지! `flex-grow: 1`

flex-basis: 얼만큼의 사이즈를 차지 할지를 지정해 줌. `flex-basis: 10%`

align-self: center ⇒ item별로 item을 어떻게 정렬 하는지를 나타내주는 표현  

- 개별요소에 적용할 수 있는 또 다른 속성
- 지정된 align-items 값을 무시하고 flex 요소를 세로선 상에서 정렬한다.

### flexbox game~

- [https://flexboxfroggy.com/#ko](https://flexboxfroggy.com/#ko)
- 마지막 문제

```css
flex-direction:column-reverse;
flex-wrap: wrap-reverse;
justify-content: center; // 세로로 적용되는 걸로 바뀌게 됨 
align-content: space-between; //
```
