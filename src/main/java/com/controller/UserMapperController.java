package com.controller;

import com.Service.impl.MinioImpl;
import com.Service.impl.UserTableImpl;
import com.dtos.ResponseResult;
import com.entity.UserTable;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
@ApiModel("用户")
@RestController("/User")
public class UserMapperController {
    @Autowired
    UserTableImpl userTableImpl;
    @Autowired
    MinioImpl minio;
    @PostMapping("/Login")
    public ResponseResult Login(MultipartFile filter, UserTable userTable){
      String ImgPath="https://img2.baidu.com/it/u=1043407016,3396810233&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1700240400&t=c908a3a9f8bc428c9a946b4b5a02f610";
      if(!filter.isEmpty()&&filter.getContentType().startsWith("image/")){
          ImgPath=minio.MinioPath(filter);}
      userTable.setUserHeadportraitUrl(ImgPath);
         return   userTableImpl.enrollAccount(userTable);
    }
}
