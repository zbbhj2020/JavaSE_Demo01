package ProjectDemo03.view;


import ProjectDemo03.domain.Employee;
import ProjectDemo03.domain.Programmer;
import ProjectDemo03.service.NameListService;
import ProjectDemo03.service.TeamException;
import ProjectDemo03.service.TeamService;

/**
 * @Description
 * @author: zbb
 * @create: 2020/5/6 23:25
 */
public class TeamView
{
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu()
    {
        boolean Flag = true;
        char menu = 0;
        while(Flag)
        {
            if (menu != '1')
            {
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)：");
            menu = TSUtility.readMenuSelection();
            switch(menu)
            {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    getTeam();
                    deleteMember();
                    break;
                case '4':
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y')
                        Flag = false;
                    break;
            }
        }
    }
    /**
     * @Description 显示所有的员工信息
     * @author zbb
     * @date 2020/5/6 23:34
     * @return
     **/
    private void listAllEmployees()
    {
//        System.out.println("所有员工信息");
        System.out.println("------------------------------开发团队调度软件-----------------------------\n");
        Employee[] allEmployees = listSvc.getAllEmployees();
        if (allEmployees == null || allEmployees.length == 0) {
            System.out.println("公司中没有任何员工信息！");
        }else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (Employee employee : allEmployees)
            {
                System.out.println(employee);
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }
    private void getTeam()
    {
//        System.out.println("查看开发团队情况");
        System.out.println("-------------------------------团队成员列表-------------------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0)
        {
            System.out.println("没有任何团队成员信息！");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (Programmer programmer : team)
            {
                System.out.println(programmer.getDetailsForTeam());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }
    private void addMember(){
//        System.out.println("添加开发团队成员");
        System.out.println("---------------------------------添加成员---------------------------------\n");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();// 按回车键继续
    }
    private void deleteMember()
    {
//        System.out.println("删除开发团队成员");
        System.out.println("---------------------------------删除成员---------------------------------\n");
        System.out.print("请输入要删除的员工ID：");
        int memberId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N')
        {
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();// 按回车键继续
    }

    public static void main(String[] args)
    {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }

}
