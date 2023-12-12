package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientImpl implements IClient {
    private Context context;
    private Logger logger = LogManager.getLogger();
    private SocketChannel socketChannel;
    private ByteBuffer byteBuffer;

    public ClientImpl(Context context) {
        this.context = context;
    }
    @SuppressWarnings({"checkstyle:EmptyLineSeparator", "checkstyle:MagicNumber"}) @Override
    public void start() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(context.host(), context.socket()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byteBuffer = ByteBuffer.allocate(256);
    }

    @Override
    public void close() {
        try {
            socketChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byteBuffer = null;
    }

    @SuppressWarnings("checkstyle:MagicNumber") @Override
    public String send(String message) {
        byteBuffer = ByteBuffer.allocate(256);
        byteBuffer.limit(256);
        byte[] byteMessage = message.getBytes();
        int iterations = (byteMessage.length + 255) / 256;
        int start = 0;
        String answer = "";
        for (int i = 0; i < iterations; i++) {
            // byteBuffer.put(message.getBytes());
            byte[] array = ArrayUtils.subarray(byteMessage, start, Math.min(start + 256, byteMessage.length));
            byteBuffer.put(array);
            try {
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.flip();
                byteBuffer.clear();
                socketChannel.read(byteBuffer);
                byteBuffer.flip();
                byte[] s = new byte[byteBuffer.limit()];
                byteBuffer.get(0, s, 0, byteBuffer.limit());
                answer = answer.concat(new String(s).trim());
                logger.info(answer);
                start += 256;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return answer;
    }
}
