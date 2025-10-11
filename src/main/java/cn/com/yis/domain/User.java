package cn.com.yis.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private String name;
    private Integer age;
    private String phone;
    private String email;

    private Address address;
}
