package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.BuserDao;
import com.loveanimals.loveanimals.dao.admin.MessageboardAboutBuserDao;
import com.loveanimals.loveanimals.dao.admin.MessageboardDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Buser;
import com.loveanimals.loveanimals.po.Messageboard;
import com.loveanimals.loveanimals.vo.MessageBoardAndBuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-07  下午 2:41
 **/
@Service
@Transactional
public class MessageboardService {

    @Autowired
    private MessageboardDao messageboardDao;

    @Autowired
    private MessageboardAboutBuserDao messageboardAboutBuserDao;

    /*
     * 添加
     * */
    public boolean insert(Messageboard messageboard){

        int i = messageboardDao.insert(messageboard);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Messageboard> query(Messageboard messageboard){
        QueryWrapper<Messageboard> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Messageboard> lambda = queryWrapper.lambda();

        if(messageboard.getId()!=null){
            lambda.eq(Messageboard::getId,messageboard.getId());
        }
        if(messageboard.getBuserid()!=null){
            lambda.eq(Messageboard::getBuserid,messageboard.getBuserid());
        }
        if(messageboard.getTitle()!=null){
            lambda.eq(Messageboard::getTitle,messageboard.getTitle());
        }
        if(messageboard.getContent()!=null){
            lambda.eq(Messageboard::getContent,messageboard.getContent());
        }

        List<Messageboard> messageboardList = messageboardDao.selectList(lambda);
        return messageboardList;
    }


    public boolean delete(Integer id){

        int i = messageboardDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Messageboard messageboard){

        int i = messageboardDao.updateById(messageboard);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 用户关联留言查询
     * */
     public List<MessageBoardAndBuser> findMessageBoardAboutBuser(){
         return messageboardAboutBuserDao.findMessageBoardAboutBuser();
     }

    /*
     * 模糊查询留言
     * */
    public List<MessageBoardAndBuser> findMessage(String message){
        return messageboardAboutBuserDao.findMessage(message);
    }

    /*
     * 查询留言
     * */
    public List<MessageBoardAndBuser> findMessageByBuserid(Integer buserid){
        return messageboardAboutBuserDao.findMessageByBuserid(buserid);
    }
}
