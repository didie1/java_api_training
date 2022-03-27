package fr.lernejo.navy_battle;

import fr.lernejo.httphandler.HttpServerCreation;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("You have to give a port number to gain access");
        }
        else if (args.length == 2) {
            HttpServerCreation newServer = new HttpServerCreation(Integer.parseInt(args[0]),args[1]);
            newServer.startServer();
        }
        else {
            HttpServerCreation newServer = new HttpServerCreation(Integer.parseInt(args[0]), "");
            newServer.startServer();
        }
    }

}
