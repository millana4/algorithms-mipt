import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) {
        try {
            SocketChannel client = SocketChannel.open();
            client.connect(new InetSocketAddress("localhost", 5050));
            
            // Получаем ответ от сервера
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = client.read(buffer);
            
            if (bytesRead > 0) {
                buffer.flip();
                byte[] bytes = new byte[bytesRead];
                buffer.get(bytes);
                System.out.println(new String(bytes));
            }
            
            client.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}