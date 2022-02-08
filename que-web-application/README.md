# 웹 서버 시작
### WebServer.java 
```java
public class WebServer {
    private static final int DEFAULT_PORT = 8080;

    // 실행하면 서버 켜짐
    public static void main(String args[]) throws Exception {
        int port = 0;
        if (args == null || args.length == 0) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }

        // 서버소켓을 생성한다.
        // 8080번 포트를 사용
        try (ServerSocket listenSocket = new ServerSocket(port)) {
            System.out.println("Web Application Server started {} port.... "+ port);

            // 클라이언트가 연결될때까지 대기
            Socket connection;
            while ((connection = listenSocket.accept()) != null) {
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        }
    }
}
```
### RequestHandler.java
```java
public class RequestHandler extends Thread {

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        System.out.println("New Client Connect! Connected IP : {"+ connection.getInetAddress()+"}, Port : {"+connection.getPort()+"}");

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            DataOutputStream dos = new DataOutputStream(out);
            byte[] body = "Hello World".getBytes();
            response200Header(dos, body.length);
            responseBody(dos, body);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
```

### 동작 방식을 그려서 이해하기
![2021_04_user_count](images/1.png)



## 과제 1. index.html 응답하기
```java
    try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
    
        // http 요청 정보를 모두 출력
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int idx = 0;
        while (bufferedReader.ready()){
            // 요청 url 정보 찾기
            System.out.println(idx+"   "+bufferedReader.readLine());
            idx++;
        }
    
        DataOutputStream dos = new DataOutputStream(out);
        byte[] body = "Hello World".getBytes();
        response200Header(dos, body.length);
        responseBody(dos, body);
    } catch (IOException e) {
        e.getStackTrace();
    }
```
출력 결과
```
0   GET /asdfasd/asdfasdfs/index.html HTTP/1.1
1   Host: localhost:8080
2   Connection: keep-alive
3   Cache-Control: max-age=0
4   sec-ch-ua: " Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"
5   sec-ch-ua-mobile: ?0
6   sec-ch-ua-platform: "Windows"
7   Upgrade-Insecure-Requests: 1
8   User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36
9   Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
10   Sec-Fetch-Site: none
11   Sec-Fetch-Mode: navigate
12   Sec-Fetch-User: ?1
13   Sec-Fetch-Dest: document
14   Accept-Encoding: gzip, deflate, br
15   Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```
첫번째 라인에 요청 URL 정보가 담겨있는것 확인 <br/>

첫번째 라인 문자열을 분리하여 작업

```java
    /**
     * InputStream에서 url 추출하기
     * @param bufferedReader
     * @return String
     * @throws IOException
     */
    public static String getUrl(BufferedReader bufferedReader) throws IOException {
        String result = "";
        if(bufferedReader.ready()){
            result = bufferedReader.readLine().split(" ")[1];
        }
        return result;
    }
```
I/O 유틸 클래스 제작 url을 추출
```java
// body에 경로 넣기
byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());
```

