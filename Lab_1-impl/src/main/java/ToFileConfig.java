package main.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.Service.JsonFile;
import main.java.Service.SerializedFile;
import main.java.Service.XmlFile;

/**
 * Spring configuration.
 */
@Configuration
public class ToFileConfig
{
    @Bean
    public JsonFile jsonFile()
    {
        return new JsonFile();
    }

    @Bean
    public SerializedFile serializedFile()
    {
        return new SerializedFile();
    }

    @Bean
    public XmlFile xmlFile()
    {
        return new XmlFile();
    }
}
