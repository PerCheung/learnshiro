package learn.quickweb.mvc.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.User;
import learn.quickweb.mvc.mapper.UserMapper;
import learn.quickweb.mvc.service.UserService;
import learn.quickweb.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(User)表服务实现类
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:51
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public R queryById(Integer id) {
        return R.ok().setData(this.userMapper.queryById(id));
    }

    /**
     * 全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAll(User user) {
        return R.ok().setData(this.userMapper.queryAll(user));
    }

    /**
     * 模糊全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    @Override
    public R queryAllLike(User user) {
        return R.ok().setData(this.userMapper.queryAllLike(user));
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @Override
    public R page(int pageNum, int pageSize, User user) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userMapper.queryAll(user)));
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    @Override
    public R pageLike(int pageNum, int pageSize, User user) {
        return R.ok().setData(PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> this.userMapper.queryAllLike(user)));
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public R insert(User user) {
        this.userMapper.insert(user);
        return R.ok().setData(user);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public R update(User user) {
        this.userMapper.update(user);
        return R.ok().setData(this.userMapper.queryById(user.getId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public R deleteById(Integer id) {
        boolean del = this.userMapper.deleteById(id) > 0;
        return R.ok().setData(del);
    }
}
