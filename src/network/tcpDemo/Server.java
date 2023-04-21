package network.tcpDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 指定socket，也就是ip和port
 * 使用socket的输入输出流获取和响应信息
 * 使用socket的accept方法，与客户端建立连接
 * 使用socket的close方法，与客户端断开连接
 * 可以使用线程池复用线程
 */
public class Server {
    // 服务端启动入口
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server is running...");
            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println("Server: one client connected!================================================");
                Thread thread = new Task(accept);
                thread.start();
            }
        } catch (IOException e) {

        }
    }
}

/**
 * 服务器端 提供的 一个服务（task）
 */
class Task extends Thread {
    private Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 具体的服务逻辑
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                socketInfo();
                repeatMsg(inputStream, outputStream);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ex) {
                System.out.println("Server: socket close exception!");
            }
            System.out.println("Server: client disconnected!=================================================");
        }
    }

    private void socketInfo() {
        // the remote IP address to which this socket is connected,
        // or null if the socket is not connected.
        System.out.println("the remote IP address: " + socket.getInetAddress());
        // the local address to which the socket is bound,
        // the loopback address if denied by the security manager,
        // or the wildcard address if the socket is closed or not bound yet.
        System.out.println("the local address: " + socket.getLocalAddress());
        // a SocketAddress representing the local endpoint of this socket,
        // or a SocketAddress representing the loopback address if denied by the security manager,
        // or null if the socket is not bound yet.
        System.out.println("LocalSocketAddress: " + socket.getLocalSocketAddress());
        // a SocketAddress representing the remote endpoint of this socket,
        // or null if it is not connected yet.
        System.out.println("RemoteSocketAddress: " + socket.getRemoteSocketAddress());
    }

    public void repeatMsg(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        writer.write("hello, welcome to server, I will repeat your words until you say end.\n");
        writer.flush();
        while (true) {
            String msg = reader.readLine();
            System.out.println("Server received the msg: " + msg);
            if ("end".equals(msg)) {
                writer.write("the repeat service is closed, thanks for your use!\n");
                writer.flush();
                break;
            }
            writer.write("Server received the msg: " + msg + "\n");
            writer.flush();
        }

    }
}