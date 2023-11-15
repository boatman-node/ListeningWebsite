package com.enumerate;

public enum filetype {
    image("image/jpeg"),
    audio("audio/wav");


    String value;


    filetype( String value){

       this.value=value;
    }

    public String getValue() {
        return value;
    }
}
