package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserTable)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("user_table")
public class UserTable implements Serializable {
    private static final long serialVersionUID = 398797925999729292L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名字
     */
    private String userAccountname;
    /**
     * 用户密码
     */
    private String userAccountpassword;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户注册代码
     */
    private String userRegistrationcode;
    /**
     * 用户头像
     */
    private String userHeadportraitUrl;
    /**
     * 用户注册时间
     */
    private Date userRegistrationdate;
    /**
     * 用户上次登陆时间
     */
    private Date lastLoginTime;
    /**
     * 加盐
     */
    private String userSalt;

}

