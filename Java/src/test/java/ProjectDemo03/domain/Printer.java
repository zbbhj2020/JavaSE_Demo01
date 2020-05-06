package ProjectDemo03.domain;

/**
 * @author: zbb
 * @create: 2020/5/6 16:03
 */
public class Printer implements Equipment
{
    private String name;// 机器名称
    private String type;// 机器型号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }


    // 说明信息： 名称(型号)
    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
