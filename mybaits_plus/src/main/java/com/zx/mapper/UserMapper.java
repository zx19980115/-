package com.zx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author 11633
 * @Date 2021/7/2 13:46
 * @Version 1.0
 */

//在对应的Mapper上面实现基本的接口 BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
    //所有CRUD操作都已经编写完成
    //不需要像以前一样配置文件了
}
