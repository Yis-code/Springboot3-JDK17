package cn.com.yis;

import cn.com.yis.domain.UserDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot3Jdk17ApplicationTests {

    @Autowired
    private UserDO userDO;

    @Test
    void contextLoads() {
        System.out.println(userDO);
    }

}
