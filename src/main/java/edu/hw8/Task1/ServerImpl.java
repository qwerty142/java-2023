package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SuppressWarnings("checkstyle:LineLength") public class ServerImpl implements IServer {
    private Boolean running = true;
    private Context context;
    private static Map<String, String> storage = new HashMap<>();
    private final ThreadPoolExecutor threadPoolExecutor;

    static {
        storage.put("личности", "Не переходи на личности там, где их нет");
        storage.put("оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами");
        storage.put("глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.");
        storage.put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }

    public ServerImpl(int amountOfUsers, Context context) {
        this.context = context;
        threadPoolExecutor =
            (ThreadPoolExecutor)
                Executors
                    .newFixedThreadPool(
                        Math
                            .min(amountOfUsers,
                                Runtime.getRuntime().availableProcessors()
                            )
                    );
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(context.host(), context.socket()));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            Deque<SelectionKey> used = new ConcurrentLinkedDeque<>();

            running = true;
            while (running) {

                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> it = selected.iterator();
                while (it.hasNext()) {
                    SelectionKey elem = it.next();
                    if (elem.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }

                    if (elem.isReadable() && !used.contains(elem)) {
                        used.add(elem);
                        threadPoolExecutor.execute(() -> {
                            try {
                                send(elem);
                                used.remove(elem);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    }
                    it.remove();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("checkstyle:MagicNumber") private void send(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        int tryResult = channel.read(byteBuffer);

        if (tryResult == -1) {
            channel.close();
        } else {
            byteBuffer.flip();
            String clientMess = new String(byteBuffer.array()).trim();
            String answer = storage.getOrDefault(clientMess, "Fatal");
            byteBuffer.clear();
            byteBuffer.put(answer.getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        }

    }
}
