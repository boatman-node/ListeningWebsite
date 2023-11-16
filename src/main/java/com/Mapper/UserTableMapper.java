package com.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.UserTable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserTableMapper extends BaseMapper<UserTable> {
    Integer deleteById(Integer integer);
    int insert(UserTable userTable);
}
