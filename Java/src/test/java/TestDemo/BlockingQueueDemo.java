package TestDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: zbb
 * @create: 2020/5/1 21:00
 */
public class BlockingQueueDemo
{
    public static void main(String[] args)
    {
        // 创建后，容量无法更改。
        // 方法类型add()、remove()、element()
        // 出现异常：
        //      该阻塞队列满时插入元素会抛出IllegalStateException：Queue full  非法状态异常
        //      该阻塞队列为空时，再移除元素会抛出NoSuchElementException：没有此元素
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("我是队列头"));
        System.out.println(blockingQueue.add("你的"));
        System.out.println(blockingQueue.add("爸爸"));
        System.out.println("==========================");
        System.out.println(blockingQueue.element());
        // queue队列是先进先出原则，
//        blockingQueue.remove();
//        for (String s : blockingQueue) {
//            System.out.println(s);
//        }
    }

}
