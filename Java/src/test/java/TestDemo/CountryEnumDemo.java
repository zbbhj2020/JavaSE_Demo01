package TestDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: zbb
 * @create: 2020/5/1 14:27
 */
public class CountryEnumDemo
{
    public static void main(String[] args) throws InterruptedException
    {
        // new一个倒数计数器
        CountDownLatch countDownLatch = new CountDownLatch(CountryEnum.values().length);

        // 循环遍历i=6次
        for (int i = 1; i <= CountryEnum.values().length; i++)
        {
            // new 6个线程
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦帝国，一统华夏！！！");
    }
}
