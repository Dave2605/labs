package test.java.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.StringReader;

import main.java.Model.Department;
import main.java.Model.Employee;

public class TestJsonFile extends TestService
{
    Gson gson;

    @Before
    public void initializeJson()
    {
        gson = new Gson();
    }

    @Test
    public void testEmployeeJson()
    {
        String jsonString = gson.toJson(employeesHolder);
        assertThat(jsonString, is("{\"holder\":[{\"id\":1,\"name\":\"John\",\"lastName\":\"Johnson\",\"department\":\"Finance\",\"salary\":\"7000\",\"phone\":\"0636734\"}]}"));

        JsonReader jsonReader = new JsonReader(new StringReader(jsonString));
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray =  (JsonArray)jsonParser.parse(jsonReader).getAsJsonObject().get("holder");
        Employee emp = gson.fromJson(jsonArray.get(0), Employee.class);
        if(!employee.equals(gson.fromJson(jsonArray.get(0), Employee.class)))
        {
            throw new AssertionError();
        }
    }

    @Test
    public void testDepartmentsJson()
    {
        String jsonString = gson.toJson(departmentsHolder);
        assertThat(jsonString, is("{\"holder\":[{\"id\":1,\"name\":\"Finance\",\"manager\":\"Andrew\"}]}"));

        JsonReader jsonReader = new JsonReader(new StringReader(jsonString));
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray =  (JsonArray)jsonParser.parse(jsonReader).getAsJsonObject().get("holder");

        if(!department.equals(gson.fromJson(jsonArray.get(0), Department.class)))
        {
            throw new AssertionError();
        }
    }
}
