package org.computerized.pl.interceptor;

import org.computerized.pl.code.CodeDefinition;
import org.computerized.pl.model.SessionVO;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfAssistantIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessionVO sessionVO = (SessionVO)request.getSession().getAttribute("sessionInfo");
        int auth = sessionVO.getAuth().intValue();

        if(!(auth == CodeDefinition.Auth.PROF.getCode().intValue() || auth == CodeDefinition.Auth.ASSISTANT.getCode().intValue())) {
            response.sendRedirect("/error/400");
            return false;
        }

        return true;
    }
}
