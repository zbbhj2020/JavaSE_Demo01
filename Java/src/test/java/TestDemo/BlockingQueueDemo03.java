package TestDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: zbb
 * @create: 2020/5/1 22:46
 */
public class BlockingQueueDemo03
{
    public static void main(String[] args) throws InterruptedException {
        // 方法offer(E e, long timeout, TimeUnit unit):当队列满时，队列会阻塞生产者线程2秒，超过2秒后生产者线程则会退出不再向队列中offer()元素。
        // 方法poll(long timeout, TimeUnit unit) 当队列为空时，队列会阻止消费者线程2秒，超过2秒后消费者线程会退出不再从队列中take()元素。
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("我是队列头", 2L, TimeUnit.SECONDS) ;
        blockingQueue.offer("你的",2L, TimeUnit.SECONDS);
        blockingQueue.offer("爸爸",2L, TimeUnit.SECONDS);
//        blockingQueue.offer("的朋友",2L, TimeUnit.SECONDS);;
        System.out.println("==========================");
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll(2L,TimeUnit.SECONDS);
        System.out.println("==========================");
//        System.out.println(blockingQueue.peek());// 检查队列头，但不删除
    }
}
