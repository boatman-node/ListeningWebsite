package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * (FavoritesDetails)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("favorites_details")
public class FavoritesDetails implements Serializable {
    private static final long serialVersionUID = 164636683560808241L;
    /**
     * 收藏夹Id
     */
    private Long favoritesId;
    /**
     * 书籍Id
     */
    private Long bookId;

}

