package com.loveanimals.loveanimals.dao.admin;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.loveanimals.loveanimals.po.Messageboard;
import com.loveanimals.loveanimals.vo.MessageBoardAndBuser;
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
public interface MessageboardAboutBuserDao extends BaseMapper<MessageBoardAndBuser> {

    /*
    * 用户关联留言查询
    * */
    List<MessageBoardAndBuser> findMessageBoardAboutBuser();

    /*
     * 模糊查询留言
     * */
    List<MessageBoardAndBuser> findMessage(String message);

    /*
     * 查询留言
     * */
    List<MessageBoardAndBuser> findMessageByBuserid(Integer buserid);
}
