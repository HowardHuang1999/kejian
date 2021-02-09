package com.loveanimals.loveanimals.service.admin;

import com.loveanimals.loveanimals.po.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  下午 12:44
 **/
@Service
@Transactional
@Slf4j
public class UploadService {
    /**
     * 时间格式化
     */
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");

    /**
     * 图片保存路径，自动从yml文件中获取数据
     *   示例： E:/images/
     */
    @Value("${file-save-path}")
    private String fileSavePath;


    /*
    * 单图片上传
    * */
    public JsonResult uploadFile(MultipartFile file, HttpServletRequest request) {
        //1.后半段目录：  2020/03/15
        String directory = simpleDateFormat.format(new Date());
        /**
         *  2.文件保存目录  E:/images/2020/03/15/
         *  如果目录不存在，则创建
         */
        File dir = new File(fileSavePath + directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        log.info("图片上传，保存位置：" + fileSavePath + directory);
        //3.给文件重新设置一个名字
        //后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName= UUID.randomUUID().toString().replaceAll("-", "")+suffix;
        //4.创建这个新文件
        File newFile = new File(fileSavePath + directory + newFileName);
        //5.复制操作
        try {
            file.transferTo(newFile);
            //协议 :// ip地址 ：端口号 / 文件目录(/images/2020/03/15/xxx.jpg)
            String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/images/" + directory + newFileName;
            log.info("图片上传，访问URL：" + url);
            return JsonResult.builder().data(url).message("上传成功！").code(1).build();
        } catch (IOException e) {
            return JsonResult.builder().data(null).message("IO异常！").code(-1).build();
        }
    }
}
