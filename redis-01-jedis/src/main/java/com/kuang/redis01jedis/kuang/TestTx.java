package com.kuang.redis01jedis.kuang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Redis事务测试
 *
 * @author caoweiquan
 * @date 2021/3/2
 */
public class TestTx {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("159.75.4.236", 6379);
        jedis.auth("154490984");
        Transaction multi = jedis.multi();
        try {
            multi.set("user:2:name", "wilche");
            multi.set("user:2:age", "12");
            int i = 1/0;

            multi.exec();
        } catch (Exception e) {
            multi.discard();
            e.printStackTrace();
        } finally {
            System.out.println("jedis.mget(\"user:2:name\", \"user:2:age\") = " + jedis.mget("user:2:name", "user:2:age"));
            jedis.close();
        }
    }

}
