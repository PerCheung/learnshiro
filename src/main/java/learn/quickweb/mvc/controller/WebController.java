package learn.quickweb.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learn.quickweb.config.jwt.JWTUtil;
import learn.quickweb.mvc.domain.User;
import learn.quickweb.mvc.mapper.UserMapper;
import learn.quickweb.util.MD5Util;
import learn.quickweb.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Peter Cheung
 * 2023/2/13 17:05
 */
@RestController
@Slf4j
@Api(tags = "资源")
public class WebController {
    @Resource
    private UserMapper userMapper;

    /**
     * 登入
     */
    @ApiOperation("登入")
    @PostMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        String salt = userMapper.queryAll(user).get(0).getSalt();
        password = MD5Util.toMD5(password, salt);
        return R.ok().data(JWTUtil.createToken(username, password));
    }


    @ApiOperation("所有人都可以访问，但是用户与游客看到的内容不同")
    @GetMapping("/article")
    public R article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return R.ok().data("你已登录");
        } else {
            return R.ok().data("你是游客");
        }
    }

    /**
     * 登入的用户才可以进行访问
     */
    @ApiOperation("登入的用户才可以进行访问")
    @GetMapping("/require_auth")
    @RequiresAuthentication
    public R requireAuth() {
        return R.ok().data("您已通过身份验证");
    }

    /**
     * admin的角色用户才可以登入
     */
    @GetMapping("/require_role")
    @ApiOperation("admin的角色用户才可以登入")
    @RequiresRoles("admin")
    public R requireRole() {
        return R.ok().data("您正在访问管理员页面");
    }

    /**
     * 拥有view和edit权限的用户才可以访问
     */
    @GetMapping("/require_permission")
    @ApiOperation("拥有view和edit权限的用户才可以访问")
    @RequiresPermissions(logical = Logical.AND, value = {"view", "edit"})
    public R requirePermission() {
        return R.ok().data("您正在访问编辑和查看页面");
    }

    @RequestMapping(path = "/401")
    @ApiOperation("401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R unauthorized() {
        return R.unauthorized().data("未登录");
    }
}
