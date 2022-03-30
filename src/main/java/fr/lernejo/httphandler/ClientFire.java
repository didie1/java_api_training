package fr.lernejo.httphandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientFire {
    private final HttpClient client;
    public final int port;
    public final String adversaryUrl;

    public ClientFire(int port, String url) {
        this.client = HttpClient.newHttpClient();
        this.port = port;
        this.adversaryUrl = url;

    }

    public void shootTarget(String cell){
        HttpRequest requestPost = HttpRequest.newBuilder()
            .uri(URI.create(this.adversaryUrl + "/api/game/fire?cell=" + cell))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .GET()
            .build();
        try{
            this.client.sendAsync(requestPost, HttpResponse.BodyHandlers.ofString()).thenAccept(resp -> System.out.println("Reply: " +
                resp.statusCode() + " : " + resp.body()));
        }
        catch (Exception e) {
            System.err.println("Can't send the request, Error : " + e);}
    }
}
