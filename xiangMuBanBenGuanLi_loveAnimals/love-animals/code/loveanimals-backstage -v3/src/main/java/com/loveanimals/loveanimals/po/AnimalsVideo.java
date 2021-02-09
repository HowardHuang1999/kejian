package com.loveanimals.loveanimals.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("animalsvideo")
public class AnimalsVideo {
	@TableId(type= IdType.AUTO)
	@ApiModelProperty(value = "表id")
	private Integer id;
	@ApiModelProperty(value = "视频地址")
	private String video;
	@ApiModelProperty(value = "视频封面")
	private String pic;
	@ApiModelProperty(value = "标题")
	private String title;
	@ApiModelProperty(value = "视频简介")
	private String introduce;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "发布时间")
	private Date createTime;
	@ApiModelProperty(value = "设置显示或不显示，默认值为1，代币噢显示，0代表不显示")
	private String status;

}
