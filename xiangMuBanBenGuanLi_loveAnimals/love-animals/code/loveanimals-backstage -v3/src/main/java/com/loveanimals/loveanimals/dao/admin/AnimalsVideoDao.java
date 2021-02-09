package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.AnimalsVideo;
import com.loveanimals.loveanimals.po.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:14
 **/
@Repository
@Mapper
public interface AnimalsVideoDao extends BaseMapper<AnimalsVideo> {
    /*
    * 根据标题和视频简介模糊搜索
    * */
    List<AnimalsVideo> findAnimalsVideoByTitle(String content);
}
