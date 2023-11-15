package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * (VoiceInformation)实体类
 *
 * @author makejava
 * @since 2023-11-14 23:02:41
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@TableName("voice_information")
public class VoiceInformation implements Serializable {
    private static final long serialVersionUID = 970916626406242424L;
    /**
     * 声音id
     */
    private Long voiceId;
    /**
     * 书的id
     */
    private Long bookId;
    /**
     * 音频的描述
     */
    private String voiceDescribed;
    /**
     * 音频的集数
     */

    private Integer described;
    /**
     * 音频的url
     */
    private String voiceUrl;

}

