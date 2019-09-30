package com.slk.web.framework.Interceptor.AccessIntercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 菜单拦截
 * Create by 杨明 2019/6/20 0020 下午 17:16
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    /**
     * 执行此方法 进入handler/controller方法之前执行
     * 常用于，身份验证授权等操作，返回false表示不通过
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        Object userId = session.getAttribute("userId");
        if (!priv.license.DecodeLicense.Decode()) {
            response.sendRedirect("code/promptNO.jsp");
            return false;
        }
        if (url.indexOf("UserLogin") > 0 || url.indexOf("One_Login") > 0 || url.indexOf("Screen") > 0 || url.indexOf("MealSummary") > 0 || url.indexOf("Prepcustomer") > 0) {
            return true;
        }
        // 创建菜单实体对象
        // 比如 WphMenuCustom custom = new WphMenuCustom();
        if (null != userId && (Integer) userId == 1) return true;
        if (null != userId) {
            //将 userId 放到对象的setUserId(userId);中
            //比如 setUserId(userId);
        }
         /*
         将前台传的菜单（/User/index）进行字符串截取
         比如 custom.setMenuurl(url.substring(url.indexOf("/"), url.indexOf("/", 1)+1));
         判断菜单是否有值
         if(结果!=0){
            return true;
         }else{
            response.sendRedirect("/code/promptNO.jsp");//没有权限
         }
         */
        return false;
    }

    //进入handler/controller方法之后，返回ModelAndView之前执行
    //可以将公用的模型数据在此方法传到视图，也可以统一制定视图
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

    }

    //进入handler/controller方法，执行handler完成后执行
    //可以统一异常处理、日志处理等
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e) throws Exception {
        System.out.println("LoginInterceptor---------afterCompletion-");
    }
}
