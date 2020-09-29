package com.lhf.sysuserservice.service.impl;

import com.lhf.sysfvscommon.dto.ResourceDetailsDTO;
import com.lhf.sysfvscommon.entity.ResourceDetails;
import com.lhf.sysuserservice.dao.ResourceDetailsDao;
import com.lhf.sysuserservice.service.inter.ResourceDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/16 20:12
 */
@Service
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    @Resource
    private ResourceDetailsDao resourceDetailsDao;


    @Override
    public boolean insert(ResourceDetails params) {
        return resourceDetailsDao.insert(params) > 0;
    }


    @Override
    public boolean delete(String resourceId) {
        return this.resourceDetailsDao.deleteById(resourceId) > 0;
    }


    @Override
    public boolean update(ResourceDetails params) {
        return this.resourceDetailsDao.updateById(params) > 0;
    }


    @Override
    public List<ResourceDetailsDTO> queryByClientId(String clientId) {
        List<ResourceDetailsDTO> list = new ArrayList<>();
        BeanUtils.copyProperties(this.resourceDetailsDao.queryByClientId(clientId), list);
        return list;
    }
}
