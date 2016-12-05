package main.java.Holders;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import main.java.Model.BaseObject;
import main.java.Model.Department;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DepartmentsHolder extends Holder
{
    public DepartmentsHolder()
    {
        holder = new ArrayList();
    }

    public void modify(int id, String... args)
    {
        Department department;

        for(BaseObject dept : holder) {

            if (dept.getId()==id)
            {
                department = (Department)dept;
                department.modify(args[0], args[1]);
            }
        }
    }

    public String getObjectName()
    {
        return "department";
    }
}
