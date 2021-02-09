package com.loveanimals.loveanimals.config;

import com.loveanimals.loveanimals.security.ApiFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @description:
 * @author: Mr.pang
 * @create: 2020-10-05 17:36
 **/
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {


    @Autowired
    ApiFilter apiFilter;
    /**
     * 自定义拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {



        registry.addInterceptor(apiFilter).addPathPatterns("/**/check/**");


        /**

         一个*：只匹配字符，不匹配路径（/）
         两个**：匹配字符，和路径（/）


         - /**： 匹配所有路径
         - /admin/**：匹配 /admin/ 下的所有路径
         - /secure/*：只匹配 /secure/user，不匹配 /secure/user/info

         */
    }
}
