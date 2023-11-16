package com.pool;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.Random;
import java.util.UUID;

public class SaltStorage {
    public static String getSalt() {
        return UUID.randomUUID().toString().substring(0,6);
    }

    public static long getId() {
        return new Random().nextLong();
    }
}