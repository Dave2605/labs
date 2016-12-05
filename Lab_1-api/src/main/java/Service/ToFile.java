package main.java.Service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import main.java.Holders.Holder;

@Configuration
@Service
public interface ToFile
{
    Logger log = Logger.getLogger(ToFile.class);

    @Bean
    public void write(Holder holder);

    @Bean
    public Holder read(Holder holder);
}
