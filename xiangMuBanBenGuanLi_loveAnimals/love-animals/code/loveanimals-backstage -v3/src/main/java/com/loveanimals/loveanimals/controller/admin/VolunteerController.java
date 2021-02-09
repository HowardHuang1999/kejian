package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.JsonResult;
import com.loveanimals.loveanimals.po.Volunteer;
import com.loveanimals.loveanimals.service.admin.UploadService;
import com.loveanimals.loveanimals.service.admin.VolunteerService;
import com.loveanimals.loveanimals.vo.MessageBoardAndBuser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:35
 **/
@Api(value = "/api/vol", description = "志愿者中心")
@CrossOrigin
@RestController
@RequestMapping("/api/vol")
@Slf4j
public class VolunteerController {
    @Autowired
    private VolunteerService volunteerService;

    @Autowired
    private UploadService uploadService;


    @ApiOperation(value = "添加志愿者")
    @PostMapping("/check/add")
   /* @ApiImplicitParams({
            @ApiImplicitParam(name = "vname",value = "姓名"),
            @ApiImplicitParam(name = "vphone",value = "电话")
    })*/
    public Map<String,Object> add(String vname,String status, String vphone, String vaddress,String vintroduce,String email,String sex,String age,MultipartFile photo,HttpServletRequest request,Integer buserid){
        Map<String,Object> map=new HashMap<>();
        if(vname==null||vphone==null||vaddress==null||vintroduce==null||email==null||sex==null||age==null){
            map.put("code","2020");
            map.put("msg","必要参数不能为空（vname,vphone,vaddress,vintroduce,email,sex,age）");
            map.put("data",null);
            return map;
        }

        String image= null;
        try {
            JsonResult jsonResult=uploadService.uploadFile(photo,request);
            image = String.valueOf(jsonResult.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Volunteer volunteer=new Volunteer();
        volunteer.setVname(vname);
        volunteer.setVphone(vphone);
        volunteer.setVaddress(vaddress);
        volunteer.setVintroduce(vintroduce);
        volunteer.setCreateTime(new Date());
        volunteer.setEmail(email);
        volunteer.setAge(age);
        volunteer.setSex(sex);
        volunteer.setImage(image);
        volunteer.setStatus(status);
        volunteer.setBuserid(buserid);

        boolean b =volunteerService.insert(volunteer);
        if(!b){
            map.put("code","2021");
            map.put("msg","添加失败");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","添加成功");
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "查询志愿者")
    @GetMapping("/check/get")
    public Map<String,Object> get(Volunteer volunteer){
        Map<String,Object> map=new HashMap<>();

        List<Volunteer> volunteerList= volunteerService.query(volunteer);
        if(volunteerList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",volunteerList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",volunteerList.size());
        map.put("data",volunteerList);
        return map;
    }

    @ApiOperation(value = "删除志愿者")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = volunteerService.delete(id);
        if(!delete){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","删除成功:"+id);
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "修改志愿者")
    @PostMapping("/check/update")
    public Map<String,Object> update(Volunteer volunteer){
        Map<String,Object> map=new HashMap<>();

        if(volunteer.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update =volunteerService.update(volunteer);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","修改成功:"+volunteer.getId());
        map.put("data",null);
        return map;
    }


    @ApiOperation(value = "根据用户id查询志愿申请记录")
    @GetMapping("/check/getVolunteerBy")
    public Map<String,Object> getVolunteerBy(Integer buserid){
        Map<String,Object> map=new HashMap<>();

        List<Volunteer> volunteerList= volunteerService.findVolunteerByBuserid(buserid);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",volunteerList.size());
        map.put("data",volunteerList);
        return map;
    }
}
