package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("留言板")
@TableName("messageboard")
public class Messageboard {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "留言id")
	private Integer id;
	@ApiModelProperty(value = "注册用户id（外键，关联注册用户表）")
	private Integer buserid;
	@ApiModelProperty(value = "留言标题")
	private String title;
	@ApiModelProperty(value = "留言内容")
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBuserid() {
		return buserid;
	}

	public void setBuserid(Integer buserid) {
		this.buserid = buserid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
