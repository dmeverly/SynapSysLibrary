package web;

import java.net.http.HttpRequest;

public class WebController {
    private HttpRequest httpRequest;

    public WebController(){
        this.httpRequest = HttpRequest.newBuilder().build();
    }
}
