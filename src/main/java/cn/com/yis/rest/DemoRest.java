package cn.com.yis.rest;

import cn.com.yis.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRest {

    @Autowired
    private UserDO userDO;

    @RequestMapping("/getUser")
    public String getUser() {
        return userDO.toString();
    }
}
