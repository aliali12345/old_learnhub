package org.learn.entity;


import lombok.Data;
import javax.persistence.*;

@Data
@Table(name="learnhub")
@Entity
public class Learnhub {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(50) comment '空间名称'")
    private String name;

    @Column(name = "avatar", columnDefinition = "varchar(50) comment '空间头像'")
    private String avatar;

    @Column(name = "introduction",columnDefinition = "varchar(255) comment '简介'")
    private String introduction;

    @Column(name = "admin", columnDefinition = "tinyint comment '管理员'")
    private int admin = 0;

    @Column(name = "star", columnDefinition = "int comment '点赞量'")
    private int star = 0;

    @Column(name = "follow", columnDefinition = "int comment '关注量'")
    private int follow = 0;

    @Column(name = "permissions", columnDefinition = "tinyint comment '访问权限'")
    private int permissions = 0;
}
