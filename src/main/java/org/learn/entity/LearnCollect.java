package org.learn.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="learn_collect")
@Entity
public class LearnCollect {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "learn_id", columnDefinition = "bigint comment '空间id'")
    private String resourceId;

    @Column(name = "user_id", columnDefinition = "char(50) comment '用户id'")
    private String userId;

    @Column(name = "update_time", columnDefinition = "varchar(255) comment '更新时间'")
    private String updateTime;
}
