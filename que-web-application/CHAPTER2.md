# 웹 서버 리팩토링
## 과제 1. Log 설정
1. pom.xml 에 Logback Classic Module 추가
```xml
    <!-- logger -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.1.2</version>
    </dependency>
```

2. resources 아래 logback.xml 설정 추가
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration>
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <Pattern>%d{HH:mm:ss.SSS} [%-5level] [%thread] [%logger{36}] - %m%n</Pattern>
        </layout>
    </appender>

    <root level="DEBUG">
        <appender-ref ref="STDOUT" />
    </root>
</configuration>
```

## 과제 2. HttpRequest, HttpResponse 분리 & 리팩토링
*각 출력값에 대한 분석 및 소스 정리*
```
GET /user/login.html HTTP/1.1
Host: localhost:8080
Connection: keep-alive
    .
    .
    .
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: isLogin=true
```

1. HttpMethod : 메소드 유형 enum 클래스
```java
public enum HttpMethod {
    GET, POST;
}
```
2. RequestLine : 메소드 유형, url, queryString 추출 클래스
```java
public class RequestLine {

    private static final Logger log = LoggerFactory.getLogger(RequestLine.class);

    private HttpMethod method;

    private String path;

    private String queryString;

    public RequestLine(String requestLine) {
        log.debug("request line : {}", requestLine);
        String[] tokens = requestLine.split(" ");
        this.method = HttpMethod.valueOf(tokens[0]);

        String[] url = tokens[1].split("\\?");
        this.path = url[0];

        if (url.length == 2) {
            this.queryString = url[1];
        }
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getQueryString() {
        return queryString;
    }
}
```
3. RequestParams : 메소드 유형, url, queryString을 담을 클래스
```java
public class RequestParams {

    private static final Logger log = LoggerFactory.getLogger(RequestParams.class);

    private Map<String, String> params = new HashMap<>();

    public void addQueryString(String queryString) {
        putParams(queryString);
    }

    private void putParams(String data) {
        log.debug("data : {}", data);

        if (data == null || data.isEmpty()) {
            return;
        }

        params.putAll(HttpRequestUtils.parseQueryString(data));
        log.debug("params : {}", params);
    }

    public void addBody(String body) {
        putParams(body);
    }

    public String getParameter(String name) {
        return params.get(name);
    }
}
```
4. HttpHeaders : 두번째 라인부터의 header값을 담을 클래스
```java
public class HttpHeaders {

    private static final String CONTENT_LENGTH = "Content-Length";

    private static final Logger log = LoggerFactory.getLogger(HttpHeaders.class);

    private Map<String, String> headers = new HashMap<>();

    void add(String header) {
        log.debug("header : {}", header);
        String[] splitedHeaders = header.split(":");
        headers.put(splitedHeaders[0], splitedHeaders[1].trim());
    }

    String getHeader(String name) {
        return headers.get(name);
    }

    int getIntHeader(String name) {
        String header = getHeader(name);
        return header == null ? 0 : Integer.parseInt(header);
    }

    int getContentLength() {
        return getIntHeader(CONTENT_LENGTH);
    }
}
```
5. HttpRequest
```java
public class HttpRequest {

    private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);

    private RequestLine requestLine;

    private HttpHeaders headers;

    private RequestParams requestParams = new RequestParams();

    public HttpRequest(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            requestLine = new RequestLine(createRequestLine(br));
            requestParams.addQueryString(requestLine.getQueryString());
            headers = processHeaders(br);
            requestParams.addBody(IOUtils.readData(br, headers.getContentLength()));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private String createRequestLine(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null) {
            throw new IllegalStateException();
        }
        return line;
    }

    private HttpHeaders processHeaders(BufferedReader br) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String line;
        while (!(line = br.readLine()).equals("")) {
            headers.add(line);
        }
        return headers;
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }

    public String getPath() {
        return requestLine.getPath();
    }

    public String getHeader(String name) {
        return headers.getHeader(name);
    }

    public String getParameter(String name) {
        return requestParams.getParameter(name);
    }
}
```
6. HttpResponse
```java
public class HttpResponse {

    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);

    private DataOutputStream dos = null;

    private Map<String, String> headers = new HashMap<String, String>();

    public HttpResponse(OutputStream out) {
        dos = new DataOutputStream(out);
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public void forward(String url) {
        try {
            byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
            if (url.endsWith(".css")) {
                headers.put("Content-Type", "text/css");
            } else if (url.endsWith(".js")) {
                headers.put("Content-Type", "application/javascript");
            } else {
                headers.put("Content-Type", "text/html;charset=utf-8");
            }
            headers.put("Content-Length", body.length + "");
            response200Header(body.length);
            responseBody(body);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void forwardBody(String body) {
        byte[] contents = body.getBytes();
        headers.put("Content-Type", "text/html;charset=utf-8");
        headers.put("Content-Length", contents.length + "");
        response200Header(contents.length);
        responseBody(contents);
    }

    private void response200Header(int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            processHeaders();
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.writeBytes("\r\n");
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void sendRedirect(String redirectUrl) {
        try {
            dos.writeBytes("HTTP/1.1 302 Found \r\n");
            processHeaders();
            dos.writeBytes("Location: " + redirectUrl + " \r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void processHeaders() {
        try {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                dos.writeBytes(key + ": " + headers.get(key) + " \r\n");
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
```

7. 리팩토링 후 RequestHandler의 run() 함수 수정
```java
    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            HttpRequest request = new HttpRequest(in);
            HttpResponse response = new HttpResponse(out);
            String path = getDefaultPath(request.getPath());

            if ("/user/create".equals(path)) {
                User user = new User(request.getParameter("userId"), request.getParameter("password"),
                        request.getParameter("name"), request.getParameter("email"));
                log.debug("user : {}", user);
                DataBase.addUser(user);
                response.sendRedirect(CommonConstants.INDEX_URL);
            } else if ("/user/login".equals(path)) {
                User user = DataBase.findUserById(request.getParameter("userId"));
                if (user != null) {
                    if (user.login(request.getParameter("password"))) {
                        response.addHeader("Set-Cookie", "isLogined=true; Path=/");
                        response.sendRedirect(CommonConstants.INDEX_URL);
                    } else {
                        response.sendRedirect(CommonConstants.LOGIN_FAIL_URL);
                    }
                } else {
                    response.sendRedirect(CommonConstants.LOGIN_FAIL_URL);
                }
            } else if ("/user/list".equals(path)) {
                if (!isLogin(request.getHeader("Cookie"))) {
                    response.sendRedirect(CommonConstants.LOGIN_URL);
                    return;
                }

                Collection<User> users = DataBase.findAll();
                StringBuilder sb = new StringBuilder();
                sb.append("<table border='1'>");
                for (User user : users) {
                    sb.append("<tr>");
                    sb.append("<td>" + user.getUserId() + "</td>");
                    sb.append("<td>" + user.getName() + "</td>");
                    sb.append("<td>" + user.getEmail() + "</td>");
                    sb.append("</tr>");
                }
                sb.append("</table>");
                response.forwardBody(sb.toString());
            } else {
                response.forward(path);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
```