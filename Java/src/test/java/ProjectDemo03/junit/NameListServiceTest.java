package ProjectDemo03.junit;

import ProjectDemo03.domain.Employee;
import ProjectDemo03.service.NameListService;
import ProjectDemo03.service.TeamException;
import org.junit.Test;

/**
 * @Description 对NameListService类的测试
 * @author: zbb
 * @create: 2020/5/6 20:17
 */
public class NameListServiceTest
{
    @Test
    public void testGetAllEmployees() throws TeamException
    {
        NameListService service = new NameListService();
        int id = 1;
        Employee employee = service.getEmployee(id);
        System.out.println(employee);
        System.out.println("==========================================");
        Employee[] allEmployees = service.getAllEmployees();
        for (Employee employee1 : allEmployees)
        {
            System.out.println(employee1);
        }
    }
}
