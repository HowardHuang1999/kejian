package com.loveanimals.loveanimals.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-15  下午 4:03
 **/
@Data
@ApiModel("用户关联留言")
public class MessageBoardAndBuser {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "用户id")
    private Integer buserid;
    @ApiModelProperty(value = "账号")
    private String bname;
    @ApiModelProperty(value = "密码")
    private String bpwd;
    @ApiModelProperty(value = "状态信息，默认为1,意思是开启，0为关闭")
    private String status;
    @ApiModelProperty(value = "头像")
    private String headphoto;
    @ApiModelProperty(value = "用户名")
    private String username;
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "留言id")
    private Integer messageboardid;
    @ApiModelProperty(value = "留言标题")
    private String title;
    @ApiModelProperty(value = "留言内容")
    private String content;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
