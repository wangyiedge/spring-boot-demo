package cn.me.edge.service;

import cn.me.edge.model.po.AuthResourcePo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 资源数据表 服务类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
public interface IAuthResourceService extends IService<AuthResourcePo> {

    /**
     * 根据用户id获取用户所有资源权限
     * @param userId 用户id
     * @return 资源列表
     */
    List<AuthResourcePo> listResourceByUserId(Long userId);

}
