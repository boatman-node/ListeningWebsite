package com.Service;

import com.dtos.ResponseResult;
import com.pool.pageable;
import org.springframework.http.ResponseEntity;

public interface BookInformation  {
    ResponseResult InsetBooks(com.entity.BookInformation bookInformation);

    ResponseResult SelectBooksList(com.entity.BookInformation bookInformation, pageable pageable);
}
