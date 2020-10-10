package com.lhf.sysfvscommon.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 权限表(SysPer)实体类
 *
 * @author lhf
 * @since 2020-09-17 16:15:52
 */
@ApiModel("权限表(SysPer)实体类")
@Data
public class SysPer implements Serializable {
    private static final long serialVersionUID = -16424367645945661L;
    @ApiModelProperty(value = "权限id")
    private Integer perId;
    @ApiModelProperty(value = "权限")
    private String per;
    @ApiModelProperty(value = "菜单名字")
    private String menuName;
    @ApiModelProperty(value = "类型，0 菜单 1按钮")
    private Integer menuType;
    @ApiModelProperty(value = "菜单图标")
    private String menuIco;
    @ApiModelProperty(value = "排序")
    private Integer menuSort;
    @ApiModelProperty(value = "父类id，默认0，一级菜单")
    private Integer parentId;


    public SysPer() {
    }

    public SysPer(String per, String menuName, Integer menuType, Integer parentId) {
        this.per = per;
        this.menuName = menuName;
        this.menuType = menuType;
        this.parentId = parentId;
    }
}