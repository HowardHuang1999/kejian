package com.loveanimals.loveanimals.controller.admin;

import com.loveanimals.loveanimals.po.Animals;
import com.loveanimals.loveanimals.po.AnimalsVideo;
import com.loveanimals.loveanimals.po.JsonResult;
import com.loveanimals.loveanimals.service.admin.AnimalsService;
import com.loveanimals.loveanimals.service.admin.AnimalsVideoService;
import com.loveanimals.loveanimals.service.admin.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @create: 2020-09-23  下午 2:35
 **/
@Api(value = "/api/video", description = "视频媒体中心")
@CrossOrigin
@RestController
@RequestMapping("/api/video")
@Slf4j
public class AnimalsVideoController {
    @Autowired
    private AnimalsVideoService animalsService;

    @Autowired
    private UploadService uploadService;
    /*
     * 视频信息导入
     * */
    @ApiOperation(value = "添加视频信息")
    @PostMapping("/check/add")
    public Map<String,Object> add(MultipartFile file_animalsVideo,MultipartFile file_animalsImage, HttpServletRequest request, String status, String title,String introduce){
        Map<String,Object> map=new HashMap<>();
        if(title==null){
            map.put("code","2020");
            map.put("msg","标题不能为空");
            map.put("data",null);
            return map;
        }

        String animalsVideo= null;
        String animalsImage= null;
        try {
            JsonResult jsonResult=uploadService.uploadFile(file_animalsVideo,request);
            JsonResult jsonResult2=uploadService.uploadFile(file_animalsImage,request);
            animalsVideo = String.valueOf(jsonResult.getData());
            animalsImage = String.valueOf(jsonResult2.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }

        AnimalsVideo animals=new AnimalsVideo();
        animals.setTitle(title);
        animals.setIntroduce(introduce);
        animals.setVideo(animalsVideo);
        animals.setPic(animalsImage);
        animals.setStatus(status);
        animals.setCreateTime(new Date());

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
    查询所有视频信息
    */
    @ApiOperation(value = "查询视频信息")
    @GetMapping("/get")
    public Map<String,Object> get(AnimalsVideo animals){
        Map<String,Object> map=new HashMap<>();

        List<AnimalsVideo> animalsList= animalsService.query(animals);
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
    @ApiOperation(value = "根据id删除视频信息")
    @GetMapping("/check/del")
    public Map<String,Object> del(Integer id){
        Map<String,Object> map=new HashMap<>();

        boolean delete = animalsService.delete(id);
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


    @ApiOperation(value = "修改视频信息")
    @PostMapping("/check/update")
    public Map<String,Object> update(AnimalsVideo animals){
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
    @ApiOperation(value = "根据标题和视频简介进行模糊查询")
    @GetMapping("/getVideo")
    public Map<String,Object> getVideo(String content){
        Map<String,Object> map=new HashMap<>();

        List<AnimalsVideo> animalsList= animalsService.findAnimalsVideoByTitle(content);
        map.put("code","200");
        map.put("msg","查询成功");
        map.put("count",animalsList.size());
        map.put("data",animalsList);
        return map;
    }

}
