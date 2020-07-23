package cn.me.edge.security.handler;

import cn.me.edge.model.reponse.BaseResponse;
import cn.me.edge.util.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author edge
 * @date 2020/7/17
 */
@Component
public class SysLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ResponseUtil.responseJson(response, new BaseResponse(200, "退出成功"));
    }
}
