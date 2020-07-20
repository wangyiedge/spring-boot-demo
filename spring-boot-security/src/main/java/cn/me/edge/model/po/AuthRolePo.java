package cn.me.edge.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_auth_role")
public class AuthRolePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 启用，禁用
     */
    private Boolean enable;

    /**
     * 备注
     */
    private String memos;

    /**
     * 创建人
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新人
     */
    private String updateUserId;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 有效标识,TRUE:有效,FALSE:无效
     */
    private Boolean available;


}
