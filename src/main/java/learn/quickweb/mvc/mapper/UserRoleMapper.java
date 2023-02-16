package learn.quickweb.mvc.mapper;

import learn.quickweb.mvc.domain.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色连接表(UserRole)表数据库访问层
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:22
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userRole 主键
     * @return 实例对象
     */
    UserRole queryById(UserRole userRole);

    /**
     * 查询指定行数据
     *
     * @param userRole 查询条件
     * @return 对象列表
     */
    List<UserRole> queryAll(UserRole userRole);

    /**
     * 模糊查询指定行数据
     *
     * @param userRole 查询条件
     * @return 对象列表
     */
    List<UserRole> queryAllLike(UserRole userRole);

    /**
     * 统计总行数
     *
     * @param userRole 查询条件
     * @return 总行数
     */
    long count(UserRole userRole);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int insert(UserRole userRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserRole> entities);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param userRole 主键
     * @return 影响行数
     */
    int deleteById(UserRole userRole);

}

