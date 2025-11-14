package cn.com.yis;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.com.yis.mapper")
@SpringBootApplication
@EnableDubbo
public class Springboot3Jdk17Application {

    public static void main(String[] args) {
//        SpringApplication.run(Springboot3Jdk17Application.class, args);
        SpringApplication springApplication = new SpringApplication(Springboot3Jdk17Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setLazyInitialization(true);
        springApplication.run(args);
    }

}
