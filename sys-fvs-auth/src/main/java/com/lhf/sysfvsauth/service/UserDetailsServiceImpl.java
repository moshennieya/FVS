package com.lhf.sysfvsauth.service;

import com.lhf.sysfvsauth.config.details.UserDetailsImpl;
import com.lhf.sysfvsauth.feign.UserFeign;
import com.lhf.sysfvscommon.dto.SysUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/30 10:21
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserFeign userFeign;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserDTO userDTO = userFeign.queryOneByUsername(username);

        if (userDTO == null) {
            throw new UsernameNotFoundException("用户未找到");
        }

        UserDetailsImpl details = new UserDetailsImpl();
        BeanUtils.copyProperties(userDTO, details);

        return details;
    }
}
