package javaEE;
//todo https://www.liaoxuefeng.com/wiki/1252599548343744/1304265903570978?t=1682563115260
// todo 通过这个可以意会到http的实现思路思想

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 本质上是一个基于TCP连接的服务器
 * 根据http协议，server处理请求的内容
 * 再返回网页数据
 * 然后html可以被浏览器解析
 * 至此构建了BS交互
 */
public class HTTPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("httpServer is running...");
            while (true) {
                Socket accept = serverSocket.accept();
                new RequestHandler(accept).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket accept) {
        this.socket = accept;
    }

    @Override
    public void run() {
        // solve the request and make a response
        boolean requestOK = false;
        try (InputStream inputStream = socket.getInputStream(); OutputStream outputStream = socket.getOutputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

            // 读取request
            String firstLine = reader.readLine();
            if (firstLine.startsWith("GET / HTTP/1.")) {
                // 表示是get方法 并且使用的是http协议
                // 可以请求
                requestOK = true;
            }

            System.out.println(requestOK ? "Response OK" : "Response Error");
            // 读取请求内容，包括header 和 body
            if (requestOK) {
                // 读取 header
                for (; ; ) {
                    String header = reader.readLine();
                    if (header.isEmpty()) { // 读取到空行时, HTTP Header读取完毕
                        break;
                    }
                    System.out.println(header);
                }

                // 发送成功响应:
                String data = "<html><body><h1>Hello, world!</h1></body></html>";
                int length = data.getBytes(StandardCharsets.UTF_8).length;
                writer.write("HTTP/1.0 200 OK\r\n");
                writer.write("Connection: close\r\n");
                writer.write("Content-Type: text/html\r\n");
                writer.write("Content-Length: " + length + "\r\n");
                writer.write("\r\n"); // 空行标识Header和Body的分隔
                writer.write(data);
                writer.flush();

            } else {
                // 请求错误，客户端问题
                // 404
                // 发送错误响应:
                writer.write("HTTP/1.0 404 Not Found\r\n");
                writer.write("Content-Length: 0\r\n");
                writer.write("\r\n");
                writer.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("client disconnected.");
        }
    }
}