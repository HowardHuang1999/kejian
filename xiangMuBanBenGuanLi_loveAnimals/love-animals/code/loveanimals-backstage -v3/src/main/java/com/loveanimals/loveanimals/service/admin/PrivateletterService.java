package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.PrivateletterDao;
import com.loveanimals.loveanimals.po.Privateletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  下午 2:41
 **/
@Service
@Transactional
public class PrivateletterService {

    @Autowired
    private PrivateletterDao privateletterDao;

    /*
     * 添加
     * */
    public boolean insert(Privateletter privateletter){

        int i = privateletterDao.insert(privateletter);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Privateletter> query(Privateletter privateletter){
        QueryWrapper<Privateletter> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Privateletter> lambda = queryWrapper.lambda();

        if(privateletter.getId()!=null){
            lambda.eq(Privateletter::getId,privateletter.getId());
        }
        if(privateletter.getBuserid()!=null){
            lambda.eq(Privateletter::getBuserid,privateletter.getBuserid());
        }
        if(privateletter.getContent()!=null){
            lambda.eq(Privateletter::getContent,privateletter.getContent());
        }
        if(privateletter.getCreatetime()!=null){
            lambda.eq(Privateletter::getCreatetime,privateletter.getCreatetime());
        }
        if(privateletter.getReadstatus()!=null){
            lambda.eq(Privateletter::getReadstatus,privateletter.getReadstatus());
        }


        List<Privateletter> privateletterList = privateletterDao.selectList(lambda);
        return privateletterList;
    }


    /*
    * 删除
    * */
    public boolean delete(Integer id){

        int i = privateletterDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
    * 修改
    * */
    public boolean update(Privateletter privateletter){

        int i = privateletterDao.updateById(privateletter);
        if(i<=0){
            return false;
        }
        else return true;
    }

}
