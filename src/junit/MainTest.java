package junit;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    void testAdd() {
        assertEquals(11, JunitDemo.add(5, 5),"ddd");

//        assertEquals(11, JunitDemo.add(5, 5));
//        assertEquals(12, JunitDemo.add(5, 5));

    }
}
