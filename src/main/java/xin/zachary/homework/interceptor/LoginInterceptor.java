package xin.zachary.homework.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    //是否把当前请求拦截下来，false代表终止，true代表继续运行
    //参数handler表示被拦截的目标
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录拦截
        if(request.getSession().getAttribute("username")==null){
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            return false;
        }
        return true;
    }
    //ModelAndView参数改变现实的视图或者发往视图的方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
