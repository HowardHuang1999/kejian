package com.loveanimals.loveanimals.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AuserDao;
import com.loveanimals.loveanimals.po.Auser;
import com.loveanimals.loveanimals.po.JsonResult;
import com.loveanimals.loveanimals.service.admin.AuserService;
import com.loveanimals.loveanimals.service.admin.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-23  下午 2:11
 **/
@Api(value = "/api/user", description = "管理员中心")
@CrossOrigin
@RestController
@RequestMapping("/api/user")
@Slf4j
public class AuserController {
    @Autowired
    AuserDao auserDao;

    @Autowired
    private AuserService auserService;

    @Autowired
    private UploadService uploadService;


    @ApiOperation(value = "后台登录")
    @GetMapping("/login")
    public Map<String,Object> login(HttpServletRequest request, String username, String password){

        Map<String,Object> map=new HashMap<>();

        if(username==null||"".equals(username)||password==null||"".equals(password)){
            map.put("code","401");
            map.put("msg","账号密码不能为空!！！");
            map.put("data",null);
            return map;
        }
        //数据库取出
        try {
            QueryWrapper<Auser> queryWrapper = new QueryWrapper<>();
            LambdaQueryWrapper<Auser> lambda = queryWrapper.lambda();
            lambda.eq(Auser::getAname,username);        //先把用户名对应对象找出来
            Auser auser = auserDao.selectOne(lambda);    //根据lambda找出对象Auser
            if(password.equals(auser.getApwd())){            //比较密码是否一致
                request.getSession().setAttribute("aname",username);
            }else {
                map.put("code","200");
                map.put("msg","登陆失败，账号或密码错误");
                map.put("data",null);
                return map;
            }
        } catch (Exception e) {
            map.put("code","200");
            map.put("msg","登陆失败，账号或密码错误");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","成功登陆");
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "后台登出")
    @GetMapping("/logout")
    public Map<String,Object> logout(HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("aname");
        Map<String,Object> map=new HashMap<>();
        if(username==null){
            map.put("code","402");
            map.put("msg","未登录，无法退出账号");
            map.put("data",null);
            return map;
        }
        request.getSession().removeAttribute("aname");
        map.put("code","200");
        map.put("msg","成功退出");
        map.put("data",null);
        return map;
    }



    /*
     * 添加管理员
     * */
    @ApiOperation(value = "添加管理员")
    @PostMapping("/check/add")
    public Map<String,Object> add(String aname, String apwd, String name, String idcard, MultipartFile photo,HttpServletRequest request, String status, String address){
        Map<String,Object> map=new HashMap<>();
        if(aname==null||apwd==null||name==null||idcard==null||address==null){
            map.put("code","2020");
            map.put("msg","必要参数不能为空(aname,apwd,name,idcard,address)");
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

        Auser auser=new Auser();
        auser.setAname(aname);
        auser.setApwd(apwd);
        auser.setName(name);
        auser.setAddress(address);
        auser.setStatus(status);
        auser.setPhoto(image);
        auser.setIdcard(idcard);

        boolean b = auserService.insert(auser);
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
    @ApiOperation(value = "查询管理员")
    @GetMapping("/check/get")
    public Map<String,Object> get(Auser auser){
        Map<String,Object> map=new HashMap<>();

        List<Auser> auserList= auserService.query(auser);
        if(auserList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",auserList);
            return map;
        }
        map.put("code","200");
        map.put("msg","success");
        map.put("count",auserList.size());
        map.put("data",auserList);
        return map;
    }
    @ApiOperation(value = "删除管理员")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = auserService.delete(id);
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
    @ApiOperation(value = "修改管理员")
    @PostMapping("/check/update")
    public Map<String,Object> update(Auser auser){
        Map<String,Object> map=new HashMap<>();

        if(auser.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = auserService.update(auser);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+auser.getId());
        map.put("data",null);
        return map;
    }


}
