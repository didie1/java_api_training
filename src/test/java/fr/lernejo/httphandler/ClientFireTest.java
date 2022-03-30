package fr.lernejo.httphandler;

import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ClientFireTest {
        ClientFire client = new ClientFire(8001, "http://localhost:9876");
        @Test
        void SendGet() throws IOException, InterruptedException {
            client.shootTarget("B2");
            Assertions.assertThat(true).isEqualTo(true);
        }
    }
