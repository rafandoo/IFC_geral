import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class servidor {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(5000)) {
            while (true) {
                Socket socket = server.accept();
                Scanner entrada = new Scanner(socket.getInputStream());
                try (PrintWriter w = new PrintWriter(socket.getOutputStream())) {
                    w.println("Servidor: teste de transmissão!");
                }
                while (entrada.hasNextLine()) {
                    System.out.println(entrada.nextLine());
                }
            }
        }
     }    
}
