package com.loveanimals.loveanimals.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: loveanimals
 * @description:
 * @author: Mr.pang
 * @create: 2020-10-05 19:21
 **/
@Component
public class ApiFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ausername = (String)request.getSession().getAttribute("aname");
        String busername = (String)request.getSession().getAttribute("bname");
        if(ausername!=null||busername!=null){
            return true;
        }
        output(response, "未登录，无法访问");
        return false;
    }
    public void output(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map=new HashMap<>();
        map.put("code","401");
        map.put("msg",msg);
        map.put("data",null);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
