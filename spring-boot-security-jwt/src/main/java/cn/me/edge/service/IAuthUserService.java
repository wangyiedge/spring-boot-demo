package cn.me.edge.service;

import cn.me.edge.model.po.AuthUserPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author edge
 * @since 2020-07-16
 */
public interface IAuthUserService extends IService<AuthUserPo> {

    /**
     * 通过用户名获取用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    AuthUserPo getUserByUserName(String userName);

}
