package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("动物收藏表")
@TableName("animalscollection")
public class Animalscollection {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "表id")
	private Integer id;
	@ApiModelProperty(value = "用户id")
	private Integer buserid;
	@ApiModelProperty(value = "动物id")
	private Integer animalsid;
	@ApiModelProperty(value = "收藏，默认为0,未收藏，为1时，代表收藏")
	private String collection;

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

	public Integer getAnimalsid() {
		return animalsid;
	}

	public void setAnimalsid(Integer animalsid) {
		this.animalsid = animalsid;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}
}
