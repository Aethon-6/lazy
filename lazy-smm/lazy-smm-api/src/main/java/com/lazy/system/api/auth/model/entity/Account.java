package com.lazy.system.api.auth.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 账号表
 * </p>
 *
 * @author ywx
 * @since 2024-09-25
 */
@Data
@Builder
@Getter
@Setter
@TableName("lazy_account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;

    /**
     * 账号
     */
    @TableField("loginname")
    private String loginname;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /**
     * 排序号
     */
    @TableField(value = "sort_num", fill = FieldFill.INSERT)
    private Integer sortNum;

    /**
     * 是否删除（0：未删除；1：已删除）
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    @TableLogic
    private String delFlag;
}
