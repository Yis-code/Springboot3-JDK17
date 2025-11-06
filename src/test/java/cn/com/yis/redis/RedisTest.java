package cn.com.yis.redis;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testStringRedisTemplate() {
        // 测试String类型的存储和获取
        String key = "test:string:key";
        String value = "Hello Redis!2222";

        boolean exists = stringRedisTemplate.hasKey(key);
        log.info("key是否存在: {}", exists);

        // 存储数据
        if (!exists) {
            stringRedisTemplate.opsForValue().set(key, value);
        }

        // 读取数据
        String result = stringRedisTemplate.opsForValue().get(key);
        log.info("从Redis获取的值: {}", result);
        
        // 验证结果
        assertEquals(value, result);
    }

    @Test
    public void testJsonRedisTemplate() {
        // 1、添加K-V缓存
        stringRedisTemplate.opsForValue().set("key-01", "value-01", 300, TimeUnit.SECONDS);
        // 2、添加JSON格式
        String jsonStr = JSONObject.of("name", "张三", "age", 18).toJSONString();
        stringRedisTemplate.opsForValue().set("key-02", jsonStr, 500, TimeUnit.SECONDS);
        Object key01 = stringRedisTemplate.opsForValue().get("key-01");
        Object key02 = stringRedisTemplate.opsForValue().get("key-02");
        log.info("key01：{},key02：{}", key01, key02);
    }

    @Test
    public void testRedisTemplate() {
        // 测试对象类型的存储和获取
        String key = "test:object:key";
        User user = new User(1L, "张三", "zhangsan@example.com");

        // 存储对象
        redisTemplate.opsForValue().setIfPresent(key, user);

        // 读取对象
        // 修改testRedisTemplate方法中的类型转换
        User result = (User) redisTemplate.opsForValue().get(key);
        log.info("从Redis获取的用户对象: {}", result);

        // 验证结果
        assertNotNull(result);
        assertEquals(user.getId(), result.getId());
        assertEquals(user.getName(), result.getName());
        assertEquals(user.getEmail(), result.getEmail());

    }

    @Test
    public void testHashOperations() {
        // 测试Hash类型的操作
        String key = "test:hash:user";
        String hashKey1 = "id";
        String hashValue1 = "1001";
        String hashKey2 = "name";
        String hashValue2 = "李四";

        // 存储Hash数据
        stringRedisTemplate.opsForHash().put(key, hashKey1, hashValue1);
        stringRedisTemplate.opsForHash().put(key, hashKey2, hashValue2);

        // 获取单个Hash值
        String id = (String) stringRedisTemplate.opsForHash().get(key, hashKey1);
        String name = (String) stringRedisTemplate.opsForHash().get(key, hashKey2);

        System.out.println("从Redis Hash获取的id: " + id);
        System.out.println("从Redis Hash获取的name: " + name);

        // 验证结果
        assertEquals(hashValue1, id);
        assertEquals(hashValue2, name);

        // 删除Hash中的一个字段
//        stringRedisTemplate.opsForHash().delete(key, hashKey1);
//        assertNull(stringRedisTemplate.opsForHash().get(key, hashKey1), "删除后应返回null");
    }

    @Test
    public void testKeyOperations() {
        // 测试键的基本操作
        String key1 = "test:key:1";
        String key2 = "test:key:2";

        // 设置键值
        stringRedisTemplate.opsForValue().set(key1, "value1");
        stringRedisTemplate.opsForValue().set(key2, "value2");

        // 检查键是否存在
        boolean exists1 = stringRedisTemplate.hasKey(key1);
        boolean exists2 = stringRedisTemplate.hasKey(key2);

        System.out.println("key1是否存在: " + exists1);
        System.out.println("key2是否存在: " + exists2);

        // 验证结果
        assertEquals(true, exists1);
        assertEquals(true, exists2);

        // 删除键
        stringRedisTemplate.delete(key1);
        exists1 = stringRedisTemplate.hasKey(key1);

        System.out.println("删除后key1是否存在: " + exists1);
        assertEquals(false, exists1);
    }

    // 内部User类用于测试对象存储
    static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        private Long id;
        private String name;
        private String email;

        public User(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}