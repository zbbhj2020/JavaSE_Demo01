package TestDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo
{
    public static void main(String[] args) {
        // CyclicBarrier(int parties, Runnable barrierAction)
        // 创建一个新的 CyclicBarrier ，当指定数量的线程调用await()方式时，将开启屏障，直到最后一个线程到达屏障时，屏障才会解除，所有被拦截的线程才会继续执行任务。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("*******已集齐7颗龙珠，出来吧，神龙！");
        });

        for (int i = 1; i <= 7; i++)
        {
            final int longzhucount = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 已收集" + longzhucount + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
