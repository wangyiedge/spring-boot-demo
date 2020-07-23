package cn.me.edge.model.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * SpringSecurity的用户实体
 * 实现{@link UserDetails} 接口
 * @author edge
 * @date 2019/10/1 20:23
 */
@Data
public class SysUserEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;


	/**
	 * 用户角色
	 */
	private Collection<GrantedAuthority> authorities;
	/**
	 * 账户是否过期
	 */
	private boolean isAccountNonExpired = true;
	/**
	 * 账户是否被锁定
	 */
	private boolean isAccountNonLocked = true;
	/**
	 * 证书是否过期
	 */
	private boolean isCredentialsNonExpired = true;
	/**
	 * 账户是否有效
	 */
	private boolean isEnabled = true;
}