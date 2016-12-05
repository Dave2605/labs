package main.java.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import main.java.Holders.DepartmentsHolder;
import main.java.Holders.EmployeesHolder;
import main.java.Holders.Holder;
import main.java.Model.Department;
import main.java.Model.Employee;

/**
 * Serialization/Deserialization to Xml.
 */
public class XmlFile implements ToFile
{
    private final String EMP_SRC = "emp.xml";
    private final String DEPT_SRC = "dept.xml";

    private String src;

    /**
     * Serialization to Xml.
     * @param holder object to serialize
     */
    @Override
    public void write(Holder holder)
    {
        JAXBContext context;

        try
        {
            if (holder instanceof EmployeesHolder)
            {
                src = EMP_SRC;
                context = JAXBContext.newInstance(EmployeesHolder.class, Employee.class);
            } else
            {
                src = DEPT_SRC;
                context = JAXBContext.newInstance(DepartmentsHolder.class, Department.class);
            }
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                OutputStream os = new FileOutputStream(new File(src));

                marshaller.marshal(holder, os);
                ToZip.zip(src);

                log.info("object was serialized to xml");
            } catch (FileNotFoundException e)
            {
                log.error(e);
            }
             catch (JAXBException e)
            {
                log.error(e);
            }
    }

    /**
     * Deserialization from Xml.
     * @param holder object to deserialize
     * @return serialized holder object
     */
    @Override
    public Holder read(Holder holder)
    {
        JAXBContext context;
        Object o = null;
        try
        {
            if (holder instanceof EmployeesHolder)
            {
                src = EMP_SRC;
                context = JAXBContext.newInstance(EmployeesHolder.class, Employee.class);
            }else
            {
                src = DEPT_SRC;
                context = JAXBContext.newInstance(DepartmentsHolder.class, Department.class);
            }
            InputStream is = new FileInputStream(src);
            Unmarshaller u = context.createUnmarshaller();
            o = u.unmarshal(is);
            log.info("xml file was deserialized");
        } catch (JAXBException e)
        {
            log.error(e);
        } catch (FileNotFoundException e)
        {
            log.error(e);
        }
        return (Holder) o;
    }
}
