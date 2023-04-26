package network.rmi.local;


import network.rmi.WorldClock;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

/**
 * Java的RMI严重依赖序列化和反序列化，而这种情况下可能会造成严重的安全漏洞，
 * 因为Java的序列化和反序列化不但涉及到数据，还涉及到二进制的字节码，
 * 即使使用白名单机制也很难保证100%排除恶意构造的字节码。
 * 因此，使用RMI时，双方必须是内网互相信任的机器，不要把1099端口暴露在公网上作为对外服务。
 */
public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // 连接到服务器localhost，端口1099:
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        // 查找名称为"WorldClock"的服务并强制转型为WorldClock接口:
        /**
         * WorldClock 的 classpath要一致
         */
        WorldClock worldClock = (WorldClock) registry.lookup("WorldClock");
        // 正常调用接口方法:
        LocalDateTime now = worldClock.getLocalDateTime("Asia/Shanghai");
        // 打印调用结果:
        System.out.println(now);
    }
}
