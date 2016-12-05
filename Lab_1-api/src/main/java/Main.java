package main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.Holders.DepartmentsHolder;
import main.java.Holders.EmployeesHolder;
import main.java.Holders.Holder;
import main.java.Service.JsonFile;
import main.java.Service.ToFile;
import main.java.Service.XmlFile;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ToFileConfig.class);

        ToFile toFile = context.getBean(XmlFile.class);

       // ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
       // ToFile toFile = (JsonFile) context.getBean("ToFile");

        Holder employeesHolder = new EmployeesHolder();

        Holder departmentHolder = new DepartmentsHolder();

        Display display = new Display();

        UserInput input = new UserInput(employeesHolder, departmentHolder, display, toFile);

        for(;;)
        {
            input.mainManu();
            input.mainManuInput();
        }
    }
}
