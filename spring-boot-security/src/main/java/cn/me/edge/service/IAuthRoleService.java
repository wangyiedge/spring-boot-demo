package cn.me.edge.service;

import cn.me.edge.model.po.AuthRolePo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
public interface IAuthRoleService extends IService<AuthRolePo> {

    /**
     * 根据用户ID查询角色集合
     * @param userId 用户id
     * @return 角色集合
     */
    List<AuthRolePo> listRoleByUserId(Long userId);

}
