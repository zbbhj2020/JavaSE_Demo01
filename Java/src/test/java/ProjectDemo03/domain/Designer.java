package ProjectDemo03.domain;

/**
 * @author: zbb
 * @create: 2020/5/6 16:40
 */
public class Designer extends Programmer
{
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus)
    {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription() ;
    }

    public String getDetailsForTeam()
    {
        return getTeamBaseDetails() + "\t设计师\t" + getBonus();
    }

}
