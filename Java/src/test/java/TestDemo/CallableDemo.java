package TestDemo;

import java.util.concurrent.Callable;

class MyThread implements Runnable
{
    // 重写Runnable接口的run()方法，相当于执行体
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer>
{
    // 重写Runnable接口的call()方法，相当于执行体
    @Override
    public Integer call() throws Exception {
        return null;
    }
}

public class CallableDemo
{
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
