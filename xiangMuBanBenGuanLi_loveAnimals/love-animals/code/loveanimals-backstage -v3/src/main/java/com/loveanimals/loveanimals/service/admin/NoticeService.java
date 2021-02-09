package com.loveanimals.loveanimals.service.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.NoticeDao;
import com.loveanimals.loveanimals.po.Notice;
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
public class NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    /*
     * 添加
     * */
    public boolean insert(Notice notice){

        int i = noticeDao.insert(notice);
        if(i<=0){
            return false;
        }
        else return true;
    }
    /*
     * 查询
     * */
    public List<Notice> query(Notice notice){
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<Notice> lambda = queryWrapper.lambda();

        if(notice.getId()!=null){
            lambda.ge(Notice::getId,notice.getId());
        }
        if(notice.getNtitle()!=null){
            lambda.eq(Notice::getNtitle,notice.getNtitle());
        }
        if(notice.getNcontent()!=null){
            lambda.ge(Notice::getNcontent,notice.getNcontent());
        }
        if(notice.getCreateTime()!=null){
            lambda.le(Notice::getCreateTime,notice.getCreateTime());
        }
        if(notice.getStatus()!=null){
            lambda.ge(Notice::getStatus,notice.getStatus());
        }
        if(notice.getPhoto1()!=null){
            lambda.ge(Notice::getPhoto1,notice.getPhoto1());
        }
        if(notice.getPhoto2()!=null){
            lambda.ge(Notice::getPhoto2,notice.getPhoto2());
        }
        if(notice.getPhoto3()!=null){
            lambda.ge(Notice::getPhoto3,notice.getPhoto3());
        }
        if(notice.getPhoto4()!=null){
            lambda.ge(Notice::getPhoto4,notice.getPhoto4());
        }
        if(notice.getPhoto5()!=null){
            lambda.ge(Notice::getPhoto5,notice.getPhoto5());
        }
        List<Notice> noticeList = noticeDao.selectList(lambda);
        return noticeList;
    }

    /*
    删除
    */
    public boolean delete(Integer id){

        int i = noticeDao.deleteById(id);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
    更新
    */
    public boolean update(Notice notice){

        int i = noticeDao.updateById(notice);
        if(i<=0){
            return false;
        }
        else return true;
    }

    /*
     * 根据公告标题进行模糊查询
     * */
    public List<Notice> findNoticeBytitle(String title){
        return noticeDao.findNoticeBytitle(title);
    }
}
