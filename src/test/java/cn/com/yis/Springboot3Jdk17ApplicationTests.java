package cn.com.yis;

import cn.com.yis.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot3Jdk17ApplicationTests {

    @Autowired
    private User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
