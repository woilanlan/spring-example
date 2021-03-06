package com.longlong.mp01.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Conditional;

import java.time.LocalDateTime;

@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {

    private static final long serialVersionUID = 1529833390583048859L;

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.ID_WORKER)
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
