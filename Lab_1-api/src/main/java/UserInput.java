package main.java;

import java.util.Scanner;

import main.java.Holders.Holder;
import main.java.Model.BaseObject;
import main.java.Model.Department;
import main.java.Model.Employee;
import main.java.Service.ToFile;

public class UserInput
{
    private Holder employees;
    private Holder departments;
    private Holder holder;
    private Display display;

    private Employee employee;
    private Department department;

    ToFile toFile;

    private Scanner scan;
    private String s;

    public UserInput(Holder employees, Holder departments, Display display, ToFile toFile)
    {
        this.employees = employees;
        this.departments = departments;
        this.display = display;

        employee = new Employee();
        department = new Department();

        scan = new Scanner(System.in);

        this.toFile = toFile;
    }

    public void mainManu()
    {
        display.mainMenu();
    }

    public void mainManuInput()
    {
        s = scan.next();

        switch (s)
        {
            case "e":
                holder = employees;
                break;
            case "d":
                holder = departments;
                break;
            case "q":
                System.exit(0);
                break;
            default:
                display.error();
                mainManu();
                mainManuInput();
        }
        display.menu(holder.getObjectName());

        menuIpnut(holder);
    }

    private void menuIpnut(Holder holder)
    {
        s = scan.next();

        switch (s)
        {
            case "1":
                if (holder.equals(employees))
                {
                    readEmpData();
                    createEmployee();
                } else if (holder.equals(departments))
                {
                    readDeptData();
                    createDepartment();
                    System.out.println(departments.show());
                }
                break;
            case "2":
                display.modify(holder.getObjectName());
                display.out(holder.show());
                int id = scan.nextInt();
                if (holder.equals(employees))
                {
                    readEmpData();
                    holder.modify(id, employee.getName(), employee.getLastName(), employee.getDepartment(), employee.getSalary(), employee.getPhone());
                } else if (holder.equals(departments))
                {
                    readDeptData();
                    holder.modify(id, department.getName(), department.getManager());
                }
                break;
            case "3":
                display.delete(holder.getObjectName());
                display.out(holder.show());
                id = scan.nextInt();
                holder.delete(id);
                break;
            case "4":
                display.out(holder.show());
                break;
            case "5":
                if (holder.equals(employees))
                {
                    toFile.write(employees);
                }else
                {
                    toFile.write(departments);
                }
                break;
            case "6":
                if (holder.equals(employees))
                {
                    employees = toFile.read(employees);
                }else
                {
                    departments = toFile.read(departments);
                }
                break;
            case "7":
                mainManu();
                mainManuInput();
                break;
            default:
                display.error();
        }
    }

    private void createEmployee()
    {
        BaseObject employee = new Employee(holder.getLength(), this.employee.getName(), this.employee.getLastName(), this.employee.getDepartment(), this.employee.getSalary(), this.employee.getPhone());
        add(employee);
    }

    private void createDepartment()
    {
        BaseObject department = new Department(holder.getLength(), this.department.getName(), this.department.getManager());
        add(department);
    }

    private void add(BaseObject object)
    {
        holder.add(object);
    }

    private void readEmpData()
    {
        display.out("Enter" + '\n' + "Name");

        employee.setName(scan.next());

        display.out("Enter" + '\n' + "Lastname");

        employee.setLastName(scan.next());

        display.out("Enter" + '\n' + "Department");

        employee.setDepartment(scan.next());

        display.out("Enter" + '\n' + "Salary");

        employee.setSalary(scan.next());

        display.out("Enter" + '\n' + "Phone");

        employee.setPhone(scan.next());
    }

    private void readDeptData()
    {
        display.out("Enter" + '\n' + "Department Name");

        department.setName(scan.next());

        display.out("Enter" + '\n' + "Manager Name");

        department.setManager(scan.next());
    }
}
