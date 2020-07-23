package cn.me.edge.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * 自定义密码处理逻辑
 *
 * @author edge
 */
@Component
public class SysPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        //加密方法可以根据业务进行修改，简单验证时，可以直接返回 rawPassword;
        String encodePass = DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        return bcryptPasswordEncoder.encode(encodePass);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encodePass = DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        return bcryptPasswordEncoder.matches(encodePass, encodedPassword);
    }
}
