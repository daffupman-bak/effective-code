package io.daff.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author daffupman
 * @since 2020/2/1
 */
public class RunTest {

    @Test
    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<Integer> result = threadPool.submit(() -> {
            // 这里是在Callable接口下，Callable可以抛异常，返回值
            Thread.sleep(1000L * 10);
            return 2 * 5;
        });
        // Future#get是一个阻塞方法，直到获取结果才能往下执行
        System.out.println(result.get());
    }

    @Test
    public void testExecute() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(() -> {
            // 这里是在Runnable接口下，Runnable接口不能抛出异常，所以需要try-catch
            try {
                Thread.sleep(1000L * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = 2 * 5;
            System.out.println("执行结果：" + num);
        });
    }
}
