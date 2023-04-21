package network.tcpDemo;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Client {
    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    private void sendMsg(InputStream inputStream, OutputStream outputStream) {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String re = reader.readLine();
                System.out.println("服务器回复：" + re);
                System.out.print("input your msg: ");
                String msg = scanner.nextLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void run() {
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                System.out.println("连接上了服务器！");
                sendMsg(inputStream, outputStream);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Client: socket close exception!");
            }
            System.out.println("Client: client disconnected!");
        }
    }


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        Client client = new Client(socket);
        client.run();

    }
}