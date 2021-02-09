package com.loveanimals.loveanimals.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.BuserDao;
import com.loveanimals.loveanimals.dao.admin.MessageboardDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Buser;
import com.loveanimals.loveanimals.po.Messageboard;
import com.loveanimals.loveanimals.service.admin.BuserService;
import com.loveanimals.loveanimals.service.admin.MessageboardService;
import com.loveanimals.loveanimals.vo.MessageBoardAndBuser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-08  下午 2:11
 **/
@Api(value = "/api/messageboard", description = "留言板")
@CrossOrigin
@RestController
@RequestMapping("/api/messageboard")
public class MessageboardController {
    @Autowired
    MessageboardDao messageboardDao;

    @Autowired
    private MessageboardService messageboardService;

    /*
     * 添加
     * */
    @ApiOperation(value = "发布留言")
    @PostMapping("/check/publish")
    public Map<String,Object> add(Integer buserid,String title,String content){
        Map<String,Object> map=new HashMap<>();
        if(title==null||content==null){
            map.put("code","2020");
            map.put("msg","留言标题或内容不能为空");
            map.put("data",null);
            return map;
        }
        Messageboard messageboard=new Messageboard();
        messageboard.setBuserid(buserid);
        messageboard.setTitle(title);
        messageboard.setContent(content);
        messageboard.setCreateTime(new Date());

        boolean b = messageboardService.insert(messageboard);
        if(!b){
            map.put("code","2021");
            map.put("msg","发布失败");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","操作成功");
        map.put("data",null);
        return map;
    }


    @ApiOperation(value = "查询留言")
    @GetMapping("/get")
    public Map<String,Object> get(Messageboard messageboard){
        Map<String,Object> map=new HashMap<>();

        List<Messageboard> messageboardList= messageboardService.query(messageboard);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",messageboardList.size());
        map.put("data",messageboardList);
        return map;
    }


    @ApiOperation(value = "删除留言")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = messageboardService.delete(id);
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
    @ApiOperation(value = "修改留言")
    @PostMapping("/check/update")
    public Map<String,Object> update(Messageboard messageboard){
        Map<String,Object> map=new HashMap<>();

        if(messageboard.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = messageboardService.update(messageboard);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+messageboard.getId());
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "关联用户查询留言")
    @GetMapping("/getMessage")
    public Map<String,Object> getMessage(MessageBoardAndBuser messageBoardAndBuser){
        Map<String,Object> map=new HashMap<>();

        List<MessageBoardAndBuser> messageboardList= messageboardService.findMessageBoardAboutBuser();
        map.put("code","200");
        map.put("msg","success");
        map.put("count",messageboardList.size());
        map.put("data",messageboardList);
        return map;
    }

    /*
     * 模糊查询留言
     * */
    @ApiOperation(value = "模糊查询留言")
    @GetMapping("/getMessageVague")
    public Map<String,Object> getMessageVague(String message){
        Map<String,Object> map=new HashMap<>();

        List<MessageBoardAndBuser> messageboardList= messageboardService.findMessage(message);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",messageboardList.size());
        map.put("data",messageboardList);
        return map;
    }


    @ApiOperation(value = "根据用户id查询留言")
    @GetMapping("/check/getMessageBy")
    public Map<String,Object> getMessageBy(Integer buserid){
        Map<String,Object> map=new HashMap<>();

        List<MessageBoardAndBuser> messageboardList= messageboardService.findMessageByBuserid(buserid);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",messageboardList.size());
        map.put("data",messageboardList);
        return map;
    }

}
