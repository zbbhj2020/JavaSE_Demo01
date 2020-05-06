package ProjectDemo03.domain;

/**
 * @author: zbb
 * @create: 2020/5/6 16:47
 */
public class Architect extends Designer
{
    private int stock;

    public Architect() {
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock)
    {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock  + "\t" + getEquipment().getDescription() ;
    }

    public String getDetailsForTeam()
    {
        return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + getStock();
    }
}
