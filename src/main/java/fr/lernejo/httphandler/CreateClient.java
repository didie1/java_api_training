package fr.lernejo.httphandler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateClient {
    private final int port;

    public CreateClient(int portNumber){
        this.port = portNumber;
    }
    public void requestPost(String url) throws IOException, InterruptedException {
         String inputJson = "{ \"id\":\"\"" + this.port + "\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"I will crush you\" }";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + "/api/game/start"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(inputJson))
            .build();
        HttpClient client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
