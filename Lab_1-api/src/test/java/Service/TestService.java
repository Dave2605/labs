package test.java.Service;

import org.junit.Before;

import main.java.Holders.DepartmentsHolder;
import main.java.Holders.EmployeesHolder;
import main.java.Model.Department;
import main.java.Model.Employee;

public abstract class TestService
{
    static final String SRC = "test";

    Employee employee;
    Department department;
    EmployeesHolder employeesHolder;
    DepartmentsHolder departmentsHolder;

    @Before
    public void initialize()
    {
        employee = new Employee(1, "John", "Johnson", "Finance", "7000", "0636734");
        department = new Department(1, "Finance", "Andrew");
        employeesHolder = new EmployeesHolder();
        departmentsHolder = new DepartmentsHolder();
        employeesHolder.add(employee);
        departmentsHolder.add(department);
    }
}
