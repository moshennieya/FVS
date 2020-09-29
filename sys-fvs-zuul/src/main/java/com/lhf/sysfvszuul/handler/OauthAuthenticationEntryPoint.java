package com.lhf.sysfvszuul.handler;

import cn.hutool.json.JSONUtil;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvscommon.util.Status;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/14 19:14
 */
public class OauthAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(JSONUtil.toJsonStr(Result.failure(Status.AUTHENTICATION_FAILURE)));
        writer.flush();
        writer.close();

    }
}
