package io.daff.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author daffupman
 * @since 2020/2/1
 */
public class QueueTest {

    @Test
    public void testArrayBlockingQueue() throws InterruptedException {
        /*
        基于数组的有界阻塞队列
         */
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加元素：" + i);
        }
    }

    @Test
    public void testLinkedBlockingQueue() throws InterruptedException {
        /*
        基于链表的无界阻塞队列（默认大小为Integer的最大值，可视为无界），也可指定大小
         */
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(i);
            System.out.println("向队列中添加元素：" + i);
        }
    }

    @Test
    public void testSynchronousQueue() {
        /*
        同步移交队列，不存储元素，只处理一个元素
         */
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        // 存值
        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("存值成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 取值
        new Thread(() -> {
            try {
                queue.take();
                System.out.println("取值成功");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
