package com.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/**
 * (BookInformation)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:31
 */
@TableName("book_information")
public class BookInformation implements Serializable {
    private static final long serialVersionUID = 619627733902482430L;
    /**
     * 书的id
     */
    @TableId
    private Long bookId;
    /**
     * 书的名字
     */
    private String bookName;
    /**
     * 书的类型
     */
    private Long bookType;
    /**
     * 书的发布者
     */
    private Long publisherUser;
    /**
     * 是否审核完结0成功1
     */
    private Integer isAudit;
    /**
     * 是否完结0成功1失败
     */
    private Integer isComplete;
    /**
     * 图片路径
     */
    private String bookHeadportraitUrl;
    /**
     * 描述
     */
    private String bookDescription;
    /**
     * 收藏
     */
    private Integer collectionQuantity;
    /**
     * 喜欢
     */
    private Integer likesQuantity;
    /**
     * 最新更新时间
     */
    private Date lastLoginTime;
    /**
     * 最新到的位置
     */
    private String lastLoginChapter;
}

