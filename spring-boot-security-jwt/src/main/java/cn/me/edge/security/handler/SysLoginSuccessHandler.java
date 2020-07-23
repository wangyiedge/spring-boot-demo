package cn.me.edge.security.handler;

import cn.me.edge.model.po.AuthUserPo;
import cn.me.edge.model.reponse.CommonResponse;
import cn.me.edge.model.security.SysUserEntity;
import cn.me.edge.model.vo.AuthUserVO;
import cn.me.edge.service.IAuthUserService;
import cn.me.edge.util.JWTUtil;
import cn.me.edge.util.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
public class SysLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private IAuthUserService authUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SysUserEntity sysUserEntity = (SysUserEntity) authentication.getPrincipal();
        AuthUserPo po = authUserService.getById(sysUserEntity.getUserId());
        AuthUserVO vo = new AuthUserVO();
        BeanUtils.copyProperties(po,vo);
        vo.setUserId(po.getId());
        // 生成JWT Token
        vo.setAccessToken(JWTUtil.createAccessToken(sysUserEntity));
        vo.setRefreshToken(JWTUtil.createRefreshToken(sysUserEntity));
        CommonResponse<AuthUserVO> commonResponse = new CommonResponse<>(200,"登陆成功", vo);
        ResponseUtil.responseJson(response, commonResponse);
    }
}
