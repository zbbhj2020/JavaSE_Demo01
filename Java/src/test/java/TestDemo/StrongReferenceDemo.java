package TestDemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author: zbb
 * @create: 2020/5/4 0:14
 */
public class StrongReferenceDemo
{
    public static void main(String[] args) {
//        Object obj1 = new Object();
//        Object obj2 = obj1;
//        System.out.println(obj1);
//        System.out.println(obj1 == obj2);
//        obj1 = null;
//        System.gc();
//        System.out.println(obj2);

//        Object obj3 = new Object();
//        SoftReference<Object> softReference = new SoftReference<>(obj3);
//        System.out.println(obj3);
//        System.out.println(softReference);
//        System.out.println(obj3 == softReference.get());

//        Object obj4 = new Object();
//        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
//        // WeakReference(T referent, ReferenceQueue<? super T> q)
//        // 参数一：指向对象obj4，参数二：指定引用队列
//        WeakReference<Object> weakReference = new WeakReference<>(obj4,referenceQueue);
//
//        System.out.println(obj4);// java.lang.Object@511d50c0
//        System.out.println(weakReference.get()); // java.lang.Object@511d50c0
//        System.out.println(referenceQueue.poll());// 队列取出用poll()；null
//
//        System.out.println("===========================");
//        // 当弱引用被回收时，会被放进队列中。
//        // 1、先回收弱引用。
//        obj4 = null;
//        // 指向对象obj4被回收，由于弱引用机制，weakReference弱引用对象会在被回收之前放入引用队列【需要定义回收线程的响应时间】。
//        System.gc();
//        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
//        // 2、再查看引用队列中是否存在该弱引用对象。
//        System.out.println(obj4);// null
//        System.out.println(weakReference.get()); // null
//        System.out.println(referenceQueue.poll());// java.lang.ref.WeakReference@60e53b93

        Object obj5 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj5,referenceQueue);
        System.out.println(obj5);// java.lang.Object@511d50c0
        System.out.println(phantomReference.get()); // 虚引用调用get()方法返回的是null。不能被取得。
        System.out.println(referenceQueue.poll());// 队列取出用poll()；null

        System.out.println("===========================");
        // 当弱引用被回收时，会被放进队列中。
        // 1、先回收弱引用。
        obj5 = null;
        // 指向对象obj5被回收，由于虚引用机制，weakReference弱引用对象会在被回收之前放入引用队列。
        System.gc();
        // 虚引用被回收前自动进入引用队列。
        // 2、再查看引用队列中是否存在该弱引用对象。
        System.out.println(obj5);// null
        System.out.println(phantomReference.get()); // null
        System.out.println(referenceQueue.poll());// java.lang.ref.PhantomReference@60e53b93
    }
}
