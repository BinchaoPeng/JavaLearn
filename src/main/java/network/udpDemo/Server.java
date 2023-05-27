package network.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 注意点：每次接收和发送数据包，应该是新new的，否则会复用getLength和getOffset,导致信息可能不完全，或者就更新这个数据
 */
public class Server {
    public static void main(String[] args) {
        try (DatagramSocket ds = new DatagramSocket(6666)) {

            while (true) {
                System.out.println("udp server is running, port is " + ds.getLocalSocketAddress());
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                // receive
                ds.receive(datagramPacket);
                // data from receiving
                printDatagramInfo(datagramPacket);
                String msg = new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), StandardCharsets.UTF_8);
                // ds.getRemoteSocketAddress() 返回的是 null
                // 应该用数据包，数据包里包含客户端信息
                System.out.println("msg from " + datagramPacket.getSocketAddress() + ": " + msg);

                // reply(send)，这里应该新建一个数据包，否则会复用getLength和getOffset,或者就更新这个数据
                byte[] bytes1 = ("Server reply: " + msg).getBytes(StandardCharsets.UTF_8);
                datagramPacket.setData(bytes1);
                datagramPacket.setLength(bytes1.length);
                // data to send
                printDatagramInfo(datagramPacket);
//                Thread.sleep(10000);  // 用于测试客户端接收超时
                ds.send(datagramPacket);
                System.out.println("\n");
            }

        } catch (SocketException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }


    }

    private static void printDatagramInfo(DatagramPacket datagramPacket) {
        if (datagramPacket != null) {
            System.out.println("getAddress: " + datagramPacket.getAddress());
            System.out.println("getPort: " + datagramPacket.getPort());
            System.out.println("getSocketAddress: " + datagramPacket.getSocketAddress());
            System.out.println("getData: " + Arrays.toString(datagramPacket.getData()));
            System.out.println("getLength: " + datagramPacket.getLength());
            System.out.println("getOffset: " + datagramPacket.getOffset());
        }
    }
}
