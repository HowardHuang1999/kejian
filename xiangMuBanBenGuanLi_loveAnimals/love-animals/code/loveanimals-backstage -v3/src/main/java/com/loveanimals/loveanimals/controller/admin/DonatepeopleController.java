package com.loveanimals.loveanimals.controller.admin;

import com.alipay.api.AlipayApiException;
import com.loveanimals.loveanimals.config.pay.AliPayService;
import com.loveanimals.loveanimals.po.Adopt;
import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.Donatepeople;
import com.loveanimals.loveanimals.service.admin.AnimalsService;
import com.loveanimals.loveanimals.service.admin.DonatepeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-10-15  下午 2:35
 **/
@Api(value = "/api/donate", description = "爱心捐赠")
@CrossOrigin
@RestController
@RequestMapping("/api/donate")
public class DonatepeopleController {
    @Autowired
    private DonatepeopleService donatepeopleService;

    @Autowired
    AliPayService aliPayService;

    /*
     * 动物信息录入
     * */
    @ApiOperation(value = "添加捐赠者信息")
    @PostMapping("/check/add")
    public Map<String,Object> add(String name,String phone,String email,String message, String money,String moneyway,Integer buserid){
        Map<String,Object> map=new HashMap<>();
        if(name==null||money==null){
            map.put("code","2020");
            map.put("msg","必要不能为空（name,money）");
            map.put("data",null);
            return map;
        }
        Donatepeople donatepeople1=new Donatepeople();
        donatepeople1.setName(name);
        donatepeople1.setPhone(phone);
        donatepeople1.setEmail(email);
        donatepeople1.setMessage(message);
        donatepeople1.setMoney(money);
        donatepeople1.setMoneyway(moneyway);
        donatepeople1.setCreateTime(new Date());
        donatepeople1.setBuserid(buserid);

        boolean b = donatepeopleService.insert(donatepeople1);
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
    /*
    查询所有信息
    */
    @ApiOperation(value = "查询捐赠者信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Donatepeople donatepeople){
        Map<String,Object> map=new HashMap<>();

        List<Donatepeople> donatepeopleList= donatepeopleService.query(donatepeople);
        if(donatepeopleList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",donatepeopleList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",donatepeopleList.size());
        map.put("data",donatepeopleList);
        return map;
    }
    /*
    根据id删除
    */
    @ApiOperation(value = "根据id删除捐赠信息")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = donatepeopleService.delete(id);
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


    @ApiOperation(value = "修改捐赠者信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(Donatepeople donatepeople){
        Map<String,Object> map=new HashMap<>();

        if(donatepeople.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = false;
            update = donatepeopleService.update(donatepeople);
        if(!update){
            map.put("code","2021");
            map.put("msg","id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+donatepeople.getId());
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "根据用户id查询捐赠信息")
    @GetMapping("/check/getDonateBy")
    public Map<String,Object> getDonateBy(Integer buserid){
        Map<String,Object> map=new HashMap<>();

        List<Donatepeople> adoptList= donatepeopleService.findDonateByBuserid(buserid);
        map.put("code","200");
        map.put("msg","success");
        map.put("count",adoptList.size());
        map.put("data",adoptList);
        return map;
    }

}
