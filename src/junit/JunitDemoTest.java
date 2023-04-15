package junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


class JunitDemoTest {
    /**
     * 测试执行顺序
     * beforeAll
     * BeforeEach
     * AfterEach
     * afterAll
     */

    public JunitDemo junitDemo;

    @BeforeEach
    public void beforeEach() {
        junitDemo = new JunitDemo();
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void add() {
        assertEquals(10, JunitDemo.add(5, 5), "ddd");
        System.out.println("add test");
    }

    @Test
    void subject() {
        assertEquals(0, junitDemo.subject(5, 5), "ddd");
        System.out.println("subject test");
    }

    /**
     * 使用 csv文件 存储 测试用例
     * 一行就是一个测试用例
     * @param a
     * @param b
     * @param result
     */
    @ParameterizedTest
    @CsvFileSource(resources = {"./input.csv"})
    void test(int a, int b, int result) {
        assertEquals(result, junitDemo.subject(a, b));
    }
}