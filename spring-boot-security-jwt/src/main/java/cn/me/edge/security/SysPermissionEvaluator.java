package cn.me.edge.security;

import cn.me.edge.model.security.SysUserEntity;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 自定义用户权限校验逻辑。
 * 用于{@link PreAuthorize}注解中 hasPermission()方法<br>
 *
 * 在{@link JWTAuthenticationTokenFilter}拦截器中，会将JWT Token解析，取出权限信息放在{@link SysUserEntity}中
 *
 * @author edge
 */
@Component
public class SysPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object uri, Object permission) {
        // 校验 uri 是否在权限列表中
        // 此处Authorities是来自JWT携带的权限信息
        SysUserEntity sysUserEntity = (SysUserEntity) authentication.getPrincipal();
        return sysUserEntity.getAuthorities().stream().anyMatch(e -> e.getAuthority().equals(uri));
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String targetType, Object o) {
        return false;
    }
}
