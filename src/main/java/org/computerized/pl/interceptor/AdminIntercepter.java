package org.computerized.pl.interceptor;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.general.SessionVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessionVO sessionVO = (SessionVO)request.getSession().getAttribute("sessionInfo");

        if(!sessionVO.getAuth().equals(CodeDefinition.Auth.ADMIN.getCode())) {
            response.sendRedirect("/error/400");
            return false;
        }

        return true;
    }
}
