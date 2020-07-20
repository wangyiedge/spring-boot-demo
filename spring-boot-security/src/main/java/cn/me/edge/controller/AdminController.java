package cn.me.edge.controller;

import cn.me.edge.model.reponse.BaseResponse;
import cn.me.edge.model.reponse.CommonResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

/**
 * 只有'admin'角色才可以访问该controller下资源
 *
 * @author edge
 * @date 2020/7/17
 */
@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('admin')")
public class AdminController {

    @GetMapping({"/info"})
    public BaseResponse info(){
        return new CommonResponse<>("GET admin info");
    }

    @GetMapping({"/user/list"})
    public BaseResponse listUser(){
        return new CommonResponse<>("GET admin user list");
    }

}
