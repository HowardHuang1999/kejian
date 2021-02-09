package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.JsonResult;
import com.loveanimals.loveanimals.service.admin.AnimalsService;
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
 * @create: 2020-09-23  下午 2:35
 **/
@Api(value = "/api/ani", description = "动物中心")
@CrossOrigin
@RestController
@RequestMapping("/api/ani")
@Slf4j
public class AnimalsController {
    @Autowired
    private AnimalsService animalsService;

    @Autowired
    private UploadService uploadService;
    /*
     * 动物信息录入
     * */
    @ApiOperation(value = "添加动物")
    @PostMapping("/check/add")
    public Map<String,Object> add(MultipartFile file_animalsImage, HttpServletRequest request, String status, String aname, String sex, String aintroduce, String age, String photo1, String photo2, String photo3, String photo4, String photo5, String weight){
        Map<String,Object> map=new HashMap<>();
        if(aname==null||aintroduce==null||sex==null||age==null){
            map.put("code","2020");
            map.put("msg","必要参数不能为空（aname,sex,age,aintroduce）");
            map.put("data",null);
            return map;
        }

        String animalsImage= null;
        try {
            JsonResult jsonResult=uploadService.uploadFile(file_animalsImage,request);
            animalsImage = String.valueOf(jsonResult.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Animals animals=new Animals();
        animals.setAname(aname);
        animals.setAnimalsImage(animalsImage);
        animals.setAintroduce(aintroduce);
        animals.setSex(sex);
        animals.setAge(age);
        animals.setStatus(status);
        animals.setCreateTime(new Date());
        animals.setPhoto1(photo1);
        animals.setPhoto2(photo2);
        animals.setPhoto3(photo3);
        animals.setPhoto4(photo4);
        animals.setPhoto5(photo5);
        animals.setWeight(weight);

        boolean b = animalsService.insert(animals);
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
    查询所有动物信息
    */
    @ApiOperation(value = "查询动物信息")
    @GetMapping("/get")
    public Map<String,Object> get(Animals animals){
        Map<String,Object> map=new HashMap<>();

        List<Animals> animalsList= animalsService.query(animals);
        if(animalsList.isEmpty()==true){
            map.put("code","201");
            map.put("msg","您输入的查询信息不存在，请核对后再尝试");
            map.put("data",animalsList);
            return map;
        }
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",animalsList.size());
        map.put("data",animalsList);
        return map;
    }
    /*
    根据id删除
    */
    @ApiOperation(value = "根据id删除动物")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = animalsService.delete(id);
        if(!delete){
            map.put("code","2021");
            map.put("msg","动物id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg","删除成功:"+id);
        map.put("data",null);
        return map;
    }


    @ApiOperation(value = "修改动物信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(Animals animals){
        Map<String,Object> map=new HashMap<>();

        if(animals.getId()==null){
            map.put("code","2021");
            map.put("msg","id不能为空");
            map.put("data",null);
            return map;
        }
        boolean update = false;
            update = animalsService.update(animals);
        if(!update){
            map.put("code","2021");
            map.put("msg","动物id不存在");
            map.put("data",null);
            return map;
        }
        map.put("code","200");
        map.put("msg"," 修改成功:"+animals.getId());
        map.put("data",null);
        return map;
    }

    /*
     * 根据动物名进行模糊查询
     * */
    @ApiOperation(value = "根据动物名进行模糊查询")
    @GetMapping("/getAnimals")
    public Map<String,Object> findAnaimals(String animalsname){
        Map<String,Object> map=new HashMap<>();

        List<Animals> animalsList= animalsService.findAnimalsByname(animalsname);
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",animalsList.size());
        map.put("data",animalsList);
        return map;
    }

}
