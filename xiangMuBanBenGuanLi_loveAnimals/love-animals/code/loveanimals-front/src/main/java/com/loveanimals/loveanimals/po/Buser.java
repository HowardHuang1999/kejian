package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("注册用户信息")
@TableName("busertable")
public class Buser {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "用户id")
	private Integer id;
	@ApiModelProperty(value = "用户名")
	private String bname;
	@ApiModelProperty(value = "密码")
	private String bpwd;
	@ApiModelProperty(value = "状态信息，默认为1,意思是开启，0为关闭")
	private String status;
	@ApiModelProperty(value = "头像")
	private String headphoto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBpwd() {
		return bpwd;
	}

	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHeadphoto() {
		return headphoto;
	}

	public void setHeadphoto(String headphoto) {
		this.headphoto = headphoto;
	}
}
