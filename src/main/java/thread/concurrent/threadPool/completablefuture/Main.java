package thread.concurrent.threadPool.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 * <p>
 * * 可以串行执行也可以并行执行
 * * ┌─────────────┐ ┌─────────────┐
 * * │ Query Code  │ │ Query Code  │
 * * │  from sina  │ │  from 163   │
 * * └─────────────┘ └─────────────┘
 * *        │               │
 * *        └───────┬───────┘
 * *                ▼
 * *         ┌─────────────┐
 * *         │    anyOf    │
 * *         └─────────────┘
 * *                │
 * *        ┌───────┴────────┐
 * *        ▼                ▼
 * * ┌─────────────┐  ┌─────────────┐
 * * │ Query Price │  │ Query Price │
 * * │  from sina  │  │  from 163   │
 * * └─────────────┘  └─────────────┘
 * *        │                │
 * *        └────────┬───────┘
 * *                 ▼
 * *          ┌─────────────┐
 * *          │    anyOf    │
 * *          └─────────────┘
 * *                 │
 * *                 ▼
 * *          ┌─────────────┐
 * *          │Display Price│
 * *          └─────────────┘
 * 除了anyOf()可以实现“任意个CompletableFuture只要一个成功”，allOf()可以实现“所有CompletableFuture都必须成功”，这些组合操作可以实现非常复杂的【异步流程控制】。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}
