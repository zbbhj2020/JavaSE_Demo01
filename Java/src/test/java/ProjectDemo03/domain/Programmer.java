package ProjectDemo03.domain;

import ProjectDemo03.service.Status01;

/**
 * @author: zbb
 * @create: 2020/5/6 16:20
 */
public class Programmer extends Employee
{
    private int memberId;// 开发团队中的id。
    private Status01 status = Status01.FREE;
    private Equipment equipment;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status01 getStatus() {
        return status;
    }

    public void setStatus(Status01 status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.getDetails() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getTeamBaseDetails()
    {
        return memberId + "/" + getId() + "     " + getName() + "\t" + getAge() + "\t\t" + getSalary();
    }

    public String getDetailsForTeam()
    {
        return getTeamBaseDetails() + "\t程序员";
    }
}
