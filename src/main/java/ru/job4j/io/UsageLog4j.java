package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        int i = 33;
        double d = 1.234;
        byte b = 125;
        long l = 2147483648L;
        short s = 32666;
        char a = 'a';
        float f = 3.14f;
        boolean isWorking = true;
        LOG.debug("User info  int : {}, double : {}, byte : {}, long : {},  short : {}, char : {}, float : {}, isWorking : {}", i, d, b, l, s, a, f, isWorking);
    }
}