## 과제 2. Get 방식으로 회원가입
method > get
action > /user/create
```html
    <form name="question" method="get" action="/user/create">
      <div class="form-group">
          <label for="userId">사용자 아이디</label>
          <input class="form-control" id="userId" name="userId" placeholder="User ID">
      </div>
      <div class="form-group">
          <label for="password">비밀번호</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
      <div class="form-group">
          <label for="name">이름</label>
          <input class="form-control" id="name" name="name" placeholder="Name">
      </div>
      <div class="form-group">
          <label for="email">이메일</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="Email">
      </div>
      <button type="submit" class="btn btn-success clearfix pull-right">회원가입</button>
      <div class="clearfix" />
  </form>
```
GET > 요청 정보 출력해보기
```
url: /user/create?userId=quedevel&password=1234&name=kimdongho&email=quedevel%40innotree.com
etc.... : Host: localhost:8080
etc.... : Connection: keep-alive
etc.... : sec-ch-ua: " Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"
etc.... : sec-ch-ua-mobile: ?0
etc.... : sec-ch-ua-platform: "Windows"
etc.... : Upgrade-Insecure-Requests: 1
etc.... : User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36
etc.... : Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
etc.... : Sec-Fetch-Site: same-origin
etc.... : Sec-Fetch-Mode: navigate
etc.... : Sec-Fetch-User: ?1
etc.... : Sec-Fetch-Dest: document
etc.... : Referer: http://localhost:8080/user/form.html
etc.... : Accept-Encoding: gzip, deflate, br
etc.... : Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
```
url을 파라미터로 변경 후 User로 만들기
```java
    // 회원 가입 url
    if(url.startsWith("/user/create")){
        // Get 요청으로 파라미터가 쿼리스트링으로 넘어올때
        int paramIdx = url.indexOf("?");
        if(paramIdx >= 0){
            // queryString 추출
            String queryString = url.substring(paramIdx+1); // ex) userId=quedevel&password=1234&name=kimdongho&email=quedevel%40innotree.com
    
            // queryString을 파라미터 맵으로 변경하는 util 제작
            params = IOUtils.convertQueryStringToMap(queryString);
    
            // 회원생성
            User user = new User(params.get("userId"),params.get("password"),params.get("name"),params.get("email"));
    
            System.out.println(user.toString());
    
            url = "/index.html";
        }
    }
```
queryString을 파라미터 맵으로 변경하는 util 제작
```java
    /**
     * queryString to Map
     * @param queryString
     * @return Map<String, String>
     */
    public static Map<String, String> convertQueryStringToMap(String queryString){
        Map<String, String> result = new HashMap<>();
        String[] pArr = queryString.split("&");
        if (pArr.length > 0){
            for(String p : pArr){
                String[] param = p.split("=");
                result.put(param[0], param[1]);
            }
        }
        return result;
    }
```

## 과제 3. Post 방식으로 회원가입
method > post
action > /user/create
```html
    <form name="question" method="post" action="/user/create">
      <div class="form-group">
          <label for="userId">사용자 아이디</label>
          <input class="form-control" id="userId" name="userId" placeholder="User ID">
      </div>
      <div class="form-group">
          <label for="password">비밀번호</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
      <div class="form-group">
          <label for="name">이름</label>
          <input class="form-control" id="name" name="name" placeholder="Name">
      </div>
      <div class="form-group">
          <label for="email">이메일</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="Email">
      </div>
      <button type="submit" class="btn btn-success clearfix pull-right">회원가입</button>
      <div class="clearfix" />
  </form>
```
POST > 요청 정보 출력해보기
```
url: /user/create
etc.... : Host: localhost:8080
etc.... : Connection: keep-alive
etc.... : Content-Length: 89
etc.... : Cache-Control: max-age=0
etc.... : sec-ch-ua: " Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"
etc.... : sec-ch-ua-mobile: ?0
etc.... : sec-ch-ua-platform: "Windows"
etc.... : Upgrade-Insecure-Requests: 1
etc.... : Origin: http://localhost:8080
etc.... : Content-Type: application/x-www-form-urlencoded
etc.... : User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36
etc.... : Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
etc.... : Sec-Fetch-Site: same-origin
etc.... : Sec-Fetch-Mode: navigate
etc.... : Sec-Fetch-User: ?1
etc.... : Sec-Fetch-Dest: document
etc.... : Referer: http://localhost:8080/user/form.html
etc.... : Accept-Encoding: gzip, deflate, br
etc.... : Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
etc.... : 
```
검색해보니 post로 데이터를 전달할 경우 전달하는 데이터는 HTTP 본문에 담긴다고 한다.

HTTP 본문에 데이터 추출하기인데 전혀 모르겠지만 일단 BufferedReader에 담겨올태니 클래스에 있는 read 메소드 사용해보기로 한다.
```java
    public int read(char cbuf[], int off, int len) throws IOException 
```
```java
    char[] contentBody = new char[5000];
    bufferedReader.read(contentBody,0,contentBody.length);
    
    String str = String.copyValueOf(contentBody);
```
출력결과
```
Host: localhost:8080
Connection: keep-alive
Content-Length: 38
Cache-Control: max-age=0
sec-ch-ua: " Not;A Brand";v="99", "Google Chrome";v="97", "Chromium";v="97"
sec-ch-ua-mobile: ?0
sec-ch-ua-platform: "Windows"
Upgrade-Insecure-Requests: 1
Origin: http://localhost:8080
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.99 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: same-origin
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Sec-Fetch-Dest: document
Referer: http://localhost:8080/user/form.html
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7

userId=1&password=1&name=1&email=1%401
```

