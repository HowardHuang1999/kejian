package com.loveanimals.loveanimals.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.BuserDao;
import com.loveanimals.loveanimals.dao.admin.PrivateletterDao;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Buser;
import com.loveanimals.loveanimals.po.JsonResult;
import com.loveanimals.loveanimals.po.Privateletter;
import com.loveanimals.loveanimals.service.admin.BuserService;
import com.loveanimals.loveanimals.service.admin.PrivateletterService;
import com.loveanimals.loveanimals.service.admin.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  下午 2:11
 **/
@Api(value = "/api/letter", description = "用户私信推送")
@CrossOrigin
@RestController
@RequestMapping("/api/letter")
@Slf4j
public class PrivateletterController {
    @Autowired
    PrivateletterService privateletterService;

    /*
     * 用户注册
     * */
    @ApiOperation(value = "推送私信给用户")
    @PostMapping("/check/push")
    public Map<String,Object> add(Integer buserid, String content, String readstatus){
        Map<String,Object> map=new HashMap<>();
        if(buserid==null||content==null){
            map.put("code","2020");
            map.put("msg","参数不能为空");
            map.put("data",null);
            return map;
        }

        Privateletter privateletter=new Privateletter();
        privateletter.setBuserid(buserid);
        privateletter.setContent(content);
        privateletter.setCreatetime(new Date());
        privateletter.setReadstatus(readstatus);

        boolean b = privateletterService.insert(privateletter);
        if(!b){
            map.put("code","2021");
            map.put("msg","添加失败，请核对参数类型是否正确");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","操作成功");
        map.put("data",privateletter);
        return map;
    }


    @ApiOperation(value = "查询推送信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Privateletter privateletter){
        Map<String,Object> map=new HashMap<>();

        List<Privateletter> privateletterList= privateletterService.query(privateletter);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",privateletterList.size());
        map.put("data",privateletterList);
        return map;
    }
    @ApiOperation(value = "删除推送信息")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = privateletterService.delete(id);
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


    @ApiOperation(value = "修改推送信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(Privateletter privateletter){
        Map<String,Object> map=new HashMap<>();

        if(privateletter.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = privateletterService.update(privateletter);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+privateletter.getId());
        map.put("data",null);
        return map;
    }

}
