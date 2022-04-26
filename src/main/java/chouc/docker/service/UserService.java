package chouc.docker.service;


import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import chouc.docker.entities.User;
import chouc.docker.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

    public static final String CACHE_KEY_USER = "user:";

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;


    public User findUserById(Integer id) {
        User user = null;
        String key = CACHE_KEY_USER + id;
        user = (User) redisTemplate.opsForValue().get(key);
        if (user == null) {
            user = userMapper.selectByPrimaryKey(id);
            if (user == null) {
                return user;
            } else {
                redisTemplate.opsForValue().set(key, user);
            }
        } else {
            user.setUsername(user.getUsername()+" from redis ");
        }
        return user;
    }
}
