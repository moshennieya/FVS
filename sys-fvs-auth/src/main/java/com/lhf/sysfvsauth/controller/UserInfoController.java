package com.lhf.sysfvsauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 10:17
 */
@Controller
@RequestMapping("/login")
public class UserInfoController {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @GetMapping("/info")
    @ResponseBody
    public Object info() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
