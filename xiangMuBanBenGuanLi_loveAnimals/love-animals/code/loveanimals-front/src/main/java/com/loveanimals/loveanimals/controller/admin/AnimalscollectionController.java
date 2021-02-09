package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Animalscollection;
import com.loveanimals.loveanimals.po.Help;
import com.loveanimals.loveanimals.service.admin.AnimalscollectionService;
import com.loveanimals.loveanimals.service.admin.HelpService;
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
@Api(value = "/api/collection", description = "动物收藏")
@CrossOrigin
@RestController
@RequestMapping("/api/collection")
public class AnimalscollectionController {

    @Autowired
    private AnimalscollectionService animalscollectionService;

    /*
     * 添加收藏
     * */
    @ApiOperation(value = "添加收藏")
    @PostMapping("/check/add")
    public Map<String,Object> add(Integer buserid,Integer animalsid,String collection){
        Map<String,Object> map=new HashMap<>();
        if(buserid==null||animalsid==null||collection==null){
            map.put("code","2020");
            map.put("msg","必要参数不能为空");
            map.put("data",null);
            return map;
        }
        Animalscollection animalscollection=new Animalscollection();
        animalscollection.setBuserid(buserid);
        animalscollection.setAnimalsid(animalsid);
        animalscollection.setCollection(collection);

        boolean b = animalscollectionService.insert(animalscollection);
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

    @ApiOperation(value = "查询收藏信息")
    @GetMapping("/check/get")
    public Map<String,Object> get(Animalscollection animalscollection){
        Map<String,Object> map=new HashMap<>();

        List<Animalscollection> animalscollectionList=animalscollectionService.query(animalscollection);
        if(animalscollectionList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",animalscollectionList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",animalscollectionList.size());
        map.put("data",animalscollectionList);
        return map;
    }

    @ApiOperation(value = "取消收藏")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = animalscollectionService.delete(id);
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

}
