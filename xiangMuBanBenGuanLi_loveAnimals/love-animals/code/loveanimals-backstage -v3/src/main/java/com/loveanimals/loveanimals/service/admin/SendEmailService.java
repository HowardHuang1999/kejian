package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.EmailDao;
import com.loveanimals.loveanimals.po.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  上午 10:38
 **/
@Service("serdbyemail")
public class SendEmailService {
    @Autowired
    private EmailDao emailDao;

    @Autowired
    JavaMailSender jms;

    public String send(String sender,String receiver,String title,String text){
        //建立邮件消息
        SimpleMailMessage mainMessage = new SimpleMailMessage();
        //发送者
        System.out.println("发送者 ------------------");
        mainMessage.setFrom(sender);
        System.out.println("接收者 ------------------");
        //接收者
        mainMessage.setTo(receiver);

        //发送的标题
        mainMessage.setSubject(title);
        //发送的内容
        mainMessage.setText(text);
        jms.send(mainMessage);
        return "1";
    }

    /*
     * 添加
     * */
    public boolean insert(Email email){

        int i = emailDao.insert(email);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Email> query(Email email){
        QueryWrapper<Email> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Email> lambda = queryWrapper.lambda();

        if(email.getId()!=null){
            lambda.eq(Email::getId,email.getId());
        }
        if(email.getSender()!=null){
            lambda.eq(Email::getSender,email.getSender());
        }
        if(email.getReceiver()!=null){
            lambda.eq(Email::getReceiver,email.getReceiver());
        }
        if(email.getTitle()!=null){
            lambda.eq(Email::getTitle,email.getTitle());
        }
        if(email.getText()!=null){
            lambda.eq(Email::getText,email.getText());
        }

        List<Email> emailList = emailDao.selectList(lambda);
        return emailList;
    }


    public boolean delete(Integer id){

        int i = emailDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Email email){

        int i = emailDao.updateById(email);
        if(i<=0){
            return false;
        }
        else return true;
    }



}
