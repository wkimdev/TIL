* 입출력문제는 기본적이라 생각하고 대충넘어가려 했었나보다;;.. 알고리즘에서는 처리속도를 줄이는게 중요한데 이번기회에 확실히 알고 넘어가자.
### 자바의 입력 Class

* Scanner, BufferedReader, StringTokenizer
* BufferedReader, StringTokenizer 는 문자열로 활용하기 위하여 사용. BufferedReader를 사용하는 것이 Scanner를 사용하는 것보다 빠르다.
* BufferedReader는 문자열에 최적화 되어 있음.
#### Scanner를 사용했을시 입력 형태.

    Scanner를 사용했을시 입력 형태.
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(); // int
    long l = sc.nextLong(); // int
    String s = sc.next(); // String
    String s = sc.nextLine(); // String

#### BufferedReader를 사용할때

* 아래와 같이 한줄로 입력시, sc.nextInt()를 12번 호출하는건 비효율적이다. 입력갯수가 큰 알고리즘 문제의 경우 시간제한에 걸리게 된다.
    1 2 3 4 5 6 7 8 9 10 11 12 // 한줄 입력

    for(int i=0;i<12;i++) {
    sc.nextInt();
    }

* 그래서 아래와 같이 사용한다.
* 문자열로 받고 split메소드를 이용해서 공백을 기준으로 잘라서 활용.
* integer.parseInt() 형변환을 통해 사용.
    1 2 3 4 5 6 7 8 9 10 11 12 // 한줄 입력

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    // s[0] = "1"; Integer.parseInt(s[0]) => 1
    // s[1] = "2";
    // s[2] = "3";
    // .....

#### StringTokenizer 사용목적

* BufferedReader는 잘라서 배열과 같이 인덱스를 사용하여 접근하여 사용.
* StringTokenizer는 공백이 있다면 뒤에 문자열이 공백 자리를 땡겨 채우도록 한다.
* StringTokenizer가 BufferedReader보다 빠르게 사용될 수 있다.
* 문자열을 자르게 위해 split을 사용할땐, split은 정규식을 기반으로 자르는 로직으로서 내부는 복잡하다. 그에 비해 StringTokenizer의 nextToken()메소드는 단순히 공백 자리를 땡겨 채우는 것이다. 그렇기 때문에 속도 차이가 날 수 밖에 없다.
* 정규식이나 인덱스 접근과 같은 처리가 필요없다면 StringTokenizer를 사용하는 것이 효율적이다.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in);
    StringTokenizer st = new StringTokenizer(br.readLine());

    // AB CDD EFFF GH 입력

    st.nextToken() // AB
    st.nextToken() // CDD
    st.nextToken() // EFFF
    st.nextToken() // GH

#### 같은 문제를 풀었을 때, Scanner와 StringBuilder를 사용했을 때의 처리속도차이

* 이미지 첨부
* 잠깐, 여기서 자바 eof이란 뭐야??

* 출처
* [http://mygumi.tistory.com/78] 
