package com.lhf.sysfvscommon.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 用户角色关联表(SysUserRole)实体类
 *
 * @author lhf
 * @since 2020-09-17 16:15:55
 */
@ApiModel("")
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = 154402688450344869L;
    @ApiModelProperty(value="用户id")
    private Long userId;
    @ApiModelProperty(value="角色id")
    private Integer roleId;


}