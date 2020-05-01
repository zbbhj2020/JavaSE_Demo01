import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: zbb
 * @create: 2020/5/1 16:23
 */
public class SemaphoreDemo
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(3);
        // 模拟6个老王
        for (int i = 1; i <= 6; i++)
        {
            final int mancount = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("第" + Thread.currentThread().getName() + "号老王 抢进隔壁家的门");
                    try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("第" + Thread.currentThread().getName() + "号老王3分钟后离开隔壁家");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(mancount)).start();
        }
    }
}

