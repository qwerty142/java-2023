package edu.hw8;

import edu.hw8.Task1.ClientImpl;
import edu.hw8.Task1.Context;
import edu.hw8.Task1.ServerImpl;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    private final Context context = new Context("localhost", 5556);
    @Test
    public void checkAbilityToWorkServer() throws InterruptedException {
        ServerImpl server = new ServerImpl(4, context);
        new Thread(server, "check").start();
        Thread.sleep(1000);
        for(int i = 0; i < 3; i++) {
            Thread client = new Thread(() -> {
                ClientImpl client1 = new ClientImpl(context);
                String result = client1.send("личности");
            });
            client.start();
        }
        server.stop();
    }

    @Test
    public void checkOutResult() throws InterruptedException {
        ServerImpl server = new ServerImpl(4, context);
        new Thread(server, "check").start();
        Thread.sleep(3000);
        ClientImpl client = new ClientImpl(context);
        client.start();

        String m1 = "личности";
        String r1 = client.send(m1);
        String m2 = "оскорбления";
        String r2 = client.send(m2);
        String m3 = "глупый";
        String r3 = client.send(m3);
        String m4 = "интеллект";
        String r4 = client.send(m4);
        server.stop();
        client.close();
        assertThat(r1).isEqualTo("Не переходи на личности там, где их нет");
        assertThat(r2).isEqualTo("Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        assertThat(r3).isEqualTo("А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        assertThat(r4).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
    }
}
