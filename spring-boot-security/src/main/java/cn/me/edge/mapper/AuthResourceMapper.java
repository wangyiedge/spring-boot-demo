package cn.me.edge.mapper;

import cn.me.edge.model.po.AuthResourcePo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 资源数据表 Mapper 接口
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
public interface AuthResourceMapper extends BaseMapper<AuthResourcePo> {

    /**
     * 根据用户id 获取用户所有用户资源权限
     * @param userId 用户id
     * @return 资源权限
     */
    List<AuthResourcePo> listResourceByUserId(Long userId);
}
