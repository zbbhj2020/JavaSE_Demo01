import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: zbb
 * @create: 2020/5/1 22:16
 */
public class BlockingQueueDemo01
{
    public static void main(String[] args) {
        // 方法 offer()、poll()、peek()
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("我是队列头"));
        System.out.println(blockingQueue.offer("你的"));
        System.out.println(blockingQueue.offer("爸爸"));
        System.out.println("==========================");
        System.out.println(blockingQueue.peek());// 检查队列头，但不删除
    }
}
