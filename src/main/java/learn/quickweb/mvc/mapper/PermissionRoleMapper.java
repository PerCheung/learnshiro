package learn.quickweb.mvc.mapper;

import learn.quickweb.mvc.domain.PermissionRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限角色连接表(PermissionRole)表数据库访问层
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:20
 */
@Mapper
public interface PermissionRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param permissionRole 主键
     * @return 实例对象
     */
    PermissionRole queryById(PermissionRole permissionRole);

    /**
     * 查询指定行数据
     *
     * @param permissionRole 查询条件
     * @return 对象列表
     */
    List<PermissionRole> queryAll(PermissionRole permissionRole);

    /**
     * 模糊查询指定行数据
     *
     * @param permissionRole 查询条件
     * @return 对象列表
     */
    List<PermissionRole> queryAllLike(PermissionRole permissionRole);

    /**
     * 统计总行数
     *
     * @param permissionRole 查询条件
     * @return 总行数
     */
    long count(PermissionRole permissionRole);

    /**
     * 新增数据
     *
     * @param permissionRole 实例对象
     * @return 影响行数
     */
    int insert(PermissionRole permissionRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PermissionRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PermissionRole> entities);

    /**
     * 修改数据
     *
     * @param permissionRole 实例对象
     * @return 影响行数
     */
    int update(PermissionRole permissionRole);

    /**
     * 通过主键删除数据
     *
     * @param permissionRole 主键
     * @return 影响行数
     */
    int deleteById(PermissionRole permissionRole);

}

