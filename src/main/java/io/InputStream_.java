package io;

import javax.xml.stream.events.Characters;
import java.io.*;
import java.util.Arrays;

public class InputStream_ {
    /***
     * 从 工程 根目录算起
     * @param args
     */
    public static void main(String[] args) {
        // try-with-resources
        try (InputStream inputStream = new FileInputStream("resources/input.txt");) {
            System.out.println("字节输入流  基本信息");
            int length = inputStream.available();
            System.out.println("Number of remaining bytes:" + length);

            System.out.println("使用byte数组获取！！！");
            byte[] bytes = new byte[100];
            int read = inputStream.read(bytes); // 返回读取的字节数

            System.out.println("读取的字节数: " + read);
            System.out.println(Arrays.toString(bytes));
            System.out.println(new String(Arrays.copyOf(bytes, length))); //会自动转换

            System.out.println("循环读取");
            int b;
            while ((b = inputStream.read()) != -1) {
                System.out.println((char) b);
            }

            System.out.println("缓冲字节输入流");
            InputStream inputStream1 = new FileInputStream("resources/input.txt"); // 需要重新读，不然为0
            BufferedInputStream bis = new BufferedInputStream(inputStream1);
            System.out.println("字节长度：" + bis.available());
            byte[] bytes1 = new byte[bis.available()];
            int read1 = bis.read(bytes1);
            System.out.println(new String(bytes1));

            System.out.println("数据字节输入流");
            DataInputStream dis = new DataInputStream(new FileInputStream("resources/input.txt"));
//            System.out.println(dis.readUTF());
            while (dis.read() != -1) {
//                System.out.println(dis.readChar());
                System.out.print((char) dis.readByte()+" ");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
