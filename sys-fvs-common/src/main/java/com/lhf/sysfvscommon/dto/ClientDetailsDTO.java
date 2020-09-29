package com.lhf.sysfvscommon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * 客户端信息表(ClientDetails)实体类
 *
 * @author lhf
 * @since 2020-09-15 11:19:10
 */
@ApiModel("客户端信息表DTO")
@ApiIgnore
@Data
public class ClientDetailsDTO implements Serializable {
    private static final long serialVersionUID = -39506661872355991L;
    @ApiModelProperty(value = "客户端id")
    private String clientId;
    @ApiModelProperty(value = "客户端名字")
    private String clientName;
    @ApiModelProperty(value = "密码是否是必须的 0 不是，1 是")
    private Integer secretRequired;
    @ApiModelProperty(value = "客户端密码")
    private String clientSecret;
    @ApiModelProperty(value = "是否有授权范围 0 无 1有")
    private Integer scoped;
    @ApiModelProperty(value = "token有效期")
    private Integer accessTokenValiditySeconds;
    @ApiModelProperty(value = "是否自动授权")
    private Integer autoApprove;
    @ApiModelProperty(value = "token刷新时间")
    private Integer refreshTokenValiditySeconds;

    @ApiModelProperty(value = "资源")
    private List<ResourceDetailsDTO> resources;



}