package main.java.org.learn.entity;


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
    @Column(name = "admin", columnDefinition = "int comment '管理员'")
    private int admin;
    @Column(name = "star", columnDefinition = "int commit '点赞量'")
    private int star;
    @Column(name = "follow", columnDefinition = "int commit '关注量'")
    private int follow;
    @Column(name = "permissions", columnDefinition = "int commit '访问权限'")
    private int permisions;
}
