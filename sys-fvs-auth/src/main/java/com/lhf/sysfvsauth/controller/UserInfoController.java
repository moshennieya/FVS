package com.lhf.sysfvsauth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/6 10:17
 */
@RestController
@RequestMapping("/uua")
public class UserInfoController {


    @GetMapping("/info")
    public UserDetails info(Principal principal) {
        Authentication authentication = (Authentication) principal;
        return (UserDetails)authentication.getDetails();
    }
}
