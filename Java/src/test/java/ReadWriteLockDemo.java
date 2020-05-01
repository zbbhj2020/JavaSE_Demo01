import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: zbb
 * @create: 2020/5/1 11:26
 */
// 自动以资源类，模拟缓存
class myCache {
    // 创建缓存容器对象
    private volatile HashMap<String, Object> ms = new HashMap<>();

    // 创建读写锁对象
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // 写数据
    public void put(String key, Object value)
    {
        // 写锁加锁
        rwLock.writeLock().lock();
        // 临界区代码块
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ms.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：");
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            // 释放写锁
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        rwLock.readLock().lock();
        try
        {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：");
            ms.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：");
        }catch( Exception e) {
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
    // 读写之后切记清除缓存
    public void clearMap()
    {
        ms.clear();
    }

}

// 线程操作资源类
public class ReadWriteLockDemo
{
    public static void main(String[] args)
    {
        myCache myCache = new myCache();
        // 5个线程，每个线程写一次
        for (int i = 1; i <= 5; i++)
        {
            final int threadCount = i;
            new Thread(() -> {
                myCache.put(threadCount + "", threadCount + "");
            }, String.valueOf(i)).start();
        }

        // 5个线程，每个线程各读一次
        for (int i = 1; i <= 5; i++)
        {
            final int threadCount = i;
            new Thread(() -> {
                myCache.get(threadCount + "");
            }, String.valueOf(i)).start();
        }

        myCache.clearMap();
    }

}
