package com.lhf.sysfvscommon.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
/**
 * 角色权限关联表(SysRolePer)实体类
 *
 * @author lhf
 * @since 2020-09-17 16:15:52
 */
@ApiModel("")
@Data
public class SysRolePer implements Serializable {
    private static final long serialVersionUID = 911097110791430660L;
    @ApiModelProperty(value="角色id")
    private Integer roleId;
    @ApiModelProperty(value="权限id")
    private Integer perId;


}