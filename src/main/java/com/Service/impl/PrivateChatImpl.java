package com.Service.impl;

import com.Mapper.PrivateChatMapper;
import com.Service.PrivateChat;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrivateChatImpl implements PrivateChat {
    @Autowired
    PrivateChatMapper privateChatMapper;
    @Override
    public List<PrivateChat> getListChat(Integer counterpart, Integer Our) {
        return null;
    }
}
