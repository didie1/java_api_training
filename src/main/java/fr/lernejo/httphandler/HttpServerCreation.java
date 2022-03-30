package fr.lernejo.httphandler;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.*;


public class HttpServerCreation {
    private final HttpServer server;
    public HttpServerCreation(int port, String address) throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        this.server.setExecutor(executorService);
        HttpContext context = server.createContext("/ping", new Ping());
        HttpContext contextGame = server.createContext("/api/game/start", new Post(port));
        HttpContext contextFire = server.createContext("/api/game/start", new Fire(port,"J1"));
    }
    public void startServer(){
        this.server.start();
    }
}
