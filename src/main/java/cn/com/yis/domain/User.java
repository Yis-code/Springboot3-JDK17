package cn.com.yis.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@ConfigurationProperties(prefix = "user")
@Validated
public class User {
    private String name;
    private Integer age;
    private String phone;
    @NotBlank(message = "邮箱不能为空")
    private String email;

    private Address address;
}
