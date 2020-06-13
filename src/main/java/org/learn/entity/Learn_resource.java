package main.java.org.learn.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "learn_resource")
@Entity
public class Learn_resource {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(name = "resource_name", columnDefinition = "int comment '资源名称'")
    private String resource_name;
    @Column(name = "user_name", columnDefinition = "datetime comment '作者'")
    private String user_name;
    @Column(name = "introduction", columnDefinition = "datetime comment '描述'")
    private String introduction;
    @Column(name = "content", columnDefinition = "datetime comment '内容'")
    private String content;
    @Column(name = "tags", columnDefinition = "datetime comment '标签'")
    private String tags;
    @Column(name = "type", columnDefinition = "datetime comment '资源类型'")
    private String type;
    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'")
    private String update_time;
}
