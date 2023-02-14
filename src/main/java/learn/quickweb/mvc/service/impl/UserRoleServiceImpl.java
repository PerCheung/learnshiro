package learn.quickweb.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.UserRole;
import learn.quickweb.mvc.mapper.UserRoleMapper;
import learn.quickweb.mvc.service.UserRoleService;
import learn.quickweb.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色连接表(UserRole)表服务实现类
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:52
 */
@Slf4j
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Integer id) {
        return R.ok().setData(this.userRoleMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(UserRole userRole) {
        return R.ok().setData(this.userRoleMapper.queryAll(userRole));
    }

    /**
     * 模糊全查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(UserRole userRole) {
        return R.ok().setData(this.userRoleMapper.queryAllLike(userRole));
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, UserRole userRole) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userRoleMapper.queryAll(userRole)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param userRole 筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, UserRole userRole) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userRoleMapper.queryAllLike(userRole)));
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(UserRole userRole) {
        this.userRoleMapper.insert(userRole);
        return R.ok().setData(userRole);
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public R update(UserRole userRole) {
        this.userRoleMapper.update(userRole);
        return R.ok().setData(this.userRoleMapper.queryById(userRole.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Integer id) {
        boolean del = this.userRoleMapper.deleteById(id) > 0;
        return R.ok().setData(del);
    }
}
