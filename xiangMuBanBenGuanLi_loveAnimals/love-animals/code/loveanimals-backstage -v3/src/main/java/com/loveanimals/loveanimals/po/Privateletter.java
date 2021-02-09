package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-09  下午 4:05
 **/
@Data
@TableName("privateletter")
public class Privateletter {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "表id")
    private Integer id;
    @ApiModelProperty(value = "注册用户id，关联注册用户表")
    private Integer buserid;
    @ApiModelProperty(value = "内容")
    private String content;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发布时间")
    private Date createtime;
    @ApiModelProperty(value = "是否已读，默认值为0，0代表未读，1代表已读")
    private String readstatus;
}
