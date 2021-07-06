package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 11633
 * @Date 2021/7/2 13:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
//    @TableId(type = IdType.ID_WORKER)
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version//乐观锁Version注解
    private Integer version;
}
