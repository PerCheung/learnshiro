package learn.quickweb.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.Permission;
import learn.quickweb.mvc.service.PermissionService;
import learn.quickweb.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限表(Permission)表控制层
 *
 * @author Peter Cheung
 * @since 2023-02-15 15:43:38
 */
@Slf4j
@RestController
@RequestMapping("permission")
@Api(tags = "权限表(Permission)表控制层")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @ApiOperation("全查询")
    @GetMapping
    public R queryAll(@ApiParam(value = "permission 筛选条件") Permission permission) {
        return this.permissionService.queryAll(permission);
    }

    /**
     * 模糊全查询
     *
     * @param permission 筛选条件
     * @return 查询结果
     */
    @ApiOperation("模糊全查询")
    @PostMapping("like")
    public R queryAllLike(@ApiParam(value = "permission 筛选条件") Permission permission) {
        return this.permissionService.queryAllLike(permission);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public R queryById(@ApiParam(value = "id 主键") @PathVariable("id") Integer id) {
        return this.permissionService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("page")
    public R page(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "permission 筛选条件") @RequestBody Permission permission) {
        return this.permissionService.page(pageNum, pageSize, permission);
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum    页数
     * @param pageSize   每页数量
     * @param permission 筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页模糊查询")
    @PostMapping("page/like")
    public R pageLike(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "permission 筛选条件") @RequestBody Permission permission) {
        return this.permissionService.pageLike(pageNum, pageSize, permission);
    }

    /**
     * 新增数据
     *
     * @param permission 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R add(@ApiParam(value = "permission 实体") @RequestBody Permission permission) {
        return this.permissionService.insert(permission);
    }

    /**
     * 编辑数据
     *
     * @param permission 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public R edit(@ApiParam(value = "permission 实体") @RequestBody Permission permission) {
        return this.permissionService.update(permission);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation("删除数据")
    @DeleteMapping
    public R deleteById(@ApiParam(value = "id 主键") @RequestParam Integer id) {
        return this.permissionService.deleteById(id);
    }

}

