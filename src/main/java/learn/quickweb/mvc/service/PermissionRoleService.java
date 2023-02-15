package learn.quickweb.mvc.service;

import learn.quickweb.mvc.domain.PermissionRole;
import learn.quickweb.util.R;

/**
 * 权限角色连接表(PermissionRole)表服务接口
 *
 * @author Peter Cheung
 * @since 2023-02-15 15:43:40
 */
public interface PermissionRoleService {

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
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    R queryAll(PermissionRole permissionRole);

    /**
     * 模糊全查询
     *
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    R queryAllLike(PermissionRole permissionRole);

    /**
     * 分页查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    R page(int pageNum, int pageSize, PermissionRole permissionRole);

    /**
     * 分页模糊查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    R pageLike(int pageNum, int pageSize, PermissionRole permissionRole);

    /**
     * 新增数据
     *
     * @param permissionRole 实例对象
     * @return 实例对象
     */
    R insert(PermissionRole permissionRole);

    /**
     * 修改数据
     *
     * @param permissionRole 实例对象
     * @return 实例对象
     */
    R update(PermissionRole permissionRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    R deleteById(Integer id);

}
