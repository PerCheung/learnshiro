package learn.quickweb.mvc.mapper;

import learn.quickweb.mvc.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限表(Permission)表数据库访问层
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:19
 */
@Mapper
public interface PermissionMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param permission 主键
     * @return 实例对象
     */
    Permission queryById(String permission);

    /**
     * 查询指定行数据
     *
     * @param permission 查询条件
     * @return 对象列表
     */
    List<Permission> queryAll(Permission permission);

    /**
     * 模糊查询指定行数据
     *
     * @param permission 查询条件
     * @return 对象列表
     */
    List<Permission> queryAllLike(Permission permission);

    /**
     * 统计总行数
     *
     * @param permission 查询条件
     * @return 总行数
     */
    long count(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Permission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Permission> entities);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param permission 主键
     * @return 影响行数
     */
    int deleteById(String permission);

}

