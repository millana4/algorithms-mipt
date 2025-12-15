import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    private static final int PORT = 5050;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(PORT));
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                
                if (key.isAcceptable()) {
                    try {
                        handleAccept(key);
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        }
    }

    private static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel client = server.accept();
        
        // Отправляем сообщение сразу при подключении
        String response = "Hello from the server!";
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes());
        client.write(buffer);
        
        client.close();
    }
}