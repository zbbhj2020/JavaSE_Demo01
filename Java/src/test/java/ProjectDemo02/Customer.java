package ProjectDemo02;

/**
 * @author: zbb
 * @create: 2020/5/6 12:55
 */
// 客户信息类
public class Customer
{
    private String name;// 声明名字
    private char gender;// 声明性别
    private int age;// 声明年龄
    private String phone;// 声明电话
    private String email;// 声明邮箱

    // 部分参数构造器
    public Customer(String name, char gender, int age)
    {
        this(name, gender, age, "", "");
    }

    // 全参构造器
    public Customer(String name, char gender, int age, String phone, String email)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }
    // 以及getter与setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return name + "\t " + gender + "\t\t" + age + "\t\t" + phone + "\t" + email;
    }
}