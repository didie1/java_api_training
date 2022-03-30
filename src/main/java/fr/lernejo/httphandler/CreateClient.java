package fr.lernejo.httphandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateClient {
    private final HttpClient client;
    public final int port;

    public CreateClient(int port){
        this.client = HttpClient.newHttpClient();
        this.port = port;

    }
    public void requestPost(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"hello\"}"))
            .build();

        HttpClient client = HttpClient.newHttpClient();
        this.client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(r -> System.out.println("Reply: " +
            r.statusCode() + " : " + r.body()));
    }

}
