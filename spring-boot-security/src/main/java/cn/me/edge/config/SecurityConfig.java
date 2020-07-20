package cn.me.edge.config;

import cn.me.edge.security.SysPasswordEncoder;
import cn.me.edge.security.SysUserDetailsServiceImpl;
import cn.me.edge.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring security 配置
 * {@link EnableGlobalMethodSecurity} 用来开启注解形式的权限控制，注意全局只能有一个，否则会报错
 *
 * @author edge
 * @date 2020/7/14
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserDetailsServiceImpl userDetailsService;

    /**
     * 自定义密码处理逻辑
     */
    @Autowired
    private SysPasswordEncoder sysPasswordEncoder;

    /**
     * 自定义登录成功Handler
     */
    @Autowired
    private SysLoginSuccessHandler sysLoginSuccessHandler;

    /**
     * 自定义登录失败Handler
     */
    @Autowired
    private SysLoginFailureHandler sysLoginFailureHandler;

    /**
     * 自定义无权限Handler
     */
    @Autowired
    private SysAccessDeniedHandler sysAccessDeniedHandler;

    /**
     * 自定义登出成功Handler
     */
    @Autowired
    private SysLogoutSuccessHandler sysLogoutSuccessHandler;

    /**
     * 自定义未登录Handler
     */
    @Autowired
    private SysEntryPointHandler sysEntryPointHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider())
                .httpBasic()
                // 未登录处理
                .authenticationEntryPoint(sysEntryPointHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/security/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin() //使用自带的登录页面
//                .loginPage("/security/login") // 自定义未登录跳转页面的uri
                // loginProcessingUrl 定义的是用户点击登陆后，实际处理登陆POST请求的地址
                .loginProcessingUrl("/security/login")
                .permitAll()
                //登录失败
                .failureHandler(sysLoginFailureHandler)
                //登录成功
                .successHandler(sysLoginSuccessHandler)
                .and()
                .exceptionHandling()
                //没有权限
                .accessDeniedHandler(sysAccessDeniedHandler)
                .and()
                .logout()
                .logoutUrl("/security/logout")
                //退出成功
                .logoutSuccessHandler(sysLogoutSuccessHandler)
                .permitAll()
                .and()
                //开启跨域访问
                .cors().disable()
                //开启模拟请求，比如API POST测试工具的测试，不开启时，API POST会报403
                .csrf().disable();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        //对默认的UserDetailsService进行覆盖
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(sysPasswordEncoder);
        return authenticationProvider;
    }
}
