package collectionPractices;

import java.util.*;

public class HashTest {
    public static void main(String[] args) {
        int hash = Objects.hash(new String[]{"a", "b"});
        System.out.println(hash);
        Map m = new HashMap<String, String>();
        m.put(null, null);
        Object o = m.get(null);
        System.out.println(o);

    }
}
