package com.lqz.demo.config;


import com.lqz.demo.entity.User;
import com.lqz.demo.util.SerializingUtil;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月15日 10:47:00
 */
@Order(1)
@WebFilter(filterName = "firstFilter", urlPatterns = "/*")
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("first filter start");
        try {
            InputStream is = request.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
        System.out.println("first filter end");
    }

    @Override
    public void destroy() {

    }
}
