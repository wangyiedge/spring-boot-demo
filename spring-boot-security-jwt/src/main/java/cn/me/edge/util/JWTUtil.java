package cn.me.edge.util;

import cn.me.edge.config.JWTConfig;
import cn.me.edge.model.security.SysUserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT生成工具
 *
 * @author edge
 */
public class JWTUtil {

    /**
     * 生成Access Token 包含用户资源权限
     *
     * @param userEntity security用户实体
     * @author edge
     */
    public static String createAccessToken(SysUserEntity userEntity) {
        ObjectMapper objectMapper = new ObjectMapper();
        String token = null;
        try {
            token = Jwts.builder()
                    .setHeaderParam("alg", SignatureAlgorithm.HS512.getValue())
                    .setHeaderParam("typ", "JWT")
                    // token id, 此处用用户id填充
                    .setId(String.valueOf(userEntity.getUserId()))
                    // token主体，即所有人，这里放入用户名
                    .setSubject(userEntity.getUsername())
                    // 签发时间
                    .setIssuedAt(new Date())
                    // 签发者
                    .setIssuer("edge")
                    // 自定义属性 放入用户拥有权限
                    .claim("authorities", objectMapper.writeValueAsString(userEntity.getAuthorities()))
                    // 失效时间
                    .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                    .setNotBefore(new Date())
                    // 签名算法和密钥
                    .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                    .compact();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // token前面增加Bearer前缀
        return JWTConfig.tokenPrefix + token;
    }

    /**
     * 返回刷新Token，刷新Token只用来更新AccessToken 所以不需要将权限放入其中
     *
     * @param userEntity security用户实体
     * @return 刷新Token
     */
    public static String createRefreshToken(SysUserEntity userEntity) {
        return JWTConfig.tokenPrefix + Jwts.builder()
                .setHeaderParam("alg", SignatureAlgorithm.HS512.getValue())
                .setHeaderParam("typ", "JWT")
                // token id, 此处用用户id填充
                .setId(String.valueOf(userEntity.getUserId()))
                // token主体，即所有人，这里放入用户名
                .setSubject(userEntity.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("edge")
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + JWTConfig.expiration))
                .setNotBefore(new Date())
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
    }

    /**
     * 解析JWT Token
     * @param token jwt token
     * @return jwt中的payload
     */
    public static Claims parseJWT(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(JWTConfig.secret)
                .parseClaimsJws(token)
                .getBody();
    }


}