package learn.quickweb.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import learn.quickweb.config.jwt.JWTUtil;
import learn.quickweb.mvc.domain.User;
import learn.quickweb.mvc.service.UserService;
import learn.quickweb.util.MD5Util;
import learn.quickweb.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * @author Peter Cheung
 * 2023/2/13 17:05
 */
@RestController
@Slf4j
@Api(tags = "资源")
@Validated
public class WebController {
    @Resource
    private UserService userService;

    /**
     * 登入
     */
    @ApiOperation("登入")
    @PostMapping("login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password) {
        User user = (User) userService.queryById(username).getData();
        if (user == null) {
            return R.badRequest().data("用户不存在");
        }
        password = MD5Util.toMD5(password, user.getSalt());
        if (!user.getPassword().equals(password)) {
            return R.badRequest().data("密码错误");
        }
        return R.ok().data(JWTUtil.createToken(username, password));
    }

    /**
     * 注册用户
     */
    @ApiOperation("注册用户")
    @PostMapping("register")
    //@RequiresAuthentication 开启后，必须登录的用户才能注册
    public R register(@NotBlank(message = "用户名不为空") @RequestParam("username") String username,
                      @NotBlank(message = "密码不为空") @RequestParam("password") String password) {
        User user = (User) userService.queryById(username).getData();
        if (!(user == null)) {
            return R.badRequest().data("用户已存在");
        }
        //随机盐
        String salt = UUID.randomUUID().toString();
        String passwordSalt = MD5Util.toMD5(password, salt);
        user = new User();
        user.setUsername(username);
        user.setPassword(passwordSalt);
        user.setSalt(salt);
        return this.userService.insert(user);
    }

    /**
     * 所有人都可以访问，但是用户与游客看到的内容不同
     */
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
}
