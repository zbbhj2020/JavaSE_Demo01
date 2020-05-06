package ProjectDemo03.service;

import ProjectDemo03.domain.Architect;
import ProjectDemo03.domain.Designer;
import ProjectDemo03.domain.Employee;
import ProjectDemo03.domain.Programmer;

/**
 * @Description
 * @author: zbb
 * @create: 2020/5/6 20:15
 */
public class TeamService
{
    private static int counter = 1; // 给member赋值
    private final int MAX_MEMBER = 5;// 设置开发团队最大值
    private Programmer[] team = new Programmer[MAX_MEMBER];// 保存开发团队成员
    private static int total;// 记录开发团队中实际的人数

    /**
     * @Description 获取开发团队全部成员
     * @author zbb
     * @date 2020/5/6 21:27
     * @return
     **/
    public Programmer[] getTeam()
    {
        Programmer[] teamNew = new Programmer[TeamService.total];
        for (int i = 0; i < teamNew.length; i++)
        {
            teamNew[i] = this.team[i];
        }
        return teamNew;
    }

    /**
     * @Description 将指定员工添加开发团队成员
     * @author zbb
     * @date 2020/5/6 21:27
     * @return
     **/
    public void addMember(Employee employee) throws TeamException
    {
        if (total >= MAX_MEMBER)
        {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(employee instanceof Programmer))
        {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(employee))
        {
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p = (Programmer)employee;
        if (p.getStatus() == Status01.BUSY)
        {
            throw new TeamException("该员工已是某团队成员");
        }else if (p.getStatus() == Status01.VOCATION)
        {
            throw new TeamException("该员正在休假，无法添加");
        }
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++)
        {
            if (team[i] instanceof Architect)
            {
                numOfArch++;
            }else if (team[i] instanceof Designer)
            {
                numOfDes++;
            }else{
                numOfPro++;
            }
        }
        if (p instanceof Architect)
        {
            if (numOfArch >= 1)
            {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if (p instanceof Designer)
        {
            if (numOfDes >= 2)
            {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        }else if (p instanceof Programmer)
        {
            if (numOfPro >= 3)
            {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }
        team[total] = p; // 将p或者employee添加到现有的team数组中
        total++;
        p.setStatus(Status01.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * @Description 删除开发团队成员
     * @author zbb
     * @date 2020/5/6 21:28
     * @return
     **/
    public void removeMember(int memberId) throws TeamException
    {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId)
            {
                team[i].setStatus(Status01.FREE);
                break;
            }
        }
        if (i == total)
        {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        // 后一个元素覆盖前一个元素，实现删除操作
        for (int j = i + 1; j < total; j++) {
            team[j -1] = team[j];
        }
        total--;
        team[total] = null;

    }

    /**
     * @Description 判断指定的员工是否已经存在于现有的开发团队中
     * @author zbb
     * @date 2020/5/6 21:53
     * @return
     **/
    private boolean isExist(Employee employee)
    {
        for (int i = 0; i < total; i++) {
            // team[i].getId() == employee.getMemberId()
            if (team[i].getId() == employee.getId())
            {
                return true;
            }
        }
        return false;
    }

}
