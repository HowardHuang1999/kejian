package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-09-26  下午 7:42
 **/
@TableName("adopttable")
public class Adopt {
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "表id")
    private Integer id;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "申请时间")
    private Date createTime;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "联系电话")
    private String phone;
    @ApiModelProperty(value = "居住地址")
    private String address;
    @ApiModelProperty(value = "身份证号")
    private String idcard;
    @ApiModelProperty(value = "审核情况，默认为0,代表未审核，1代表审核通过，-1代表审核不通过")
    private String status;
    @ApiModelProperty(value = "想领养的动物id")
    private Integer animalsid;
    @ApiModelProperty(value = "要领养的动物图片")
    private String animalsphoto;
    @ApiModelProperty(value = "个人介绍")
    private String introduce;
    @ApiModelProperty(value = "房产信息")
    private String house;
    @ApiModelProperty(value = "工作单位")
    private String unitname;
    @ApiModelProperty(value = "证书照片")
    private String idphoto;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "领养人年龄")
    private String age;
    @ApiModelProperty(value = "注册用户id")
    private Integer buserid;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIntroduce() {
        return introduce;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAnimalsid() {
        return animalsid;
    }

    public void setAnimalsid(Integer animalsid) {
        this.animalsid = animalsid;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getIdphoto() {
        return idphoto;
    }

    public void setIdphoto(String idphoto) {
        this.idphoto = idphoto;
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

    public String getAnimalsphoto() {
        return animalsphoto;
    }

    public void setAnimalsphoto(String animalsphoto) {
        this.animalsphoto = animalsphoto;
    }

    public Integer getBuserid() {
        return buserid;
    }

    public void setBuserid(Integer buserid) {
        this.buserid = buserid;
    }
}
