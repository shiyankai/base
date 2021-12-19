package cn.syk.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @Author syk
 * @date 2021/11/27 7:15
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我的初始化："+MyFilter.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        //放行字段
//        if(hrequest.getRequestURI().indexOf("/index") != -1 ||
//                hrequest.getRequestURI().indexOf("/user") != -1 ||
//                hrequest.getRequestURI().indexOf("/online") != -1 ||
//                hrequest.getRequestURI().indexOf("/login") != -1
//        ) {
//            hrequest.getSession();//session的创建  实际使用中需要排除掉对外接口的包
//            filterChain.doFilter(servletRequest, servletResponse);
//        }else {
//            wrapper.sendRedirect("/login");
//        }
//        暂时全部放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁MyFilter:"+MyFilter.class.getName());
    }
}
