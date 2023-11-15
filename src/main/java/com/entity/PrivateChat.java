package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * (PrivateChat)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("private_chat")
public class PrivateChat implements Serializable {
    private static final long serialVersionUID = 353813471724655129L;
    /**
     * 发送方
     */
    private Long dispatcherUserId;
    /**
     * 接受方
     */
    private Long recipientUserId;
    /**
     * 发送时间
     */
    private Date dispatcherDate;
    /**
     * 是否撤销
     */
    private Integer isRevocation;
    /**
     * 消息
     */
    private String msg;
    /**
     * 聊天id
     */
    private Integer dispatcherId;

}

