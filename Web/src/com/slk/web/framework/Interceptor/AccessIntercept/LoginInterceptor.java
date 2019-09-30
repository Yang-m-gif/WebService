package com.slk.web.framework.Interceptor.AccessIntercept;

import com.slk.web.framework.Cache.MemcachedUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/*
 * 用户登录拦截
 */
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> excludedUrls;

    /**
     * 执行此方法 进入handler/controller方法之前执行
     * 常用于，身份验证授权等操作，返回false表示不通过
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String returnJsp = "/login.jsp";
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        Object userId = session.getAttribute("userId");
        if (null==userId){
            userId = request.getParameter("userId");
        }
        System.out.println("--------userId-------------" + userId);
        System.out.println("--------sessionID-------------" + session.getId());

        if (!priv.license.DecodeLicense.Decode()) {
            response.sendRedirect(returnJsp);
            return false;
        }
        if (url.indexOf("UserLogin") > 0 || url.indexOf("Screen") > 0 || url.indexOf("One_Login") > 0 || url.indexOf("MealSummary") > 0 || url.indexOf("Prepcustomer") > 0)
            return true;
        if (null != userId && (session.getId().equals(MemcachedUtil.get(userId + "UserSessionId")) || MemcachedUtil.get(userId + "UserSessionId") == null)) {
            return true;
        }

        if (null != userId) {
            returnJsp = returnJsp + "?message=当前账号在其他地点登录";
        } else if (null == userId)
            returnJsp = returnJsp + "?message=请登录后操作";

        //一体机session为空,跳到一体机首页
		/*if(url.indexOf("Screen")>0){
			returnJsp = "/code/Screen/Carousel/Main_Pos.jsp";
		}*/

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open('" + request.getContextPath() + returnJsp + "','_top')");
        out.println("</script>");
        out.println("</html>");
        System.out.println(request.getContextPath() + returnJsp);

        return false;
    }


    /**
     * 进入handler/controller方法之后，返回ModelAndView之前执行
     * 可以将公用的模型数据在此方法传到视图，也可以统一制定视图
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {
        // String url=(String)request.getSession().getAttribute("urlF");
        // if(null!=url&&!"".equals(url)){
        // request.getSession().setAttribute("urlF", null);
        // request.getSession().removeAttribute("urlF");
        // request.getRequestDispatcher(url).forward(request, response);
        // }

    }

    /**
     * 进入handler/controller方法，执行handler完成后执行
     * 可以统一异常处理、日志处理等
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
        System.out.println("LoginInterceptor---------afterCompletion-");
    }

    public List<String> getExcludedUrls() {
        return excludedUrls;
    }

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

	/*public static void main(String[] args) {
		MemcachedUtil.put("hello", "world", 60);
		String hello = (String) MemcachedUtil.get("hello");
		System.out.println(hello);
	}*/
}
