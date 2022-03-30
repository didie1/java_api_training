package fr.lernejo.httphandler;

public class Interaction {
    public final ClientFire client;
    public Interaction(int port ,String url){
        this.client = new ClientFire(port,url);
    }
    public void shooting(){
        try {
            this.client.shootTarget("B2");
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
