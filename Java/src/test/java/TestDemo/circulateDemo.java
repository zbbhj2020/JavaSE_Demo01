package TestDemo;

/**
 * @author: zbb
 * @create: 2020/5/5 14:17
 */
// 练习for循环使用
public class circulateDemo
{
    // 外层循环管i行数
    // 内层循环管j列数
    public static void main(String[] args)
    {
        // 行:i代表行数，当i是第一行时，j有6列。第一行有6颗星。
        for (int i = 1; i <= 6 ; i++)
        {
            for (int j = 1; j <= 7 - i ; j++)
            {
                System.out.print("*" + " ");
            }
            // 内循环结束之后要换行。换行很重要，千万别丢失。
            System.out.println();
        }
    }
}
