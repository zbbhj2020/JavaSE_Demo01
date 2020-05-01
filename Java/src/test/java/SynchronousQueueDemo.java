import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: zbb
 * @create: 2020/5/2 0:28
 */
public class SynchronousQueueDemo
{
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println("线程："+Thread.currentThread().getName() + "\t put 1");
                blockingQueue.put("1");

                System.out.println("线程："+Thread.currentThread().getName() + "\t put 2");
                blockingQueue.put("2");

                System.out.println("线程："+Thread.currentThread().getName() + "\t put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("线程："+ Thread.currentThread().getName() + "\t" + blockingQueue.take());
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("线程："+ Thread.currentThread().getName() + "\t" + blockingQueue.take());
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println("线程："+ Thread.currentThread().getName() + "\t" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

    }
}
