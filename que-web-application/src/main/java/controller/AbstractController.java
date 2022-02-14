package controller;

import http.HttpMethod;
import http.HttpRequest;
import http.HttpResponse;

public abstract class AbstractController implements Controller{

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        HttpMethod method = request.getMethod();

        if(method.isPost()){
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }

    }

    protected void doPost(HttpRequest request, HttpResponse response){

    }

    protected void doGet(HttpRequest request, HttpResponse response){

    }


}
