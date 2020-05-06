package TestDemo;

import java.util.concurrent.TimeUnit;

// 资源类
class HoldLockThread implements Runnable
{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB)
    {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run()
    {
        synchronized(this.lockB)
        {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获取：" + lockA);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (this.lockA)
            {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获取：" + lockB);
            }
        }
    }
}

public class DeadLockDemo
{
    public static void main(String[] args)
    {
        String lockA = "lockA";
        String lockB = "lockB";

        /**
         * 通过带有形参列表的构造器创建实例对象线程A与线程B。
         * 把门将锁当做通行证，线程A的通行证顺序是A锁、B锁；而线程B的通行证是B锁、A锁。
         * 根据synchronized同步锁的规则，一把锁只能由一个线程获得，直到锁被释放为止；
         * 当两个线程调用run()方法，当A线程通过锁B进入同步代码块时，B线程则通过锁B进入同步代码块，由于一把锁对应一个线程，
         * 此时线程A要申请B锁，而线程B要申请A锁，则两个线程同时想要获取对方的锁，这就形成的死锁现象。
         */
        // 线程A
        new Thread(new HoldLockThread(lockA,lockB),"Thread A").start();

        // 线程B
        new Thread(new HoldLockThread(lockB,lockA),"Thread B").start();
    }
}
