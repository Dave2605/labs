package test.java.Service;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


public class TestToZip extends TestService
{
    @Before
    public void jsonToFile() throws FileNotFoundException
    {
        Gson gson = new Gson();
        PrintWriter w = new PrintWriter(SRC + ".json");
        w.write(gson.toJson(employeesHolder));
        w.flush();
        w.close();
    }

    @Test
    public void testZip() throws IOException
    {
        ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(SRC + ".zip"));

        ZipEntry ze = new ZipEntry(SRC + ".json");
        zout.putNextEntry(ze);

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(SRC + ".json"));

        int length;
        byte[] buffer = new byte[1024];

        while ((length = in.read(buffer)) > 0)
        {
            zout.write(buffer, 0, length);
        }
        in.close();
        zout.closeEntry();
        zout.close();
    }

    @After
    public void close()
    {
        File jsonFile = new File(SRC + ".json");
        File zipFile = new File(SRC + ".zip");
        jsonFile.delete();
        zipFile.delete();
    }

}
