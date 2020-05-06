package TestDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// 资源类
class ShareResource
{
    // 标志位：默认值为true,进行生产+消费，volatile保证该变量的可见性；但不保证原子性；
    private volatile boolean FLAG = true;
    // 使用并发工具包JUI中的AtomicInteger原子值，默认为0，保证标志位的原子性。
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 阻塞队列的使用方式,保证扩展性、适配性、声明时不能固定写死，让只有的操作更有余地。
    BlockingQueue<String> blockingQueue = null;

    // 作为阻塞队列的接口的构造器。创建实例对象时，可以任意实现7个阻塞队列的实例。
    public ShareResource(BlockingQueue<String> blockingQueue)
    {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    // 生产者
    public void myProd() throws InterruptedException
    {
        String data = null;// 记住一句话：代码复用，代码复用，代码复用；
        boolean retValue = false;// 默认为false，可以写成：boolean retValue;
        while(FLAG)
        {
            // 表示原子值的i++；因为阻塞队列泛型是String类型，原子值可以加一个空串组合成String类型的值
            data = atomicInteger.incrementAndGet() + "";
            // 获得插入数据的返回的boolean值
            retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            // 判断：如果为true，输出插入队列成功，如果不为true，则插入队列失败。
            if (retValue)
            {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "：成功(＾－＾)V");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "：失败o(╥﹏╥)o");
            }
            // 自定义生产时间：1秒钟
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        System.out.println(Thread.currentThread().getName() + "\t 厨房起火了，别干了 ，快跑啊[○･｀Д´･ ○]");
    }

    // 消费者
    public void myConsumer() throws InterruptedException
    {
        String result = null;// 记住一句话：代码复用，代码复用，代码复用；
        while (FLAG)
        {
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);// 表示线程当代两秒后不再poll()。
            // equalsIgnoreCase()：作用一般是用来比较两个字符串是否相同，且不区分大小写。equals()：区分大小写
            // 判断：如果结果值为空，且与指定字符串的长度相同。
            if (result == null || result.equalsIgnoreCase(""))
            {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒钟没有完成消费，消费者退出！(╯‵□′)╯︵┻━┻");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + ":成功(＾－＾)V");
        }
    }

    public void stop()
    {
        this.FLAG = false;
    }
}

/**
 * volatile/CAS/atomicInteger/BlockingQueue/线程交互
 *
 *
 */
// 线程操作资源类
public class ProdConsumer_BlockingQueueDemo
{
    public static void main(String[] args)
    {
        // 线程调用资源
        ShareResource shareResource = new ShareResource(new ArrayBlockingQueue<>(10));
        // 生产者线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 面包店开门了");
            try {
                shareResource.myProd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "生产者").start();
        // 消费者线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 顾客进面包店了");
            System.out.println();
            System.out.println();
            try {
                shareResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "消费者").start();

        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，大老板main线程把天然气搞炸了。。。(～￣(OO)￣)ブ");

        shareResource.stop();
    }
}
