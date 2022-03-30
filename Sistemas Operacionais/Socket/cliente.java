import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class cliente {   
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5000);

        try (Scanner scanner = new Scanner(socket.getInputStream())) {
            System.out.println("Cliente : recebendo mensagem\n" + scanner.nextLine());
        }
        socket.close();
    }
}