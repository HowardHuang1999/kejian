package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Email;
import com.loveanimals.loveanimals.service.admin.SendEmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  上午 10:41
 **/
@Api(value = "/api/email", description = "发送邮件")
@CrossOrigin
@RestController
@RequestMapping("/api/email")
public class SendEmailController {
    @Autowired
    @Qualifier("serdbyemail")
    private SendEmailService sendEmailService;

    @ApiOperation(value = "发送邮件")
    @PostMapping("/send")
    public Map<String,Object> send(String title,String text){
        Map<String,Object> map=new HashMap<>();
        String sender="1767064249@qq.com";
        String receiver="1767064249@qq.com";
        if(sender==null||title==null||text==null){
            map.put("code","2020");
            map.put("msg","参数不能为空");
            map.put("data",null);
            return map;
        }

        Email email=new Email();
        email.setSender(sender);
        email.setReceiver(receiver);
        email.setTitle(title);
        email.setText(text);
        boolean b = sendEmailService.insert(email);
        if(!b){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        String result= null;
        try {
            result = sendEmailService.send(sender, receiver, title, text);
        } catch (Exception e) {
            map.put("code","2021");
            map.put("msg","请输入正确的邮件账号！");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg",result);
        map.put("data",email);
        return map;
    }


    @ApiOperation(value = "查询邮件信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Email email){
        Map<String,Object> map=new HashMap<>();

        List<Email> emailList= sendEmailService.query(email);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",emailList.size());
        map.put("data",emailList);
        return map;
    }
    @ApiOperation(value = "删除邮件")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = sendEmailService.delete(id);
        if(!delete){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success delete:"+id);
        map.put("data",null);
        return map;
    }
}
