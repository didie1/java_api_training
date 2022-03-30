package fr.lernejo.httphandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.HttpURLConnection;


public class Fire implements HttpHandler {
    public final int port;
    public final String cell;
    public Fire(int port,String cell) {
        this.port = port;
        this.cell = cell;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (!httpExchange.getRequestMethod().equals("GET")) {
            httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_NOT_FOUND, 0);
            return;
        }
        try {
            httpExchange.getResponseHeaders().set("Content-type", "application/json");
            String reply = "{\"consequence\":\"sunk\",\"shipLeft\":true}";
            httpExchange.getResponseHeaders().set("Content-Type", "application/json;");
            httpExchange.sendResponseHeaders(202, reply.getBytes().length);
            httpExchange.getResponseBody().write(reply.getBytes());
            httpExchange.close();
        } catch (IOException e) {
            httpExchange.sendResponseHeaders(400, 0);
        }
    }
}
