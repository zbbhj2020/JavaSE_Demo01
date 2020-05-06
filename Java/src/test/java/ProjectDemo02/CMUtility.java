package ProjectDemo02;
import java.util.*;

/**
 CMUtility工具类：
 将不同的功能封装为方法，就是可以直接通过调用方法使用它的功能，而无需考虑具体的功能实现细节。
 */
public class CMUtility
{
    // 得到获取键盘输入功能的扫描器对象
    private static Scanner scanner = new Scanner(System.in);

    // 获取键盘输入
    private static String readKeyBoard(int limit, boolean blankReturn)
    {
        // 声明接收行输入的变量
        String line = "";
        // 如果有一下行输入则进入循环
        while (scanner.hasNextLine()) {
            // 获取下一行输入
            line = scanner.nextLine();
            // 如果输入长度等于0
            if (line.length() == 0) {
                //
                if (blankReturn)
                {
                    return line;
                }
                else continue;
            }
            // 如果下一行输入小于1 或者 >限制长度，则提示错误信息，跳过此次循环进入下一次循环
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
    /**
     用于界面菜单的选择。该方法读取键盘，如果用户键入’1’-’5’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection()
    {
        // 声明接收输入信息的字符变量
        char c;
        for (; ; ) {
            // 获取键盘输入字符
            String str = readKeyBoard(1, false);
            // 获取输入字符数组的索引值为0的值。
            c = str.charAt(0);
            // 如果c不等于1-5，返回错误信息提示并进入下一次循环。
            if (c != '1' && c != '2' &&
                    c != '3' && c != '4' && c != '5') {
                System.out.print("选择错误，请重新输入：");
            } else break;// 如果正确则跳出循环
        }
        // 返回输入字符
        return c;
    }
    /**
     从键盘读取一个字符，并将其作为方法的返回值。
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }
    /**
     从键盘读取一个字符，并将其作为方法的返回值。
     如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);
    }
    /**
     从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
     如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, true);
            if (str.equals("")) {
                return defaultValue;
            }
            try {
                // 将字符转化为带符号正整数。
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }
    /**
     从键盘读取一个长度不超过limit的字符串，并将其作为方法的返回值。
     如果用户不输入字符而直接回车，方法将以defaultValue 作为返回值。
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        // 三目运算符
        return str.equals("") ? defaultValue : str;
    }
    /**
     用于确认选择的输入。该方法从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection()
    {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

}

