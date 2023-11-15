package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
/**
 * (Classificationtype)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@TableName("classificationtype")
public class Classificationtype implements Serializable {
    private static final long serialVersionUID = 113828021073417009L;
    /**
     * 书的类型
     */
    private Long bookType;
    /**
     * 书名
     */
    private String bookName;

}

