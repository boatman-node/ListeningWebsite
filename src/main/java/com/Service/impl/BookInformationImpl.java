package com.Service.impl;

import com.Mapper.BookInformationMapper;
import com.Service.BookInformation;
import com.dtos.AppHttpCodeEnum;
import com.dtos.ResponseResult;
import com.pool.SaltStorage;
import com.pool.pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.dtos.AppHttpCodeEnum.SUCCESS;

@Service
public class BookInformationImpl implements BookInformation {
    @Autowired
    BookInformationMapper bookInformationMapper;
    /*插入书籍*/
    @Override
    public ResponseResult InsetBooks(com.entity.BookInformation bookInformation) {
        bookInformation.setBookId(SaltStorage.getId());
        bookInformation.setIsAudit(0);
        bookInformation.setIsAudit(0);
        if (bookInformation.getBookDescription().isEmpty()) {
            bookInformation.setBookDescription("该小说暂时没有描述！");
        }
        bookInformation.setLastLoginTime(new Date());
        if(bookInformation.getLastLoginChapter().isEmpty()){
            bookInformation.setLastLoginChapter("该小说在没有开始创作！");
        }
        return new ResponseResult(bookInformationMapper.insert(bookInformation) == 1 ? SUCCESS : AppHttpCodeEnum.FAIL);
    }

    @Override
    public ResponseResult SelectBooksList(com.entity.BookInformation bookInformation, pageable pageable) {
        return new ResponseResult<>(AppHttpCodeEnum.SUCCESS,bookInformationMapper.queryAllByLimit(bookInformation,pageable));
    }

}
