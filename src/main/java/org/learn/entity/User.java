package org.learn.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name="user_info")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "user_name", columnDefinition = "varchar(50) comment '昵称'",unique = true)
    private String username;

    @Column(name = "password", columnDefinition = "varchar(50) comment '密码'")
    private String password;

    @Column(name = "avatar", columnDefinition = "varchar(50) comment '头像'")
    private String avatar;

    @Column(name = "email", columnDefinition = "varchar(50) comment '邮箱'")
    private String email;

    @Column(name = "identity", columnDefinition = "tinyint comment '身份： 1 老师 2 学生 3 其他'")
    private Integer identity;

    @Column(name = "organization",  columnDefinition = "varchar(50) comment '学校或单位'")
    private String organization;

    @Column(name = "site",  columnDefinition = "varchar(100) comment '主页'")
    private String site;

    @Column(name = "introduction",columnDefinition = "varchar(255) comment '简介'")
    private String introduction;
}
