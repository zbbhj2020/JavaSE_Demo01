package ProjectDemo03.domain;

/**
 * @author: zbb
 * @create: 2020/5/6 15:56
 */
public class PC implements Equipment
{
    private String model;// 机器型号
    private String display;// 显示器名称

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    // 显示说明信息:型号(显示器名称)
    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
