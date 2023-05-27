package SPI;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 为服务使用者（调用方）提供特定功能
 * 选择一种具体实现
 * 调用者使用这个类，来获取 服务， 这里指定了使用哪个服务实现（代码是选了第0个）
 */
public class Log4jService {
    private static final Log4jService SERVICE = new Log4jService();  // 提供个调用者使用
    private final Log4j log4j; // 服务接口，在new Log4jService的时候，初始化，以及用于调用接口服务
    private final List<Log4j> serviceProviderList; //用于保存所有写在配置文件（META-INF/services）中的所有服务实现

    // 构造器，初始化
    private Log4jService() {
        System.out.println("构建 Log4jService 对象");
        // 服务加载器
        // 会在
        ServiceLoader<Log4j> serviceLoader = ServiceLoader.load(Log4j.class);

        // 收集 服务提供者
        System.out.println("收集 服务提供者");
        List<Log4j> list = new ArrayList<>();
        for (Log4j service : serviceLoader) {
            list.add(service);
            System.out.println(service.getClass());
        }
        serviceProviderList = list;
        System.out.println("服务提供者数量：" + serviceProviderList.size());
        // 指定 具体的 服务提供者
        if (serviceProviderList.size() > 0) {
            log4j = serviceProviderList.get(0);
        } else {
            log4j = null;
        }

    }

    public static Log4jService getService() {
        return SERVICE;
    }

    public void log4j(String msg) {
        if (log4j == null) {
            System.out.println("spiInterface 中没有发现 log4j 服务提供者");
        } else {
            log4j.log4j(msg);
        }

    }

}
