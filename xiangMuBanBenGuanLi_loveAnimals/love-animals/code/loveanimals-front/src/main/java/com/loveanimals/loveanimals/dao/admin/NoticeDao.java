package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Auser;
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
public interface NoticeDao extends BaseMapper<Notice> {
    /*
     * 根据公告标题进行模糊查询
     * */
    List<Notice> findNoticeBytitle(String title);
}
