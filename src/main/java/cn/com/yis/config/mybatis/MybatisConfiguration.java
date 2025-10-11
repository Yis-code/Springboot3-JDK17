package cn.com.yis.config.mybatis;

import cn.com.yis.config.mybatis.interceptor.MybatisPlusAllSqlLog;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

//@Configuration
public class MybatisConfiguration {

    //    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new MybatisPlusAllSqlLog());
        return mybatisPlusInterceptor;
    }

}