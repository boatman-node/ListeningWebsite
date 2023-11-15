package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserFavorites)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("user_favorites")
public class UserFavorites implements Serializable {
    private static final long serialVersionUID = -45372666975771071L;
    /**
     * 收藏夹id
     */
    private Long favoritesId;
    /**
     * 创建的用户
     */
    private Long userId;
    /**
     * 收藏夹名字
     */
    private String favoritesName;
    /**
     * 创建时间
     */
    private Date favoritesRegistrationdate;
    /**
     * 是否私密
     */
    private Integer isPrivacy;
}

