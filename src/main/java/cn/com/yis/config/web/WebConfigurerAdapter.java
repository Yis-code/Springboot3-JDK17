package cn.com.yis.config.web;

import cn.com.yis.config.mybatis.interceptor.TraceLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurerAdapter implements WebMvcConfigurer {

    /**
     * 注册TraceLogInterceptor拦截器
     */
    @Bean
    public TraceLogInterceptor logInterceptor() {
        return new TraceLogInterceptor();
    }

    /**
     * 添加拦截器到拦截器链
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor());
        // 可以具体指定哪些需要拦截，哪些不拦截，其实也可以使用自定义注解更灵活完成
        // .addPathPatterns("/**")
        // .excludePathPatterns("/xxx.yyy");
    }
}
