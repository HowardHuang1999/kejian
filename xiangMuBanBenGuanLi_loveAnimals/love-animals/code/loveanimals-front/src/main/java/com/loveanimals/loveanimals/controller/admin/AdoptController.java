package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Adopt;
import com.loveanimals.loveanimals.service.admin.AdoptService;
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
 * @create: 2020-09-26  下午 7:36
 **/
@Api(value = "/api/ado", description = "领养申请")
@CrossOrigin
@RestController
@RequestMapping("/api/ado")
public class AdoptController {
    @Autowired
    private AdoptService adoptService;

    @ApiOperation(value = "添加领养信息")
    @PostMapping("/check/add")
    public Map<String,Object> add(String name, String phone,String status, String address,String idcard, String introduce,Integer animalsid,String animalsphoto,String house,String unitname,String idphoto,String sex, String age,Integer buserid){
        Map<String,Object> map=new HashMap<>();
        if(name==null||phone==null||address==null||introduce==null||idcard==null||animalsid==null||unitname==null||sex==null||age==null){
            map.put("code","2020");
            map.put("msg","必填参数不能为空（name,phone,address,introduce,idcard,animalsid,unitname,sex,age）");
            map.put("data",null);
            return map;
        }
        Adopt adopt=new Adopt();
        adopt.setName(name);
        adopt.setPhone(phone);
        adopt.setAddress(address);
        adopt.setIdcard(idcard);
        adopt.setIntroduce(introduce);
        adopt.setCreateTime(new Date());
        adopt.setAnimalsid(animalsid);
        adopt.setHouse(house);
        adopt.setUnitname(unitname);
        adopt.setIdphoto(idphoto);
        adopt.setSex(sex);
        adopt.setAge(age);
        adopt.setStatus(status);
        adopt.setBuserid(buserid);

        boolean b = adoptService.insert(adopt);

        if(!b){
            map.put("code","2021");
            map.put("msg","动物id不存在，请核对并输入正确动物id");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","操作成功");
        map.put("data",null);
        return map;
    }

    @ApiOperation(value = "查询领养表")
    @GetMapping("/check/get")
    public Map<String,Object> get(Adopt adopt){
        Map<String,Object> map=new HashMap<>();

        List<Adopt> adoptList= adoptService.query(adopt);
        if(adoptList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",adoptList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",adoptList.size());
        map.put("data",adoptList);
        return map;
    }

    @ApiOperation(value = "删除领养表")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = adoptService.delete(id);
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

    @ApiOperation(value = "修改领养表")
    @PostMapping("/check/update")
    public Map<String,Object> update(Adopt adopt){
        Map<String,Object> map=new HashMap<>();

        if(adopt.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update =adoptService.update(adopt);
        if(!update){
            map.put("code","2021");
            map.put("msg","系统出错");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","success update:"+adopt.getId());
        map.put("data",null);
        return map;
    }
}
