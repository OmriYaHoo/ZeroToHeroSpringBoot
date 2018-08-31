package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiLogsFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ApiLogsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        logger.info("Request Info: URL=" + req.getRequestURI() + ", METHOD=" + req.getMethod());
        filterChain.doFilter(req, res);
        logger.info("Request Info: CODE=" + res.getStatus() + ", CONTENT_TYPE=" + res.getContentType());

    }

    @Override
    public void destroy() {

    }
}
