package com.lhf.sysfvsauth.config.handler;

import cn.hutool.json.JSONUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/10/17 16:29
 */
public class SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        response.setCharacterEncoding("utf8");
        PrintWriter writer = response.getWriter();
        writer.write(JSONUtil.parseObj(authentication).toString());
    }
}
