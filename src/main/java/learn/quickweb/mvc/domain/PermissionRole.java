package learn.quickweb.mvc.domain;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限角色连接表(PermissionRole)实体类
 *
 * @author Peter Cheung
 * @since 2023-02-13 15:17:50
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("权限角色连接表(PermissionRole)实体类")
public class PermissionRole implements Serializable {
    private static final long serialVersionUID = 179064312454649521L;
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer id;
    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id")
    private String permissionId;
    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private String roleId;
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

