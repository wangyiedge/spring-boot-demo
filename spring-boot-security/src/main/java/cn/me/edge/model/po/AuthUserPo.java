package cn.me.edge.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_auth_user")
public class AuthUserPo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 加密后的密码
     */
    private String password;

    /**
     * 有效标示
     */
    private Boolean enable;

    /**
     * 创建用户
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新者
     */
    private String updateUserId;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 是否锁定
     */
    private Boolean locked;

    /**
     * 过期时间
     */
    private Long expiredTime;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 数据有效
     */
    private Boolean available;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 类型
     */
    private Integer type;


}
