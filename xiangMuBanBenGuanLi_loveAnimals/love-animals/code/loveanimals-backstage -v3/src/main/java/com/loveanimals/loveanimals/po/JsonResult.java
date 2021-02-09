package com.loveanimals.loveanimals.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: Mr.Pang
 * @create: 2020-11-08  下午 8:31
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private Integer code;
    private String message;
    private Object data;
}

