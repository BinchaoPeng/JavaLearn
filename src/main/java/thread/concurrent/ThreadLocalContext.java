package thread.concurrent;

/**
 * 对于【上下文】的一个通俗理解：
 * 这种在一个线程中，横跨若干方法调用，需要传递的对象，我们通常称之为上下文（Context），它是一种状态，可以是用户身份、任务信息等。
 * <p>
 * ThreadLocal表示线程的“局部变量”，它确保每个线程的ThreadLocal变量都是各自独立的；
 * ThreadLocal适合在一个线程的处理流程中保持上下文（避免了同一参数在所有方法中传递）；
 * 使用ThreadLocal要用try ... finally结构，并在finally中清除。
 */

class User {
    private String name;
    private String sex;
    private int age;

    public User(String name) {
        this.name = name;
        this.age = (int) (Math.random() * 100 + 10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

public class ThreadLocalContext {
    static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public void login() {
        User user = threadLocal.get();
        System.out.println(user.toString() + " logging! " + Thread.currentThread().getName());
    }

    public void doTask() {
        User user = threadLocal.get();
        System.out.println(user.toString() + " doing! " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        String[] names = new String[]{"Jack", "Bob", "Jim", "Bim", "HH", "Keven", "Ke", "JJ", "Ris", "Ren", "Ket"};
        ThreadLocalContext demo = new ThreadLocalContext();
//        ThreadLocal<User> threadLocal = new ThreadLocal<>(); 这样就会报错
        ThreadLocal<User> threadLocal = ThreadLocalContext.threadLocal; // 必须使用类里面的那个静态实例

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread() {
                @Override
                public void run() {
                    /**
                     * 保证了上下文的一致性
                     */
                    threadLocal.set(new User(names[finalI]));
                    demo.login();
                    demo.doTask();
                    threadLocal.remove();
                }
            }.start();
        }
    }
}
