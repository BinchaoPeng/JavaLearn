package map;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Properties_ {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        // 不能放 null 的 key-value
        properties.put("name", "root");
        properties.put("psw", "AA123456");
        Set<Map.Entry<Object, Object>> set = properties.entrySet();

        for (Object e :
                set) {
            Map.Entry entry = (Map.Entry) e;
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // 以src为根目录
        OutputStream stream = new FileOutputStream("./test.properties");
        properties.store(stream,"comments");

    }
}
