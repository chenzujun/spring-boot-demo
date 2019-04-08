package com.raine.demo.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * 拦截器 demo
 *
 * @author chenjun
 * @date 2019/3/29
 * @since V1.0
 */
public class LogCostFilter implements Filter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("LogCostFilter doFilter Execute cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void init(FilterConfig filterConfig){
        log.info("LogCostFilter init");
    }

    @Override
    public void destroy() {
        log.info("LogCostFilter destroy");
    }
}
