package com.microclouds.config;

import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author :https://github.com/Fanqie22
 * @description : Shiro 启用配置类 ,可自定义
 * @date : 2018年12月23日15:47:52
 */
@Configuration
public class ShiroConfig {

    private String loginUrl = "/microclouds/login";

    private String successUrl = "/microclouds/main";

    private String unauthorizedUrl = "/microclouds/unauthorized";

    /**
     * @param manager
     * @return ShiroFilterFactoryBean
     * @ DefaultFilter : 一个枚举类，
     * @description :定义了拦截器,authc,anon等分别有对应的拦截器,anon是可匿名,不需要凭证
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);

        //提供登录到url
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        //提供登陆成功的url
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        //提供验证不通过的url
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // 自定义过滤器
        Map<String, Filter> filterMap = shiroFilterFactoryBean.getFilters();
        filterMap.put("hasToken", accessTokenFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        // 配置过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // loginout过滤器,具体的退出代码Shiro已实现
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接,静态资源,顺序判断
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        // 成功登陆的页面,需要"authc" , 登陆页面 ,可匿名
        filterChainDefinitionMap.put(successUrl, "authc");
        filterChainDefinitionMap.put(loginUrl, "anon");
        filterChainDefinitionMap.put("/microclouds/a", "anon");
        // 要用角色是admin的才可以登录,对应的拦截器是RolesAuthorizationFilter
//      filterChainDefinitionMap.put("/admin", "roles[admin]");
        //所有的druid请求，不需要拦截，anon对应的拦截器不会进行拦截
        filterChainDefinitionMap.put("/druid/**", "anon");
        //自动跳去登录的地址
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        /**
         * 认证通过或者记住了登录状态(remeberMe)则可以通过
         * 否则所有的路径都拦截，被UserFilter拦截，这里会判断用户有没有登陆
         */
        filterChainDefinitionMap.put("/**", "user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);//设置一个拦截器链
        return shiroFilterFactoryBean;
    }


    /**
     * 注入一个securityManager
     * 得到SecurityManager实例 并绑定给SecurityUtils
     */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        // 对Subject，realm等进行基本的参数注入
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        // 往SecurityManager中注入自定义的Realm，代替原本的默认配置
        manager.setRealm(authRealm);
        return manager;
    }

    // 自定义的Realm
    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") SimplePasswordMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        //这边可以选择是否将认证的缓存到内存中，现在有了这句代码就将认证信息缓存的内存中了
        authRealm.setCacheManager(new MemoryConstrainedCacheManager());
        //最简单的情况就是明文直接匹配，然后就是加密匹配，这里的匹配工作则就是交给CredentialsMatcher来完成
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    // 配置自定义的拦截器
    @Bean
    public ResourceRequestFilter accessTokenFilter() {
        return new ResourceRequestFilter();
    }

    /*
     * Realm在验证用户身份的时候，要进行密码匹配( 因为数据的密码都是加密的,一般使用MD5加密 )
     * 最简单的情况就是明文直接匹配，然后就是加密匹配，这里的匹配工作则就是交给CredentialsMatcher来完成
     * 支持任意数量的方案，包括纯文本比较、散列比较和其他方法。除非该方法重写，否则使用默认值
     * */
    @Bean("credentialMatcher")
    public SimplePasswordMatcher credentialMatcher() {
        return new SimplePasswordMatcher();
    }


    /*
     * 以下AuthorizationAttributeSourceAdvisor,DefaultAdvisorAutoProxyCreator
     * 两个类是为了支持shiro注解 , 在view ( jsp ,html )注解
     * */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

}
