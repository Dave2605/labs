package main.java.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import main.java.Holders.EmployeesHolder;
import main.java.Holders.Holder;
import main.java.Model.BaseObject;
import main.java.Model.Department;
import main.java.Model.Employee;

/**
 * Serialization/Deserialization to Json.
 */
public class JsonFile implements ToFile
{
    private final String EMP_SRC = "emp.json";
    private final String DEPT_SRC = "dept.json";

    private String src;

    /**
     * Serialization to Json.
     * @param holder object to serialize
     */
    @Override
    public void write(Holder holder)
    {
        if(holder instanceof EmployeesHolder)
        {
            src = EMP_SRC;
        }else
        {
            src = DEPT_SRC;
        }
        try
        {
            PrintWriter w = new PrintWriter(src);
            Gson gson = new Gson();
            w.write(gson.toJson(holder));
            w.flush();
            w.close();
            ToZip.zip(src);
            log.info("file was serialized to Json");
        } catch (IOException e)
        {
            log.error(e);
        }
    }

    /**
     * Deserialization from Json.
     * @param holder object to deserialize
     * @return serialized holder object
     */
    @Override
    public Holder read(Holder holder)
    {
        if(holder instanceof EmployeesHolder)
        {
            src = EMP_SRC;
        }else
        {
            src = DEPT_SRC;
        }
        FileReader fileReader = null;
        BaseObject object;
        Gson gson = new Gson();
        try
        {
            fileReader = new FileReader(src);
            JsonReader jsonReader = new JsonReader(fileReader);

            JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray =  (JsonArray)jsonParser.parse(jsonReader).getAsJsonObject().get("holder");

            for (JsonElement element : jsonArray){
                if(holder instanceof EmployeesHolder)
                {
                    object = gson.fromJson(element, Employee.class);
                }else{
                    object = gson.fromJson(element, Department.class);
                }
                holder.add(object);
            }
            log.info("Json was deserialized");
        } catch (FileNotFoundException e)
        {
            log.error(e);
        }
        return holder;
    }
}
