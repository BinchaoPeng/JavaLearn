package SPI;

public class Caller{
    public static void main(String[] args) {
        Log4jService service = Log4jService.getService();
        service.log4j("hello SPI!");
    }
}
