package learn.quickweb.mvc.service;

import learn.quickweb.mvc.domain.User;
import learn.quickweb.util.R;

/**
 * 用户表(User)表服务接口
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:22
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    R queryById(String username);

    /**
     * 全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    R queryAll(User user);

    /**
     * 模糊全查询
     *
     * @param user 筛选条件
     * @return 查询结果
     */
    R queryAllLike(User user);

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, User user);

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param user     筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    R update(User user);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    R deleteById(String username);

}
