package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Help;
import com.loveanimals.loveanimals.service.admin.HelpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:35
 **/
@Api(value = "/api/help", description = "救助中心")
@CrossOrigin
@RestController
@RequestMapping("/api/help")
public class HelpController {

    @Autowired
    private HelpService helpService;

    /*
     * 救助信息录入
     * */
    @ApiOperation(value = "添加救助信息")
    @PostMapping("/check/add")
    public Map<String,Object> add(String name,String phone, String introduce, String address,String status,String photo1,String photo2,String photo3,Integer buserid){
        Map<String,Object> map=new HashMap<>();
        if(phone==null||name==null||introduce==null||address==null){
            map.put("code","2020");
            map.put("msg","必要参数不能为空（name，phone,introduce,address）");
            map.put("data",null);
            return map;
        }
        Help help=new Help();
        help.setName(name);
        help.setPhone(phone);
        help.setIntroduce(introduce);
        help.setAddress(address);
        help.setCreateTime(new Date());
        help.setStatus(status);
        help.setPhoto1(photo1);
        help.setPhoto2(photo2);
        help.setPhoto3(photo3);
        help.setBuserid(buserid);

        boolean b = helpService.insert(help);
        if(!b){
            map.put("code","2021");
            map.put("msg","添加失败，请核对参数类型是否正确");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","操作成功");
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "查询救助信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Help help){
        Map<String,Object> map=new HashMap<>();

        List<Help> helpList=helpService.query(help);
        if(helpList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",helpList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",helpList.size());
        map.put("data",helpList);
        return map;
    }

    @ApiOperation(value = "删除救助信息")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = helpService.delete(id);
        if(!delete){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success delete:"+id);
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "修改救助信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(Help help){
        Map<String,Object> map=new HashMap<>();

        if(help.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = helpService.update(help);
        if(!update){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+help.getId());
        map.put("data",null);
        return map;
    }

}
