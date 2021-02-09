package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Notice;
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
public class AnimalsService {
    @Autowired
    private AnimalsDao animalsDao;

    /*
     * 添加
     * */
    public boolean insert(Animals animals){

        int i = animalsDao.insert(animals);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 查询
     * */
    public List<Animals> query(Animals animals){
        QueryWrapper<Animals> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Animals> lambda = queryWrapper.lambda();

        if(animals.getId()!=null){
            lambda.eq(Animals::getId,animals.getId());
        }
        if(animals.getAname()!=null){
            lambda.eq(Animals::getAname,animals.getAname());
        }
        if(animals.getSex()!=null){
            lambda.eq(Animals::getSex,animals.getSex());
        }
        if(animals.getAge()!=null){
            lambda.eq(Animals::getAge,animals.getAge());
        }
        if(animals.getAintroduce()!=null){
            lambda.le(Animals::getAintroduce,animals.getAintroduce());
        }
        if(animals.getAnimalsImage()!=null){
            lambda.ge(Animals::getAnimalsImage,animals.getAnimalsImage());
        }
        if(animals.getStatus()!=null){
            lambda.ge(Animals::getStatus,animals.getStatus());
        }
        if(animals.getPhoto1()!=null){
            lambda.ge(Animals::getPhoto1,animals.getPhoto1());
        }
        if(animals.getPhoto2()!=null){
            lambda.ge(Animals::getPhoto2,animals.getPhoto2());
        }
        if(animals.getPhoto3()!=null){
            lambda.ge(Animals::getPhoto3,animals.getPhoto3());
        }
        if(animals.getPhoto4()!=null){
            lambda.ge(Animals::getPhoto4,animals.getPhoto4());
        }
        if(animals.getPhoto5()!=null){
            lambda.ge(Animals::getPhoto5,animals.getPhoto5());
        }
        if(animals.getCreateTime()!=null){
            lambda.ge(Animals::getCreateTime,animals.getCreateTime());
        }
        if(animals.getWeight()!=null){
            lambda.ge(Animals::getWeight,animals.getWeight());
        }
        List<Animals> animalsList = animalsDao.selectList(lambda);
        return animalsList;
    }

   /* 根据姓名查询*/
    public Animals query(String aname){
        QueryWrapper<Animals> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Animals> lambda = queryWrapper.lambda();
        lambda.eq(Animals::getAname,aname);
        Animals animals = animalsDao.selectOne(lambda);
        return animals;
    }
    /*
    删除
    */
    public boolean delete(Integer id){

        int i = animalsDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
    更新
    */
    public boolean update(Animals animals){

        int i = animalsDao.updateById(animals);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 根据动物名进行模糊查询
     * */
    public List<Animals> findAnimalsByname(String aname){
        return animalsDao.findAnimalsByname(aname);
    }
}
