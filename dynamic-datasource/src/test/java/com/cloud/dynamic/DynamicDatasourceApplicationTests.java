package com.cloud.dynamic;

import com.cloud.dynamic.entity.User;
import com.cloud.dynamic.repository.UserMapper;
import com.cloud.dynamic.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicDatasourceApplicationTests {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        User user = new User();
        user.setUsername("master");
        user.setPassword("master");
        user.setSex(1);
        user.setAge(18);
        int save = userMapper.save(user);
        System.out.println(save);
        Assert.assertEquals(1, userMapper.save(user));
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setPassword("123456");
        // 返回插入的记录数 ，期望是1条 如果实际不是一条则抛出异常
        int update = userMapper.update(user);
        System.out.println(update);
        Assert.assertEquals(1, userMapper.update(user));
    }

    @Test
    public void selectById() {
        User user = userMapper.selectById(1);
        System.out.println("id:" + user.getId());
        System.out.println("name:" + user.getUsername());
        System.out.println("password:" + user.getPassword());
    }

    @Test
    public void deleteById() {
        Assert.assertEquals(1, userMapper.deleteById(1));
    }

    @Test
    public void selectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(user -> {
            System.out.println("id:" + user.getId());
            System.out.println("name:" + user.getUsername());
            System.out.println("password:" + user.getPassword());
        });
    }

    @Test
    public void testTransactional() {
        userService.testTransactional();
    }


}
