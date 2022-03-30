package fr.lernejo.navy_battle;

import org.junit.Test;

import java.io.IOException;

class LauncherTest {
    @Test
    void launch() {
        String[] oneArgument = {"8001"} ;
        try {
            Launcher.main(oneArgument);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        String[] twoArgument = {"8001","http://localhost:9001"};
        try {
            Launcher.main(twoArgument);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
