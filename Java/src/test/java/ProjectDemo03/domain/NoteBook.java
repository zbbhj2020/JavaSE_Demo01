package ProjectDemo03.domain;

/**
 * @author: zbb
 * @create: 2020/5/6 16:00
 */
public class NoteBook implements Equipment
{
    private String model;// 机器型号
    private double price;// 机器价格

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NoteBook() {
    }

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    // 说明信息：型号(价格)
    @Override
    public String getDescription() {
        return model + "(" + price  + ")";
    }
}
