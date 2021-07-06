package com.zx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.mapper.UserMapper;
import com.zx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * @Author 11633
 * @Date 2021/7/6 9:56
 * @Version 1.0
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test//姓名不为空，邮箱不为空，年龄大于等于18
    public void test(){
        QueryWrapper<User> wrapper =  new QueryWrapper<>();
        wrapper.isNotNull("email").isNotNull("name").ge("age",18);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("name","Tom"); //姓名为Mike
        // 查询一条数据，出现多个结果使用List或者Map
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void test3(){
        //查询年龄在20~30之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Integer integer = userMapper.selectCount(wrapper);//查询结果数
        System.out.println(integer);
    }

    @Test
    public void test4(){
        //模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.like("name","o");
//        wrapper.likeLeft("name","dy");
        wrapper.likeRight("name","s");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test5(){
        //子查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from user where id<=3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    @Test
    public void test6(){
        //通过id进行排序
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
