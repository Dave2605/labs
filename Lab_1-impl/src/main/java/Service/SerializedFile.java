package main.java.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import main.java.Holders.EmployeesHolder;
import main.java.Holders.Holder;

/**
 * Serialization/Deserialization to Json.
 */
public class SerializedFile implements ToFile
{
    private final String EMP_SRC = "emp.txt";
    private final String DEPT_SRC = "dept.txt";

    private String src;

    /**
     * Serialization.
     * @param holder object to serialize
     */
    @Override
    public void write(Holder holder)
    {
        FileOutputStream fos;
        try
        {
            if (holder instanceof EmployeesHolder)
            {
                src = EMP_SRC;
                fos = new FileOutputStream(src);
            }else
            {
                src = DEPT_SRC;
                fos = new FileOutputStream(src);
            }

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(holder);
            oos.flush();
            oos.close();
            ToZip.zip(src);
            log.info("object was serialized");
        } catch (FileNotFoundException e)
        {
            log.error(e);
        } catch (IOException e)
        {
            log.error(e);
        }
    }

    /**
     * Deserialization.
     * @param holder object to deserialize
     * @return serialized holder object
     */
    @Override
    public Holder read(Holder holder)
    {
        FileInputStream fis;
        Object o = null;
        try
        {
            if (holder instanceof EmployeesHolder)
            {
                src = EMP_SRC;
                fis = new FileInputStream(src);
            } else
            {
                src = DEPT_SRC;
                fis = new FileInputStream(src);
            }
            ObjectInputStream oin = new ObjectInputStream(fis);
            o = oin.readObject();
            oin.close();
            log.info("file was deserialized");
        } catch (FileNotFoundException e)
        {
            log.error(e);
        } catch (ClassNotFoundException e)
        {
            log.error(e);
        } catch (IOException e)
        {
            log.error(e);
        }
        return (Holder) o;
    }
}
