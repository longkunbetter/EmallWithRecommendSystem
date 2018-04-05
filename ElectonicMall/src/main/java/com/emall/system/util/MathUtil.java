package com.emall.system.util;

import java.util.Random;

public class MathUtil {
    public static final Random RANDOM = new Random();

    /**
     * 获取0-range范围内的随机整数
     * @param range
     *          0 - range
     * */
    public static int getRandomInteger(int range){
        return RANDOM.nextInt(range);
    }
}
