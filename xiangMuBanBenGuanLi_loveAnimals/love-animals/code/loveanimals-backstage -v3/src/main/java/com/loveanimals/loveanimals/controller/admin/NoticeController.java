package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Notice;
import com.loveanimals.loveanimals.service.admin.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:35
 **/
@Api(value = "/api/not", description = "公告中心")
@CrossOrigin
@RestController
@RequestMapping("/api/not")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /*
     * 公告发布
     * */
    @ApiOperation(value = "发布公告")
    @PostMapping("/check/add")
    public Map<String,Object> add(String status,String ntitle, String ncontent,String photo1,String photo2,String photo3,String photo4,String photo5){
        Map<String,Object> map=new HashMap<>();
        if(ntitle==null||ncontent==null){
            map.put("code","2020");
            map.put("msg","参数不能为空");
            map.put("data",null);
            return map;
        }
        Notice notice=new Notice();
        notice.setNtitle(ntitle);
        notice.setNcontent(ncontent);
        notice.setCreateTime(new Date());
        notice.setStatus(status);
        notice.setPhoto1(photo1);
        notice.setPhoto2(photo2);
        notice.setPhoto3(photo3);
        notice.setPhoto4(photo4);
        notice.setPhoto5(photo5);

        boolean b = noticeService.insert(notice);
        if(!b){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","操作成功");
        map.put("data",null);
        return map;
    }


    @ApiOperation(value = "查询公告")
    @GetMapping("/get")
    public Map<String,Object> get(Notice notice){
        Map<String,Object> map=new HashMap<>();

        List<Notice> noticeList= noticeService.query(notice);
        if(noticeList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",noticeList);
            return map;
        }
        map.put("code","200");
        map.put("msg","success");
        map.put("count",noticeList.size());
        map.put("data",noticeList);
        return map;
    }

    @ApiOperation(value = "删除公告")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = noticeService.delete(id);
        if(!delete){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success delete:"+id);
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "修改公告")
    @PostMapping("/check/update")
    public Map<String,Object> update(Notice notice){
        Map<String,Object> map=new HashMap<>();

        if(notice.getId()==null){
            map.put("code","2021");
            map.put("msg","pid不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = noticeService.update(notice);
        if(!update){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+notice.getId());
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "根据公告标题进行模糊查询")
    @GetMapping("/findNotice")
    public Map<String,Object> findNotice(String title){
        Map<String,Object> map=new HashMap<>();

        List<Notice> noticeList= noticeService.findNoticeBytitle(title);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",noticeList.size());
        map.put("data",noticeList);
        return map;
    }
}
