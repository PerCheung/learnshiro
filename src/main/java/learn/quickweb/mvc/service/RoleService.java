package learn.quickweb.mvc.service;

import learn.quickweb.mvc.domain.Role;
import learn.quickweb.util.R;

/**
 * 角色表(Role)表服务接口
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:51
 */
public interface RoleService {

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
     * @param role 筛选条件
     * @return 查询结果
     */
    R queryAll(Role role);

    /**
     * 模糊全查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    R queryAllLike(Role role);

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, Role role);

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, Role role);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    R insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    R update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(Integer id);

}
