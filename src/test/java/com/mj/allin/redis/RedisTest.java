package com.mj.allin.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtil redisUtils;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 插入缓存数据
     */
    @Test
    public void set() {
        redisUtils.set("redis_key", "redis_vale");
    }

    /**
     * 读取缓存数据
     */
    @Test
    public void get() {
        String value = redisUtils.get("redis_key");
        System.out.println(value);
    }
    @Test
    public void test1(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().leftPush("department","dept"+i);
        }
    }
    @Test
    public void testTest1(){
        List<String> list = redisTemplate.opsForList().range("department",0,-1);
        if (list != null && list.size()>0){
            list.forEach(s-> System.out.println(s));
        }
    }

    @Test
    public void testHash(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForHash().put("myhash","hash"+i,""+i);
        }
    }
    @Test
    public void testTestHash(){
        Map<String,String> map = new HashMap<>();
        Map<Object, Object> myhash = redisTemplate.opsForHash().entries("myhash");
        myhash.forEach((k,v) ->{System.out.println(k+" "+v);});
        System.out.println("1");
    }
    @Test
    public void testList(){
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().leftPush("mylist",i+""+i);
        }
    }
    @Test
    public void testTestList(){
        //获取集合指定位置的值。index
        String index = redisTemplate.opsForList().index("mylist", 2);
        System.out.println(index);
        //获取指定区间的值。range
        List<String> range = redisTemplate.opsForList().range("mylist", 0, -1);
        range.forEach(s -> System.out.println(s));
        //把最后一个参数值放到指定集合的第一个出现中间参数的前面，如果中间参数值存在的话。leftPush
        Long mylist = redisTemplate.opsForList().leftPush("mylist", "33", "43");
        List<String> range1 = redisTemplate.opsForList().range("mylist", 0, -1);
        range1.forEach(s -> System.out.println(s));
        //size
        Long mylist1 = redisTemplate.opsForList().size("mylist");
        System.out.println(mylist1);
    }
    @Test
    public void testSet(){
        //向变量中批量添加值
        redisTemplate.opsForSet().add("setValue","A","B","C","D","E","F");

    }

}
