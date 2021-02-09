package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("animalstable")
public class Animals {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "表id")
	private Integer id;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	@ApiModelProperty(value = "动物名字")
	private String aname;
	@ApiModelProperty(value = "主照片")
	private String animalsImage;//对应数据库表的格式为animals_image
	@ApiModelProperty(value = "领养状态（默认是0，代表未领养，1未已领养）")
	private String status;
	@ApiModelProperty(value = "动物介绍")
	private String aintroduce;
	@ApiModelProperty(value = "性别")
	private String sex;
	@ApiModelProperty(value = "年龄")
	private String age;
	@ApiModelProperty(value = "其他照片1")
	private String photo1;
	@ApiModelProperty(value = "其他照片2")
	private String photo2;
	@ApiModelProperty(value = "其他照片3")
	private String photo3;
	@ApiModelProperty(value = "其他照片4")
	private String photo4;
	@ApiModelProperty(value = "其他照片5")
	private String photo5;
	@ApiModelProperty(value = "体重")
	private String weight;

	public Integer getId() {
		return id;
	}
	public String getAname() {
		return aname;
	}
	public String getAintroduce() {
		return aintroduce;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public void setAintroduce(String aintroduce) {
		this.aintroduce = aintroduce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAnimalsImage() {
		return animalsImage;
	}

	public void setAnimalsImage(String animalsImage) {
		this.animalsImage = animalsImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPhoto4() {
		return photo4;
	}
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}

	public String getPhoto5() {
		return photo5;
	}

	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}
