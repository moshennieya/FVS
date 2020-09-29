package com.lhf.sysuserservice.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.lang.UUID;
import com.lhf.sysfvscommon.dto.ClientDetailsDTO;
import com.lhf.sysfvscommon.entity.ClientDetails;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import com.lhf.sysuserservice.dao.ClientDetailsDao;
import com.lhf.sysuserservice.dao.ResourceDetailsDao;
import com.lhf.sysuserservice.service.inter.ClientDetailsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/15 15:06
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    @Resource
    private ClientDetailsDao clientDetailsDao;

    @Resource
    private ResourceDetailsDao resourceDetailsDao;

    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * 添加
     *
     * @param params
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insert(ClientDetails params) {
        //添加客户端
        String clientId = UUID.randomUUID().toString();
        params.setClientId(clientId);
        params.setClientSecret(passwordEncoder.encode(params.getClientSecret()));
        this.clientDetailsDao.insert(params);

        //添加资源
        List<ResourceDetails> resources = params.getResources();
        if (CollectionUtils.isEmpty(resources)) {
            return false;
        }
        List<ResourceDetails> newResources = resources.stream()
                .peek(item -> item.setClientId(clientId))
                .peek(item -> item.setResourceId(UUID.randomUUID().toString()))
                .collect(Collectors.toList());
        newResources.forEach(System.out::println);
        return this.resourceDetailsDao.insertAny(newResources) > 0;
    }

    /**
     * 修改
     *
     * @param params
     * @return
     */
    @Override
    public boolean update(ClientDetails params) {
        Assert.notNull(params.getClientId());

        if (StringUtils.isNotBlank(params.getClientSecret())) {
            params.setClientSecret(passwordEncoder.encode(params.getClientSecret()));
        }
        return this.clientDetailsDao.updateById(params) > 0;
    }

    /**
     * 删除
     *
     * @param clientId
     * @return
     */
    @Override
    public boolean delete(String clientId) {
        return this.clientDetailsDao.deleteById(clientId) > 0;
    }

    /**
     * 精确查找,包含资源
     *
     * @param clientId
     * @return
     */
    @Override
    public ClientDetailsDTO queryByClientId(String clientId) {
        return this.clientDetailsDao.queryByClientId(clientId);
    }
}
