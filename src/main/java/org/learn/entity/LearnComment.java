package org.learn.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="learn_comment")
@Entity
public class LearnComment {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "resource_id", columnDefinition = "bigint comment '资源id'")
    private String resourceId;

    @Column(name = "user_id", columnDefinition = "char(50) comment '作者id'")
    private String userId;

    @Column(name = "comment", columnDefinition = "varchar(255) comment '评论内容'")
    private String comment;

    @Column(name = "update_time", columnDefinition = "varchar(255) comment '更新时间'")
    private String updateTime;
}
