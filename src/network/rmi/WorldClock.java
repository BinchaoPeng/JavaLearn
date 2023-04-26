package network.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

/**
 * Java的RMI远程调用是指，一个JVM中的代码可以通过网络实现远程调用另一个JVM的某个方法。
 * RMI是Remote Method Invocation的缩写。
 */
public interface WorldClock extends Remote {
    // Java的RMI规定此接口必须派生自java.rmi.Remote，并在每个方法声明抛出RemoteException
    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
}
