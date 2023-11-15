package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserAudiocoin)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("user_audiocoin")
public class UserAudiocoin implements Serializable {
    private static final long serialVersionUID = 145385132619722471L;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户金币
     */
    private Integer audiocoin;
    /**
     * 用户是否开通了vip
     */
    private Integer isVip;
    /**
     * vip的购买时间
     */
    private Date vipStartDate;
    /**
     * vip的结束时间
     */
    private Date vipEndDate;
}

