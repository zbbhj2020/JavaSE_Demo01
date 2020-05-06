package ProjectDemo03.service;

// 状态枚举类：表示员工的状态
public class Status
{
    private final String NAME; // 名字
    // 有参构造器
    private Status(String name)
    {
        this.NAME = name;
    }

    public static final Status FREE = new Status("FREE");// 状态FREE
    public static final Status VOCATION = new Status("VOCATION");// 状态VOCATION
    public static final Status BUSY = new Status("BUSY");// 状态BUSY

    // getter方法
    public String getNAME()
    {
        return NAME;
    }
    @Override
    public String toString()
    {
        return NAME;
    }
}

