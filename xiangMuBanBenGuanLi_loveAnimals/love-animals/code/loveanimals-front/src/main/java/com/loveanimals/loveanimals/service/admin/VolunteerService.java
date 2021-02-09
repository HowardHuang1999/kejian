package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.dao.admin.VolunteerDao;
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
public class VolunteerService {

    @Autowired
    private VolunteerDao volunteerDao;

    /*
     * 添加
     * */
    public boolean insert(Volunteer volunteer){

        int i = volunteerDao.insert(volunteer);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 查询
     * */
    public List<Volunteer> query(Volunteer volunteer){
        QueryWrapper<Volunteer> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Volunteer> lambda = queryWrapper.lambda();

        if(volunteer.getId()!=null){
            lambda.eq(Volunteer::getId,volunteer.getId());
        }
        if(volunteer.getVname()!=null){
            lambda.eq(Volunteer::getVname,volunteer.getVname());
        }
        if(volunteer.getVaddress()!=null){
            lambda.ge(Volunteer::getVaddress,volunteer.getVaddress());
        }
        if(volunteer.getVphone()!=null){
            lambda.le(Volunteer::getVphone,volunteer.getVphone());
        }
        if(volunteer.getVintroduce()!=null){
            lambda.ge(Volunteer::getVintroduce,volunteer.getVintroduce());
        }
        if(volunteer.getCreateTime()!=null){
            lambda.ge(Volunteer::getCreateTime,volunteer.getCreateTime());
        }
        if(volunteer.getEmail()!=null){
            lambda.eq(Volunteer::getEmail,volunteer.getEmail());
        }
        if(volunteer.getSex()!=null){
            lambda.eq(Volunteer::getSex,volunteer.getSex());
        }
        if(volunteer.getAge()!=null){
            lambda.eq(Volunteer::getAge,volunteer.getAge());
        }
        if(volunteer.getImage()!=null){
            lambda.eq(Volunteer::getImage,volunteer.getImage());
        }
        if(volunteer.getStatus()!=null){
            lambda.eq(Volunteer::getStatus,volunteer.getStatus());
        }
        if(volunteer.getCreateTime()!=null){
            lambda.eq(Volunteer::getCreateTime,volunteer.getCreateTime());
        }
        if(volunteer.getBuserid()!=null){
            lambda.eq(Volunteer::getBuserid,volunteer.getBuserid());
        }
        List<Volunteer> volunteerList = volunteerDao.selectList(lambda);
        return volunteerList;
    }

    public boolean delete(Integer id){

        int i = volunteerDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Volunteer volunteer){

        int i = volunteerDao.updateById(volunteer);
        if(i<=0){
            return false;
        }
        else return true;
    }
}
