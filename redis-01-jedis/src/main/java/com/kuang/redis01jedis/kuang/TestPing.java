package com.kuang.redis01jedis.kuang;

import redis.clients.jedis.Jedis;

/**
 * 测试jedis
 *
 * @author caoweiquan
 * @date 2021/3/2
 */
public class TestPing {

    public static void main(String[] args) {
        // 1. new jedis 对象
        Jedis jedis = new Jedis("159.75.4.236", 6379);
        jedis.auth("154490984");

        System.out.println(jedis.ping());
        jedis.set("name", "wilche");
        System.out.println("jedis.get(name) = " + jedis.get("name"));
    }

}
