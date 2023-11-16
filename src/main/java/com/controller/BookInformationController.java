package com.controller;

import com.Mapper.BookInformationMapper;
import com.Service.impl.BookInformationImpl;
import com.Service.impl.MinioImpl;
import com.dtos.ResponseResult;
import com.entity.BookInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController("/Book")
public class BookInformationController {
    @Autowired
    MinioImpl minio;
    @Autowired
    BookInformationImpl bookInformation;
    @PostMapping("/publishBook")
    public ResponseResult publishBook(MultipartFile file, BookInformation bookInformation){
        String ImgPath="https://img2.baidu.com/it/u=1043407016,3396810233&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1700240400&t=c908a3a9f8bc428c9a946b4b5a02f610";
        if(!file.isEmpty()&&file.getContentType().startsWith("image/")){
            ImgPath=minio.MinioPath(file);}
        bookInformation.setBookHeadportraitUrl(ImgPath);
        return this.bookInformation.InsetBooks(bookInformation);
    }
}
