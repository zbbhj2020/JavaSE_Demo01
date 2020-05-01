import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *     public interface ConditionCondition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象
 * 与任意 Lock 实现组合使用，为每个对象提供多个等待 set（wait-set）。其中，Lock 替代了 synchronized 方法和语句的使用，Condition 替
 * 代了 Object 监视器方法的使用。
 *     条件（也称为条件队列 或条件变量）为线程提供了一个含义，以便在某个状态条件现在可能为 true 的另一个线程通知它之前，一直挂起该线程（即让其“等待”）。
 * 因为访问此共享状态信息发生在不同的线程中，所以它必须受保护，因此要将某种形式的锁与该条件相关联。等待提供一个条件的主要属性是：以原子方式 释放相
 * 关的锁，并挂起当前线程，就像 Object.wait 做的那样。
 *     Condition 实例实质上被绑定到一个锁上。要为特定 Lock 实例获得 Condition 实例，请使用其 newCondition() 方法。
 *     作为一个示例，假定有一个绑定的缓冲区，它支持 put 和 take 方法。如果试图在空的缓冲区上执行 take 操作，则在某一个项变得可用之前，线程将一直阻塞；
 * 如果试图在满的缓冲区上执行 put 操作，则在有空间变得可用之前，线程将一直阻塞。我们喜欢在单独的等待 set 中保存 put 线程和 take 线程，这样就可以
 * 在缓冲区中的项或空间变得可用时利用最佳规划，一次只通知一个线程。可以使用两个 Condition 实例来做到这一点。
 */
// 资源类
class ShareData
{
    // 初始值为0的变量
    private int number = 0;
    // 造把锁
    private Lock lock = new ReentrantLock();
    // 注意：condition()是被绑定到Lock上面的，要创建一个Lock的conditon，需要用newCondition。
    // 可以创建多个Condition条件锁。
    private Condition nullZero = lock.newCondition();
    private Condition isZero = lock.newCondition();

    // 增量操作
    public void increment() throws InterruptedException
    {
        // 加锁
        lock.lock();
        try
        {
            // 1、判断
            while (number != 0)
            {
                // 不是0就等待，不能增量
                nullZero.await();
            }
            // 2、可以增量（number+1）
            number++;
            System.out.println(Thread.currentThread().getName() + "\t number+1=" + number);
            // 3、通知唤醒
            nullZero.signalAll();
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            // 释放锁
            lock.unlock();
        }
    }

    // 减量操作
    public void decrement()
    {
        // 加锁
        lock.lock();
        try
        {
            // 1、判断
            while (number == 0)
            {
                // number=0，等待，不能减量
                nullZero.await();
            }
            // 2、生产
            number--;
            System.out.println(Thread.currentThread().getName() + "\t number-1=" + number);
            // 3、通知唤醒
            nullZero.signalAll();
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            // 释放锁
            lock.unlock();
        }
    }

}

/**
 * 题目：一个初始值为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮。
 *
 * 1、线程    操作     资源类
 * 2、判断    干活     通知
 * 3、防止   虚假     唤醒机制
 * 4、高内聚要低耦合
 * 5、多对一时要加锁
 */
public class ProdConsumer_TraditionDemo
{
    public static void main(String[] args)
    {
        ShareData shareData = new ShareData();

        // 生产者
        new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    shareData.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程A").start();

        // 消费者
        new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    shareData.decrement();
                }
        }, "线程B").start();

    }

}
