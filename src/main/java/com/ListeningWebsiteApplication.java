package com;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
@Slf4j
@SpringBootApplication
@MapperScan("com.Mapper")
public class ListeningWebsiteApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ListeningWebsiteApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        log.info("swagger地址   "+"http://localhost:"+environment.getProperty("server.port")+"/swagger-ui.html");
    }

}
