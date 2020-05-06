package ProjectDemo01;

/**
 * @author: zbb
 * @create: 2020/5/5 20:42
 */
public class FamilyAccount
{
    public static void main(String[] args)
    {
        String details = "收支\t    账户金额\t      收支金额\t     说   明\n";
        String details2 = "-----------------家庭收支记账软件-----------------\n" +
                "\t\t\t\t 1 收支明细\n" +
                "\t\t\t\t 2 登记收入\n" +
                "\t\t\t\t 3 登记支出\n" +
                "\t\t\t\t 4 退    出\n" +
                "\t\t\t\t 请选择(1-4)：";
        int balance = 10000;
        boolean isFlag = true;

        do {
            System.out.println(details2);
            // 要求用户输入1~4；
            char selection = Utility.readMenuSelection();
            switch(selection) {
                case '1':
//                    System.out.println("1.收支明细");
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("------------------------------------------------");
                    break;
                case '2':
                    System.out.print("本次收入金额：");
                    // 获取键盘输入数值
                    int amount1 = Utility.readNumber2();
                    System.out.print("本次收入说明：");
                    // 获取8位字符输入
                    String desc1 = Utility.readString();
                    balance += amount1;
                    details += "收入\t\t" + balance + "  \t\t  " +
                            amount1 + "  \t\t\t" + desc1 + "\n";
                    System.out.println("---------------------登记完成--------------------");
                    break;
                case '3':
                    System.out.print("本次支出金额：");
                    // 获取规定4位数以内输入
                    int amount2 = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    // 获取8位数字符输入
                    String desc2 = Utility.readString();

                    balance -= amount2;
                    details += "支出\t\t" + balance + "  \t\t  " +
                            amount2 + "  \t\t\t" + desc2 + "\n";
                    System.out.println("---------------------登记完成--------------------");
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = Utility.readConfirmSelection();
                    if (yn == 'Y') isFlag = false;
                    break;
            }
        }while(isFlag);
    }
}
