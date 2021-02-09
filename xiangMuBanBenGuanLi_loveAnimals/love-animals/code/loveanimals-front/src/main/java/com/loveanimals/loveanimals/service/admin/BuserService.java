package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.dao.admin.AuserDao;
import com.loveanimals.loveanimals.dao.admin.BuserDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Auser;
import com.loveanimals.loveanimals.po.Buser;
import com.loveanimals.loveanimals.po.Privateletter;
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
public class BuserService {

    @Autowired
    private BuserDao buserDao;

    /*
     * 添加
     * */
    public boolean insert(Buser buser){

        int i = buserDao.insert(buser);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Buser> query(Buser buser){
        QueryWrapper<Buser> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Buser> lambda = queryWrapper.lambda();

        if(buser.getId()!=null){
            lambda.eq(Buser::getId,buser.getId());
        }
        if(buser.getBname()!=null){
            lambda.eq(Buser::getBname,buser.getBname());
        }
        if(buser.getBpwd()!=null){
            lambda.eq(Buser::getBpwd,buser.getBpwd());
        }
        if(buser.getHeadphoto()!=null){
            lambda.eq(Buser::getHeadphoto,buser.getHeadphoto());
        }
        if(buser.getStatus()!=null){
            lambda.eq(Buser::getStatus,buser.getStatus());
        }

        List<Buser> buserList = buserDao.selectList(lambda);
        return buserList;
    }


    public boolean delete(Integer id){

        int i = buserDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    public boolean update(Buser buser){

        int i = buserDao.updateById(buser);
        if(i<=0){
            return false;
        }
        else return true;
    }


    /*
     * 动物收藏
     * */
   public List<Animals> findAnimalsCollection(Integer buserid){
        return buserDao.findAnimalsCollection(buserid);
    }


    /*
     * 查询私信推送
     * */
    public List<Privateletter> findPrivateletter(Integer userid){
        return buserDao.findPrivateletter(userid);
    }
}
