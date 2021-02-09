package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.Adopt;
import com.loveanimals.loveanimals.po.Donatepeople;
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
public interface DonatepeopleDao extends BaseMapper<Donatepeople> {
    List<Donatepeople> findDonateByBuserid(Integer buserid);
}
