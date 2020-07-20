package cn.me.edge.security;

import cn.me.edge.model.po.AuthRolePo;
import cn.me.edge.model.po.AuthUserPo;
import cn.me.edge.model.security.SysUserEntity;
import cn.me.edge.service.IAuthRoleService;
import cn.me.edge.service.IAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Spring Security 用户逻辑的实现
 *
 * @author edge
 * @date 2020/7/14
 */
@Component
public class SysUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAuthUserService authUserService;
    @Autowired
    private IAuthRoleService authRoleService;

    /**
     * 重写查询用户和权限信息
     * 登陆验证时，通过username获取用户的基础信息和权限信息
     * {@link UserDetails} 会被放到spring的全局缓存SecurityContextHolder中
     *
     */
    @Override
    public SysUserEntity loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException {
        // 替换为从数据库获取用户信息
        AuthUserPo authUserPo = authUserService.getUserByUserName(username);
        if(authUserPo == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
//        if(authUserPo.getLocked() || !authUserPo.getEnable() || !authUserPo.getAvailable()){
//            throw new DisabledException("用户被锁定！");
//        }
        SysUserEntity selfUserEntity = new SysUserEntity();
        selfUserEntity.setUserId(authUserPo.getId());
        selfUserEntity.setUsername(authUserPo.getUserName());
        selfUserEntity.setPassword(authUserPo.getPassword());
        selfUserEntity.setEnabled(authUserPo.getEnable());
        selfUserEntity.setAccountNonLocked(authUserPo.getLocked() == null || !authUserPo.getLocked());
        selfUserEntity.setAccountNonExpired(authUserPo.getExpiredTime() == null || authUserPo.getExpiredTime() > System.currentTimeMillis());
        // 从数据库获取用户权限信息
        List<AuthRolePo> authRoleList = authRoleService.listRoleByUserId(authUserPo.getId());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authRoleList.forEach(e-> authorities.add(new SimpleGrantedAuthority("ROLE_"+e.getName())));
        selfUserEntity.setAuthorities(authorities);
        return selfUserEntity;
    }
}