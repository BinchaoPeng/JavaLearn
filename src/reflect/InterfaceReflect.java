package reflect;

import java.util.ServiceLoader;

public class InterfaceReflect {
    public static void main(String[] args) {
        ServiceLoader<Inter> serviceLoader = ServiceLoader.load(Inter.class);
        for (Inter i : serviceLoader) {
            System.out.println(i.med("hello"));
        }
    }
}
