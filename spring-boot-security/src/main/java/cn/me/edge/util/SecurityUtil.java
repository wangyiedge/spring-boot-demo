package cn.me.edge.util;

import cn.me.edge.model.security.SysUserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security工具类
 *
 * @author edge
 */
public class SecurityUtil {

    /**
     * 获取当前用户信息
     */
    public static SysUserEntity getUserInfo() {
        return (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取当前用户ID
     */
    public static Long getUserId() {
        return getUserInfo().getUserId();
    }

    /**
     * 获取当前用户账号
     */
    public static String getUserName() {
        return getUserInfo().getUsername();
    }
}