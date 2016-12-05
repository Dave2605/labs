package main.java.Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Interface for model objects.
 */
@XmlRootElement
public interface BaseObject
{
    String getData();

    void setId(int id);

    int getId();
}
