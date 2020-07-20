package cn.me.edge.controller;

import cn.me.edge.model.reponse.BaseResponse;
import cn.me.edge.model.reponse.CommonResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author edge
 * @date 2020/7/14
 */
@RestController
@RequestMapping("/security")
@PreAuthorize("hasAnyRole('operator','admin')")
public class SecurityController {

    /**
     * 拥有'operator'或者'admin' 角色的用户可以访问
     */
    @PreAuthorize("hasAnyRole('operator','admin')")
    @RequestMapping(value = "/operate/hello", method = {RequestMethod.GET, RequestMethod.POST})
    public BaseResponse operatorHello(){
        return new CommonResponse<>("hello operator!");
    }

    /**
     * 拥有'operator' 角色同时拥有'/security/operate/info' 资源的用户可以访问
     */
    @PreAuthorize("hasAnyRole('operator') and hasPermission('/security/operate/info','')")
    @GetMapping({"/operate/info"})
    public BaseResponse operateInfo(String userId){
        return new CommonResponse<>("GET operate info!");
    }

    @PreAuthorize("hasAnyAuthority('operator')")
    @GetMapping({"/operate/"})
    public BaseResponse tom(){
        return new CommonResponse<>("hello tom!");
    }

    @GetMapping({"/login"})
    public BaseResponse login(){
        return new CommonResponse<>("请重新登陆!");
    }

}
