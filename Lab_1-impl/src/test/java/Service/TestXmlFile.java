package test.java.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import main.java.Model.Department;
import main.java.Model.Employee;

public class TestXmlFile extends TestService
{
    JAXBContext context;

    @Test
    public void testEmployeeXml() throws JAXBException
    {
        context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        marshaller.marshal(employee, sw);

        assertThat(sw.toString(), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<employee>\n" +
                "    <department>Finance</department>\n" +
                "    <id>1</id>\n" +
                "    <lastName>Johnson</lastName>\n" +
                "    <name>John</name>\n" +
                "    <phone>0636734</phone>\n" +
                "    <salary>7000</salary>\n" +
                "</employee>\n"));

        StringReader reader = new StringReader(sw.toString());
        Unmarshaller u = context.createUnmarshaller();
        if(!employee.equals(u.unmarshal(reader)))
        {
            throw new AssertionError();
        }
    }

    @Test
    public void testDepartmentXml() throws JAXBException
    {
        context = JAXBContext.newInstance(Department.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        marshaller.marshal(department, sw);

        assertThat(sw.toString(), is("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<department>\n" +
                "    <id>1</id>\n" +
                "    <manager>Andrew</manager>\n" +
                "    <name>Finance</name>\n" +
                "</department>\n"));

        StringReader reader = new StringReader(sw.toString());
        Unmarshaller u = context.createUnmarshaller();
        if(!department.equals(u.unmarshal(reader)))
        {
            throw new AssertionError();
        }
    }
}
