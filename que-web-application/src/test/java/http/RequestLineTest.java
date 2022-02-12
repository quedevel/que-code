package http;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequestLineTest {

    @Test
    public void create_method_get() {
        RequestLine line = new RequestLine("GET /index.html HTTP/1.1");
        assertEquals("GET", line.getMethod().name());
        assertEquals("/index.html", line.getPath());
    }

    @Test
    public void create_method_post() {
        RequestLine line = new RequestLine("POST /index.html HTTP/1.1");
        assertEquals("/index.html", line.getPath());
    }

    @Test
    public void create_path_and_params() {
        RequestLine line = new RequestLine("GET /user/create?userId=javajigi&password=pass HTTP/1.1");
        assertEquals("GET", line.getMethod().name());
        assertEquals("/user/create", line.getPath());
    }
}