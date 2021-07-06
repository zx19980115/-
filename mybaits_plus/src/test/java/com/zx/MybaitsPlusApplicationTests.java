package com.zx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.mapper.UserMapper;
import com.zx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybaitsPlusApplicationTests {

    //继承了BaseMapper，所有的方法都来自自己的父类
    //我们也可以编写自己的扩展方法！
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //参数是一个Wrapper，条件构造器，这里我们先不用，null
        //查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(18);
        user.setEmail("1111");
        user.setName("zx");
        int result = userMapper.insert(user);//根据结果，发现自动帮我们生成了ID

        System.out.println(result);//受影响的行数
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        //通过条件自动拼接动态sql
        user.setId(5L);
        user.setName("zxxx");
        user.setEmail("2222222");
        //注意：updateById()里边放的是对象
        userMapper.updateById(user);
    }

    //测试乐观锁成功！
    @Test
    public void testOptimisticLocker(){
        //1.查询用户信息
        User user = userMapper.selectById(1L);
        //2.修改用户信息
        user.setName("xzzz");
        user.setEmail("1163312787@qq.com");
        //3.执行更新操作
        userMapper.updateById(user);
    }

    //测试乐观锁失败！
    @Test
    public void testOptimisticLocker2(){
        //线程 1
        User user = userMapper.selectById(1L);
        user.setName("xzzz111");
        user.setEmail("1163312787@qq.com");

        //模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("xzzz222");
        user2.setEmail("1163312787@qq.com");
        userMapper.updateById(user2);

        userMapper.updateById(user);//如果没有乐观锁就会覆盖插队线程的值！
    }

    //测试单个查询
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //测试批量查询
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3,6));
        users.forEach(System.out::println);
    }

    //按条件查询之一 map
    @Test
    public void testSelectByBatchIds(){
        Map<String,Object> map = new HashMap();
        //自定义查询条件
        map.put("name","xzzz222");
        map.put("age","18");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testPage(){
        //  参数一：当前页
        //  参数二：页面大小
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());

    }

    //测试删除
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1411254884082192385L);
    }

    //测试批量删除
    @Test
    public void testDeleteByBatch(){
        userMapper.deleteBatchIds(Arrays.asList(1411254884082192386L,1411254884082192387L));
    }

    //通过map删除
    @Test
    public void testDeleteMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","xzzz222");
        userMapper.deleteByMap(map);
    }
}
