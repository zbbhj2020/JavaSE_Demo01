package ProjectDemo01;

import java.util.Scanner;

/**
 * @author: zbb
 * @create: 2020/5/5 19:20
 */
// Utility:公用程序
public class Utility
{
    // 获取键盘输入信息。
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 读取键盘输入的字符：获取enter回车键之前的所有没被读取的所有字符
     */
    // 这是一个获取键盘输入字符的方法。
    private static String readKeyBoard(int limit)
    {
        String line = "";
        // 如果键盘能获取到下一个输入
        while(scanner.hasNext())
        {
            // 获取下一行的所有输入字符
            line = scanner.nextLine();
            // 如果输入字符的长度小于1或者输入字符的长度大于限制行数
            if (line.length() < 1 || line.length() > limit)
            {
                // 提示错误
                System.out.println("输入错误，输入值不在范围内，请重新输入：");
                // 跳过循环，进入下一个循环。
                continue;
            }
            // 如果输入正确则停止循环。
            break;
        }
        // 返回输入的正确字符。
        return line;
    }

    /**
     用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection()
    {
        char c;
        for (;;)
        {
            // 获取输入的1位字符
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c !='3' && c != '4')
            {
                System.out.println("输入错误！请重新输入：");
            }
            else break;
        }
        return c;
    }

    /**
     用于收入和支出金额的输入。该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值。
     */
    public static int readNumber()
    {
        int num;
        for (;;)
        {
            // 获取输入的4位字符
            String str = readKeyBoard(4);
            // 将字符串参数解析为带符号的十进制整数（-负整数或者+正整数）。
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入：");;
            }
        }
        return num;
    }
    public static int readNumber2()
    {
        int num;
        for (;;)
        {
            // 获取输入的4位字符
            String str = readKeyBoard(8);
            // 将字符串参数解析为带符号的十进制整数（-负整数或者+正整数）。
            try {
                num = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入错误，请重新输入：");;
            }
        }
        return num;
    }

    /**
     用于收入和支出说明的输入。该方法从键盘读取一个不超过8位长度的字符串，并将其作为方法的返回值。
     */
    public static String readString()
    {
        String str = readKeyBoard(8);
        return str;
    }

    /**
     用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection()
    {
        char c;
        for (;;)
        {
            // 获取转化为大写的一个字符
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N')
            {
                break;
            }else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}
