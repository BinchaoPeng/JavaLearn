package SPI;

/**
 * 接口的一种具体实现，需要导出成jar包
 *
 */
public class Log4jImplA implements Log4j {
    @Override
    public void log4j(String msg) {
        System.out.println("Log4jImplA: " + msg);
    }


}
