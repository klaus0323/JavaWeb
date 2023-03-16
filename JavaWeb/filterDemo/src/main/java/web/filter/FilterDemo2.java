package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*") // 所有资源全拦截
public class FilterDemo2 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行前对request处理
        System.out.println("filterdemo");

        // 放行请求
        filterChain.doFilter(servletRequest,servletResponse);

        // 放行后对response进行处理

    }

    @Override
    public void destroy() {

    }
}
