package controller;

import http.HttpRequest;
import http.HttpResponse;

/**
 * servlet 인터페이스 역할
 */
public interface Controller {

    void service(HttpRequest request, HttpResponse response);
}
