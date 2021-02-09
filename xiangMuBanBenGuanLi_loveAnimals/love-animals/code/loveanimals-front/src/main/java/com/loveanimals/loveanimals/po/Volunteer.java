package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("volunteertable")
public class Volunteer {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "表id")
	private Integer id;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "申请时间")
	private Date createTime;         //对应数据库表的格式为 create_time
	@ApiModelProperty(value = "申请人姓名")
	private String vname;
	@ApiModelProperty(value = "电话")
	private String vphone;
	@ApiModelProperty(value = "居住地址")
	private String vaddress;
	@ApiModelProperty(value = "个人介绍")
	private String vintroduce;
	@ApiModelProperty(value = "邮件")
	private String email;
	@ApiModelProperty(value = "性别")
	private String sex;
	@ApiModelProperty(value = "年龄")
	private String age;
	@ApiModelProperty(value = "一寸或大一寸人头照")
	private String image;
	@ApiModelProperty(value = "审核情况（默认是0，代表未审核，1代表审核通过，-1代表审核不通过）")
	private String status;
	@ApiModelProperty(value = "注册用户id")
	private Integer buserid;


	public Integer getId() {
		return id;
	}
	public String getVname() {
		return vname;
	}
	public String getVphone() {
		return vphone;
	}
	public String getVaddress() {
		return vaddress;
	}
	public String getVintroduce() {
		return vintroduce;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public void setVphone(String vphone) {
		this.vphone = vphone;
	}
	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}
	public void setVintroduce(String vintroduce) {
		this.vintroduce = vintroduce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBuserid() {
		return buserid;
	}

	public void setBuserid(Integer buserid) {
		this.buserid = buserid;
	}
}
