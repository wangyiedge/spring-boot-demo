package cn.me.edge.security.handler;

import cn.me.edge.model.reponse.ErrorResponse;
import cn.me.edge.util.ResponseUtil;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author edge
 * @date 2020/7/17
 */
@Component
public class SysLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        String msg;
        if (ex instanceof UsernameNotFoundException || ex instanceof BadCredentialsException) {
            msg = "用户名或密码错误!";
        } else if (ex instanceof DisabledException || ex instanceof LockedException || ex instanceof AccountExpiredException) {
            msg = "账户被禁用!";
        } else {
            msg = "登录失败!";
        }
        ErrorResponse errorResponse = new ErrorResponse(401, msg);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ResponseUtil.responseJson(response, errorResponse);
    }
}
