package com.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.BookInformation;
import com.pool.pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInformationMapper extends BaseMapper<BookInformation> {
     List<BookInformation> queryAllByLimit(BookInformation bookInformation, pageable pageable);
     int insert(BookInformation bookInformation);
}
