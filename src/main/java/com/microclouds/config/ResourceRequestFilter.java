package com.microclouds.config;

import com.microclouds.common.uitl.ResponseValue;
import com.microclouds.entity.User;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description : Shiro 资源请求拦截配置器
 * @author: https://github.com/Fanqie22
 * @date : 2018年12月21日14:47:20
 */
public class ResourceRequestFilter extends AccessControlFilter {

    /**
     * 登录页面
     */
    private String loginUrl = "login";

    /**
     * 是否拦截请求
     *
     * @param servletRequest
     * @param servletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        // 类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取用户信息
        Subject subject = getSubject(request, response);
        User userInfo = (User) subject.getPrincipal();
        if (userInfo.getUserType() == 1) { // 超管
            return true;
        }

        // 获取当前请求路径
        String requestUri = request.getRequestURI().toLowerCase();
        requestUri = requestUri.replaceAll(request.getContextPath(), "");
        // 获取请求方法
        String method = request.getMethod().toLowerCase();
        //获取数据存储的权限信息,查看用户是否有权限访问资源 TODO
//        UserActionQueryVo vo = new UserActionQueryVo();
//        vo.setUserId(userInfo.getId());
//        vo.setRequestMethod(method);
//        vo.setRequestUrl(requestUri);
//        // 判断资源权限
//        boolean hasPermission = actionService.hasPermission(vo);
//        return hasPermission;
        return false;
    }

    /**
     * 拦截无权限/不合法/超时的请求
     *
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        // 类型转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=UTF-8");

        // 获取请求头
        String header = request.getHeader("x-requested-with");
        // 获取主体
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) { // 用户登录超时
            // ajax请求
            if (header != null && header.equalsIgnoreCase("XMLHttpRequest")) {
                ResponseValue responseValue = new ResponseValue();
                responseValue.setCode("PropertyUtil.logoutCode");//TODO
                responseValue.setMessage("登录超时");
                // 转换成json格式返回
//                String result = JsonUtils.objectToJson(responseValue);
//                response.getWriter().println(result);
            } else {
                // 跳转到登录页面
                response.sendRedirect(request.getContextPath() + loginUrl);
            }
        } else { // 用户无权限
            // ajax请求
            if (header != null && header.equalsIgnoreCase("XMLHttpRequest")) {
                System.out.println("header = " + header);
                ResponseValue responseValue = new ResponseValue();
                responseValue.setCode("PropertyUtil.unAuthcCode"); //TODO
                responseValue.setMessage("用户无权限");
                // 转换成json格式返回
//                String result = JsonUtils.objectToJson(responseValue);
//                response.getWriter().println(result);
            } else {
                response.sendRedirect(request.getContextPath() + loginUrl);
            }
        }

        return false;
    }
}
