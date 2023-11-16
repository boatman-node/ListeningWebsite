package com.Service.impl;

import com.Mapper.UserTableMapper;
import com.Service.UserTable;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dtos.AppHttpCodeEnum;
import com.dtos.ResponseResult;
import com.entity.Token;
import com.google.gson.Gson;
import com.pool.JWTUtil;
import com.pool.SaltStorage;
import com.pool.SaltedEncryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserTableImpl implements UserTable {
    @Autowired
    UserTableMapper mapper;
    @Autowired
    JWTUtil jwtUtil;
    @Override
    public ResponseResult enrollAccount(com.entity.UserTable table) {
        if(!(table.getUserAccountname().isEmpty()||table.getUserAccountpassword().isEmpty()||table.getUserEmail().isEmpty())){
            if(table!=null){
        ResponseResult objectResponseResult ;
        if (mapper.selectCount(new LambdaQueryWrapper<com.entity.UserTable>().eq(com.entity.UserTable::getUserEmail,table.getUserEmail()))<=0) {
            table.setUserId(SaltStorage.getId());
            String salt = SaltStorage.getSalt();
            table.setUserRegistrationcode(salt);
            table.setUserSalt(salt);
            table.setAuthorityCode(salt);
            table.setUserAccountpassword(SaltedEncryption.encryptWithSalt(table.getUserAccountpassword(),salt));
            table.setUserRegistrationdate(new Date());
            if (mapper.insert(table)==1) {
                objectResponseResult = new ResponseResult<>(AppHttpCodeEnum.SUCCESS, jwtUtil.generateToken(table.getUserId().toString()));
                return objectResponseResult;
             }
           }
        }

        }
        return new ResponseResult<>(AppHttpCodeEnum.FAIL);
    }
}
