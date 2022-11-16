package SPI;

/**
 * 这个就是 SPI ， 是 服务提供者接口，后面的服务提供者就要针对这个接口进行实现
 * 要在`resources`下的 `META-INF/services`目录下 进行配置
 * 配置文件名是：接口的全类名
 * 文件内容是：具体实现类的全类名，有多个就分行写，一行一个
 */
public interface Log4j {
    /**
     * 提供 log4j 服务
     *
     * @param msg
     */
    public void log4j(String msg);
}
