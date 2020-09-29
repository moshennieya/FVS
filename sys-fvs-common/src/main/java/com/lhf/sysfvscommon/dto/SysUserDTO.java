package com.lhf.sysfvscommon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表(SysUser)实体类
 *
 * @author lhf
 * @since 2020-09-17 16:15:52
 */
@ApiModel("用户表(SysUser)实体类DTO")
@Data
public class SysUserDTO implements Serializable {
    private static final long serialVersionUID = -50823731807963280L;
    @ApiModelProperty(value = "用户id")
    private Long userId;
    @ApiModelProperty(value = "用户名/登录名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "真实名字")
    private String realName;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "邮箱号")
    private String email;
    @ApiModelProperty(value = "头像地址")
    private String headImg;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "是否锁定 0未锁定 1锁定")
    private Integer isLock;

    @ApiModelProperty(value = "角色")
    private List<SysRoleDTO> roles;

}