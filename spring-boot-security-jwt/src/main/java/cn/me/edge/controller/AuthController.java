package cn.me.edge.controller;

import cn.me.edge.model.reponse.BaseResponse;
import cn.me.edge.model.reponse.CommonResponse;
import cn.me.edge.service.IAuthResourceService;
import cn.me.edge.service.IAuthRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author edge
 * @date 2020/7/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    /**
     *  将 '/auth/info' 配置在数据库中，利用hasPermission做权限控制
     */
    @RequestMapping(value = "/info", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasPermission('/auth/info','')")
    public BaseResponse info(){
        return new CommonResponse<>("权限验证成功!");
    }

    /**
     *  不做任何配置，测试无权限
     */
    @RequestMapping(value = "/deny", method = RequestMethod.GET)
    @PreAuthorize("hasPermission('/auth/deny','')")
    public BaseResponse deny(){
        return new CommonResponse<>("如果看到这条信息，证明权限验证失败了!");
    }

}
