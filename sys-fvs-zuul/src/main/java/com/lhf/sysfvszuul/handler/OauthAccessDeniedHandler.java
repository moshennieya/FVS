package com.lhf.sysfvszuul.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/14 19:18
 */
public class OauthAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {

        response.setCharacterEncoding("utf8");

        PrintWriter writer = response.getWriter();
        writer.println("无权访问");
        writer.flush();
        writer.close();

    }
}
