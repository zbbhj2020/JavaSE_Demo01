/**
 * @author: zbb
 * @create: 2020/5/5 16:15
 */
public class chuanzhi01
{
    public static void main(String[] args) {
        int m = 10;
        int n = 20;
        System.out.println("m"+ m +"----" + "n" + n);

        chuanzhi01 c1 = new chuanzhi01();
        c1.swap(50 , 80);
        System.out.println("m"+ m +"----" + "n" + n);
    }

    public void swap(int m , int n)
    {
        int a = m;
        m = n;
        n = a;
    }
}
