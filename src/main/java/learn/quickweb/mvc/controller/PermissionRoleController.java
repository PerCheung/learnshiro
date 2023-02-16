package learn.quickweb.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.PermissionRole;
import learn.quickweb.mvc.service.PermissionRoleService;
import learn.quickweb.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限角色连接表(PermissionRole)表控制层
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:20
 */
@Slf4j
@RestController
@RequestMapping("permissionrole")
@Api(tags = "权限角色连接表(PermissionRole)表控制层")
public class PermissionRoleController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionRoleService permissionRoleService;

    /**
     * 全查询
     *
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("全查询")
    @GetMapping
    public R queryAll(@ApiParam(value = "permissionRole 筛选条件") PermissionRole permissionRole) {
        return this.permissionRoleService.queryAll(permissionRole);
    }

    /**
     * 模糊全查询
     *
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("模糊全查询")
    @PostMapping("like")
    public R queryAllLike(@ApiParam(value = "permissionRole 筛选条件") PermissionRole permissionRole) {
        return this.permissionRoleService.queryAllLike(permissionRole);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("this")
    public R queryById(@ApiParam(value = "permissionRole 筛选条件") PermissionRole permissionRole) {
        return this.permissionRoleService.queryById(permissionRole);
    }

    /**
     * 分页查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("page")
    public R page(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "permissionRole 筛选条件") @RequestBody PermissionRole permissionRole) {
        return this.permissionRoleService.page(pageNum, pageSize, permissionRole);
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum        页数
     * @param pageSize       每页数量
     * @param permissionRole 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页模糊查询")
    @PostMapping("page/like")
    public R pageLike(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "permissionRole 筛选条件") @RequestBody PermissionRole permissionRole) {
        return this.permissionRoleService.pageLike(pageNum, pageSize, permissionRole);
    }

    /**
     * 新增数据
     *
     * @param permissionRole 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R add(@ApiParam(value = "permissionRole 实体") @RequestBody PermissionRole permissionRole) {
        return this.permissionRoleService.insert(permissionRole);
    }

    /**
     * 编辑数据
     *
     * @param permissionRole 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public R edit(@ApiParam(value = "permissionRole 实体") @RequestBody PermissionRole permissionRole) {
        return this.permissionRoleService.update(permissionRole);
    }

    /**
     * 删除数据
     *
     * @param permissionRole 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping
    public R deleteById(@ApiParam(value = "permissionRole 筛选条件") PermissionRole permissionRole) {
        return this.permissionRoleService.deleteById(permissionRole);
    }

}

