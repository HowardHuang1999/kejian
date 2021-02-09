package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.dao.admin.DonatepeopleDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Donatepeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-10-15  下午 2:41
 **/
@Service
@Transactional
public class DonatepeopleService {
    @Autowired
    private DonatepeopleDao donatepeopleDao;

    /*
     * 添加
     * */
    public boolean insert(Donatepeople donatepeople){

        int i = donatepeopleDao.insert(donatepeople);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 查询
     * */
    public List<Donatepeople> query(Donatepeople donatepeople){
        QueryWrapper<Donatepeople> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Donatepeople> lambda = queryWrapper.lambda();

        if(donatepeople.getId()!=null){
            lambda.eq(Donatepeople::getId,donatepeople.getId());
        }
        if(donatepeople.getName()!=null){
            lambda.eq(Donatepeople::getName,donatepeople.getName());
        }
        if(donatepeople.getPhone()!=null){
            lambda.eq(Donatepeople::getPhone,donatepeople.getPhone());
        }
        if(donatepeople.getEmail()!=null){
            lambda.eq(Donatepeople::getEmail,donatepeople.getEmail());
        }
        if(donatepeople.getMessage()!=null){
            lambda.eq(Donatepeople::getMessage,donatepeople.getMessage());
        }
        if(donatepeople.getMoney()!=null){
            lambda.eq(Donatepeople::getMoney,donatepeople.getMoney());
        }
        if(donatepeople.getMoneyway()!=null){
            lambda.eq(Donatepeople::getMoneyway,donatepeople.getMoneyway());
        }
        if(donatepeople.getCreateTime()!=null){
            lambda.ge(Donatepeople::getCreateTime,donatepeople.getCreateTime());
        }
        if(donatepeople.getBuserid()!=null){
            lambda.ge(Donatepeople::getBuserid,donatepeople.getBuserid());
        }
        List<Donatepeople> donatepeopleList = donatepeopleDao.selectList(lambda);
        return donatepeopleList;
    }

    /*
    删除
    */
    public boolean delete(Integer id){

        int i = donatepeopleDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
    更新
    */
    public boolean update(Donatepeople donatepeople){

        int i = donatepeopleDao.updateById(donatepeople);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public List<Donatepeople> findDonateByBuserid(Integer buserid){
        return donatepeopleDao.findDonateByBuserid(buserid);
    }
}
