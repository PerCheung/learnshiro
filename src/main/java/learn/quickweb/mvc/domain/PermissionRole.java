package learn.quickweb.mvc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 权限角色连接表(PermissionRole)实体类
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:20
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("权限角色连接表(PermissionRole)实体类")
public class PermissionRole implements Serializable {
    private static final long serialVersionUID = 349722509623785183L;
    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String permission;
    /**
     * 角色
     */
    @ApiModelProperty(value = "角色")
    private String role;
    /**
     * 用此变量排序
     */
    @ApiModelProperty(value = "用此变量排序")
    private String orderByMe;
    /**
     * 升降序
     * <p>
     * ASC：表示按升序排序
     * <p>
     * DESC：表示按降序排序
     */
    @ApiModelProperty(value = "升降序 ASC：表示按升序排序 DESC：表示按降序排序")
    private String orderByMeSort;
}

