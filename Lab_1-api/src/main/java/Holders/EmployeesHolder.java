package main.java.Holders;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.Model.BaseObject;
import main.java.Model.Employee;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesHolder extends Holder
{
    public EmployeesHolder()
    {
        holder =  new ArrayList();
    }

    public void modify(int id, String... args)
    {
        Employee employee;

        for(BaseObject emp : holder) {

            if (emp.getId()==id)
            {
                employee = (Employee)emp;
                employee.modify(args[0], args[1], args[2], args[3], args[4]);
            }
        }
    }

    public String getObjectName()
    {
        return "employee";
    }
}
