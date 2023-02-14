package learn.quickweb.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.Role;
import learn.quickweb.mvc.mapper.RoleMapper;
import learn.quickweb.mvc.service.RoleService;
import learn.quickweb.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色表(Role)表服务实现类
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:51
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Integer id) {
        return R.ok().setData(this.roleMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(Role role) {
        return R.ok().setData(this.roleMapper.queryAll(role));
    }

    /**
     * 模糊全查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(Role role) {
        return R.ok().setData(this.roleMapper.queryAllLike(role));
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, Role role) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.roleMapper.queryAll(role)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, Role role) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.roleMapper.queryAllLike(role)));
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(Role role) {
        this.roleMapper.insert(role);
        return R.ok().setData(role);
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public R update(Role role) {
        this.roleMapper.update(role);
        return R.ok().setData(this.roleMapper.queryById(role.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Integer id) {
        boolean del = this.roleMapper.deleteById(id) > 0;
        return R.ok().setData(del);
    }
}
