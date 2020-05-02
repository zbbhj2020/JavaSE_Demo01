import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间按顺序调用，实现A->B->C三个线程启动
 * AA打印5次，BB打印10次，CC打印15次
 * 紧接着
 * AA打印5次，BB打印10次，CC打印15
 * ...
 * 再来10轮
 */
class ShareDataOne // 资源类
{
    private int number = 1;// A:1 B:2 C:3
    private Lock lock = new ReentrantLock();// 造把锁
    // 使用方式：条件锁对象c1在print5()方法中执行，说明c1条件锁是针对A线程的，标志位不正确，则c1.await()：A线程等待;
    // 标志位正确，则执行完操作更改为B线程标志位后通知B线程，唤醒B线程，则由针对B线程的c2条件锁执行c2.signal()。
    private Condition c1 = lock.newCondition();
    // 条件锁c2在print10()方法中执行，说明c2条件锁是针对B线程的，标志位不正确，则c2.await()：B线程等待;
    // 标志位正确，则执行完操作更改为C线程标志位后通知C线程，唤醒C线程，则由针对C线程的c3条件锁执行c3.signal()。
    private Condition c2 = lock.newCondition();
    // 条件锁c3在print15()方法中执行，说明c3条件锁是针对C线程的，标志位不正确，则c3.await()：C线程等待;
    // 标志位正确，则执行完操作更改为A线程标志位后通知A线程，唤醒A线程，则由针对A线程的c1条件锁执行c1.signal()。
    private Condition c3 = lock.newCondition();

    public void print5()
    {
        lock.lock();
        try
        {
            while(number != 1)  // 1、判断
            {
                // 等待
                c1.await();
            }
            // 2、干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "号线程打印\t" + i);
            }
            number = 2; // 标志位
            c2.signal();// 3、通知B
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10()
    {
        lock.lock();
        try
        {
            while(number != 2)  // 1、判断
            {
                // 等待
                c2.await();
            }
            // 2、干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "号线程打印\t" + i);
            }
            number = 3; // 标志位
            c3.signal();// 3、通知C
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15()
    {
        lock.lock();
        try
        {
            while(number != 3)  // 1、判断
            {
                // 等待
                c3.await();
            }
            // 2、干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "号线程打印\t" + i);
            }
            number = 1; // 标志位
            c1.signal();// 3、通知A
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
public class SynAndReentrantLockDemo
{
    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareDataOne.print5();
            }
        }, "Thread A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareDataOne.print10();
            }
        }, "Thread B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareDataOne.print15();
            }
        }, "Thread C").start();
    }
}
