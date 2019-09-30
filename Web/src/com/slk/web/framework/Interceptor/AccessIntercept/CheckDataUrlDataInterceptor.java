package com.slk.web.framework.Interceptor.AccessIntercept;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * 数据拦截器
 * Create by 杨明 2019/6/20 0020 下午 17:16
 */
public class CheckDataUrlDataInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LogManager.getLogger(CheckDataUrlDataInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (null != annotation) {
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    request.getSession(true).setAttribute("token", UUID.randomUUID().toString());
                    request.getSession(true).setAttribute("testPath", request.getServletPath());
                    System.out.println(request.getQueryString());
                }
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        logger.warn("please don't repeat submit,url:" + request.getServletPath());
                        System.out.println("请不要重复提交,url:" + request.getServletPath());
                        PrintWriter writer = response.getWriter();
                        writer.println("<html>");
                        writer.println("<script>");
                        System.out.println(request.getSession(true).getAttribute("testPath") + "?message=恭喜您操作成功");
                        writer.println("window.open('" + request.getSession(true).getAttribute("testPath") + "?message=恭喜您操作成功" + "','_self')");
                        writer.println("</script>");
                        writer.println("</html>");
                        return false;
                    }
                }
                request.getSession(true).removeAttribute("token");
            }
        }
        return false;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(true).getAttribute("token");
        if (null == serverToken) return true;
        String clinetToken = request.getParameter("token");
        if (null == clinetToken) return true;
        if (!serverToken.equals(clinetToken)) return true;
        return false;
    }

}
