package learn.quickweb.mvc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import learn.quickweb.mvc.domain.Role;
import learn.quickweb.mvc.service.RoleService;
import learn.quickweb.util.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色表(Role)表控制层
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:51
 */
@Slf4j
@RestController
@RequestMapping("role")
@Api(tags = "角色表(Role)表控制层")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 全查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @ApiOperation("全查询")
    @GetMapping
    public R queryAll(@ApiParam(value = "role 筛选条件") Role role) {
        return this.roleService.queryAll(role);
    }

    /**
     * 模糊全查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @ApiOperation("模糊全查询")
    @PostMapping("like")
    public R queryAllLike(@ApiParam(value = "role 筛选条件") Role role) {
        return this.roleService.queryAllLike(role);
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
        return this.roleService.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页查询")
    @PostMapping("page")
    public R page(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "role 筛选条件") @RequestBody Role role) {
        return this.roleService.page(pageNum, pageSize, role);
    }

    /**
     * 分页模糊查询
     *
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @param role     筛选条件
     * @return 查询结果
     */
    @ApiOperation("分页模糊查询")
    @PostMapping("page/like")
    public R pageLike(@ApiParam(value = "页数，不传默认是第一页") @RequestParam(defaultValue = "1") int pageNum, @ApiParam(value = "每页数量，不传默认是10个") @RequestParam(defaultValue = "10") int pageSize, @ApiParam(value = "role 筛选条件") @RequestBody Role role) {
        return this.roleService.pageLike(pageNum, pageSize, role);
    }

    /**
     * 新增数据
     *
     * @param role 实体
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public R add(@ApiParam(value = "role 实体") @RequestBody Role role) {
        return this.roleService.insert(role);
    }

    /**
     * 编辑数据
     *
     * @param role 实体
     * @return 编辑结果
     */
    @ApiOperation("编辑数据")
    @PutMapping
    public R edit(@ApiParam(value = "role 实体") @RequestBody Role role) {
        return this.roleService.update(role);
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
        return this.roleService.deleteById(id);
    }

}

