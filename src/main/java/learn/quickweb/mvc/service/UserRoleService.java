package learn.quickweb.mvc.service;

import learn.quickweb.mvc.domain.UserRole;
import learn.quickweb.util.R;

/**
 * 用户角色连接表(UserRole)表服务接口
 *
 * @author Peter Cheung
 * @since 2023-02-15 15:43:43
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    R queryById(Integer id);

    /**
     * 全查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    R queryAll(UserRole userRole);

    /**
     * 模糊全查询
     *
     * @param userRole 筛选条件
     * @return 查询结果
     */
    R queryAllLike(UserRole userRole);

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param userRole 筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, UserRole userRole);

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param userRole 筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, UserRole userRole);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    R insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    R update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(Integer id);

}
