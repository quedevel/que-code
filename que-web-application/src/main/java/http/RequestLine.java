package http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestLine {

    private static final Logger log = LoggerFactory.getLogger(RequestLine.class);

    private HttpMethod method;

    private String path;

    private String queryString;

    public RequestLine(String requestLine) {
        log.debug("request line : {}", requestLine);
        // GET /user/create?userId=quedevel&password=1q2w3e4r&name=leo HTTP/1.1
        String[] tokens = requestLine.split(" ");

        this.method = HttpMethod.valueOf(tokens[0]); // 메소드 유형 enum

        String[] url = tokens[1].split("\\?");
        this.path = url[0]; // url로 변수 초기화

        // queryString이 없다면 url.length == 1
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