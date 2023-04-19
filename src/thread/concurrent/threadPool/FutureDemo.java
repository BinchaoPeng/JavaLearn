package thread.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * Runnable接口没有返回值，只能在实现类中使用字段记录，并需要配套对应的获取方法，不方便
 * Callable接口有返回值，返回一个Future对象，两者都是带泛型的
 * 返回的Future结果可能会阻塞，因为尚未获得线程执行完毕的结果
 * 这样就可以在线程间通信，交互信息
 */

class Task implements Callable<String> {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        String re;
        try {
            long time = (long) (Math.random() * 3000 + 1000);
            Thread.sleep(time);
            System.out.println(re = "Task_" + this.name + " " + time + "ms");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return re;
    }
}

public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            try {
                Future<String> submit = service.submit(new Task("" + i));
                Thread.sleep(2000);
                if (submit.isDone()) {
                    System.out.println("Future result Done: " + submit.get());
                }else {
                    /**
                     * 这个方法抛出异常后，后续代码会无法执行
                     */
                    System.out.println("Future result wait: " + submit.get(1, TimeUnit.SECONDS));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
