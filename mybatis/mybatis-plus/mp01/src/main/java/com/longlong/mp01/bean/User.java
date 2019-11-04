package com.longlong.mp01.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/*
不符合匹配规则的，可以使用注解指定
@TableName 指定数据库表名
@TableId 指定表的主键字段
@TableField 指定表中对应的字段名称

排除非表字段
1、使用 transient 该属性不参与序列化
private transient String remark;
2、使用 static 标识为静态成员变量，提供get/set方法
private static String remark;
3、@TableField(exist = false) 表示不是数据库表中的字段
 */
@Data
@ApiModel
@TableName("mp_user")
public class User {

    @ApiModelProperty(value = "id")
    @TableId
    private Long userId;

    @ApiModelProperty(value = "姓名")
    @TableField("name")
    private String realName;

    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "备注")
    @TableField(exist = false)
    private String remark;
}
