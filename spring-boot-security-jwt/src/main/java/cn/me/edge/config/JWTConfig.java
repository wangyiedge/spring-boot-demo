package cn.me.edge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * JWT配置类
 *
 * @author edge
 */
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JWTConfig {
    /**
     * 密钥KEY
     */
    public static String secret = "123";
    /**
     * TokenKey
     */
    public static String tokenHeader = "Authorization";
    /**
     * Token前缀字符
     */
    public static String tokenPrefix = "Bearer ";
    /**
     * 过期时间
     */
    public static Integer expiration = 86400;
    /**
     * 不需要认证的接口
     */
    public static String antMatchers;


    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    public String getTokenHeader() {
        return tokenHeader;
    }

    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JWTConfig.tokenPrefix = tokenPrefix;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        JWTConfig.expiration = expiration * 1000;
    }

    public String getAntMatchers() {
        return antMatchers;
    }

    public void setAntMatchers(String antMatchers) {
        JWTConfig.antMatchers = antMatchers;
    }
}