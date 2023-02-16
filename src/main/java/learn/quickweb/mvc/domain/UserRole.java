package learn.quickweb.mvc.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 用户角色连接表(UserRole)实体类
 *
 * @author Peter Cheung
 * @since 2023-02-16 13:26:22
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户角色连接表(UserRole)实体类")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 982985545954513997L;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;
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

