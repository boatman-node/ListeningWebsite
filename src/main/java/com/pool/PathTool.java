package com.pool;

import java.util.Random;
import java.util.UUID;

public class PathTool {
    static public String  GETPath(){

        return UUID.randomUUID().toString();
    }

    static public long  GETId(){

        return new Random().nextLong();
    }
}
