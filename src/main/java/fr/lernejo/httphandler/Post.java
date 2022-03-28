
package fr.lernejo.httphandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;


public class Post implements HttpHandler {
    public final int port;
    public Post(int port){
        this.port = port;
    }
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            String reply = "{\"id\":\" " + this.port + "\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"May the code win\"}";
            String messageReceived = new String(httpExchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            System.out.println(messageReceived);
            httpExchange.getResponseHeaders().set("Content-type", "application/json");
            httpExchange.sendResponseHeaders(202, reply.length());
            try (OutputStream os = httpExchange.getResponseBody()){
                os.write(reply.getBytes());}
        } else {
            httpExchange.sendResponseHeaders(404, -1);
        }
    }
}
