package main.java.Model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements BaseObject, Serializable
{
    private int id;
    private String name;
    private String lastName;
    private String department;
    private String salary;
    private String phone;

    public Employee()
    {

    }

    public Employee(int id, String name, String lastName, String department, String salary, String phone)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.phone = phone;
        this.salary = salary;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @XmlElement
    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getSalary()
    {
        return salary;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getData()
    {
        return id + " " + name + " " + lastName + " " + department + " " + salary + " " + phone;
    }

    public void setId(int id)
    {
        this.id = id+1;
    }

    public void modify(String name, String lastName, String department, String salary, String phone)
    {
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object object)
    {
        Employee employee = (Employee)object;

        return this.name.equals(employee.name) && this.lastName.equals(employee.lastName) &&
                this.department.equals(employee.department) && this.salary.equals(employee.salary) &&
                this.phone.equals(employee.phone);
    }
}
