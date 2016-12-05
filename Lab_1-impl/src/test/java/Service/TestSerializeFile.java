package test.java.Service;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import main.java.Holders.DepartmentsHolder;
import main.java.Model.Employee;

public class TestSerializeFile extends TestService
{
    @Test
    public void testSerializeEmployee() throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(employee);
        byte b[] = bos.toByteArray();
        out.close();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        ObjectInput in = new ObjectInputStream(bis);
        if(!employee.equals(in.readObject()))
        {
            throw new AssertionError();
        }
    }

    @Test
    public void testSerializeDepartment() throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(department);
        byte b[] = bos.toByteArray();
        out.close();
        bos.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(b);
        ObjectInput in = new ObjectInputStream(bis);
        if(!department.equals(in.readObject()))
        {
            throw new AssertionError();
        }
    }
}
