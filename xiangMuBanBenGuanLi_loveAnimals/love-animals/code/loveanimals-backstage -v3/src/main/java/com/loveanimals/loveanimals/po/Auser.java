package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("管理员信息")
@TableName("ausertable")
public class Auser {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "管理员id")
	private Integer id;
	@ApiModelProperty(value = "用户名")
	private String aname;
	@ApiModelProperty(value = "密码")
	private String apwd;
	@ApiModelProperty(value = "管理员姓名")
	private String name;
	@ApiModelProperty(value = "管理员身份证号")
	private String idcard;
	@ApiModelProperty(value = "状态信息，默认为1,意思是开启，0为关闭")
	private String status;
	@ApiModelProperty(value = "地址")
	private String address;
	@ApiModelProperty(value = "一寸或大一寸人头照")
	private String photo;
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
