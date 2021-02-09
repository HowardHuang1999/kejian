package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AdoptDao;
import com.loveanimals.loveanimals.po.Adopt;
import com.loveanimals.loveanimals.po.Volunteer;
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
public class AdoptService {
    @Autowired
    private AdoptDao adoptDao;

    /*
     * 添加
     * */
    public boolean insert(Adopt adopt){

        int i = adoptDao.insert(adopt);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 查询
     * */
    public List<Adopt> query(Adopt adopt){
        QueryWrapper<Adopt> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Adopt> lambda = queryWrapper.lambda();

        if(adopt.getId()!=null){
            lambda.eq(Adopt::getId,adopt.getId());
        }
        if(adopt.getHouse()!=null){
            lambda.eq(Adopt::getHouse,adopt.getHouse());
        }
        if(adopt.getAnimalsphoto()!=null){
            lambda.eq(Adopt::getAnimalsphoto,adopt.getAnimalsphoto());
        }
        if(adopt.getUnitname()!=null){
            lambda.eq(Adopt::getUnitname,adopt.getUnitname());
        }
        if(adopt.getIdphoto()!=null){
            lambda.eq(Adopt::getIdphoto,adopt.getIdphoto());
        }
        if(adopt.getName()!=null){
            lambda.eq(Adopt::getName,adopt.getName());
        }
        if(adopt.getPhone()!=null){
            lambda.eq(Adopt::getPhone,adopt.getPhone());
        }
        if(adopt.getAddress()!=null){
            lambda.eq(Adopt::getAddress,adopt.getAddress());
        }
        if(adopt.getIdcard()!=null){
            lambda.eq(Adopt::getIdcard,adopt.getIdcard());
        }
        if(adopt.getIntroduce()!=null){
            lambda.eq(Adopt::getIntroduce,adopt.getIntroduce());
        }
        if(adopt.getAnimalsid()!=null){
            lambda.eq(Adopt::getAnimalsid,adopt.getAnimalsid());
        }
        if(adopt.getStatus()!=null){
            lambda.eq(Adopt::getStatus,adopt.getStatus());
        }
        if(adopt.getCreateTime()!=null){
            lambda.eq(Adopt::getCreateTime,adopt.getCreateTime());
        }
        if(adopt.getBuserid()!=null){
            lambda.eq(Adopt::getBuserid,adopt.getBuserid());
        }
        List<Adopt> adoptList = adoptDao.selectList(lambda);
        return adoptList;
    }

    public boolean delete(Integer id){

        int i = adoptDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Adopt adopt){

        int i = adoptDao.updateById(adopt);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public List<Adopt> findAdoptByBuserid(Integer buserid){
        return adoptDao.findAdoptByBuserid(buserid);
    }
}
