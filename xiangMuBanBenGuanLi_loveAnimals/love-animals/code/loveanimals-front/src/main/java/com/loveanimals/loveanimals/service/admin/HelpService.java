package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.dao.admin.HelpDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Help;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:41
 **/
@Service
@Transactional
public class HelpService {
    @Autowired
    private HelpDao helpDao;

    /*
     * 添加
     * */
    public boolean insert(Help help){

        int i = helpDao.insert(help);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Help> query(Help help){
        QueryWrapper<Help> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Help> lambda = queryWrapper.lambda();

        if(help.getId()!=null){
            lambda.eq(Help::getId,help.getId());
        }
        if(help.getName()!=null){
            lambda.eq(Help::getName,help.getName());
        }
        if(help.getPhone()!=null){
            lambda.ge(Help::getPhone,help.getPhone());
        }
        if(help.getAddress()!=null){
            lambda.ge(Help::getAddress,help.getAddress());
        }
        if(help.getIntroduce()!=null){
            lambda.ge(Help::getIntroduce,help.getIntroduce());
        }
        if(help.getIntroduce()!=null){
            lambda.ge(Help::getStatus,help.getStatus());
        }
        if(help.getCreateTime()!=null){
            lambda.ge(Help::getCreateTime,help.getCreateTime());
        }
        if(help.getPhoto1()!=null){
            lambda.eq(Help::getPhoto1,help.getPhoto1());
        }
        if(help.getPhoto2()!=null){
            lambda.eq(Help::getPhoto2,help.getPhoto2());
        }
        if(help.getPhoto3()!=null){
            lambda.eq(Help::getPhoto3,help.getPhoto3());
        }
        if(help.getBuserid()!=null){
            lambda.eq(Help::getBuserid,help.getBuserid());
        }
        List<Help> helpList = helpDao.selectList(lambda);
        return helpList;
    }


    public boolean delete(Integer id){

        int i =helpDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Help help){

        int i = helpDao.updateById(help);
        if(i<=0){
            return false;
        }
        else return true;
    }

}
