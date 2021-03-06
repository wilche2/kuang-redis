package com.kuang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kuang.pojo.User;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate2;

//    @Autowired
//    private RedisUtil redisUtil;

    @Test
    void contextLoads() throws JSONException, JsonProcessingException {

//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushAll();
        ValueOperations valueOperations = redisTemplate2.opsForValue();

        User u = new User();
        u.setName("caoweiquan");
        // String s = new ObjectMapper().writeValueAsString(u);

        // 从redis-cli去看，会发现是转义过后的数据，是因为序列化的缘故
        valueOperations.set("test1", u);
        System.out.println("valueOperations.get(\"test1\") = " + valueOperations.get("test1"));
    }

//    @Test
//    void testRedisUtil() throws JsonProcessingException {
//        User u = new User();
//        u.setName("777777777777777777");
//        redisUtil.set("user", new ObjectMapper().writeValueAsString(u));
//        System.out.println("redisUtil.get(\"user\") = " + redisUtil.get("user"));
//    }

}
