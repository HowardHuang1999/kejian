package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AuserDao;
import com.loveanimals.loveanimals.po.Auser;
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
public class AuserService {

    @Autowired
    private AuserDao auserDao;

    /*
     * 添加
     * */
    public boolean insert(Auser auser){

        int i = auserDao.insert(auser);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Auser> query(Auser auser){
        QueryWrapper<Auser> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Auser> lambda = queryWrapper.lambda();

        if(auser.getId()!=null){
            lambda.eq(Auser::getId,auser.getId());
        }
        if(auser.getAname()!=null){
            lambda.eq(Auser::getAname,auser.getAname());
        }
        if(auser.getApwd()!=null){
            lambda.eq(Auser::getApwd,auser.getApwd());
        }
        if(auser.getName()!=null){
            lambda.eq(Auser::getName,auser.getName());
        }
        if(auser.getAddress()!=null){
            lambda.eq(Auser::getAddress,auser.getAddress());
        }
        if(auser.getStatus()!=null){
            lambda.eq(Auser::getStatus,auser.getStatus());
        }
        if(auser.getPhoto()!=null){
            lambda.eq(Auser::getPhoto,auser.getPhoto());
        }
        if(auser.getIdcard()!=null){
            lambda.eq(Auser::getIdcard,auser.getIdcard());
        }
        List<Auser> auserList = auserDao.selectList(lambda);
        return auserList;
    }


    public boolean delete(Integer id){

        int i = auserDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Auser auser){

        int i = auserDao.updateById(auser);
        if(i<=0){
            return false;
        }
        else return true;
    }
}
