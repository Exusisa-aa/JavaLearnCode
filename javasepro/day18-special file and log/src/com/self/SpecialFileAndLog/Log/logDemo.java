package com.self.SpecialFileAndLog.Log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logDemo {

    public static final Logger LOGGER = LoggerFactory.getLogger("logTrace");

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            try {
                LOGGER.info("开始执行除法~~");
                divide(10,0);
                LOGGER.info("除法执行结束~~");
            } catch (Exception e) {
                LOGGER.error("除法执行失败~~");
            }
        }
    }

    public static void divide(int a, int b) {
        LOGGER.debug("取得数据a:" + a);
        LOGGER.debug("取得数据b:" + b);
        int c = a / b;
        LOGGER.info("结果是" + c);
    }
}
