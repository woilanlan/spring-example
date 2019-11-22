package com.longlong.mp01.bean;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@ApiModel
public class User1 {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "姓名")
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    @ApiModelProperty(value = "年龄")
    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "上级id")
    private Long managerId;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
