package com.lhf.sysfvsauth.config.details;

import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 9:03
 */
public class ClientDetailsImpl implements ClientDetails {

    private static final long serialVersionUID = 7745738175122445265L;
    /**
     * 客户端id
     */
    private String clientId;
    /**
     * 是否必填
     */
    private Integer secretRequired;

    /**
     * 客户端密码
     */
    private String clientSecret;

    /**
     * 是否又授权范围
     */
    private Integer scoped;

    /**
     * token有效期
     */
    private Integer accessTokenValiditySeconds;

    /**
     * token刷新时间
     */
    private Integer refreshTokenValiditySeconds;

    /**
     * 其他信息，暂时不需要
     */
    private Map<String, Object> additionalInformation;

    /**
     * 是否自动授权
     */
    private Integer autoApprove;

    /**
     * 资源
     */
    private List<ResourceDetailsDTO> resources;


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setSecretRequired(Integer secretRequired) {
        this.secretRequired = secretRequired;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setScoped(Integer scoped) {
        this.scoped = scoped;
    }

    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    public void setAdditionalInformation(Map<String, Object> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setAutoApprove(Integer autoApprove) {
        this.autoApprove = autoApprove;
    }

    public void setResources(List<ResourceDetailsDTO> resources) {
        this.resources = resources;
    }

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resources.stream().map(ResourceDetailsDTO::getResourceId).collect(Collectors.toSet());
    }

    @Override
    public boolean isSecretRequired() {
        return this.secretRequired == 1;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return this.scoped == 1;
    }

    @Override
    public Set<String> getScope() {
        return this.resources.stream().flatMap(item -> Stream.of(item.getScope().split(","))).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.resources.stream().flatMap(item -> Stream.of(item.getAuthorizedGrantType().split(","))).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.resources.stream()
                .flatMap(item -> Stream.of(item.getRegisteredRedirectUri()
                        .split(",")))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        return this.resources.stream()
                .map(item -> {
                    if (StringUtils.isNotBlank(item.getAuthority())) {
                        return item.getAuthority();
                    } else {
                        return "";
                    }
                })
                .flatMap(item -> Stream.of(item.split(","))
                        .map(SimpleGrantedAuthority::new))
                .distinct()
                .filter(item -> StringUtils.isNotBlank(item.getAuthority()))
                .collect(Collectors.toSet());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return this.autoApprove == 1;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    @Override
    public String toString() {
        return "ClientDetailsImpl{" +
                "clientId='" + clientId + '\'' +
                ", secretRequired=" + secretRequired +
                ", clientSecret='" + clientSecret + '\'' +
                ", scoped=" + scoped +
                ", accessTokenValiditySeconds=" + accessTokenValiditySeconds +
                ", refreshTokenValiditySeconds=" + refreshTokenValiditySeconds +
                ", additionalInformation=" + additionalInformation +
                ", autoApprove=" + autoApprove +
                ", resources=" + resources +
                '}';
    }
}
