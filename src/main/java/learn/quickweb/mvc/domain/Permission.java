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
 * 权限表(Permission)实体类
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:19
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("权限表(Permission)实体类")
public class Permission implements Serializable {
    private static final long serialVersionUID = 852874834686124349L;
    /**
     * 权限
     */
    @ApiModelProperty(value = "权限")
    private String permission;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
    /**
     * 逻辑删除
     */
    @ApiModelProperty(value = "逻辑删除")
    private Integer deleted;
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

