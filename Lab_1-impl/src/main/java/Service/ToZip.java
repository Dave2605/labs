package main.java.Service;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ToZip
{
    static Logger log = Logger.getLogger(ToZip.class);

    public static void zip(String src)
    {
        try
        {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(src + ".zip"));

            ZipEntry ze = new ZipEntry(src);
            zout.putNextEntry(ze);

            BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));

            int length;
            byte[] buffer = new byte[1024];

            while((length = in.read(buffer)) > 0) {
                zout.write(buffer, 0, length);
            }
            in.close();
            zout.closeEntry();
            zout.close();
        } catch (FileNotFoundException e)
        {
            log.error(e);
        } catch (IOException e)
        {
            log.error(e);
        }
    }
}

