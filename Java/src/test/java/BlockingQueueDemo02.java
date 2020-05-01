import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: zbb
 * @create: 2020/5/1 22:33
 */
public class BlockingQueueDemo02 {
    public static void main(String[] args) throws InterruptedException {
        // 方法 put()，当队列满了在put插入元素，此时线程会阻塞,一直put，直到移除一个元素再添加进队列。
        // 方法 take(),当队列为空，take()方法会一直执行，造成线程阻塞，直到有元素插入进来，在执行take()方法移除一个元素。编程执行完毕。
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("我是队列头");
        blockingQueue.put("你的");
        blockingQueue.put("爸爸");
        blockingQueue.clear();
        System.out.println("==========================");
        System.out.println(blockingQueue.peek());// 检查队列头，但不删除
    }
}
