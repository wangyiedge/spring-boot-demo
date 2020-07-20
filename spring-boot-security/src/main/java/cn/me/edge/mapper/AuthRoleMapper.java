package cn.me.edge.mapper;

import cn.me.edge.model.po.AuthRolePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
public interface AuthRoleMapper extends BaseMapper<AuthRolePo> {

    /**
     * 根据用户ID查询角色集合
     * @param userId 用户id
     * @return 角色集合
     */
    List<AuthRolePo> listRoleByUserId(Long userId);

}
