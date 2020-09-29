package com.lhf.sysfvsauth.service;

import com.lhf.sysfvsauth.config.details.ClientDetailsImpl;
import com.lhf.sysfvsauth.feign.ClientFeign;
import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 9:22
 */
@Service("clientDetailsServiceImpl")
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    @Resource
    private ClientFeign clientFeign;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetailsDTO dto = clientFeign.queryByClientId(clientId);
        if (dto == null) {
            throw new NoSuchClientException("未找到该客户端");
        }
        ClientDetailsImpl details = new ClientDetailsImpl();
        BeanUtils.copyProperties(dto, details);
        logger.info("客户端信息---->{}", details);
        return details;
    }
}
