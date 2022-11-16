package io.serialization;

import java.io.*;

/**
 * 序列化
 * 将 对象或数据结构 写入 文件
 * 就是 输出流
 * 可采用 ObjectOutputStream
 */
public class Serialization {
    public static void main(String[] args) {
        File file = new File("resources/file.txt");
        if (!file.exists()) {
            boolean newFile = false;
            try {
                newFile = file.createNewFile();
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("resources/file.txt"));
                SerialObject serialObject = new SerialObject(1, true);
                output.writeObject(serialObject);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("创建文件：" + newFile);
        }
    }
}
