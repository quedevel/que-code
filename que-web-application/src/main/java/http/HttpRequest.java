package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.IOUtils;

public class HttpRequest {

    private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);

    private RequestLine requestLine;

    private HttpHeaders headers;

    private RequestParams requestParams = new RequestParams();

    public HttpRequest(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            requestLine = new RequestLine(createRequestLine(br)); // 메소드 유형, url, queryString 추출
            requestParams.addQueryString(requestLine.getQueryString()); // queryString to map
            headers = processHeaders(br); // header값 map 형식으로 생성
            requestParams.addBody(IOUtils.readData(br, headers.getContentLength())); // post로 데이터 보낼때
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