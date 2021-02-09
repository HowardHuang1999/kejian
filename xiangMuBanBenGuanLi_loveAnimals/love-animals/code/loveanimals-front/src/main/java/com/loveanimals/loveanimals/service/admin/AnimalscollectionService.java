package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalscollectionDao;
import com.loveanimals.loveanimals.dao.admin.HelpDao;
import com.loveanimals.loveanimals.po.Animalscollection;
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
public class AnimalscollectionService {
    @Autowired
    private AnimalscollectionDao animalscollectionDao;

    /*
     * 添加
     * */
    public boolean insert(Animalscollection animalscollection){

        int i = animalscollectionDao.insert(animalscollection);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Animalscollection> query(Animalscollection animalscollection){
        QueryWrapper<Animalscollection> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Animalscollection> lambda = queryWrapper.lambda();

        if(animalscollection.getId()!=null){
            lambda.eq(Animalscollection::getId,animalscollection.getId());
        }
        if(animalscollection.getBuserid()!=null){
            lambda.eq(Animalscollection::getBuserid,animalscollection.getBuserid());
        }
        if(animalscollection.getAnimalsid()!=null){
            lambda.eq(Animalscollection::getAnimalsid,animalscollection.getAnimalsid());
        }
        if(animalscollection.getCollection()!=null){
            lambda.eq(Animalscollection::getCollection,animalscollection.getCollection());
        }

        List<Animalscollection> animalscollectionList = animalscollectionDao.selectList(lambda);
        return animalscollectionList;
    }


    public boolean delete(Integer id){

        int i =animalscollectionDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

}
