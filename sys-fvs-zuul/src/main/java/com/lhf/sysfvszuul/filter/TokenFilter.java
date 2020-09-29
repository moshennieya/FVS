package com.lhf.sysfvszuul.filter;

import cn.hutool.json.JSONUtil;
import com.lhf.sysfvscommon.util.Result;
import com.lhf.sysfvscommon.util.Status;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/9/14 10:59
 */
@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            HttpServletResponse response = requestContext.getResponse();
            ServletOutputStream outputStream = null;
            try {
                outputStream = response.getOutputStream();
                outputStream.write(JSONUtil.toJsonStr(Result.failure(Status.AUTHENTICATION_FAILURE)).getBytes());
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
