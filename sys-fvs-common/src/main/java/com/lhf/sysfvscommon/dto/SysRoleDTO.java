package com.lhf.sysfvscommon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色表(SysRole)实体类
 *
 * @author lhf
 * @since 2020-09-17 16:15:52
 */
@ApiModel("角色表(SysRole)实体类")
@Data
public class SysRoleDTO implements Serializable {
    private static final long serialVersionUID = 507667785475819464L;
    @ApiModelProperty(value = "角色主键")
    private Integer roleId;
    @ApiModelProperty(value = "角色名")
    private String roleName;
    @ApiModelProperty(value = "角色")
    private Integer role;
    @ApiModelProperty(value = "图标")
    private String roleIco;
    @ApiModelProperty(value = "角色创建时间")
    private Date createTime;
    @ApiModelProperty(value = "权限")
    private List<SysPerDTO> pers;
}