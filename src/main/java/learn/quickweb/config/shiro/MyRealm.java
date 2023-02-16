package learn.quickweb.config.shiro;

import learn.quickweb.config.jwt.JWTToken;
import learn.quickweb.config.jwt.JWTUtil;
import learn.quickweb.mvc.domain.*;
import learn.quickweb.mvc.mapper.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Peter Cheung
 * 2023/2/13 14:57
 */
@Service
@Slf4j
public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private PermissionRoleMapper permissionRoleMapper;

    /**
     * 大坑！必须重写此方法，不然Shiro会报错！
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String username = JWTUtil.getUserName(principal.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //用户的角色
        Set<String> roles = new HashSet<>();
        //用户的权限
        Set<String> permissions = new HashSet<>();

        UserRole userRole = new UserRole();
        userRole.setUsername(username);
        List<UserRole> userRoles = userRoleMapper.queryAll(userRole);
        for (UserRole role : userRoles) {
            roles.add(role.getRole());
            PermissionRole permissionRole = new PermissionRole();
            permissionRole.setRole(role.getRole());
            List<PermissionRole> permissionRoles = permissionRoleMapper.queryAll(permissionRole);
            for (PermissionRole permission : permissionRoles) {
                permissions.add(permission.getPermission());
            }
        }
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        String token = authenticationToken.getCredentials().toString();
        //解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUserName(token);
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        User user = userMapper.queryById(username);
        if (user == null) {
            throw new AuthenticationException("用户不存在");
        }

        if (!JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("密码错误");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
