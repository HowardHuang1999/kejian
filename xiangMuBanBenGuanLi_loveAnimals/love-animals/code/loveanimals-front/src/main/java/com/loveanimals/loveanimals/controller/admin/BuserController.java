package com.loveanimals.loveanimals.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.loveanimals.loveanimals.dao.admin.AuserDao;
import com.loveanimals.loveanimals.dao.admin.BuserDao;
import com.loveanimals.loveanimals.po.*;
import com.loveanimals.loveanimals.service.admin.AuserService;
import com.loveanimals.loveanimals.service.admin.BuserService;
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
@Api(value = "/api/buser", description = "注册用户管理中心")
@CrossOrigin
@RestController
@RequestMapping("/api/buser")
@Slf4j
public class BuserController {
    @Autowired
    BuserDao buserDao;

    @Autowired
    private UploadService uploadService;

    @ApiOperation(value = "用户登录")
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
            QueryWrapper<Buser> queryWrapper = new QueryWrapper<>();
            LambdaQueryWrapper<Buser> lambda = queryWrapper.lambda();
            lambda.eq(Buser::getBname,username);        //先把用户名对应对象找出来
            Buser buser = buserDao.selectOne(lambda);    //根据lambda找出对象Auser
            if(password.equals(buser.getBpwd())){            //比较密码是否一致
                request.getSession().setAttribute("bname",username);
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

    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public Map<String,Object> logout(HttpServletRequest request){
        String username = (String)request.getSession().getAttribute("bname");
        Map<String,Object> map=new HashMap<>();
        if(username==null){
            map.put("code","402");
            map.put("msg","未登录，无法退出账号");
            map.put("data",null);
            return map;
        }
        request.getSession().removeAttribute("bname");
        map.put("code","200");
        map.put("msg","成功退出");
        map.put("data",null);
        return map;
    }




    @Autowired
    private BuserService buserService;
    /*
     * 用户注册
     * */
    @ApiOperation(value = "用户注册")
    @PostMapping("/check/register")
    public Map<String,Object> add(String bname,String bpwd,MultipartFile headphoto,HttpServletRequest request,String status){
        Map<String,Object> map=new HashMap<>();
        if(bname==null||bpwd==null){
            map.put("code","2020");
            map.put("msg","账号密码不能为空");
            map.put("data",null);
            return map;
        }


        String image= null;
        try {
            JsonResult jsonResult=uploadService.uploadFile(headphoto,request);
            image = String.valueOf(jsonResult.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Buser buser=new Buser();
        buser.setBname(bname);
        buser.setBpwd(bpwd);
        buser.setHeadphoto(image);

        boolean b = buserService.insert(buser);
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
    @ApiOperation(value = "查询注册用户信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Buser buser){
        Map<String,Object> map=new HashMap<>();

        List<Buser> buserList= buserService.query(buser);
        if(buserList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",buserList);
            return map;
        }
        map.put("code","200");
        map.put("msg","success");
        map.put("count",buserList.size());
        map.put("data",buserList);
        return map;
    }
    @ApiOperation(value = "删除注册用户")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = buserService.delete(id);
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
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(Buser buser){
        Map<String,Object> map=new HashMap<>();

        if(buser.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = buserService.update(buser);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+buser.getId());
        map.put("data",null);
        return map;
    }


    @ApiOperation(value = "查看我的收藏动物")
    @PostMapping("/check/getcollection")
    public Map<String,Object> getanimalscollection(Integer buserid){
        Map<String,Object> map=new HashMap<>();

        List<Animals> animalsList= buserService.findAnimalsCollection(buserid);

        map.put("code","200");
        map.put("msg","success");
        map.put("count",animalsList.size());
        map.put("data",animalsList);
        return map;
    }

    @ApiOperation(value = "查看我的私信推送")
    @PostMapping("/check/getprivateletter")
    public Map<String,Object> getprivateletter(Integer buserid){
        Map<String,Object> map=new HashMap<>();

        List<Privateletter> privateletterList= buserService.findPrivateletter(buserid);

        map.put("code","200");
        map.put("msg","success");
        map.put("count",privateletterList.size());
        map.put("data",privateletterList);
        return map;
    }
}
