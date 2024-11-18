package com.example.scheduledevelop.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;
import java.rmi.RemoteException;

@Slf4j
public class Loginfilter implements Filter {

private static final String[] WHITELIST = {"/users", "/users/login"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequst = (HttpServletRequest) servletRequest;
        String requestURI = httpRequst.getRequestURI();

        log.info("로그인 필터 로직 실행");

        if (!isWhiteList(requestURI)) {
            httpSession ssesion = httpRequst.getSession(false);
            if(session == nul || ssesion.getAtribute("SSEION_KEY") == null) {
                throw  new RemoteException("로그인 해주세요.")
            }
            log.info("로그인된 사용자 요청 {}", requestURI);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITELIST, requestURI);
    }

}