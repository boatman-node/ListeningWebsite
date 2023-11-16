package com.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseResult <T> implements Serializable {
        private int code;
        private String message;
        private T data;

        public ResponseResult(AppHttpCodeEnum success) {
                this.code=success.code;
                this.message=success.getErrorMessage();
        }

        public ResponseResult(AppHttpCodeEnum success,T data) {
                this.code=success.code;
                this.message=success.getErrorMessage();
                this.data=data;
        }

}
