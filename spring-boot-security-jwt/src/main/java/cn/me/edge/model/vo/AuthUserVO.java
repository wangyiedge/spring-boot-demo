package cn.me.edge.model.vo;

import lombok.Data;

/**
 * @author edge
 */
@Data
public class AuthUserVO {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 登陆token
     */
    private String accessToken;

    /**
     * 刷新token
     */
    private String refreshToken;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 类型
     */
    private Integer type;
}
