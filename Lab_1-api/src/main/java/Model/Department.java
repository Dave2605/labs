package main.java.Model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Department implements BaseObject, Serializable
{
    private int id;
    private String name;
    private String manager;

    public Department()
    {

    }

    public Department(int id, String name, String manager)
    {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setManager(String manager)
    {
        this.manager = manager;
    }

    public String getName()
    {
        return name;
    }

    public String getManager()
    {
        return manager;
    }

    public String getData()
    {
        return id + " " + name + " " + manager;
    }

    public void setId(int id)
    {
        this.id = id+1;
    }

    public void modify(String name, String manager)
    {
        this.name = name;
        this.manager = manager;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public boolean equals(Object object)
    {
        Department department = (Department) object;
        return this.getName().equals(department.getName()) && this.getManager().equals(department.getManager());
    }
}
