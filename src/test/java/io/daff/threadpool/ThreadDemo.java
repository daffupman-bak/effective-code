package io.daff.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池相关
 *
 * @author daffupman
 * @since 2020/2/1
 */
public class ThreadDemo {

    /**
     * 不推荐
     */
    @Test
    public void oldHandle() {
        /*
        模拟多用户请求的场景
         */
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println("文档处理开始...");
                try {
                    Thread.sleep(1000L * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束...");
            }).start();
        }
    }

    /**
     * 推荐做法
     */
    @Test
    public void newHandle() throws InterruptedException {
        /*
        开启一个固定数量的线程池
         */
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(() -> {
                System.out.println("文档处理开始...");
                try {
                    Thread.sleep(1000L * 3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("文档处理结束...");
            });
        }

        Thread.sleep(1000L * 1000);
    }

}
