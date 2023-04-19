package thread.concurrent.threadPool;

import java.util.concurrent.CompletableFuture;

/**
 * 需要定义的是CompletableFuture完成时和异常时需要回调的实例
 * 完成时，CompletableFuture会调用Consumer对象
 * 异常时，CompletableFuture会调用Function对象
 *
 * 可见CompletableFuture的优点是：
 *  异步任务结束时，会自动回调某个对象的方法；
 *  异步任务出错时，会自动回调某个对象的方法；
 *  主线程设置好回调后，不再关心异步任务的执行。
 *
 * 可以串行执行也可以并行执行
 * ┌─────────────┐ ┌─────────────┐
 * │ Query Code  │ │ Query Code  │
 * │  from sina  │ │  from 163   │
 * └─────────────┘ └─────────────┘
 *        │               │
 *        └───────┬───────┘
 *                ▼
 *         ┌─────────────┐
 *         │    anyOf    │
 *         └─────────────┘
 *                │
 *        ┌───────┴────────┐
 *        ▼                ▼
 * ┌─────────────┐  ┌─────────────┐
 * │ Query Price │  │ Query Price │
 * │  from sina  │  │  from 163   │
 * └─────────────┘  └─────────────┘
 *        │                │
 *        └────────┬───────┘
 *                 ▼
 *          ┌─────────────┐
 *          │    anyOf    │
 *          └─────────────┘
 *                 │
 *                 ▼
 *          ┌─────────────┐
 *          │Display Price│
 *          └─────────────┘
 *
 * CompletableFuture的命名规则：
 * xxx()：表示该方法将继续在已有的线程中执行；
 * xxxAsync()：表示将异步在线程池中执行。
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo::fetchPrice);//这里是一个符合Supplier接口定义的对象
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}
