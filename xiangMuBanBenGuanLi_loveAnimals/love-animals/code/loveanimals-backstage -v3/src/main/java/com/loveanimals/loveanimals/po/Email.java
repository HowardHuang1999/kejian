package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("邮件信息")
@TableName("email")
public class Email {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "邮件id")
	private Integer id;
	@ApiModelProperty(value = "发送者")
	private String sender;
	@ApiModelProperty(value = "接收者")
	private String receiver;
	@ApiModelProperty(value = "标题")
	private String title;
	@ApiModelProperty(value = "内容")
	private String text;
}
