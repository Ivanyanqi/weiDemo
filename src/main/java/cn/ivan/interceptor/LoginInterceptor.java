package cn.ivan.interceptor;

import cn.ivan.annotation.LoginCheck;
import cn.ivan.model.base.TUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 * User: 仙人球
 * Date: 2017/5/12
 * Time: 15:16
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;  // 对应的handler处理器
        // 获取controller的登陆拦截注解
        LoginCheck loginCheck = method.getMethodAnnotation(LoginCheck.class);
        if(loginCheck != null){
            boolean anonymity = loginCheck.anonymity();
            if(anonymity){
                return true;
            }
        }
        TUser user = (TUser) request.getSession().getAttribute("user");
        String contextPath = request.getContextPath();
        if(user == null){  // 没有登陆，跳转到登陆页面
            response.sendRedirect(contextPath+"/toLoginPage");
        }else{
            return true ;  // 放行
        }
        return false;
    }
}
