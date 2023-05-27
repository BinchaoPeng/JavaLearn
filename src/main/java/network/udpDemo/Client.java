package network.udpDemo;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 接收的时候，好像复用不了数据包对象，他的getLength不会自动更新
 * <p>
 * 在客户端发送数据包之前，数据包是没有记录getAddress和getAddress的
 * 只有DatagramSocket ds中才包含此类信息
 */
public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            // 意思是后续接收UDP包时，等待时间最多不会超过5秒，否则在没有收到UDP包时，客户端会无限等待下去。
            // 这一点和服务器端不一样，服务器端可以无限等待，因为它本来就被设计成长时间运行。
            ds.setSoTimeout(5000);
            // connect
            ds.connect(InetAddress.getByName("127.0.0.1"), 6666);

            Scanner scanner = new Scanner(System.in);
            String s;
            do {
                // send to server
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                s = scanner.nextLine();
                datagramPacket.setData(s.getBytes(StandardCharsets.UTF_8));
                printDatagramInfo(datagramPacket);
                ds.send(datagramPacket);

                // receive from server
                System.out.println("server info: " + ds.getRemoteSocketAddress());
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                ds.receive(dp);
                System.out.println("receive from server: " + new String(dp.getData(), dp.getOffset(), dp.getLength()));
            } while (!"end".equals(s));
            ds.disconnect();
            System.out.println("client is closed!");
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printDatagramInfo(DatagramPacket datagramPacket) {
        if (datagramPacket != null) {
            System.out.println("getAddress: " + datagramPacket.getAddress());
            System.out.println("getPort: " + datagramPacket.getAddress());
            // 在客户端发送数据包之前，数据包是没有记录getAddress和getAddress的
            // 只有ds中才包含此类信息
//            System.out.println("getSocketAddress: " + datagramPacket.getSocketAddress());
            System.out.println("getData: " + Arrays.toString(datagramPacket.getData()));
            System.out.println("getLength: " + datagramPacket.getLength());
            System.out.println("getOffset: " + datagramPacket.getOffset());
        }
    }
}
