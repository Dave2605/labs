package main.java.Holders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;

import main.java.Model.BaseObject;

public abstract class Holder implements Serializable
{
    @XmlAnyElement(lax=true)
    List<BaseObject> holder;

    public void add(BaseObject obj)
    {
        holder.add(obj);
    }

    public void setHolder(ArrayList<BaseObject> holder)
    {
        this.holder = holder;
    }

    public void delete(int id)
    {
        holder.remove(id-1);

        int count = 0;

        for(BaseObject obj : holder)
        {
            count++;
            obj.setId(count);
        }
    }

    public String show()
    {
        String data = "";

        for(BaseObject obj : holder) {
            data += obj.getData() + '\n';
        }

        return data;
    }

    public int getLength()
    {
        return holder.size()+1;
    }

    abstract public void modify(int id, String... args);

    abstract public String getObjectName();

    public List getHolder()
    {
        return holder;
    }
}
