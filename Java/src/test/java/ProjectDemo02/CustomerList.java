package ProjectDemo02;

/**
 * @author: zbb
 * @create: 2020/5/6 12:57
 */
// 客户数组类
public class CustomerList
{
    // 定义客户数组变量
    private Customer[] customers;
    // 声明一个储存int类型数值的变量total
    private int total = 0;

    // 创建一个客户总数的客户数组的有参构造器
    public CustomerList(int totalCustomer)
    {
        customers = new Customer[totalCustomer];
    }

    // 添加客户的方法
    public boolean addCustomer(Customer customer)
    {
        // 如果总数输入值大于等于数组长度返回false。
        if (total >= customers.length) return false;
        // 如果不大于等于数组长度，则
        customers[total++] = customer;
        return true;
    }

    // 更改客户信息【改】
    public boolean replaceCustomer(int index, Customer cust)
    {
        // 如果索引值小于0或者大于总数，返回false。
        if (index < 0 || index >= total) return false;
        // 将客户信息添加至指定索引值进行更新。
        customers[index] = cust;
        // 且返回true。
        return true;
    }
    // 删除客户【删】
    public boolean deleteCustomer(int index)
    {
        // 如果索引值小于0或者大于总数，返回false。
        if (index < 0 || index >= total) return false;
        // 循环遍历
        for (int i = index; i < total - 1; i++)
        {
            // 将后一位元素向前移，表示指定索引位的值被删除。
            customers[i] = customers[i + 1];
        }
        // 全部删除则为空
        customers[--total] = null;
        return true;
    }

    // 获取所有客户信息，返回的是数组信息【查全部】
    public Customer[] getAllCustomers()
    {
        // 通过客户总量创建一个新数组
        Customer[] custs = new Customer[total];
        // 循环遍历所有元素
        for (int i = 0; i < total; i++) {
            // 将索引元素赋值给新数组
            custs[i] = customers[i];
        }
        // 返回所有客户信息
        return custs;
    }

    // 获取总客户数【数组总长度】
    public int getTotal()
    {
        return total;
    }

    // 通过索引值得到客户元素的方法【查一个】
    public Customer getCustomer(int index)
    {
        // 如果索引值小于0或者大于等于总长度，返回null。
        if (index < 0 || index >= total) return null;
        // 如果在范围内返回数组索引信息。
        return customers[index];
    }
}