가장 끝에 나온다는 점을 활용하여 최종적으로 리펙토링까지 한 소스
```java
    // http 요청 정보 가져오기
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
    List<String> httpRequestList = new ArrayList<>();

    String readLine = bufferedReader.readLine();

    if(!"".equals(readLine)) httpRequestList.add(readLine);

    // bufferedReader.readLine() 첫번째 라인에 url 주소가 있음
    String url = readLine.split(" ")[1];
    if(url.isEmpty()){
        return;
    }

    // 모든 정보 리스트에 넣기
    while(!"".equals(readLine)){
        readLine = bufferedReader.readLine();
        if(!"".equals(readLine)) httpRequestList.add(readLine);
    }

    // 모든 요청정보 추출
    httpRequestList.forEach(System.out::println);

    // 컨텐츠 길이 추출
    int contentLength = IOUtils.getContentLength(httpRequestList);

    Map<String, String> params = new HashMap<>();

    // 회원 가입 url
    if(url.startsWith("/user/create")){
        int paramIdx = url.indexOf("?");
        String queryString = "";
        if(paramIdx >= 0){
            // get 요청
            // queryString 추출
            queryString = url.substring(paramIdx+1); // ex) userId=quedevel&password=1234&name=kimdongho&email=quedevel%40innotree.com

            // queryString을 파라미터 맵으로 변경하는 util 제작
            params = HttpRequestUtils.parseQueryString(queryString);

        } else {
            // post 요청
            // content body 제일 마지막에 넘어온 query string 읽기
            queryString = IOUtils.readData(bufferedReader, contentLength);
            params = HttpRequestUtils.parseQueryString(queryString);
        }
        // 회원생성
        User user = new User(params.get("userId"),params.get("password"),params.get("name"),params.get("email"));
        System.out.println(user.toString());

        // redirect 필요...
        url = "/index.html";
    }


    // contentType 추출
    String contentType = IOUtils.getContentType(httpRequestList);
    if(contentType.isEmpty()){
        return;
    }

    // body에 경로 넣기
    byte[] body = Files.readAllBytes(new File("./webapp"+url).toPath());

    // js, css etc... content_type 맞추기
    DataOutputStream dos = new DataOutputStream(out);
    response200Header(dos, body.length, contentType);
    responseBody(dos, body);
```

## 과제 4. redirect 방식으로 이동
302 state code를 적용
```java
    private void response302Header(DataOutputStream dos, String url) {
        try {
            dos.writeBytes("HTTP/1.1 302 OK \r\n");
            dos.writeBytes("Location: " + url + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
```
Location을 /index.html로 설정

```
웹브라우저 -> /user/create 요청 -> 회원가입 처리 후 /index.html 302 응답
-> 웹브라우저가 다시 /index.html 로 재요청 -> /index.html 200 응답
```

## 과제 5. cookie 로그인 처리


## 과제 6. stylesheet 적용
```java
    /**
     * InputStream에서 Content_Type 추출하기
     * @param bufferedReader
     * @return String
     * @throws IOException
     */
    public static String getContentType(BufferedReader bufferedReader) throws IOException {
        String result = "";
        while (bufferedReader.ready()){
            String temp = bufferedReader.readLine();
            if(temp.indexOf("Accept") >= 0){
                result = temp.split(",")[0].split(" ")[1];
                break;
            }
        }
        return result;
    }
```
I/O 유틸 클래스 > Content_Type을 추출

```java
    private void response200Header(DataOutputStream dos, int lengthOfBodyContent, String contentType) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: "+contentType+";charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
```
Content_Type을 동적으로 받도록 메소드 수정