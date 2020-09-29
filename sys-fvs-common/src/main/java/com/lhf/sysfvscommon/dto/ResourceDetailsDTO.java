package com.lhf.sysfvscommon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;

/**
 * 资源表(ResourceDetails)实体类
 *
 * @author lhf
 * @since 2020-09-15 14:56:55
 */
@ApiModel("资源表DTO")
@Data
@ApiIgnore
public class ResourceDetailsDTO implements Serializable {
    private static final long serialVersionUID = -71435951425000426L;
    @ApiModelProperty(value = "资源id")
    private String resourceId;
    @ApiModelProperty(value = "资源名")
    private String resourceName;
    @ApiModelProperty(value = "客户端id")
    private String clientId;
    @ApiModelProperty(value = "作用域")
    private String scope;
    @ApiModelProperty(value = "授权类型")
    private String authorizedGrantType;
    @ApiModelProperty(value = "重定向地址")
    private String registeredRedirectUri;
    @ApiModelProperty(value = "权限")
    private String authority;

}