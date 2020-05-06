package TestDemo;

import java.util.Random;


/**
 * @author: zbb
 * @create: 2020/5/4 18:53
 */
// 工作中请勿使用该代码，用使用请用自己的电脑测试
// 通过设置JVM参数，该代码运行会出现的各种OOM错误。
public class GCDemo
{
    public static void main(String[] args)
    {
        System.out.println("*************GCDemo hello");

        try
        {
            String str = "ABCDE";
            while(true)
            {
                str += str + new Random().nextInt(111111) + new Random().nextInt(22222);
                str.intern();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
