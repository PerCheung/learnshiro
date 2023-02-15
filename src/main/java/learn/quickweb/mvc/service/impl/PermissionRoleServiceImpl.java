package learn.quickweb.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.PermissionRole;
import learn.quickweb.mvc.mapper.PermissionRoleMapper;
import learn.quickweb.mvc.service.PermissionRoleService;
import learn.quickweb.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限角色连接表(PermissionRole)表服务实现类
 *
 * @author Peter Cheung
 * @since 2023-02-15 15:43:40
 */
@Slf4j
@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {
    @Resource
    private PermissionRoleMapper permissionRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Integer id) {
        return R.ok().data(this.permissionRoleMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(PermissionRole permissionRole) {
        return R.ok().data(this.permissionRoleMapper.queryAll(permissionRole));
    }

    /**
     * 模糊全查询
     *
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(PermissionRole permissionRole) {
        return R.ok().data(this.permissionRoleMapper.queryAllLike(permissionRole));
    }

    /**
     * 分页查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, PermissionRole permissionRole) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionRoleMapper.queryAll(permissionRole)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, PermissionRole permissionRole) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionRoleMapper.queryAllLike(permissionRole)));
    }

    /**
     * 新增数据
     *
     * @param permissionRole 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(PermissionRole permissionRole) {
        this.permissionRoleMapper.insert(permissionRole);
        return R.ok().data(permissionRole);
    }

    /**
     * 修改数据
     *
     * @param permissionRole 实例对象
     * @return 实例对象
     */
    @Override
    public R update(PermissionRole permissionRole) {
        this.permissionRoleMapper.update(permissionRole);
        return R.ok().data(this.permissionRoleMapper.queryById(permissionRole.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Integer id) {
        boolean del = this.permissionRoleMapper.deleteById(id) > 0;
        return R.ok().data(del);
    }
}
