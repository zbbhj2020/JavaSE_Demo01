package ProjectDemo03.service;

import ProjectDemo03.domain.*;

import static ProjectDemo03.service.Data.*;

/**
 * @Description 功能：负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author: zbb
 * @create: 2020/5/6 16:50
 */
public class NameListService
{
    private Employee[] employees;

    public NameListService()
    {
        //1.根据项目提供的Data类构建相应大小的employees数组
        employees = new Employee[Data.EMPLOYEES.length];
        //2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
        for (int i = 0; i < employees.length; i++)
        {
            // 遍历循环EMPLOYEES数组的所有索引值为0的int值。
            // 获取员工的类型（int）
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            // 获取EMPLOYEE的4个基本信息
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;
            switch (type)
            {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case Data.DESIGNER:
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    equipment = createEquipment(i);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus,stock);
                    break;
            }
        }
    }

    /**
     * @Description 获取指定index上的员工的设备
     * @author zbb
     * @date 2020/5/6 17:44
     * @return
     **/
    private Equipment createEquipment(int index)
    {
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        String model = Data.EQUIPMENTS[index][1];
        switch(key)
        {
            case PC://21
                String display = Data.EQUIPMENTS[index][2];
                return new PC(model,display);
            case NOTEBOOK://22
                // price在EQUIPMENTS数组中是double类型，只有在NoteBook数组中索引值为2是String类型的数字可以转换为double类型，
                // 如果作为全局变量，则会报错
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);
            case PRINTER://23
                String name = Data.EQUIPMENTS[index][1] ;
                String type = Data.EQUIPMENTS[index][2] ;
                return new Printer(name ,type);
        }
        return null;
    }

    /**
     * 给employee即数组元素进行初始化
     * @return
     */
    // 获取所有员工信息的方法
    public Employee[] getAllEmployees()
    {
        return employees;
    }

    // 获取指定员工信息的方法
    public Employee getEmployee(int id) throws TeamException
    {
        for(int i = 0 ; i < employees.length ; i++)
        {
            if (employees[i].getId() == id)
            {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
