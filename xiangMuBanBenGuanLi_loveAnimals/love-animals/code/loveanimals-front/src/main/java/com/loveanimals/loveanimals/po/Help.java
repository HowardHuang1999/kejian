package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("helptable")
public class Help {
	@TableId(type= IdType.AUTO)
	private Integer id;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "申请时间")
	private Date createTime;
	@ApiModelProperty(value = "申请人姓名")
	private String name;
	@ApiModelProperty(value = "电话")
	private String phone;
	@ApiModelProperty(value = "要救助的流浪动物地址")
	private String address;
	@ApiModelProperty(value = "审核情况（默认是0，代表未审核，1代表审核通过，-1代表审核不通过）")
	private String status;
	@ApiModelProperty(value = "介绍详细情况")
	private String introduce;
	@ApiModelProperty(value = "流浪动物照片1")
	private String photo1;
	@ApiModelProperty(value = "流浪动物照片2")
	private String photo2;
	@ApiModelProperty(value = "流浪动物照片3")
	private String photo3;
	@ApiModelProperty(value = "注册用户id")
	private Integer buserid;

	public Integer getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public Integer getBuserid() {
		return buserid;
	}

	public void setBuserid(Integer buserid) {
		this.buserid = buserid;
	}
}
