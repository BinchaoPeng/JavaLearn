package designPatterns;

import designPatterns.singleton.SingletonPatterns;

public class Main {
    public static void main(String[] args) {
//        SingletonPatterns singletonPatterns = new SingletonPatterns();   // 会报错
        SingletonPatterns instance = SingletonPatterns.getInstance();
        instance.fun("hello singleton!");

    }



}