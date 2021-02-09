package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Auser;
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
public interface AnimalsDao extends BaseMapper<Animals> {
    /*
     * 根据动物名进行模糊查询
     * */
    List<Animals> findAnimalsByname(String aname);
}
