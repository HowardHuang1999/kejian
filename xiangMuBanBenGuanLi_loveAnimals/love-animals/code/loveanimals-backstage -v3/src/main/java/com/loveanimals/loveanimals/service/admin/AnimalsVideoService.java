package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AnimalsDao;
import com.loveanimals.loveanimals.dao.admin.AnimalsVideoDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.AnimalsVideo;
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
public class AnimalsVideoService {
    @Autowired
    private AnimalsVideoDao animalsDao;

    /*
     * 添加
     * */
    public boolean insert(AnimalsVideo animalsVideo){

        int i = animalsDao.insert(animalsVideo);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 查询
     * */
    public List<AnimalsVideo> query(AnimalsVideo animals){
        QueryWrapper<AnimalsVideo> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<AnimalsVideo> lambda = queryWrapper.lambda();

        if(animals.getId()!=null){
            lambda.eq(AnimalsVideo::getId,animals.getId());
        }
        if(animals.getTitle()!=null){
            lambda.eq(AnimalsVideo::getTitle,animals.getTitle());
        }
        if(animals.getIntroduce()!=null){
            lambda.eq(AnimalsVideo::getIntroduce,animals.getIntroduce());
        }
        if(animals.getVideo()!=null){
            lambda.eq(AnimalsVideo::getVideo,animals.getVideo());
        }
        if(animals.getPic()!=null){
            lambda.eq(AnimalsVideo::getPic,animals.getPic());
        }
        if(animals.getCreateTime()!=null){
            lambda.eq(AnimalsVideo::getCreateTime,animals.getCreateTime());
        }
        if(animals.getStatus()!=null){
            lambda.ge(AnimalsVideo::getStatus,animals.getStatus());
        }
        List<AnimalsVideo> animalsList = animalsDao.selectList(lambda);
        return animalsList;
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
    public boolean update(AnimalsVideo animals){

        int i = animalsDao.updateById(animals);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 根据标题和视频简介模糊搜索
     * */
    public List<AnimalsVideo> findAnimalsVideoByTitle(String content){
        return animalsDao.findAnimalsVideoByTitle(content);
    }
}
