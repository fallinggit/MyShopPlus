package com.funtl.myshop.plus.interceptor;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @ClassName FeignRequestInterceptor
 * @Description TODO
 * @Author Scorpio
 * @Date 2019/11/30 19:16
 */
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                template.header(name, value);
            }
        }

        Enumeration<String> parameterNames = request.getParameterNames();
        StringBuilder body = new StringBuilder();
        if (parameterNames != null) {
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);

                // 将 Token 加入请求头
                if ("access_token".equals(name)) {
                    template.header("authorization", "Bearer " + value);
                }
                // 其它参数加入请求体
                else {
                    body.append(name).append("=").append(value).append("&");
                }
            }
        }

        if (body.length() > 0) {
            body.deleteCharAt(body.length() - 1);
            template.body(Request.Body.bodyTemplate("", Charset.defaultCharset()));
        }

    }
}
