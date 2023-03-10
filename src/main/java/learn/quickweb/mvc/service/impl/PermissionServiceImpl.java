package learn.quickweb.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.Permission;
import learn.quickweb.mvc.mapper.PermissionMapper;
import learn.quickweb.mvc.service.PermissionService;
import learn.quickweb.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 权限表(Permission)表服务实现类
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:20
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param permission 主键
     * @return 实例对象
     */
    @Override
    public R queryById(String permission) {
        return R.ok().data(this.permissionMapper.queryById(permission));
    }

    /**
     * 全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(Permission permission) {
        return R.ok().data(this.permissionMapper.queryAll(permission));
    }

    /**
     * 模糊全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(Permission permission) {
        return R.ok().data(this.permissionMapper.queryAllLike(permission));
    }

    /**
     * 分页查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, Permission permission) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionMapper.queryAll(permission)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, Permission permission) {
        return R.ok().data(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.permissionMapper.queryAllLike(permission)));
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Permission permission) {
        this.permissionMapper.insert(permission);
        return R.ok().data(permission);
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Permission permission) {
        this.permissionMapper.update(permission);
        return R.ok().data(this.permissionMapper.queryById(permission.getPermission()));
    }

    /**
     * 通过主键删除数据
     *
     * @param permission 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(String permission) {
        boolean del = this.permissionMapper.deleteById(permission) > 0;
        return R.ok().data(del);
    }
}
