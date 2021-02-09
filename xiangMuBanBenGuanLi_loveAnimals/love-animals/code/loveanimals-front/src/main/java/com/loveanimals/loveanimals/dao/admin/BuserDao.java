package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Auser;
import com.loveanimals.loveanimals.po.Buser;
import com.loveanimals.loveanimals.po.Privateletter;
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
public interface BuserDao extends BaseMapper<Buser> {

    /*
    * 动物收藏
    * */
    List<Animals> findAnimalsCollection(Integer userid);

    /*
     * 私信推送
     * */
    List<Privateletter> findPrivateletter(Integer userid);

}
